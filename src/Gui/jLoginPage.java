package Gui;

import Entities.User;
import Services.AccountServices;
import java.awt.event.KeyEvent;
public class jLoginPage extends javax.swing.JPanel {

    public jLoginPage(jHomePage jhp) {
        initComponents();
        _jHomePage = jhp;
        _jMainPage = new jMainPage(jhp); 
        _AccountServices=new AccountServices();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jusername = new javax.swing.JTextField();
        jlogin = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        jpassword = new javax.swing.JPasswordField();
        jBack = new javax.swing.JButton();

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setText("UserName");

        jLabel2.setText("Password");

        jusername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jusernameKeyPressed(evt);
            }
        });

        jlogin.setText("login");
        jlogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jloginMouseClicked(evt);
            }
        });

        error.setForeground(new java.awt.Color(255, 0, 0));

        jpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpasswordKeyPressed(evt);
            }
        });

        jBack.setText("Back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jusername, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(error))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(error)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jlogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBack)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void clearLogINPage(){
        jusername.setText("");
        jpassword.setText("");
        error.setText("");
    }
    public void login() {
        if(jusername.getText().isEmpty()) {
            error.setText("Username Is Empty!");
            return;
        }else error.setText(""); 
        if(jpassword.getText().isEmpty()) {
            error.setText("password Is Empty!");
            return;
        }else error.setText("");
            User user = _AccountServices.login(jusername.getText(),jpassword.getText());
        if( user!=null )
        {
            clearLogINPage();
            _jHomePage.switchPanels(_jMainPage);
            _jHomePage.loginUser=user;
        }
        else
        {     
            error.setText("Password or Username dont match!");
            return;
        }
        _jMainPage.canCreateUser();
        _jMainPage.canCreateCustomer();
        _jMainPage.canViewCustomers();
        _jMainPage.canDeleteCustomer();
        _jMainPage.canUpdateCustomer();
        _jMainPage.canCreateItem();
        _jMainPage.canViewItems();
        _jMainPage.canDeleteItem();
        _jMainPage.canViewUsers();
        _jMainPage.canViewLogs();
        _jMainPage.canUpdateItem();
        _jMainPage.canDeleteLog();
        _jMainPage.canCreateRole();
        _jMainPage.canDeleteRole();
        _jMainPage.canUpdateRole();
        _jMainPage.canDeleteUser();
        _jMainPage.canViewRoles();
    }
    private void jloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jloginMouseClicked
        login();
    }//GEN-LAST:event_jloginMouseClicked

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        _jHomePage.Home();
        clearLogINPage();
    }//GEN-LAST:event_jBackMouseClicked

    private void jpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpasswordKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            login();
        }
    }//GEN-LAST:event_jpasswordKeyPressed

    private void jusernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jusernameKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            login();
        }
    }//GEN-LAST:event_jusernameKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
                login();
            }
    }//GEN-LAST:event_formKeyPressed

    
   
    private final AccountServices _AccountServices;
    private final jMainPage _jMainPage ;
    private final jHomePage _jHomePage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel error;
    private javax.swing.JButton jBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jlogin;
    private javax.swing.JPasswordField jpassword;
    public javax.swing.JTextField jusername;
    // End of variables declaration//GEN-END:variables
}
