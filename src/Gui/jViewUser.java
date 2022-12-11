
package Gui;

import Entities.User;
import Services.UserServices;

public class jViewUser extends javax.swing.JPanel {

   
    public jViewUser(jViewUsers jvu,jHomePage jhp){
        initComponents();
        _jHomePage = jhp;
        _jViewUsers = jvu;
        choosedUser = null;
        _UserServices = new UserServices(); 
    } 
    public void renderData( ){  
        
        jNameField.setText(choosedUser.name);
        jUsernameField.setText(choosedUser.userName);
        jPasswordField.setText(choosedUser.password);
        // show Role 
    }
    public boolean isValidName() {
        // is empty (nameField)
        if(jNameField.getText().trim().isEmpty()) {
           jErrorName.setText("Cant be empty!");
           return false;
        }else jErrorName.setText("");
        //is valid (Name)
        for (int i=0 ; i < jNameField.getText().trim().length();i++){
            char x = jNameField.getText().trim().charAt(i);
            if(!(x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z' || x==' ')){
            jErrorName.setText("you must enter chars only.");
            return false;
            }else jErrorName.setText("");
        }
        return true;
    }
    public boolean isValidUserName() {
        // is empty (UserNameField)
        if(jUsernameField.getText().trim().isEmpty()) {
           jErrorUsername.setText("Cant be empty!");
           return false;
        }else jErrorUsername.setText("");
        return true;
    }
    public boolean isValidPassword() {
        // is empty (password)
        if(jPasswordField.getText().trim().isEmpty()) {
           jErrorPassword.setText("Cant be empty!");
           return false;
        }else jErrorPassword.setText("");
        // is valid (password)
        if (jPasswordField.getText().trim().length() < 8){
            jErrorPassword.setText("your password length must be greate than 8.");
            return false;
        }else jErrorPassword.setText("");
        return true;
    }
    public boolean checkAllValidations(){
        if(!isValidName()){
            return false;
        }
        if (!isValidUserName()){
            return false;
        }
        if (!isValidPassword()){
            return false;
        }
        return true;
    }
    public void resetViewUserPage(){
        jNameField.setText("");
        jUsernameField.setText("");
        jPasswordField.setText("");
        jRolesCombo.setSelectedItem(choosedUser.role);
        jUpdateUserSuccessfully.setText("");
        
        removeUpdateANdCancelButtons();
    }
    public void updateUserData(){
        User user =  choosedUser;
        user.name=jNameField.getText();
        user.userName=jUsernameField.getText();
        user.password=jPasswordField.getText();
        user.role.name = (String)(jRolesCombo.getSelectedItem());
        
        _UserServices.update(choosedUser.id,user);
        choosedUser = _UserServices.getById(choosedUser.id);
    }
    public void disableUserFields(){
        jNameField.setEditable(false);
        jUsernameField.setEditable(false);
        jPasswordField.setEditable(false);
        jRolesCombo.setEnabled(false);
    }
    public void enableUserFields(){
        jNameField.setEditable(true);
        jUsernameField.setEditable(true);
        jPasswordField.setEditable(true);
        jRolesCombo.setEnabled(true);
    }
    public void removeUpdateANdCancelButtons(){
        jCancelButton.setEnabled(false);
        jUpdateButton.setEnabled(false);
        jEditButton.setEnabled(true);
        jBackButton.setEnabled(true);
    }
    public void enableUpdateANdCancelButtons(){
        jCancelButton.setEnabled(true);
        jUpdateButton.setEnabled(true);
        jEditButton.setEnabled(false);
        jBackButton.setEnabled(false);
    }
    public void updateItemButton(){
        if(!checkAllValidations()){
           return;
        }else
        updateUserData();
        renderData();
        jUpdateUserSuccessfully.setText("Updated Successfully!");
        disableUserFields();
        removeUpdateANdCancelButtons();
    }
    public void cancelItemButton(){
        removeUpdateANdCancelButtons();
        disableUserFields();
        renderData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jNameLabel = new javax.swing.JLabel();
        jRoleLabel = new javax.swing.JLabel();
        jUserNameLabel = new javax.swing.JLabel();
        jPasswordLabel = new javax.swing.JLabel();
        jNameField = new javax.swing.JTextField();
        jUsernameField = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jRolesCombo = new javax.swing.JComboBox<>();
        jBackButton = new javax.swing.JButton();
        jCancelButton = new javax.swing.JButton();
        jUpdateButton = new javax.swing.JButton();
        jEditButton = new javax.swing.JButton();
        jErrorName = new javax.swing.JLabel();
        jErrorUsername = new javax.swing.JLabel();
        jErrorPassword = new javax.swing.JLabel();
        jUpdateUserSuccessfully = new javax.swing.JLabel();

        jNameLabel.setText("Name ");

        jRoleLabel.setText("Role");

        jUserNameLabel.setText("UserName");

        jPasswordLabel.setText("password");

        jRolesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Manager", " ", " " }));

        jBackButton.setText("Back");
        jBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackButtonMouseClicked(evt);
            }
        });

        jCancelButton.setText("Cancel");
        jCancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCancelButtonMouseClicked(evt);
            }
        });

        jUpdateButton.setText("Update");
        jUpdateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateButtonMouseClicked(evt);
            }
        });

        jEditButton.setText("Edit");
        jEditButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEditButtonMouseClicked(evt);
            }
        });

        jErrorName.setForeground(new java.awt.Color(255, 0, 0));

        jErrorUsername.setForeground(new java.awt.Color(255, 0, 0));

        jErrorPassword.setForeground(new java.awt.Color(255, 0, 0));
        jErrorPassword.setToolTipText("");

        jUpdateUserSuccessfully.setForeground(new java.awt.Color(51, 255, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jUpdateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEditButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordLabel)
                            .addComponent(jUserNameLabel)
                            .addComponent(jRoleLabel)
                            .addComponent(jNameLabel))
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRolesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jUpdateUserSuccessfully, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jErrorUsername)
                    .addComponent(jErrorName)
                    .addComponent(jErrorPassword))
                .addContainerGap(243, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jErrorName)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jNameLabel)
                            .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jUserNameLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jErrorUsername)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordLabel)
                            .addComponent(jErrorPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRolesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRoleLabel))
                        .addGap(18, 18, 18)
                        .addComponent(jUpdateUserSuccessfully)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBackButton)
                            .addComponent(jEditButton)
                            .addComponent(jCancelButton)
                            .addComponent(jUpdateButton))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCancelButtonMouseClicked
        cancelItemButton();
    }//GEN-LAST:event_jCancelButtonMouseClicked

    private void jUpdateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateButtonMouseClicked
        updateItemButton();
    }//GEN-LAST:event_jUpdateButtonMouseClicked

    private void jBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackButtonMouseClicked
        resetViewUserPage();
        _jViewUsers.renderData();
        _jHomePage.switchPanels(_jViewUsers);
    }//GEN-LAST:event_jBackButtonMouseClicked

    private void jEditButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEditButtonMouseClicked
        enableUserFields();
        enableUpdateANdCancelButtons();
    }//GEN-LAST:event_jEditButtonMouseClicked

    public User choosedUser;
    private final jHomePage _jHomePage;
    private final jViewUsers _jViewUsers;
    private final UserServices _UserServices;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBackButton;
    private javax.swing.JButton jCancelButton;
    private javax.swing.JButton jEditButton;
    private javax.swing.JLabel jErrorName;
    private javax.swing.JLabel jErrorPassword;
    private javax.swing.JLabel jErrorUsername;
    public javax.swing.JTextField jNameField;
    private javax.swing.JLabel jNameLabel;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JLabel jPasswordLabel;
    private javax.swing.JLabel jRoleLabel;
    private javax.swing.JComboBox<String> jRolesCombo;
    private javax.swing.JButton jUpdateButton;
    private javax.swing.JLabel jUpdateUserSuccessfully;
    private javax.swing.JLabel jUserNameLabel;
    private javax.swing.JTextField jUsernameField;
    // End of variables declaration//GEN-END:variables
}
