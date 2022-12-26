
package Gui.Users;

import Entities.Role;
import Entities.User;
import Gui.jHomePage;
import Services.RoleServices;
import Services.UserServices;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

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
     
    public void changecolor(java.awt.Color c)
    { 
        setBackground(c);
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
           JOptionPane.showMessageDialog(null, "Name Can't be Empty!");
           return false;
        }
        //is valid (Name)
        for (int i=0 ; i < jNameField.getText().trim().length();i++){
            char x = jNameField.getText().trim().charAt(i);
            if(!(x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z' || x==' ')){
                JOptionPane.showMessageDialog(null, "Name Can Only Contain Letters!");
                return false;
            }
        }
        return true;
    }
    public boolean isValidUserName() {
        // is empty (UserNameField)
        if(jUsernameField.getText().trim().isEmpty()) {
           JOptionPane.showMessageDialog(null, "Username is Empty!");
           return false;
        }
        return true;
    }
    public boolean isValidPassword() {
        // is empty (password)
        if(jPasswordField.getText().trim().isEmpty()) {
           JOptionPane.showMessageDialog(null, "Password is Empty!");
           return false;
        }
        // is valid (password)
        if (jPasswordField.getText().trim().length() < 8){
            JOptionPane.showMessageDialog(null, "Password Can't be less than 8 Chars!");
            return false;
        }
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
            JOptionPane.showMessageDialog(null, "Updated Successfully!");
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
        jBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Users/back.png"))); // NOI18N
        jBackButton.setMnemonic('b');
        jBackButton.setText("   Back  ");
        jBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackButtonMouseClicked(evt);
            }
        });
        jBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackButtonActionPerformed(evt);
            }
        });

        jCancelButton.setBackground(new java.awt.Color(217, 156, 69));
        jCancelButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jCancelButton.setForeground(new java.awt.Color(255, 255, 255));
        jCancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Users/cancel1.png"))); // NOI18N
        jCancelButton.setMnemonic('c');
        jCancelButton.setText("    Cancel  ");
        jCancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCancelButtonMouseClicked(evt);
            }
        });
        jCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelButtonActionPerformed(evt);
            }
        });

        jUpdateButton.setBackground(new java.awt.Color(217, 156, 69));
        jUpdateButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jUpdateButton.setForeground(new java.awt.Color(255, 255, 255));
        jUpdateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Users/update.png"))); // NOI18N
        jUpdateButton.setMnemonic('u');
        jUpdateButton.setText("   Update ");
        jUpdateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateButtonMouseClicked(evt);
            }
        });
        jUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUpdateButtonActionPerformed(evt);
            }
        });

        jEditButton.setBackground(new java.awt.Color(217, 156, 69));
        jEditButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jEditButton.setForeground(new java.awt.Color(255, 255, 255));
        jEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Users/editing.png"))); // NOI18N
        jEditButton.setMnemonic('e');
        jEditButton.setText("    Edit  ");
        jEditButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEditButtonMouseClicked(evt);
            }
        });
        jEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Item:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUserNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRolesCombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(350, 350, 350))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(350, 350, 350))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jUserNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jRolesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jRoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
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
            
    }//GEN-LAST:event_jNameFieldMouseClicked

    private void jUsernameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUsernameFieldMouseClicked
            
    }//GEN-LAST:event_jUsernameFieldMouseClicked

    private void jPasswordFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldMouseClicked
            
    }//GEN-LAST:event_jPasswordFieldMouseClicked

    private void jRolesComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRolesComboMouseClicked
          
    }//GEN-LAST:event_jRolesComboMouseClicked

    private void jBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackButtonActionPerformed
        if(!isEditing) {
            resetViewUserPage();
            _jViewUsers.renderData();
            _jHomePage.switchPanels(_jViewUsers);
            
        }
    }//GEN-LAST:event_jBackButtonActionPerformed

    private void jCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelButtonActionPerformed
        if(isEditing) {
            cancelButton();
        }
    }//GEN-LAST:event_jCancelButtonActionPerformed

    private void jUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUpdateButtonActionPerformed
        if(isEditing) {
            updateButton();
        }
    }//GEN-LAST:event_jUpdateButtonActionPerformed

    private void jEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditButtonActionPerformed
        if(!isEditing) {
            enableUserFields();
            enableUpdateANdCancelButtons();
            isEditing = true;
        }
    }//GEN-LAST:event_jEditButtonActionPerformed
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
    private javax.swing.JLabel jLabel1;
    public javax.swing.JTextField jNameField;
    private javax.swing.JLabel jNameLabel;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JLabel jPasswordLabel;
    private javax.swing.JLabel jRoleLabel;
    public javax.swing.JComboBox<String> jRolesCombo;
    private javax.swing.JButton jUpdateButton;
    private javax.swing.JLabel jUserNameLabel;
    private javax.swing.JTextField jUsernameField;
    // End of variables declaration//GEN-END:variables
}
