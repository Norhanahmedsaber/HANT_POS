package Gui;

import Entities.Log;
import Entities.User;
import Services.LogServices;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.UUID;
import javax.swing.JPanel;
public class jHomePage extends javax.swing.JFrame {

    public jHomePage() {
        initComponents();
        _jLoginPage = new jLoginPage(this);
        loginUser = null;
        _LogServices = new LogServices();
        Home();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while(true) {
                    _jLoginPage._jMainPage._jViewStatistics.allDays = _jLoginPage._jMainPage._jViewStatistics.fetchData();
                }
            }
        });
        thread.start();
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
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while(true) {
                    _jLoginPage._jMainPage._jViewStatistics.allDays = _jLoginPage._jMainPage._jViewStatistics.fetchData();
                }
            }
        });
        thread.start();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jsignin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jsignin, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(505, Short.MAX_VALUE)
                .addComponent(jsignin, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jPanel4.add(jPanel1, "card2");

        getContentPane().add(jPanel4, "card2");

        setSize(new java.awt.Dimension(768, 627));
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
    public jMainPage _jmaMainPage;
    private final jLoginPage _jLoginPage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JButton jsignin;
    // End of variables declaration//GEN-END:variables
}
