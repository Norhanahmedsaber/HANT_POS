package Gui;

import Entities.Log;
import Entities.User;
import static Gui.jMainPage.toggle;
import Services.LogServices;
import Statistics.jViewStatistics;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.UUID;
import javax.swing.JPanel;
public class jHomePage extends javax.swing.JFrame {

    public jHomePage() {
        initComponents();
        loginUser = null;
        _LogServices = new LogServices();
        _jmaMainPage = new jMainPage(this);
        _jLoginPage = new jLoginPage(this, _jmaMainPage);
        Home();
    }
     
   
    public void changecolor(java.awt.Color c, java.awt.Color c2, java.awt.Color c3, java.awt.Color c4, java.awt.Color c5)
    { 
        jPanel1.setBackground(c);
        _jmaMainPage._jNewCustomer._jChooseItem.changecolor(c);
        _jmaMainPage._jViewCustomers._jViewCustomer._jChooseItem.changecolor(c);
        _jmaMainPage._jNewCustomer.changecolor(c);
        _jmaMainPage._jViewCustomers.changecolor(c);
        _jmaMainPage._jViewCustomers._jViewCustomer.changecolor(c);
        _jmaMainPage._jNewItem.changecolor(c);
        _jmaMainPage._jViewItems._jViewItem.changecolor(c);
        _jmaMainPage._jViewItems.changecolor(c);
        _jmaMainPage._jShowLogs.changecolor(c);
        _jmaMainPage._jcreaterole.changecolor(c);
        _jmaMainPage._jViewRoles.changecolor(c);
        _jmaMainPage._jSignUpPage.changecolor(c);
        _jmaMainPage._jViewUsers._jViewUser.changecolor(c);
        _jmaMainPage._jViewUsers.changecolor(c);
        _jmaMainPage.changecolor(c);
        _jLoginPage.changecolor(c,c2,c3,c4,c5);
        _jmaMainPage._jViewStatistics.changecolor(c);
        
    }
    public void createLog(String action, String actedOn, String actedOnName ){
        Log log =new Log();
        log.id= UUID.randomUUID();
        log.userName =loginUser.userName;
        log.userRole =loginUser.role.name;
        log.action = action;
        log.actedOn = actedOn;
        log.actedOnName = actedOnName;
        log.date= new Date(); 
        _LogServices.create(log);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jsignin = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel4.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(87, 118, 130));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(170, 117, 111), null, null));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 750));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jsignin.setBackground(new java.awt.Color(217, 156, 69));
        jsignin.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jsignin.setForeground(new java.awt.Color(255, 255, 255));
        jsignin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/enter.png"))); // NOI18N
        jsignin.setMnemonic('e');
        jsignin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jsigninMouseClicked(evt);
            }
        });
        jsignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsigninActionPerformed(evt);
            }
        });
        jsignin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jsigninKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jsignin, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(558, Short.MAX_VALUE)
                .addComponent(jsignin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        jPanel4.add(jPanel1, "card2");

        getContentPane().add(jPanel4, "card2");

        jMenuBar1.setBackground(new java.awt.Color(87, 118, 130));

        jMenu1.setText("Dark Mode");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu4.setText("Light Mode");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Theme");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(821, 755));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jsigninMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jsigninMouseClicked
        switchPanels(_jLoginPage);
        _jLoginPage.jusername.grabFocus();
        
    }//GEN-LAST:event_jsigninMouseClicked

    private void jsigninKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jsigninKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            switchPanels(_jLoginPage);
            _jLoginPage.jusername.grabFocus();
        }
    }//GEN-LAST:event_jsigninKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            switchPanels(_jLoginPage);
            _jLoginPage.jusername.grabFocus();
        }
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jsigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsigninActionPerformed
        switchPanels(_jLoginPage);
        _jLoginPage.jusername.grabFocus();
    }//GEN-LAST:event_jsigninActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        changecolor(new java.awt.Color(50, 51, 52),new java.awt.Color(189, 135, 245), new java.awt.Color(135, 189, 245), new java.awt.Color(255, 255, 204), new java.awt.Color(255, 255, 204));
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        changecolor(new java.awt.Color(87, 118, 130), new java.awt.Color(217, 156, 69), new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jMenu4MouseClicked
    public void switchPanels(JPanel panel) {
        jPanel4.removeAll();
        jPanel4.add(panel);
        jPanel4.repaint();
        jPanel4.revalidate();
    }
    public void Home() {
        switchPanels(jPanel1);
        jsignin.grabFocus();
    }
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jHomePage().setVisible(true);
            }
        });
    }
    private final LogServices _LogServices;
    public User loginUser;
    private final jMainPage _jmaMainPage;
    private final jLoginPage _jLoginPage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JButton jsignin;
    // End of variables declaration//GEN-END:variables
}
