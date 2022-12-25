
package Gui.Users;

import Entities.Role;
import Entities.User;
import Gui.jHomePage;
import Services.RoleServices;
import Services.UserServices;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class jViewUser extends javax.swing.JPanel {

   
    public jViewUser(jViewUsers jvu,jHomePage jhp){
        initComponents();
        _jHomePage = jhp;
        _jViewUsers = jvu;
        choosedUser = null;
        _UserServices = new UserServices(); 
        _RoleServices = new RoleServices();
        isEditing = false;
    } 
    public void changecolor(int x, int y ,int z)
    { 
        setBackground(new java.awt.Color(x, y, z));
    }
    public void renderData( ){  
        
        jNameField.setText(choosedUser.name);
        jUsernameField.setText(choosedUser.userName); 
        ArrayList<String> roleNames = _RoleServices.getAll();
        String[] names = new String[roleNames.size()];
        for(int i=0;i<roleNames.size();i++){
            names[i] = roleNames.get(i);
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(names);
        jRolesCombo.setModel(model);
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
        jErrorName.setText("");
        jErrorPassword.setText("");
        jErrorUsername.setText("");
        removeUpdateANdCancelButtons();
    }
    public void updateUserData(){
        User user =  choosedUser;
        user.name=jNameField.getText().trim();
        user.userName=jUsernameField.getText().trim();
        user.password=jPasswordField.getText().trim();
        user.role.name = (String)(jRolesCombo.getSelectedItem());
        _UserServices.update(choosedUser.id,user);
        _jHomePage.createLog("Updated", "User",user.name );
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
    public void updateButton(){
        if(!checkAllValidations()){
           return;
        }else
        updateUserData();
        renderData();
        jUpdateUserSuccessfully.setText("Updated Successfully!");
        disableUserFields();
        removeUpdateANdCancelButtons();
        isEditing = false;
    }
    public void cancelButton(){
        removeUpdateANdCancelButtons();
        disableUserFields();
        renderData();
        isEditing = false;
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
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(87, 118, 130));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jNameLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        jNameLabel.setText("Name: ");

        jRoleLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jRoleLabel.setForeground(new java.awt.Color(255, 255, 255));
        jRoleLabel.setText("Role:");

        jUserNameLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jUserNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        jUserNameLabel.setText("UserName:");

        jPasswordLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordLabel.setText("password:");

        jNameField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jNameField.setForeground(new java.awt.Color(0, 31, 78));
        jNameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNameFieldMouseClicked(evt);
            }
        });
        jNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNameFieldKeyPressed(evt);
            }
        });

        jUsernameField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jUsernameField.setForeground(new java.awt.Color(0, 31, 78));
        jUsernameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUsernameFieldMouseClicked(evt);
            }
        });
        jUsernameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jUsernameFieldKeyPressed(evt);
            }
        });

        jPasswordField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPasswordField.setForeground(new java.awt.Color(0, 31, 78));
        jPasswordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordFieldMouseClicked(evt);
            }
        });
        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldKeyPressed(evt);
            }
        });

        jRolesCombo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jRolesCombo.setForeground(new java.awt.Color(0, 31, 78));
        jRolesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Manager", " ", " " }));
        jRolesCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRolesComboMouseClicked(evt);
            }
        });
        jRolesCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRolesComboKeyPressed(evt);
            }
        });

        jBackButton.setBackground(new java.awt.Color(217, 156, 69));
        jBackButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jBackButton.setForeground(new java.awt.Color(255, 255, 255));
        jBackButton.setText("Back");
        jBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackButtonMouseClicked(evt);
            }
        });

        jCancelButton.setBackground(new java.awt.Color(217, 156, 69));
        jCancelButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jCancelButton.setForeground(new java.awt.Color(255, 255, 255));
        jCancelButton.setText("Cancel");
        jCancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCancelButtonMouseClicked(evt);
            }
        });

        jUpdateButton.setBackground(new java.awt.Color(217, 156, 69));
        jUpdateButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jUpdateButton.setForeground(new java.awt.Color(255, 255, 255));
        jUpdateButton.setText("Update");
        jUpdateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateButtonMouseClicked(evt);
            }
        });

        jEditButton.setBackground(new java.awt.Color(217, 156, 69));
        jEditButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jEditButton.setForeground(new java.awt.Color(255, 255, 255));
        jEditButton.setText("Edit");
        jEditButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEditButtonMouseClicked(evt);
            }
        });

        jErrorName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jErrorName.setForeground(new java.awt.Color(217, 156, 69));

        jErrorUsername.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jErrorUsername.setForeground(new java.awt.Color(217, 156, 69));

        jErrorPassword.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jErrorPassword.setForeground(new java.awt.Color(217, 156, 69));
        jErrorPassword.setToolTipText("");

        jUpdateUserSuccessfully.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jUpdateUserSuccessfully.setForeground(new java.awt.Color(51, 255, 0));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Item:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordLabel)
                    .addComponent(jRoleLabel)
                    .addComponent(jLabel1)
                    .addComponent(jNameLabel)
                    .addComponent(jUserNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRolesCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jUsernameField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jErrorName, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(jErrorPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jErrorUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jUpdateUserSuccessfully, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jUpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jErrorName)
                        .addGap(18, 18, 18)
                        .addComponent(jErrorUsername)
                        .addGap(49, 49, 49)
                        .addComponent(jErrorPassword)
                        .addGap(203, 203, 203))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jNameLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jUserNameLabel))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPasswordLabel))
                                .addGap(50, 50, 50))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRoleLabel)
                                .addComponent(jRolesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)))
                .addComponent(jUpdateUserSuccessfully)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCancelButtonMouseClicked
        if(isEditing) {
            cancelButton();
        }
    }//GEN-LAST:event_jCancelButtonMouseClicked

    private void jUpdateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateButtonMouseClicked
        if(isEditing) {
            updateButton();
        }
    }//GEN-LAST:event_jUpdateButtonMouseClicked

    private void jBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackButtonMouseClicked
        if(!isEditing) {
            resetViewUserPage();
            _jViewUsers.renderData();
            _jHomePage.switchPanels(_jViewUsers);
            
        }
    }//GEN-LAST:event_jBackButtonMouseClicked

    private void jEditButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEditButtonMouseClicked
        if(!isEditing) {
            enableUserFields();
            enableUpdateANdCancelButtons();
            isEditing = true;
        }
    }//GEN-LAST:event_jEditButtonMouseClicked

    private void jNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNameFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jNameFieldKeyPressed

    private void jUsernameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jUsernameFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jUsernameFieldKeyPressed

    private void jPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jPasswordFieldKeyPressed

    private void jRolesComboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRolesComboKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jRolesComboKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_formKeyPressed

    private void jNameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNameFieldMouseClicked
            jUpdateUserSuccessfully.setText("");
    }//GEN-LAST:event_jNameFieldMouseClicked

    private void jUsernameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUsernameFieldMouseClicked
            jUpdateUserSuccessfully.setText("");
    }//GEN-LAST:event_jUsernameFieldMouseClicked

    private void jPasswordFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldMouseClicked
            jUpdateUserSuccessfully.setText("");
    }//GEN-LAST:event_jPasswordFieldMouseClicked

    private void jRolesComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRolesComboMouseClicked
            jUpdateUserSuccessfully.setText("");
    }//GEN-LAST:event_jRolesComboMouseClicked
    private boolean isEditing;
    public User choosedUser;
    private final RoleServices _RoleServices;
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
    private javax.swing.JLabel jLabel1;
    public javax.swing.JTextField jNameField;
    private javax.swing.JLabel jNameLabel;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JLabel jPasswordLabel;
    private javax.swing.JLabel jRoleLabel;
    public javax.swing.JComboBox<String> jRolesCombo;
    private javax.swing.JButton jUpdateButton;
    private javax.swing.JLabel jUpdateUserSuccessfully;
    private javax.swing.JLabel jUserNameLabel;
    private javax.swing.JTextField jUsernameField;
    // End of variables declaration//GEN-END:variables
}
