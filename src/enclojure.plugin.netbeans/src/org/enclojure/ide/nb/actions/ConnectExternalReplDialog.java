/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConnectExternalReplDialog.java
 *
 * Created on Mar 2, 2009, 4:30:01 PM
 */

package org.enclojure.ide.nb.actions;

import clojure.lang.RT;
import clojure.lang.Var;
import org.openide.util.Exceptions;

/**
 *
 * @author magrawal
 */
public class ConnectExternalReplDialog extends javax.swing.JDialog {

    static final Var connectExternalRepl =
      RT.var("org.enclojure.ide.nb.editor.repl-tc"
                , "connect-external-repl");

    /** Creates new form ConnectExternalReplDialog */
    public ConnectExternalReplDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        errorLabel.setVisible(false);
        this.setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        replName = new javax.swing.JTextField();
        replServerHost = new javax.swing.JTextField();
        replServerPort = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        connectButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        jLabel1.setText(org.openide.util.NbBundle.getMessage(ConnectExternalReplDialog.class, "ConnectExternalReplDialog.jLabel1.text")); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(ConnectExternalReplDialog.class, "ConnectExternalReplDialog.jLabel2.text")); // NOI18N

        replName.setText(org.openide.util.NbBundle.getMessage(ConnectExternalReplDialog.class, "ConnectExternalReplDialog.replName.text")); // NOI18N

        replServerHost.setText(org.openide.util.NbBundle.getMessage(ConnectExternalReplDialog.class, "ConnectExternalReplDialog.replServerHost.text")); // NOI18N

        replServerPort.setText(org.openide.util.NbBundle.getMessage(ConnectExternalReplDialog.class, "ConnectExternalReplDialog.replServerPort.text")); // NOI18N

        jLabel3.setText(org.openide.util.NbBundle.getMessage(ConnectExternalReplDialog.class, "ConnectExternalReplDialog.jLabel3.text")); // NOI18N

        connectButton.setText(org.openide.util.NbBundle.getMessage(ConnectExternalReplDialog.class, "ConnectExternalReplDialog.connectButton.text")); // NOI18N
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        cancelButton.setText(org.openide.util.NbBundle.getMessage(ConnectExternalReplDialog.class, "ConnectExternalReplDialog.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        errorLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText(org.openide.util.NbBundle.getMessage(ConnectExternalReplDialog.class, "ConnectExternalReplDialog.errorLabel.text")); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, errorLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(jLabel1)
                        .add(54, 54, 54)
                        .add(replName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(jLabel2)
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(connectButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(cancelButton))
                            .add(layout.createSequentialGroup()
                                .add(replServerHost, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 164, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jLabel3)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(replServerPort, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(replName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(replServerHost, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3)
                    .add(replServerPort, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(connectButton)
                    .add(cancelButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(errorLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        try {
            //Connect - if failed to connet - display red error on the dalog box
            connectExternalRepl.invoke(this.replName.getText(),
                    this.replServerHost.getText(),
                    Integer.parseInt(this.replServerPort.getText()));
            this.dispose();
        } catch (Exception ex) {
            this.errorLabel.setText(ex.getMessage());
            this.errorLabel.setVisible(true);
        }
}//GEN-LAST:event_connectButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConnectExternalReplDialog dialog = new ConnectExternalReplDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton connectButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField replName;
    private javax.swing.JTextField replServerHost;
    private javax.swing.JTextField replServerPort;
    // End of variables declaration//GEN-END:variables

}
