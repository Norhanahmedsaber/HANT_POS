package Gui;
 
import Entities.User;
import Services.AccountServices;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
public class jLoginPage extends javax.swing.JPanel {

    public jLoginPage(jHomePage jhp, jMainPage jmp) {
        initComponents();
        _jHomePage = jhp;
        _jMainPage = jmp; 
        _AccountServices=new AccountServices();
    }
    
   public  void changecolor(java.awt.Color c, java.awt.Color c2, java.awt.Color c3, java.awt.Color c4, java.awt.Color c5)
    { 
        setBackground(c);
        jlogin.setBackground(c2);
        jBack.setBackground(c2);
        jlogin.setForeground(c4);
        jBack.setForeground(c4);
        jLabel1.setForeground(c3);
        jLabel2.setForeground(c3);
        jusername.setBackground(c5);
        jpassword.setBackground(c5);
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jusername = new javax.swing.JTextField();
        jlogin = new javax.swing.JButton();
        jpassword = new javax.swing.JPasswordField();
        jBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(87, 118, 130));
        setForeground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(800, 700));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("UserName :");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Password :");

        jusername.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jusername.setForeground(new java.awt.Color(0, 31, 78));
        jusername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jusernameKeyPressed(evt);
            }
        });

        jlogin.setBackground(new java.awt.Color(217, 156, 69));
        jlogin.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jlogin.setForeground(java.awt.Color.white);
        jlogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/log-in3.png"))); // NOI18N
        jlogin.setMnemonic('l');
        jlogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jloginMouseClicked(evt);
            }
        });
        jlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jloginActionPerformed(evt);
            }
        });

        jpassword.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jpassword.setForeground(new java.awt.Color(0, 31, 78));
        jpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpasswordKeyPressed(evt);
            }
        });

        jBack.setBackground(new java.awt.Color(217, 156, 69));
        jBack.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jBack.setForeground(new java.awt.Color(255, 255, 255));
        jBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/back.png"))); // NOI18N
        jBack.setMnemonic('b');
        jBack.setText("  Back");
        jBack.setToolTipText("");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jusername, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jusername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void clearLogINPage(){
        jusername.setText("");
        jpassword.setText("");
    }
    public void login() {
        
        if(jusername.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username is Empty!");
            return;
        }
        if(jpassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password is Empty!");
            return;
        }
            User user = _AccountServices.login(jusername.getText().trim(),jpassword.getText().trim());
        if( user!=null )
        {
            clearLogINPage();
            _jHomePage.switchPanels(_jMainPage);
            _jHomePage.loginUser=user;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Username and Password Don't Match!");
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

    private void jloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jloginActionPerformed
        login();
    }//GEN-LAST:event_jloginActionPerformed

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        _jHomePage.Home();
        clearLogINPage();
    }//GEN-LAST:event_jBackActionPerformed

    
   
    private final AccountServices _AccountServices;
    public final jMainPage _jMainPage ;
    private final jHomePage _jHomePage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jlogin;
    private javax.swing.JPasswordField jpassword;
    public javax.swing.JTextField jusername;
    // End of variables declaration//GEN-END:variables
}
