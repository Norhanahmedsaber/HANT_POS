package Gui.Users;

import Entities.Role;
import Entities.User;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.AccountServices;
import Services.RoleServices;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
 
public class jNewUsers extends javax.swing.JPanel {
    public jNewUsers(jHomePage jhp , jMainPage jmp) {
        initComponents();
        _jHomePage = jhp;
        _jMainPage = jmp;
        _AccountServices = new AccountServices();
        _RoleServices = new RoleServices();
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
        return isValidPassword();
    }
    public void saveUserData(){
        User user = new User();
        user.id = UUID.randomUUID();    
        user.name = jNameField.getText().trim();
        user.userName = jUsernameField.getText().trim();
        user.password = jPasswordField.getText().trim();
        user.role = _RoleServices.getByName((String) jRolesCombo.getSelectedItem());
        _AccountServices.signUp(user);
        jAddedSuccessfully.setVisible(true);
        jAddedSuccessfully.setText("User was added successfully");
        _jHomePage.createLog("Added","User",user.name );
    }
    public void clearSignUpPage(){
        jNameField.setText("");
        jPasswordField.setText("");
        jUsernameField.setText("");
        jErrorName.setText("");
        jErrorPassword.setText("");
        jErrorUsername.setText("");
        ArrayList<String> roleNames = _RoleServices.getAll();
        String[] names = new String[roleNames.size()];
        for(int i=0;i<roleNames.size();i++){
            names[i] = roleNames.get(i);
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(names);
        jRolesCombo.setModel(model);
    }
    public void addAccountButton(){
        if(!checkAllValidations()){
            return;
        }
        
        saveUserData();
        clearSignUpPage();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jNameField = new javax.swing.JTextField();
        jUsernameField = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jRolesCombo = new javax.swing.JComboBox<>();
        jAddAccount = new javax.swing.JButton();
        jErrorName = new javax.swing.JLabel();
        jErrorUsername = new javax.swing.JLabel();
        jErrorPassword = new javax.swing.JLabel();
        jBack = new javax.swing.JButton();
        jAddedSuccessfully = new javax.swing.JLabel();

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setText("Name ");

        jLabel2.setText("Role");

        jLabel3.setText("UserName");

        jLabel4.setText("password");

        jNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNameFieldKeyPressed(evt);
            }
        });

        jUsernameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jUsernameFieldKeyPressed(evt);
            }
        });

        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldKeyPressed(evt);
            }
        });

        jRolesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Manager", " ", " " }));
        jRolesCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRolesComboKeyPressed(evt);
            }
        });

        jAddAccount.setText("Add Account ");
        jAddAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddAccountMouseClicked(evt);
            }
        });
        jAddAccount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jAddAccountKeyPressed(evt);
            }
        });

        jErrorName.setForeground(new java.awt.Color(255, 0, 0));

        jErrorUsername.setForeground(new java.awt.Color(255, 0, 0));

        jErrorPassword.setForeground(new java.awt.Color(255, 0, 0));
        jErrorPassword.setToolTipText("");

        jBack.setText("Back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        jAddedSuccessfully.setForeground(new java.awt.Color(0, 255, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jBack)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jErrorUsername)
                            .addComponent(jErrorName)
                            .addComponent(jErrorPassword))
                        .addGap(0, 54, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jAddAccount)
                            .addComponent(jRolesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAddedSuccessfully, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jErrorName)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jErrorUsername)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jErrorPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRolesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jAddedSuccessfully, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBack)
                    .addComponent(jAddAccount))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        _jHomePage.switchPanels(_jMainPage);
        _jMainPage.jAddusers.grabFocus();
        jAddedSuccessfully.setText("");
        clearSignUpPage();
    }//GEN-LAST:event_jBackMouseClicked

    private void jRolesComboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRolesComboKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addAccountButton();
        }
    }//GEN-LAST:event_jRolesComboKeyPressed

    private void jPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addAccountButton();
        }
    }//GEN-LAST:event_jPasswordFieldKeyPressed

    private void jUsernameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jUsernameFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addAccountButton();
        }
    }//GEN-LAST:event_jUsernameFieldKeyPressed

    private void jNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNameFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addAccountButton();
        }
    }//GEN-LAST:event_jNameFieldKeyPressed

    private void jAddAccountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jAddAccountKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addAccountButton();
        }
    }//GEN-LAST:event_jAddAccountKeyPressed

    private void jAddAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddAccountMouseClicked
        addAccountButton();
    }//GEN-LAST:event_jAddAccountMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addAccountButton();
        }
    }//GEN-LAST:event_formKeyPressed
    
    private final jMainPage _jMainPage;
    private final jHomePage _jHomePage;
    private final AccountServices _AccountServices;
    private final RoleServices _RoleServices;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddAccount;
    private javax.swing.JLabel jAddedSuccessfully;
    private javax.swing.JButton jBack;
    private javax.swing.JLabel jErrorName;
    private javax.swing.JLabel jErrorPassword;
    private javax.swing.JLabel jErrorUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JTextField jNameField;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JComboBox<String> jRolesCombo;
    private javax.swing.JTextField jUsernameField;
    // End of variables declaration//GEN-END:variables
}
