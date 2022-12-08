package Gui;

import Services.AccountServices;
import java.awt.Container;
import javax.swing.JRootPane;

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

        jLabel1.setText("UserName");

        jLabel2.setText("Password");

        jlogin.setText("login");
        jlogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jloginMouseClicked(evt);
            }
        });

        error.setForeground(new java.awt.Color(255, 0, 0));

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jusername, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                    .addComponent(jpassword)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(error)))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBack)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(error)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jlogin)
                .addGap(18, 18, 18)
                .addComponent(jBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    public JRootPane getRootPane() {
        return super.getRootPane(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Container getParent() {
        return super.getParent(); //To change body of generated methods, choose Tools | Templates.
    }

    private void jloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jloginMouseClicked
//        if(jusername.getText().isEmpty()) {
//            error.setText("Username Is Empty!");
//            return;
//        }else error.setText(""); 
//        if(jpassword.getText().isEmpty()) {
//            error.setText("password Is Empty!");
//            return;
//        }else error.setText("");
        if( _AccountServices.login( jusername.getText(), jpassword.getText()) )
        {
            jusername.setText("");
            jpassword.setText("");
            _jHomePage.switchPanels(_jMainPage);
        }
        else
        {     
            error.setText("Password or Username dont match!");
        } 
           
    }//GEN-LAST:event_jloginMouseClicked

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        _jHomePage.Home();
        jusername.setText("");
        jpassword.setText(""); 
    }//GEN-LAST:event_jBackMouseClicked

    
   
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
    private javax.swing.JTextField jusername;
    // End of variables declaration//GEN-END:variables
}
