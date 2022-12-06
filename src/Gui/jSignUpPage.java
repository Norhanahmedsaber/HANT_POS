package Gui;

import Entities.User;
import Services.AccountServices;

public class jSignUpPage extends javax.swing.JPanel {
    public jSignUpPage(jHomePage jhp) {
        initComponents();
        _jHomePage = jhp;
        _jMainPage = new jMainPage();
        _AccountServices = new AccountServices();
        _jLoginPage = new jLoginPage(jhp);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jNameField = new javax.swing.JTextField();
        jUsernameField = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jRolesCombo = new javax.swing.JComboBox<>();
        jAddAccount = new javax.swing.JButton();
        jErrorName = new javax.swing.JLabel();
        jErrorUsername = new javax.swing.JLabel();
        jErrorPassword = new javax.swing.JLabel();

        jLabel5.setText("Name ");

        jLabel6.setText("Role");

        jLabel7.setText("UserName");

        jLabel8.setText("password");

        jUsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsernameFieldActionPerformed(evt);
            }
        });

        jRolesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Manager", " ", " " }));
        jRolesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRolesComboActionPerformed(evt);
            }
        });

        jAddAccount.setText("Add Account ");
        jAddAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddAccountMouseClicked(evt);
            }
        });
        jAddAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddAccountActionPerformed(evt);
            }
        });

        jErrorName.setForeground(new java.awt.Color(255, 0, 0));

        jErrorUsername.setForeground(new java.awt.Color(255, 0, 0));

        jErrorPassword.setForeground(new java.awt.Color(255, 0, 0));
        jErrorPassword.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel8)))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRolesCombo, 0, 192, Short.MAX_VALUE)
                            .addComponent(jUsernameField)
                            .addComponent(jErrorPassword)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jErrorName)
                        .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jErrorUsername)))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jAddAccount)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jErrorName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jErrorUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jErrorPassword)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRolesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jAddAccount)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jAddAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAddAccountActionPerformed

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jComboBox1ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ComponentAdded

    private void jRolesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRolesComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRolesComboActionPerformed

    private void jUsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUsernameFieldActionPerformed

    private void jAddAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddAccountMouseClicked
        // check name is valid
        if(jNameField.getText().isEmpty()) {
            jErrorName.setText("Cannot be Empty");
            return;
        }else jErrorName.setText("");
        
        // check user name is valid
        if(jUsernameField.getText().isEmpty()) {
            jErrorUsername.setText("Cannot be Empty");
            return;
        }else jErrorUsername.setText("");

        if(jUsernameField.getText().contains(" ")){
            System.out.println("hhhhhhhh");
            jErrorUsername.setText("Cannot contain spaces");
            return;
        }else jErrorUsername.setText("");
        
          
        // check password is valid
        if(jPasswordField.getText().isEmpty()) {
            jErrorPassword.setText("Cannot be Empty");
            return;
        }else jErrorPassword.setText("");
        
        if(jPasswordField.getText().length() < 8){
            jErrorPassword.setText("Cannot be less than 8 chars");
            return;
            
        }else jErrorPassword.setText("");
        User user = new User();
        user.name = jNameField.getText();
        user.userName = jUsernameField.getText();
        user.password = jPasswordField.getText();
        user.role =(String) jRolesCombo.getSelectedItem();
        _AccountServices.signUp(user);
        _jHomePage.switchPanels(_jLoginPage);
    }//GEN-LAST:event_jAddAccountMouseClicked
    
    private final jMainPage _jMainPage;
    private final jLoginPage _jLoginPage;
    private final jHomePage _jHomePage;
    private final AccountServices _AccountServices;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddAccount;
    private javax.swing.JLabel jErrorName;
    private javax.swing.JLabel jErrorPassword;
    private javax.swing.JLabel jErrorUsername;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jNameField;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JComboBox<String> jRolesCombo;
    private javax.swing.JTextField jUsernameField;
    // End of variables declaration//GEN-END:variables
}
