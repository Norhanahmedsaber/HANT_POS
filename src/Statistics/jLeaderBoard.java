/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Statistics;

import Entities.CategoryInfo;
import Entities.UserInfo;
import Gui.jHomePage;

/**
 *
 * @author norha
 */
public class jLeaderBoard extends javax.swing.JPanel {

    /**
     * Creates new form jLeaderBoard
     */
    public jLeaderBoard(jHomePage jhp ,jViewStatistics jvs) {
        initComponents();
        _jHomePage=jhp;
        _jViewStatistics=jvs;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     public void changecolor(java.awt.Color c1,java.awt.Color c2,java.awt.Color c3,java.awt.Color c4,java.awt.Color c5)
    {
        setBackground(c1);
        jBack2.setBackground(c2);
        jBack2.setForeground(c4);
     jLabel2.setForeground(c3);
     jLabel4.setForeground(c3);
    jLabel5.setForeground(c3);
     jLabel6.setForeground(c3);
   jLabel7.setForeground(c3);
    jMostSoldCategory.setBackground(c5);
  jMostSoldCategoryscore.setBackground(c5);
     jPeriod.setForeground(c3);
     jRadioButton1.setBackground(c5);
    jRadioButton2.setBackground(c5);
  jRadioButton3.setBackground(c5);
    jRadioButton4.setBackground(c5);
  jUserWithTheMostDeals.setBackground(c5);
    jUserWithTheMostDealsscore.setBackground(c5);
     jUserWithTheMostImports.setBackground(c5);
    jUserWithTheMostImportsscore.setBackground(c5);
   jUserWithTheMostSales.setBackground(c5);
  jUserWithTheMostSalesscore.setBackground(c5);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jGroup = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jBack2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPeriod = new javax.swing.JLabel();
        jUserWithTheMostSales = new javax.swing.JTextField();
        jMostSoldCategory = new javax.swing.JTextField();
        jUserWithTheMostDeals = new javax.swing.JTextField();
        jUserWithTheMostImports = new javax.swing.JTextField();
        jUserWithTheMostSalesscore = new javax.swing.JTextField();
        jMostSoldCategoryscore = new javax.swing.JTextField();
        jUserWithTheMostDealsscore = new javax.swing.JTextField();
        jUserWithTheMostImportsscore = new javax.swing.JTextField();

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 1, 56)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Statistics/Icons/winner.png"))); // NOI18N
        jLabel2.setText("  LEADERBOARD");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Most Sold Category");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("User With The Most Sales");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("User With The Most Deals");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("User With The Most Imports");

        jBack2.setBackground(new java.awt.Color(217, 156, 69));
        jBack2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jBack2.setForeground(new java.awt.Color(255, 255, 255));
        jBack2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Roles/back.png"))); // NOI18N
        jBack2.setMnemonic('b');
        jBack2.setText("    Back   ");
        jBack2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBack2MouseClicked(evt);
            }
        });
        jBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBack2ActionPerformed(evt);
            }
        });

        jGroup.add(jRadioButton1);
        jRadioButton1.setText("Today");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });

        jGroup.add(jRadioButton2);
        jRadioButton2.setText("This Week");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });

        jGroup.add(jRadioButton3);
        jRadioButton3.setText("This Month");
        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton3MouseClicked(evt);
            }
        });
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jGroup.add(jRadioButton4);
        jRadioButton4.setText("This Year");
        jRadioButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton4MouseClicked(evt);
            }
        });

        jPeriod.setFont(new java.awt.Font("Lucida Fax", 1, 36)); // NOI18N
        jPeriod.setText("Period");

        jUserWithTheMostSales.setToolTipText("");

        jMostSoldCategory.setText("jTextField1");

        jUserWithTheMostDeals.setText("jTextField1");

        jUserWithTheMostImports.setText("jTextField1");

        jUserWithTheMostSalesscore.setText("jTextField1");

        jMostSoldCategoryscore.setText("jTextField1");

        jUserWithTheMostDealsscore.setText("jTextField1");

        jUserWithTheMostImportsscore.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jUserWithTheMostDeals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(248, 248, 248)
                                        .addComponent(jMostSoldCategoryscore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jUserWithTheMostSales)
                                            .addComponent(jMostSoldCategory))
                                        .addGap(107, 107, 107)
                                        .addComponent(jUserWithTheMostSalesscore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jUserWithTheMostImports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jUserWithTheMostImportsscore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jUserWithTheMostDealsscore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton3))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 88, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(136, 136, 136))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(122, 122, 122))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(4, 4, 4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jMostSoldCategoryscore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(jUserWithTheMostSalesscore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)))
                                .addComponent(jUserWithTheMostDealsscore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jUserWithTheMostImportsscore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jMostSoldCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jUserWithTheMostSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jUserWithTheMostDeals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jUserWithTheMostImports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jRadioButton4)
                        .addComponent(jRadioButton3)
                        .addComponent(jRadioButton2)
                        .addComponent(jRadioButton1)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
        public void today(){
            _jViewStatistics.allDays=_jViewStatistics.fetchData();
            jPeriod.setText("Of The Day");
            String maxName = "";
            int max = 0;
            for(CategoryInfo cat : _jViewStatistics.cats) {
                if(cat.NumberOfItemsToday > max) {
                    max = cat.NumberOfItemsToday;
                    maxName = cat.name;
                }
            }
            jMostSoldCategory.setText(maxName);
            jMostSoldCategoryscore.setText(Integer.toString(max));
            
            maxName = "";
            max = 0;
            for(UserInfo user : _jViewStatistics.users) {
                if(user.profitToday > max) {
                    max = user.profitToday;
                    maxName = user.username;
                }
            }
            jUserWithTheMostSales.setText(maxName);
            jUserWithTheMostSalesscore.setText(Integer.toString(max));
            
            maxName = "";
            max = 0;
            for(UserInfo user : _jViewStatistics.users) {
                if(user.dealsDoneToday > max) {
                    max = user.dealsDoneToday;
                    maxName = user.username;
                }
            }
            jUserWithTheMostDeals.setText(maxName);
            jUserWithTheMostDealsscore.setText(Integer.toString(max));
            
            maxName = "";
            max = 0;
            for(UserInfo user : _jViewStatistics.users) {
                if(user.itemsImportedToday > max) {
                    max = user.itemsImportedToday;
                    maxName = user.username;
                }
            }
            jUserWithTheMostImports.setText(maxName);
            jUserWithTheMostImportsscore.setText(Integer.toString(max));
        } 
        public void week(){
            _jViewStatistics.allDays=_jViewStatistics.fetchData();
            jPeriod.setText("Of The Week");
            String maxName = "";
            int max = 0;
            for(CategoryInfo cat : _jViewStatistics.cats) {
                if(cat.NumberOfItemsThisWeek > max) {
                    max = cat.NumberOfItemsThisWeek;
                    maxName = cat.name;
                }
            }
            jMostSoldCategory.setText(maxName);
            jMostSoldCategoryscore.setText(Integer.toString(max));
            
            maxName = "";
            max = 0;
            for(UserInfo user : _jViewStatistics.users) {
                if(user.profitThisWeek > max) {
                    max = user.profitThisWeek;
                    maxName = user.username;
                }
            }
            jUserWithTheMostSales.setText(maxName);
            jUserWithTheMostSalesscore.setText(Integer.toString(max));
            
            maxName = "";
            max = 0;
            for(UserInfo user : _jViewStatistics.users) {
                if(user.dealsDoneThisWeek > max) {
                    max = user.dealsDoneThisWeek;
                    maxName = user.username;
                }
            }
            jUserWithTheMostDeals.setText(maxName);
            jUserWithTheMostDealsscore.setText(Integer.toString(max));
            
            maxName = "";
            max = 0;
            for(UserInfo user : _jViewStatistics.users) {
                if(user.itemsImportedThisWeek > max) {
                    max = user.itemsImportedThisWeek;
                    maxName = user.username;
                }
            }
            jUserWithTheMostImports.setText(maxName);
            jUserWithTheMostImportsscore.setText(Integer.toString(max));
        } 
        public void month(){
            _jViewStatistics.allDays=_jViewStatistics.fetchData();
            jPeriod.setText("Of The Month");
            String maxName = "";
            int max = 0;
            for(CategoryInfo cat : _jViewStatistics.cats) {
                if(cat.NumberOfItemsThisMonth > max) {
                    max = cat.NumberOfItemsThisMonth;
                    maxName = cat.name;
                }
            }
            jMostSoldCategory.setText(maxName);
            jMostSoldCategoryscore.setText(Integer.toString(max));
            
            maxName = "";
            max = 0;
            for(UserInfo user : _jViewStatistics.users) {
                if(user.profitThisMonth > max) {
                    max = user.profitThisMonth;
                    maxName = user.username;
                }
            }
            jUserWithTheMostSales.setText(maxName);
            jUserWithTheMostSalesscore.setText(Integer.toString(max));
            
            maxName = "";
            max = 0;
            for(UserInfo user : _jViewStatistics.users) {
                if(user.dealsDoneThisMonth > max) {
                    max = user.dealsDoneThisMonth;
                    maxName = user.username;
                }
            }
            jUserWithTheMostDeals.setText(maxName);
            jUserWithTheMostDealsscore.setText(Integer.toString(max));
            
            maxName = "";
            max = 0;
            for(UserInfo user : _jViewStatistics.users) {
                if(user.itemsImportedThisMonth > max) {
                    max = user.itemsImportedThisMonth;
                    maxName = user.username;
                }
            }
            jUserWithTheMostImports.setText(maxName);
            jUserWithTheMostImportsscore.setText(Integer.toString(max));
        } 
        public void year(){
            _jViewStatistics.allDays=_jViewStatistics.fetchData();
            jPeriod.setText("Of The Year");
            String maxName = "";
            int max = 0;
            for(CategoryInfo cat : _jViewStatistics.cats) {
                if(cat.NumberOfItemsThisYear > max) {
                    max = cat.NumberOfItemsThisYear;
                    maxName = cat.name;
                }
            }
            jMostSoldCategory.setText(maxName);
            jMostSoldCategoryscore.setText(Integer.toString(max));
            
            maxName = "";
            max = 0;
            for(UserInfo user : _jViewStatistics.users) {
                if(user.profitThisYear > max) {
                    max = user.profitThisYear;
                    maxName = user.username;
                }
            }
            jUserWithTheMostSales.setText(maxName);
            jUserWithTheMostSalesscore.setText(Integer.toString(max));
            
            maxName = "";
            max = 0;
            for(UserInfo user : _jViewStatistics.users) {
                if(user.dealsDoneThisYear > max) {
                    max = user.dealsDoneThisYear;
                    maxName = user.username;
                }
            }
            jUserWithTheMostDeals.setText(maxName);
            jUserWithTheMostDealsscore.setText(Integer.toString(max));
            
            maxName = "";
            max = 0;
            for(UserInfo user : _jViewStatistics.users) {
                if(user.itemsImportedThisYear > max) {
                    max = user.itemsImportedThisYear;
                    maxName = user.username;
                }
            }
            jUserWithTheMostImports.setText(maxName);
            jUserWithTheMostImportsscore.setText(Integer.toString(max));
        } 
    private void jBack2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBack2MouseClicked
        _jHomePage.switchPanels(_jViewStatistics);

    }//GEN-LAST:event_jBack2MouseClicked

    private void jBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBack2ActionPerformed
        
    }//GEN-LAST:event_jBack2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        today();
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        week();
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jRadioButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton3MouseClicked
        month();
    }//GEN-LAST:event_jRadioButton3MouseClicked

    private void jRadioButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton4MouseClicked
        year();
    }//GEN-LAST:event_jRadioButton4MouseClicked

private jHomePage _jHomePage;
private jViewStatistics _jViewStatistics;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBack2;
    private javax.swing.ButtonGroup jGroup;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jMostSoldCategory;
    private javax.swing.JTextField jMostSoldCategoryscore;
    private javax.swing.JLabel jPeriod;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTextField jUserWithTheMostDeals;
    private javax.swing.JTextField jUserWithTheMostDealsscore;
    private javax.swing.JTextField jUserWithTheMostImports;
    private javax.swing.JTextField jUserWithTheMostImportsscore;
    private javax.swing.JTextField jUserWithTheMostSales;
    private javax.swing.JTextField jUserWithTheMostSalesscore;
    // End of variables declaration//GEN-END:variables
}
