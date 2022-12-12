
package Gui;

import Gui.Items.jNewItem;
import Gui.Customers.jNewCustomer;
import Gui.Logs.jShowLogs;
import Gui.Customers.jViewCustomers;
import Gui.Users.jViewUsers;
import Gui.Items.jViewItems;
import Gui.Roles.jViewRoles;
import Gui.Roles.jNewRole;

public class jMainPage extends javax.swing.JPanel {

    public jMainPage(jHomePage jhp) {
        initComponents();
        _jHomePage = jhp;
        _jNewCustomer = new jNewCustomer(jhp, this);
        _jNewItem = new jNewItem(jhp, this);
        _jViewItems = new jViewItems(jhp, this);
        _jViewCustomers = new jViewCustomers(jhp, this);
        _jShowLogs = new jShowLogs(jhp, this);
        _jSignUpPage = new jSignUpPage(jhp,this);
        _jViewUsers = new jViewUsers(jhp , this);
        _jcreaterole = new jNewRole(jhp, this);
        _jViewRoles = new jViewRoles(jhp, this);
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

        jNewitem.setText("New Item");
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

        jViewitems.setText("View Items");
        jViewitems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jViewitemsMouseClicked(evt);
            }
        });

        jViewcustomers.setText("View Customers");
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

        jLog.setText("Log");
        jLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLogMouseClicked(evt);
            }
        });

        jNewcustomer.setText("New Customer");
        jNewcustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNewcustomerMouseClicked(evt);
            }
        });

        jLogout.setText("Logout");
        jLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLogoutMouseClicked(evt);
            }
        });

        jAddusers.setText("New Users");
        jAddusers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddusersMouseClicked(evt);
            }
        });

        jViewusers.setText("View Users");
        jViewusers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jViewusersMouseClicked(evt);
            }
        });

        jViewRoles.setText("View Roles");
        jViewRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jViewRolesMouseClicked(evt);
            }
        });

        jNewRole.setText("New Role");
        jNewRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNewRoleMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jViewRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jAddusers, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNewitem, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNewcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLog, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jViewcustomers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jViewitems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jViewusers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jNewRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAddusers)
                    .addComponent(jViewusers))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNewcustomer)
                    .addComponent(jViewcustomers))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNewitem)
                    .addComponent(jViewitems))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLog)
                    .addComponent(jLogout))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jViewRoles)
                    .addComponent(jNewRole))
                .addContainerGap(172, Short.MAX_VALUE))
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
        }
    }//GEN-LAST:event_jViewcustomersMouseClicked

    private void jNewitemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNewitemMouseClicked
        if(canCreateItem()) {
            _jHomePage.switchPanels(_jNewItem);
            _jNewItem.jNameField.grabFocus();
        }
    }//GEN-LAST:event_jNewitemMouseClicked

    private void jViewitemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewitemsMouseClicked
        if(canViewItems()) {
            _jHomePage.switchPanels(_jViewItems);
            _jViewItems.showItems(); 
        }

    }//GEN-LAST:event_jViewitemsMouseClicked

    private void jLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogMouseClicked
        if(canViewLogs())
        {
            _jShowLogs.showLog();
           _jHomePage.switchPanels(_jShowLogs); 
        }
        

    }//GEN-LAST:event_jLogMouseClicked

    private void jLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogoutMouseClicked
        _jHomePage.Home();
        _jHomePage.loginUser=null;
    }//GEN-LAST:event_jLogoutMouseClicked

    private void jAddusersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddusersMouseClicked
        if(canCreateUser())
        {
            _jSignUpPage.clearSignUpPage();
           _jHomePage.switchPanels(_jSignUpPage); 
        } 
              
    }//GEN-LAST:event_jAddusersMouseClicked

    private void jViewusersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewusersMouseClicked

        if(canViewUsers()){
            _jViewUsers.renderData();
            _jHomePage.switchPanels(_jViewUsers);
        }
        
    }//GEN-LAST:event_jViewusersMouseClicked

    private void jViewcustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jViewcustomersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jViewcustomersActionPerformed

    private void jNewitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewitemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNewitemActionPerformed

    private void jViewRolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewRolesMouseClicked
        if(canViewRoles()) {
            _jViewRoles.renderData();
            _jHomePage.switchPanels(_jViewRoles);
        }
    }//GEN-LAST:event_jViewRolesMouseClicked

    private void jNewRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNewRoleMouseClicked
        if(canCreateRole()) {
            _jcreaterole.DoneButton();
            _jHomePage.switchPanels(_jcreaterole);
        }
    }//GEN-LAST:event_jNewRoleMouseClicked
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
            return true;
        }else {
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
            _jViewCustomers.jDelete.setEnabled(true);
            return true;
        }else {
            _jViewCustomers.jDelete.setEnabled(false);
            return false;
        }
    }
    public boolean canUpdateCustomer() {
        if(_jHomePage.loginUser.role.canUpdateCustomer) {
            _jViewCustomers._jViewCustomer.jEdit.setEnabled(true);
            return true;
        }else {
            _jViewCustomers.jDelete.setEnabled(false);
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
    public boolean canDeleteRole() {
        return true;
    }
    public boolean canUpdateRole() {
        return true;
    }
    
    public boolean flag;
    private final jViewRoles _jViewRoles;
    private final jNewRole _jcreaterole;
    private final jViewUsers _jViewUsers;
    private final jSignUpPage _jSignUpPage;
    private final jNewCustomer _jNewCustomer;
    private final jViewCustomers _jViewCustomers;
    private final jViewItems _jViewItems;
    private final jNewItem _jNewItem;
    private final jShowLogs _jShowLogs;
    private final jHomePage _jHomePage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddusers;
    private javax.swing.JButton jLog;
    private javax.swing.JButton jLogout;
    private javax.swing.JButton jNewRole;
    private javax.swing.JButton jNewcustomer;
    private javax.swing.JButton jNewitem;
    private javax.swing.JButton jViewRoles;
    private javax.swing.JButton jViewcustomers;
    private javax.swing.JButton jViewitems;
    private javax.swing.JButton jViewusers;
    // End of variables declaration//GEN-END:variables
    
}
