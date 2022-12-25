package Gui;
import Gui.Users.jNewUsers;
import Gui.Items.jNewItem;
import Gui.Customers.jNewCustomer;
import Gui.Customers.jViewCustomer;
import Gui.Logs.jViewLogs;
import Gui.Customers.jViewCustomers;
import Gui.Items.jChooseItem;
import Gui.Items.jViewItem;
import Gui.Users.jViewUsers;
import Gui.Items.jViewItems;
import Gui.Roles.jViewRoles;
import Gui.Roles.jNewRole;
import Gui.Users.jViewUser;
import Gui.jLoginPage;
import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.red;
import javax.swing.JPanel;

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
        jToggleButton1 = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(87, 118, 130));

        jNewitem.setBackground(new java.awt.Color(217, 156, 69));
        jNewitem.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jNewitem.setForeground(new java.awt.Color(255, 255, 255));
        jNewitem.setText("New Item");
        jNewitem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNewitemMouseClicked(evt);
            }
        });

        jViewitems.setBackground(new java.awt.Color(217, 156, 69));
        jViewitems.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jViewitems.setForeground(new java.awt.Color(255, 255, 255));
        jViewitems.setText("View Items");
        jViewitems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jViewitemsMouseClicked(evt);
            }
        });

        jViewcustomers.setBackground(new java.awt.Color(217, 156, 69));
        jViewcustomers.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jViewcustomers.setForeground(new java.awt.Color(255, 255, 255));
        jViewcustomers.setText("View Customers");
        jViewcustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jViewcustomersMouseClicked(evt);
            }
        });

        jLog.setBackground(new java.awt.Color(217, 156, 69));
        jLog.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLog.setForeground(new java.awt.Color(255, 255, 255));
        jLog.setText("Log");
        jLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLogMouseClicked(evt);
            }
        });

        jNewcustomer.setBackground(new java.awt.Color(217, 156, 69));
        jNewcustomer.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jNewcustomer.setForeground(new java.awt.Color(255, 255, 255));
        jNewcustomer.setText("New Customer");
        jNewcustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNewcustomerMouseClicked(evt);
            }
        });

        jLogout.setBackground(new java.awt.Color(217, 156, 69));
        jLogout.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLogout.setForeground(new java.awt.Color(255, 255, 255));
        jLogout.setText("Logout");
        jLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLogoutMouseClicked(evt);
            }
        });

        jAddusers.setBackground(new java.awt.Color(217, 156, 69));
        jAddusers.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jAddusers.setForeground(new java.awt.Color(255, 255, 255));
        jAddusers.setText("New Users");
        jAddusers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddusersMouseClicked(evt);
            }
        });

        jViewusers.setBackground(new java.awt.Color(217, 156, 69));
        jViewusers.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jViewusers.setForeground(new java.awt.Color(255, 255, 255));
        jViewusers.setText("View Users");
        jViewusers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jViewusersMouseClicked(evt);
            }
        });

        jViewRoles.setBackground(new java.awt.Color(217, 156, 69));
        jViewRoles.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jViewRoles.setForeground(new java.awt.Color(255, 255, 255));
        jViewRoles.setText("View Roles");
        jViewRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jViewRolesMouseClicked(evt);
            }
        });

        jNewRole.setBackground(new java.awt.Color(217, 156, 69));
        jNewRole.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jNewRole.setForeground(new java.awt.Color(255, 255, 255));
        jNewRole.setText("New Role");
        jNewRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNewRoleMouseClicked(evt);
            }
        });

        jToggleButton1.setText("٭🔆");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLog, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jNewRole, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jNewitem, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jNewcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jAddusers, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(42, 42, 42)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jViewcustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jViewusers, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jViewitems, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jViewRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNewcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jViewcustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNewitem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jViewitems, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jViewusers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAddusers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNewRole, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jViewRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jLog, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(jLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
      toggle = !toggle;
       if(toggle){
           changecolor(0,0,0);
       }else{
           changecolor(87,118,130);
       }
 
    }//GEN-LAST:event_jToggleButton1MouseClicked
    
    
    
    
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jAddusers;
    public javax.swing.JButton jLog;
    public javax.swing.JButton jLogout;
    public javax.swing.JButton jNewRole;
    public javax.swing.JButton jNewcustomer;
    public javax.swing.JButton jNewitem;
    public javax.swing.JToggleButton jToggleButton1;
    public javax.swing.JButton jViewRoles;
    public javax.swing.JButton jViewcustomers;
    public javax.swing.JButton jViewitems;
    public javax.swing.JButton jViewusers;
    // End of variables declaration//GEN-END:variables
    
}
