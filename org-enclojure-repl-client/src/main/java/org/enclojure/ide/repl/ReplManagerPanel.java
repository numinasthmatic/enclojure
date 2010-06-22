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
*    Author: Tom Hickey
)
 */

/*
 * REPLManagerPanel.java
 *
 * Created on Dec 3, 2008, 10:13:23 AM
 */

package org.enclojure.ide.repl;

/**
 *
 * @author tomhickey
 */
public class ReplManagerPanel extends javax.swing.JPanel {

    /** Creates new form REPLManagerPanel */
    public ReplManagerPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelName = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabelHost = new javax.swing.JLabel();
        jTextFieldHost = new javax.swing.JTextField();
        jLabelPort = new javax.swing.JLabel();
        jTextFieldPort = new javax.swing.JTextField();
        jCheckBoxExternal = new javax.swing.JCheckBox();
        jLabelArguments = new javax.swing.JLabel();
        jTextFieldArguments = new javax.swing.JTextField();
        jLabelClasspath = new javax.swing.JLabel();
        jTextFieldClasspath = new javax.swing.JTextField();
        jLabelTimeout = new javax.swing.JLabel();
        jTextFieldTimeout = new javax.swing.JTextField();
        jLabelStartupScript = new javax.swing.JLabel();
        jTextFieldStartupScript = new javax.swing.JTextField();
        jLabelMainClass = new javax.swing.JLabel();
        jTextFieldMainClass = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();
        jButtonNew = new javax.swing.JButton();
        jScrollPaneProcesses = new javax.swing.JScrollPane();
        jListProcesses = new javax.swing.JList();
        jLabelProcesses = new javax.swing.JLabel();
        jButtonUseProjectsClasspath = new javax.swing.JButton();
        jButtonStop = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jToggleButtonActivate = new javax.swing.JButton();

        setVerifyInputWhenFocusTarget(false);

        jLabelName.setText("Name:");

        jLabelHost.setText("Host:");

        jLabelPort.setText("Port:");

        jCheckBoxExternal.setText("Attach to running REPL server");

        jLabelArguments.setText("Arguments:");

        jLabelClasspath.setText("Classpath:");

        jTextFieldClasspath.setMaximumSize(new java.awt.Dimension(1019, 457));

        jLabelTimeout.setText("Timeout:");

        jLabelStartupScript.setText("Starup Script:");

        jLabelMainClass.setText("Main Class:");

        jButtonSave.setText("Save");

        jButtonNew.setText("New");

        jListProcesses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneProcesses.setViewportView(jListProcesses);

        jLabelProcesses.setText("Configured REPL Servers:");

        jButtonUseProjectsClasspath.setText("Use From Open Projects");

        jButtonStop.setText("Stop");

        jButtonRemove.setText("Remove");

        jToggleButtonActivate.setText("Activate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelProcesses)
                        .addGap(87, 87, 87)
                        .addComponent(jLabelName)
                        .addGap(60, 60, 60)
                        .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPaneProcesses, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelHost)
                            .addComponent(jLabelPort)
                            .addComponent(jLabelArguments)
                            .addComponent(jLabelClasspath)
                            .addComponent(jLabelTimeout)
                            .addComponent(jLabelStartupScript)
                            .addComponent(jLabelMainClass))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxExternal, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHost, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldArguments, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldClasspath, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(jButtonUseProjectsClasspath))
                            .addComponent(jTextFieldTimeout, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldStartupScript, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldMainClass, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButtonNew)
                        .addGap(5, 5, 5)
                        .addComponent(jButtonRemove)
                        .addGap(164, 164, 164)
                        .addComponent(jButtonSave)
                        .addGap(10, 10, 10)
                        .addComponent(jToggleButtonActivate)
                        .addGap(5, 5, 5)
                        .addComponent(jButtonStop)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelProcesses))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelName))
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneProcesses, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabelHost)
                        .addGap(14, 14, 14)
                        .addComponent(jLabelPort)
                        .addGap(14, 14, 14)
                        .addComponent(jLabelArguments)
                        .addGap(14, 14, 14)
                        .addComponent(jLabelClasspath)
                        .addGap(54, 54, 54)
                        .addComponent(jLabelTimeout)
                        .addGap(14, 14, 14)
                        .addComponent(jLabelStartupScript)
                        .addGap(14, 14, 14)
                        .addComponent(jLabelMainClass))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBoxExternal)
                        .addGap(7, 7, 7)
                        .addComponent(jTextFieldHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jTextFieldArguments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jTextFieldClasspath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jButtonUseProjectsClasspath)
                        .addGap(11, 11, 11)
                        .addComponent(jTextFieldTimeout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jTextFieldStartupScript, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jTextFieldMainClass, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonNew)
                    .addComponent(jButtonRemove)
                    .addComponent(jButtonSave)
                    .addComponent(jToggleButtonActivate)
                    .addComponent(jButtonStop))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonNew;
    public javax.swing.JButton jButtonRemove;
    public javax.swing.JButton jButtonSave;
    public javax.swing.JButton jButtonStop;
    public javax.swing.JButton jButtonUseProjectsClasspath;
    public javax.swing.JCheckBox jCheckBoxExternal;
    public javax.swing.JLabel jLabelArguments;
    public javax.swing.JLabel jLabelClasspath;
    public javax.swing.JLabel jLabelHost;
    public javax.swing.JLabel jLabelMainClass;
    public javax.swing.JLabel jLabelName;
    public javax.swing.JLabel jLabelPort;
    public javax.swing.JLabel jLabelProcesses;
    public javax.swing.JLabel jLabelStartupScript;
    public javax.swing.JLabel jLabelTimeout;
    public javax.swing.JList jListProcesses;
    public javax.swing.JScrollPane jScrollPaneProcesses;
    public javax.swing.JTextField jTextFieldArguments;
    public javax.swing.JTextField jTextFieldClasspath;
    public javax.swing.JTextField jTextFieldHost;
    public javax.swing.JTextField jTextFieldMainClass;
    public javax.swing.JTextField jTextFieldName;
    public javax.swing.JTextField jTextFieldPort;
    public javax.swing.JTextField jTextFieldStartupScript;
    public javax.swing.JTextField jTextFieldTimeout;
    public javax.swing.JButton jToggleButtonActivate;
    // End of variables declaration//GEN-END:variables

}
