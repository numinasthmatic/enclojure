/*
(comment
*
*    Copyright (c) ThorTech, L.L.C.. All rights reserved.
*    The use and distribution terms for this software are covered by the
*    Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
*    which can be found in the file epl-v10.html at the root of this distribution.
*    By using this software in any fashion, you are agreeing to be bound by
*    the terms of this license.
*    You must not remove this notice, or any other, from this software.
*
*    Author: Eric Thorsen
)
 */
package org.enclojure.flex;

import java.util.*;
import java.io.CharArrayReader;
import clojure.lang.Var;
import clojure.lang.RT;
import clojure.lang.IFn;
import clojure.lang.Var;
import clojure.lang.Keyword;
import clojure.lang.LispReader;
import clojure.lang.IPersistentMap;
import java.util.regex.Pattern;
import java.util.logging.*;
import java_cup.runtime.*;
import org.enclojure.flex.ClojureSymbol;
import org.enclojure.flex.CljSymbol;
import org.enclojure.flex.ClojureSymFactory;
import Example.ClojureSym;


%%

%class _Lexer
%implements ClojureSym
%cup
%char
%line
%column
%unicode
%public
%debug
%function next_token
/* %type ClojureSymbol */

%eofval{
    return new java_cup.runtime.Symbol(ClojureSym.EOF);
%eofval}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////// User code //////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

%{

final Var requireFn = RT.var("clojure.core","require");
final ClojureSymFactory symFactory = new ClojureSymFactory();
public final static Var _tokenMap = (Var)RT.var("org.enclojure.idetools.tokens","-TOKENS-");

public  java_cup.runtime.Symbol symbol(int ID,String tokenType,Object data)
{
    //  ([id tag line col charp start end text data]
    return CljSymbol.newSymbol(ID,tokenType,yyline,yycolumn
                                ,yychar,zzStartRead
                                ,yytext().length()
                                ,yytext(),data);
}

public java_cup.runtime.Symbol symbol(int ID,String tokenType)
{
    return CljSymbol.newSymbol(ID,tokenType,yyline,yycolumn
                                ,yychar,zzStartRead
                                ,yytext().length()
                                ,yytext(),yytext());
    
}

public int getPosition() {  return yychar; }

/*
public ClojureSymbol symbol(Var tokenType,Object data)
{
    return ClojureSymbol.create((IPersistentMap)tokenType.get(),yyline, yycolumn,yychar,data);
}

public ClojureSymbol symbol(Var tokenType)
{
    return ClojureSymbol.create((IPersistentMap)tokenType.get(),yyline, yycolumn,yychar);
}
*/



%}
%init{
    try {
        requireFn.invoke(clojure.lang.Symbol.create("org.enclojure.idetools.tokens"));
        requireFn.invoke(clojure.lang.Symbol.create("org.enclojure.idetools.token-set"));
    } catch (Exception ex) {
            Logger.getLogger("org.enclojure.flex._Lexer").log(Level.SEVERE, null, ex);
        }
%init}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////// NewLines and spaces /////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

mNL = \r | \n | \r\n                                    // NewLines
mWS = " " | \t | \f | {mNL}                       // Whitespaces
mCOMMA = "," 

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////      integers and floats     /////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

mHEX_DIGIT = [0-9A-Fa-f]
mDIGIT = [0-9]
mBIG_SUFFIX = g | G
mFLOAT_SUFFIX = f | F
mLONG_SUFFIX = l | L
mINT_SUFFIX = i | I
mDOUBLE_SUFFIX = d | D
mEXPONENT = (e | E)("+" | "-")?([0-9])+

mNUM_INT_PART =  0
 ( (x | X){mHEX_DIGIT}+
   | {mDIGIT}+
   | ([0-7])+
 )?
 | {mDIGIT}+

// Integer
mNUM_INT = {mNUM_INT_PART} {mINT_SUFFIX}?

// Long
mNUM_LONG = {mNUM_INT_PART} {mLONG_SUFFIX}

// BigInteger
mNUM_BIG_INT = {mNUM_INT_PART} {mBIG_SUFFIX}

//Float
mNUM_FLOAT = {mNUM_INT_PART} ( ("." {mDIGIT}+ {mEXPONENT}? {mFLOAT_SUFFIX})
 | {mFLOAT_SUFFIX}
 | {mEXPONENT} {mFLOAT_SUFFIX} )

// Double
mNUM_DOUBLE = {mNUM_INT_PART} ( ("." {mDIGIT}+ {mEXPONENT}? {mDOUBLE_SUFFIX})
 | {mDOUBLE_SUFFIX}
 | {mEXPONENT} {mDOUBLE_SUFFIX})

