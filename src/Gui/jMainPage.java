package Gui;
import Gui.Users.jNewUsers;
import Gui.Items.jNewItem;
import Gui.Customers.jNewCustomer;
import Gui.Customers.jViewCustomer;
import Gui.Logs.jViewLogs;
import Gui.Customers.jViewCustomers;
import Gui.Items.jViewItem;
import Gui.Users.jViewUsers;
import Gui.Items.jViewItems;
import Gui.Roles.jViewRoles;
import Gui.Roles.jNewRole;
import Gui.Users.jViewUser;
import Statistics.jViewStatistics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class jMainPage extends javax.swing.JPanel {

    public jMainPage(jHomePage jhp) {
        initComponents();
        _jHomePage = jhp;
       _jNewCustomer = new jNewCustomer(jhp, this);
        _jNewItem = new jNewItem(jhp, this);
        _jViewItems = new jViewItems(jhp, this);
        _jViewCustomers = new jViewCustomers(jhp, this);
        _jShowLogs = new jViewLogs(jhp, this);
        _jSignUpPage = new jNewUsers(jhp,this);
        _jViewUsers = new jViewUsers(jhp , this);
        _jcreaterole = new jNewRole(jhp, this);
        _jViewRoles = new jViewRoles(jhp, this);
       _jViewCustomer = new jViewCustomer(_jViewCustomers, jhp, this);
        _jViewItem = new jViewItem(jhp,_jViewItems, this);
        _jViewLogs = new jViewLogs(jhp, this);
        _jViewUser = new jViewUser(_jViewUsers, jhp);
  //      JPanel parent = null;
//         if (parent instanceof jNewCustomer )
//        {
//            parent = _jNewCustomer;
//        }
//        else 
//        {   
//           parent = _jViewCustomer;
//        } 
//        _jChooseItem = new jChooseItem(jhp, parent );
 

        _jViewStatistics = new jViewStatistics(jhp, this);
         toggle = false;      
  }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jNewitem = new javax.swing.JButton();
        jViewitems = new javax.swing.JButton();
        jViewcustomers = new javax.swing.JButton();
        jLog = new javax.swing.JButton();
        jNewcustomer = new javax.swing.JButton();
        jLogout = new javax.swing.JButton();
        jAddusers = new javax.swing.JButton();
        jViewusers = new javax.swing.JButton();
        jViewRoles = new javax.swing.JButton();
        jNewRole = new javax.swing.JButton();
        jStats = new javax.swing.JButton();

        setBackground(new java.awt.Color(87, 118, 130));

        jNewitem.setBackground(new java.awt.Color(217, 156, 69));
        jNewitem.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jNewitem.setForeground(new java.awt.Color(255, 255, 255));
        jNewitem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/addItem.png"))); // NOI18N
        jNewitem.setMnemonic('i');
        jNewitem.setText("          New Item                         ");
        jNewitem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNewitemMouseClicked(evt);
            }
        });
        jNewitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewitemActionPerformed(evt);
            }
        });

        jViewitems.setBackground(new java.awt.Color(217, 156, 69));
        jViewitems.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jViewitems.setForeground(new java.awt.Color(255, 255, 255));
        jViewitems.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/product.png"))); // NOI18N
        jViewitems.setMnemonic('t');
        jViewitems.setText("          View Items                       ");
        jViewitems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jViewitemsMouseClicked(evt);
            }
        });
        jViewitems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jViewitemsActionPerformed(evt);
            }
        });

        jViewcustomers.setBackground(new java.awt.Color(217, 156, 69));
        jViewcustomers.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jViewcustomers.setForeground(new java.awt.Color(255, 255, 255));
        jViewcustomers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/newCustomers.png"))); // NOI18N
        jViewcustomers.setMnemonic('m');
        jViewcustomers.setText("          View Customers             ");
        jViewcustomers.setPreferredSize(new java.awt.Dimension(300, 50));
        jViewcustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jViewcustomersMouseClicked(evt);
            }
        });
        jViewcustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jViewcustomersActionPerformed(evt);
            }
        });

        jLog.setBackground(new java.awt.Color(217, 156, 69));
        jLog.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLog.setForeground(new java.awt.Color(255, 255, 255));
        jLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/logs.png"))); // NOI18N
        jLog.setMnemonic('l');
        jLog.setText("           Log                                    ");
        jLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLogMouseClicked(evt);
            }
        });
        jLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogActionPerformed(evt);
            }
        });

        jNewcustomer.setBackground(new java.awt.Color(217, 156, 69));
        jNewcustomer.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jNewcustomer.setForeground(new java.awt.Color(255, 255, 255));
        jNewcustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/newcustomer.png"))); // NOI18N
        jNewcustomer.setMnemonic('c');
        jNewcustomer.setText("         New Customer                ");
        jNewcustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNewcustomerMouseClicked(evt);
            }
        });
        jNewcustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewcustomerActionPerformed(evt);
            }
        });

        jLogout.setBackground(new java.awt.Color(217, 156, 69));
        jLogout.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLogout.setForeground(new java.awt.Color(255, 255, 255));
        jLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/logout.png"))); // NOI18N
        jLogout.setMnemonic('e');
        jLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLogoutMouseClicked(evt);
            }
        });
        jLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoutActionPerformed(evt);
            }
        });

        jAddusers.setBackground(new java.awt.Color(217, 156, 69));
        jAddusers.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jAddusers.setForeground(new java.awt.Color(255, 255, 255));
        jAddusers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/newUser.png"))); // NOI18N
        jAddusers.setMnemonic('u');
        jAddusers.setText("          New User                          ");
        jAddusers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddusersMouseClicked(evt);
            }
        });
        jAddusers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddusersActionPerformed(evt);
            }
        });

        jViewusers.setBackground(new java.awt.Color(217, 156, 69));
        jViewusers.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jViewusers.setForeground(new java.awt.Color(255, 255, 255));
        jViewusers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/viewUsers.png"))); // NOI18N
        jViewusers.setMnemonic('e');
        jViewusers.setText("          View Users                       ");
        jViewusers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jViewusersMouseClicked(evt);
            }
        });
        jViewusers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jViewusersActionPerformed(evt);
            }
        });

        jViewRoles.setBackground(new java.awt.Color(217, 156, 69));
        jViewRoles.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jViewRoles.setForeground(new java.awt.Color(255, 255, 255));
        jViewRoles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/viewRoles.png"))); // NOI18N
        jViewRoles.setMnemonic('o');
        jViewRoles.setText("          View Roles                       ");
        jViewRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jViewRolesMouseClicked(evt);
            }
        });
        jViewRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jViewRolesActionPerformed(evt);
            }
        });

        jNewRole.setBackground(new java.awt.Color(217, 156, 69));
        jNewRole.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jNewRole.setForeground(new java.awt.Color(255, 255, 255));
        jNewRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/newRole.png"))); // NOI18N
        jNewRole.setMnemonic('r');
        jNewRole.setText("         New Role                        ");
        jNewRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNewRoleMouseClicked(evt);
            }
        });
        jNewRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewRoleActionPerformed(evt);
            }
        });

        jStats.setBackground(new java.awt.Color(217, 156, 69));
        jStats.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jStats.setForeground(new java.awt.Color(255, 255, 255));
        jStats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/statistics.png"))); // NOI18N
        jStats.setMnemonic('s');
        jStats.setText("          Statistics                          ");
        jStats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jStatsMouseClicked(evt);
            }
        });
        jStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStatsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLog, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                            .addComponent(jNewRole, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jAddusers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jNewcustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jNewitem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jViewitems, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jViewusers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jStats, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                    .addComponent(jViewRoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jViewcustomers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNewcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jViewcustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNewitem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jViewitems, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jViewusers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAddusers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNewRole, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jViewRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLog, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStats, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jNewcustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNewcustomerMouseClicked
        if(canCreateCustomer()) {
            _jHomePage.switchPanels(_jNewCustomer);
            _jNewCustomer.jNameField.grabFocus();
        }
    }//GEN-LAST:event_jNewcustomerMouseClicked

    private void jViewcustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewcustomersMouseClicked
        if(canViewCustomers()) {
            _jViewCustomers.renderData();
            _jHomePage.switchPanels(_jViewCustomers);   
            _jViewCustomers.jSearchName.grabFocus();
        }
    }//GEN-LAST:event_jViewcustomersMouseClicked

    private void jNewitemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNewitemMouseClicked
        if(canCreateItem()) {
            _jHomePage.switchPanels(_jNewItem);
            _jNewItem.jNameField.grabFocus();
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File("Images/photo2.png"));
            } catch (IOException e) {
                Logger.getLogger(jViewItem.class.getName()).log(Level.SEVERE, null, e);
            }
            Image dimg = img.getScaledInstance(220, 220,Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            _jNewItem.jPic.setIcon(imageIcon);
        }
    }//GEN-LAST:event_jNewitemMouseClicked

    private void jViewitemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewitemsMouseClicked
        if(canViewItems()) {
            _jHomePage.switchPanels(_jViewItems);
            _jViewItems.showItems();
            _jViewItems.jsearchitems.grabFocus();
        }

    }//GEN-LAST:event_jViewitemsMouseClicked

    private void jLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogMouseClicked
        if(canViewLogs())
        {
            
           _jShowLogs.renderData();
           _jHomePage.switchPanels(_jShowLogs); 
           _jShowLogs.jSearchField.grabFocus();
        }
        

    }//GEN-LAST:event_jLogMouseClicked

    private void jLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogoutMouseClicked
        _jHomePage.Home();
        _jHomePage.loginUser=null;
        _jHomePage.jsignin.grabFocus();
        
    }//GEN-LAST:event_jLogoutMouseClicked

    private void jAddusersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddusersMouseClicked
        if(canCreateUser())
        {
            _jSignUpPage.clearSignUpPage();
           _jHomePage.switchPanels(_jSignUpPage); 
           _jSignUpPage.jNameField.grabFocus();
        } 
              
    }//GEN-LAST:event_jAddusersMouseClicked

    private void jViewusersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewusersMouseClicked

        if(canViewUsers()){
            _jViewUsers.renderData();
            _jHomePage.switchPanels(_jViewUsers);
            _jViewUsers.jSearchField.grabFocus();
        }
        
    }//GEN-LAST:event_jViewusersMouseClicked

    private void jViewRolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewRolesMouseClicked
        if(canViewRoles()) {
            _jViewRoles.renderData();
            _jHomePage.switchPanels(_jViewRoles);
            _jViewRoles.jSearch.grabFocus();
        } 
    }//GEN-LAST:event_jViewRolesMouseClicked

    private void jNewRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNewRoleMouseClicked
        if(canCreateRole()) {
            _jcreaterole.DoneButton();
            _jHomePage.switchPanels(_jcreaterole);
            _jcreaterole.jRoleNameField.grabFocus();
            
        }
    }//GEN-LAST:event_jNewRoleMouseClicked

    private void jStatsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jStatsMouseClicked
        _jHomePage.switchPanels(_jViewStatistics);
    }//GEN-LAST:event_jStatsMouseClicked

    private void jNewcustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewcustomerActionPerformed
        if(canCreateCustomer()) {
            _jHomePage.switchPanels(_jNewCustomer);
            _jNewCustomer.jNameField.grabFocus();
        }
    }//GEN-LAST:event_jNewcustomerActionPerformed

    private void jLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLogoutActionPerformed

    private void jViewcustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jViewcustomersActionPerformed
        if(canViewCustomers()) {
            _jViewCustomers.renderData();
            _jHomePage.switchPanels(_jViewCustomers);   
            _jViewCustomers.jSearchName.grabFocus();
        }
    }//GEN-LAST:event_jViewcustomersActionPerformed

    private void jNewitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewitemActionPerformed
        if(canCreateItem()) {
            _jHomePage.switchPanels(_jNewItem);
            _jNewItem.jNameField.grabFocus();
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File("Images/photo2.png"));
            } catch (IOException e) {
                Logger.getLogger(jViewItem.class.getName()).log(Level.SEVERE, null, e);
            }
            Image dimg = img.getScaledInstance(220, 220,Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            _jNewItem.jPic.setIcon(imageIcon);
        }
    }//GEN-LAST:event_jNewitemActionPerformed

    private void jViewitemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jViewitemsActionPerformed
        if(canViewItems()) {
            _jHomePage.switchPanels(_jViewItems);
            _jViewItems.showItems();
            _jViewItems.jsearchitems.grabFocus();
        }
    }//GEN-LAST:event_jViewitemsActionPerformed

    private void jAddusersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddusersActionPerformed
        if(canCreateUser())
        {
            _jSignUpPage.clearSignUpPage();
           _jHomePage.switchPanels(_jSignUpPage); 
           _jSignUpPage.jNameField.grabFocus();
        } 
    }//GEN-LAST:event_jAddusersActionPerformed

    private void jViewusersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jViewusersActionPerformed
        if(canViewUsers()){
            _jViewUsers.renderData();
            _jHomePage.switchPanels(_jViewUsers);
            _jViewUsers.jSearchField.grabFocus();
        }
    }//GEN-LAST:event_jViewusersActionPerformed

    private void jNewRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewRoleActionPerformed
        if(canCreateRole()) {
            _jcreaterole.DoneButton();
            _jHomePage.switchPanels(_jcreaterole);
            _jcreaterole.jRoleNameField.grabFocus();
            
        }
    }//GEN-LAST:event_jNewRoleActionPerformed

    private void jViewRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jViewRolesActionPerformed
        if(canViewRoles()) {
            _jViewRoles.renderData();
            _jHomePage.switchPanels(_jViewRoles);
            _jViewRoles.jSearch.grabFocus();
        }
    }//GEN-LAST:event_jViewRolesActionPerformed

    private void jLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogActionPerformed
        if(canViewLogs())
        {
            
           _jShowLogs.renderData();
           _jHomePage.switchPanels(_jShowLogs); 
           _jShowLogs.jSearchField.grabFocus();
        }
    }//GEN-LAST:event_jLogActionPerformed

    private void jStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStatsActionPerformed
        _jHomePage.switchPanels(_jViewStatistics);
    }//GEN-LAST:event_jStatsActionPerformed

    
    
    
     public void changecolor(int x, int y ,int z)
    { 
        setBackground(new java.awt.Color(x, y, z));
       //_jChooseItem.changecolor(x, y, z);
       _jNewCustomer.changecolor(x, y, z);
        _jViewCustomers.changecolor(x, y, z);
        _jViewCustomer.changecolor(x, y, z);
        _jNewItem.changecolor(x, y, z);
        _jViewItem.changecolor(x, y, z);
        _jViewItems.changecolor(x, y, z);
        _jViewLogs.changecolor(x, y, z);
        _jcreaterole.changecolor(x, y, z);
        _jViewRoles.changecolor(x, y, z);
        _jSignUpPage.changecolor(x, y, z);
        _jViewUser.changecolor(x, y, z);
        _jViewUsers.changecolor(x, y, z);
        _jHomePage.changecolor(x, y, z);
       //jLoginPage.changecolor(x, y, z);
        
    }
    public boolean canCreateUser() {
        if(_jHomePage.loginUser.role.canCreateUser) {
            jAddusers.setEnabled(true);
            _jViewUsers.jAddButton.setEnabled(true);
            return true;
        }else {
            jAddusers.setEnabled(false);
            _jViewUsers.jAddButton.setEnabled(false);
            return false;
        }
    }
    public boolean canCreateCustomer (){
        if(_jHomePage.loginUser.role.canCreateCustomer) {
            jNewcustomer.setEnabled(true);
            _jViewCustomers.jAddButton.setEnabled(true);
            return true;
        }else {
            _jViewCustomers.jAddButton.setEnabled(false);
            jNewcustomer.setEnabled(false);
            return false;
        }
    }
    public boolean canViewCustomers() {
        if(_jHomePage.loginUser.role.canViewCustomers) {
            jViewcustomers.setEnabled(true);
            return true;
        }else {
            jViewcustomers.setEnabled(false);
            return false;
        }
    }
    public boolean canDeleteCustomer() {
        if(_jHomePage.loginUser.role.canDeleteCustomer) {
            _jViewCustomers.jDeleteButton.setEnabled(true);
            return true;
        }else {
            _jViewCustomers.jDeleteButton.setEnabled(false);
            return false;
        }
    }
    public boolean canUpdateCustomer() {
        if(_jHomePage.loginUser.role.canUpdateCustomer) {
            _jViewCustomers._jViewCustomer.jEdit.setEnabled(true);
            return true;
        }else {
            _jViewCustomers.jDeleteButton.setEnabled(false);
            return false;
        }
    }
    public boolean canDeleteUser() {
        if(_jHomePage.loginUser.role.canDeleteUser) {
            _jViewUsers.jDeleteButton.setEnabled(true);
            return true;
        }else {
            _jViewUsers.jDeleteButton.setEnabled(false);
            return false;
        }
    }
    public boolean canCreateItem () {
        if(_jHomePage.loginUser.role.canCreateItem) {
            jNewitem.setEnabled(true);
            _jViewItems.jadditem.setEnabled(true);
            return true;
        }else {
            jNewitem.setEnabled(false);
            _jViewItems.jadditem.setEnabled(false);
            return false;
        }
    }
    public boolean canViewItems() {
        if(_jHomePage.loginUser.role.canViewItems) {
            jViewitems.setEnabled(true);
            return true;
        }else {
            jViewitems.setEnabled(false);
            return false;
        }
    }
    public boolean canDeleteItem() {
        if(_jHomePage.loginUser.role.canDeleteItem) {
            _jViewItems.jdelete.setEnabled(true);
            return true;
        }else {
            _jViewItems.jdelete.setEnabled(false);
            return false;
        }
    }
    public boolean canUpdateItem() {
        if(_jHomePage.loginUser.role.canUpdateItem) {
            _jViewItems._jViewItem.jEdit.setEnabled(true);
            return true;
        }else {
            _jViewItems._jViewItem.jEdit.setEnabled(false);
            return false;
        }
    }
    public boolean canViewUsers() {
        if(_jHomePage.loginUser.role.canViewUsers) {
            jViewusers.setEnabled(true);
            return true;
        }else {
            jViewusers.setEnabled(false);
            return false;
        }
    }
    public boolean canViewLogs() {
        if(_jHomePage.loginUser.role.canViewLogs) {
            jLog.setEnabled(true);
            return true;
        }else {
            jLog.setEnabled(false);
            return false;
        }
    }
    public boolean canViewRoles() {
        if(_jHomePage.loginUser.role.canViewRoles) {
            jViewRoles.setEnabled(true);
            return true;
        }else {
            jViewRoles.setEnabled(false);
            return false;
        }
    }
    public boolean canDeleteLog() {
        return true;
    }
    public boolean canCreateRole() {
        if(_jHomePage.loginUser.role.canCreateRole) {
            jNewRole.setEnabled(true);
            return true;
        }else {
            jNewRole.setEnabled(false);
            return false;
        }
    }
    public boolean canUpdateRole() {
        return true;
    }
    
    
    public static boolean toggle ;
    public boolean flag;
    
  //  private final jChooseItem _jChooseItem;
    private final jViewLogs _jViewLogs;
   private final jViewItem _jViewItem;
  private final jViewCustomer _jViewCustomer;
    private final jViewRoles _jViewRoles;
    private final jNewRole _jcreaterole;
    public final jViewUsers _jViewUsers;
    private final jNewUsers _jSignUpPage;
   private final jNewCustomer _jNewCustomer;
    private final jViewCustomers _jViewCustomers;
    private final jViewItems _jViewItems;
    private final jNewItem _jNewItem;
    private final jViewLogs _jShowLogs;
    private final jHomePage _jHomePage;
    private final jViewUser _jViewUser;
    public final jViewStatistics _jViewStatistics;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jAddusers;
    public javax.swing.JButton jLog;
    public javax.swing.JButton jLogout;
    public javax.swing.JButton jNewRole;
    public javax.swing.JButton jNewcustomer;
    public javax.swing.JButton jNewitem;
    public javax.swing.JButton jStats;
    public javax.swing.JButton jViewRoles;
    public javax.swing.JButton jViewcustomers;
    public javax.swing.JButton jViewitems;
    public javax.swing.JButton jViewusers;
    // End of variables declaration//GEN-END:variables
    
}
