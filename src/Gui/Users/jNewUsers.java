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
import javax.swing.JOptionPane;
 
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
        JOptionPane.showMessageDialog(null, "Added Successfully!");
        _jHomePage.createLog("Created","User",user.name );
    }
    public void clearSignUpPage(){
        jNameField.setText("");
        jPasswordField.setText("");
        jUsernameField.setText("");
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
        jBack = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(87, 118, 130));
        setForeground(new java.awt.Color(255, 255, 255));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name: ");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Role:");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("UserName:");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("password:");

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
        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldKeyPressed(evt);
            }
        });

        jRolesCombo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
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

        jAddAccount.setBackground(new java.awt.Color(217, 156, 69));
        jAddAccount.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jAddAccount.setForeground(new java.awt.Color(255, 255, 255));
        jAddAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Users/addcustomer.png"))); // NOI18N
        jAddAccount.setMnemonic('a');
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
        jAddAccount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jAddAccountKeyPressed(evt);
            }
        });

        jBack.setBackground(new java.awt.Color(217, 156, 69));
        jBack.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jBack.setForeground(new java.awt.Color(255, 255, 255));
        jBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Users/back.png"))); // NOI18N
        jBack.setMnemonic('b');
        jBack.setText("     Back   ");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });
        jBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("New User:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jAddAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jRolesCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPasswordField)
                                    .addComponent(jUsernameField)
                                    .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 336, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jRolesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAddAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        _jHomePage.switchPanels(_jMainPage);
        _jMainPage.jAddusers.grabFocus();
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

    private void jNameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNameFieldMouseClicked
        
    }//GEN-LAST:event_jNameFieldMouseClicked

    private void jUsernameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUsernameFieldMouseClicked
      
    }//GEN-LAST:event_jUsernameFieldMouseClicked

    private void jRolesComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRolesComboMouseClicked

    }//GEN-LAST:event_jRolesComboMouseClicked

    private void jAddAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddAccountActionPerformed
        addAccountButton();
    }//GEN-LAST:event_jAddAccountActionPerformed

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        _jHomePage.switchPanels(_jMainPage);
        _jMainPage.jAddusers.grabFocus();
        clearSignUpPage();
    }//GEN-LAST:event_jBackActionPerformed
    
    private final jMainPage _jMainPage;
    private final jHomePage _jHomePage;
    private final AccountServices _AccountServices;
    private final RoleServices _RoleServices;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddAccount;
    private javax.swing.JButton jBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JTextField jNameField;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JComboBox<String> jRolesCombo;
    private javax.swing.JTextField jUsernameField;
    // End of variables declaration//GEN-END:variables
}