// BigDecimal
mNUM_BIG_DECIMAL = {mNUM_INT_PART} ( ("." {mDIGIT}+ {mEXPONENT}? {mBIG_SUFFIX}?)
 | {mEXPONENT} {mBIG_SUFFIX}? )

//Ratios
mRATIO = {mNUM_INT_PART} "/" {mNUM_INT_PART}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////// Parens, Squares, Curleys, Quotes /////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
mLP = "("
mRP = ")"
mLS = "["
mRS = "]"
mLC = "{"
mRC = "}"

mQUOTE = "'"
mBACKQUOTE = "`"
mUP = "^"
mIMPLICIT_ARG = "%" | "%"{mDIGIT}+ | "%""&"
mTILDA = "~"
mAT = "@"
mTILDAAT = {mTILDA} {mAT}

mDISPATCH = "#"
// Reader macros
mDISP_META = {mDISPATCH} {mUP}
mDISP_VAR = {mDISPATCH} "\\"
mDISP_REGEX = {mDISPATCH} "\""
mDISP_FN = {mDISPATCH} {mLP}
mDISP_SET = {mDISPATCH} {mLC}
mDISP_EVAL= {mDISPATCH} "="
mDISP_COMMENT= {mDISPATCH} "!"
mDISP_UNREADABLE= {mDISPATCH} "<"
mDISP_DISCARD_FORM= {mDISPATCH} "_"



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////// Strings /////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

mONE_NL = \r | \n | \r\n
mHEX_DIGIT = [0-9A-Fa-f]

mCHAR = \\ [^" "\r\n]
    | \\ [:jletter:]+

mSTRING_ESC = \\ n | \\ r | \\ t | \\ b | \\ f | "\\" "\\" | \\ "$" | \\ \" | \\ \'
    | "\\""u"{mHEX_DIGIT}{4}
    | "\\" [0..3] ([0..7] ([0..7])?)?
    | "\\" [4..7] ([0..7])?
    | "\\" {mONE_NL}
    | {mCHAR}


mSTRING_CONTENT = ({mSTRING_ESC}|[^\\\"])*
mSTRING = \"\" | \" ([^\\\"] | {mSTRING_ESC})? {mSTRING_CONTENT} \"
mWRONG_STRING = \" ([^\\\"] | {mSTRING_ESC})? {mSTRING_CONTENT}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////// Comments ////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

mLINE_COMMENT = ";" [^\r\n]*

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////      identifiers      ////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

mLETTER = [A-Z] | [a-z]
mSLASH_LETTER = \\ ({mLETTER} | .)

mOTHER = "_" | "-" | "*" | "." | "+" | "=" | "&" | "<" | ">" | "$" | "/" | "?" | "!"
mNoDigit = ({mLETTER} | {mOTHER})

mOTHER_REDUCED = "_" | "-" | "*" | "+" | "=" | "&" | "<" | ">" | "$" | "?" | "!"
mNoDigit1 = ({mLETTER} | {mOTHER_REDUCED})

mIDENT = {mNoDigit} ({mNoDigit} | {mDIGIT})* "#"?
mKEYWORD = ":" (":")? ({mIDENT} ":")* {mIDENT}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////      predefined      ////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

mNIL = "nil"
mTRUE = "true"
mFALSE = "false"

// Specials
mDEF = "def"
mDEFN = "defn"
mFN = "fn"
mLOOP = "loop"
mRECUR = "recur"
mDO = "do"
mIF = "if"
mNS = "ns"
mLET = "let"
mLET_STAR = "let*"
mLETFN = "letfn"
mQUOTE = "quote"


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////  states ///////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

%xstate SYMBOL

%%
<SYMBOL> {
  "."                                       {  return symbol(symDOT,yytext()); }
  "/"                                       {  return symbol(symNS_SEP,yytext()); }
  ({mNoDigit1} | {mDIGIT} | ":")+           {  return symbol(symATOM,yytext()); }
  (({mNoDigit1} | {mDIGIT} | ":")+)? "#"    {  yybegin(YYINITIAL); return symbol(symATOM,yytext()); }
  [^]                                       {  yypushback(yytext().length()); yybegin(YYINITIAL); }
}

<YYINITIAL>{

  {mLINE_COMMENT}                           {  return symbol(LINE_COMMENT,yytext()); }
  
  {mWS}+                                    {  }//return symbol(WHITESPACE,yytext()); }
  {mCOMMA}                                  {  }//return symbol(COMMA,yytext()); }

  {mSTRING}                                 {  return symbol(STRING_LITERAL,yytext()); }
  {mWRONG_STRING}                           {  return symbol(WRONG_STRING_LITERAL,yytext()); }

  {mCHAR}                                   {  return symbol(CHAR_LITERAL,yytext()); }
  {mNIL}                                    {  return symbol(NIL,yytext()); }
  {mTRUE}                                   {  return symbol(TRUE,yytext()); }
  {mFALSE}                                  {  return symbol(FALSE,yytext()); }

  {mNUM_INT}                                {  return symbol(INTEGER_LITERAL,yytext()); }
  {mNUM_LONG}                               {  return symbol(LONG_LITERAL,yytext()); }
  {mNUM_BIG_INT}                            {  return symbol(BIG_INT_LITERAL,yytext()); }
  {mNUM_FLOAT}                              {  return symbol(FLOAT_LITERAL,yytext()); }
  {mNUM_DOUBLE}                             {  return symbol(DOUBLE_LITERAL,yytext()); }
  {mNUM_BIG_DECIMAL}                        {  return symbol(BIG_DECIMAL_LITERAL,yytext()); }
  {mRATIO}                                  {  return symbol(RATIO,yytext()); }

  // Specials
  //{mDEF}                                    {  return symbol(DEF,yytext()); }
  //{mDEFN}                                   {  return symbol(DEFN,yytext()); }
//  {mFN}                                     {  return symbol(FN,yytext()); }
//  {mLOOP}                                   {  return symbol(LOOP,yytext()); }
//  {mRECUR}                                  {  return symbol(RECUR,yytext()); }
//  {mDO}                                     {  return symbol(DO,yytext()); }
//  {mIF}                                     {  return symbol(IF,yytext()); }
//  {mNS}                                     {  return symbol(NS,yytext()); }
//  {mLET}                                    {  return symbol(LET,yytext()); }
//  {mLET_STAR}                               {  return symbol(LET_STAR,yytext()); }
//  {mLETFN}                                  {  return symbol(LETFN,yytext()); }
//  {mQUOTE}                                  {  return symbol(QUOTE,yytext()); }

  // Reserved symbols
  "/"                                       {  return symbol(symATOM,yytext()); }
  "."{mIDENT} | {mIDENT}"."                 {  return symbol(symATOM,yytext()); }
  {mIDENT}                                  {  yypushback(yytext().length()); yybegin(SYMBOL); }
  {mKEYWORD}                                {  return symbol(KEYWORD,yytext()); }

  {mQUOTE}                                  {  return symbol(QUOTE,yytext()); }
  {mBACKQUOTE}                              {  return symbol(BACKQUOTE,yytext()); }
  {mDISP_META}                              {  return symbol(DISP_META,yytext()); }
  {mDISP_VAR}                               {  return symbol(DISP_VAR,yytext()); }
  {mDISP_REGEX}                             {  return symbol(DISP_REGEX,yytext()); }
  {mDISP_FN}                                {  return symbol(DISP_FN,yytext()); }
  {mDISP_SET}                               {  return symbol(DISP_SET,yytext()); }
  {mDISP_EVAL}                              {  return symbol(DISP_EVAL,yytext()); }
  {mDISP_COMMENT}                           {  return symbol(DISP_COMMENT,yytext()); }
  {mDISP_UNREADABLE}                        {  return symbol(DISP_UNREADABLE,yytext()); }
  {mDISP_DISCARD_FORM}                      {  return symbol(DISP_DISCARD_FORM,yytext()); }
  {mDISPATCH}                               {  return symbol(DISPATCH,yytext()); }
  {mUP}                                     {  return symbol(HAT,yytext()); }  
  {mIMPLICIT_ARG}                           {  return symbol(symIMPLICIT_ARG,yytext()); }
  {mTILDA}                                  {  return symbol(TILDA,yytext()); }
  {mAT}                                     {  return symbol(AT,yytext()); }
  {mTILDAAT}                                {  return symbol(TILDAAT,yytext()); }


  {mLP}                                     {  return symbol(LEFT_PAREN,yytext()); }
  {mRP}                                     {  return symbol(RIGHT_PAREN,yytext()); }
  {mLS}                                     {  return symbol(LEFT_SQUARE,yytext()); }
  {mRS}                                     {  return symbol(RIGHT_SQUARE,yytext()); }
  {mLC}                                     {  return symbol(LEFT_CURLY,yytext()); }
  {mRC}                                     {  return symbol(RIGHT_CURLY,yytext()); }

}

// Anything else is should be marked as a bad char
.                                           {  return symbol(BAD_CHARACTER,yytext()); }