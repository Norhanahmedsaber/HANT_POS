
package Gui;

public class jMainPage extends javax.swing.JPanel {

    public jMainPage(jHomePage jhp) {
        initComponents();
        _jHomePage = jhp;
        _jNewCustomer = new jNewCustomer(jhp, this);
        _jNewItem = new jNewItem(jhp, this);
        _jViewItems = new jViewItems(jhp, this);
        _jViewCustomers = new jViewCustomers(jhp, this);
        _jLog = new jLog(jhp, this);
        _jSignUpPage = new jSignUpPage(jhp,this );
        _jViewUsers = new jViewUsers(jhp , this);
        
      
    }
    
    public boolean checkRole(){
        if(_jHomePage.loginUser.role != "manager")
        {
            jAddusers.setEnabled(false);
            jViewusers.setEnabled(false);
            jLog.setEnabled(false);
            _jViewItems.jdelete.setEnabled(false);
            _jViewCustomers.jDelete.setEnabled(false);
            return false;            
       
        }
        else
        {
            jAddusers.setEnabled(true);
            jViewusers.setEnabled(true);
            jLog.setEnabled(true);
           _jViewItems.jdelete.setEnabled(true);
           _jViewCustomers.jDelete.setEnabled(true);
           return true;
        }
        
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jAddusers, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNewitem, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNewcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLog, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jViewcustomers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jViewitems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jViewusers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(219, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jNewcustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNewcustomerMouseClicked
        _jHomePage.switchPanels(_jNewCustomer);
        _jNewCustomer.jNameField.grabFocus();
    }//GEN-LAST:event_jNewcustomerMouseClicked

    private void jViewcustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewcustomersMouseClicked
        _jViewCustomers.renderData();
        _jHomePage.switchPanels(_jViewCustomers);
    }//GEN-LAST:event_jViewcustomersMouseClicked

    private void jNewitemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNewitemMouseClicked
        _jHomePage.switchPanels(_jNewItem);
        _jNewItem.jNameField.grabFocus();
    }//GEN-LAST:event_jNewitemMouseClicked

    private void jViewitemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewitemsMouseClicked
        _jHomePage.switchPanels(_jViewItems);
        _jViewItems.showItems();

    }//GEN-LAST:event_jViewitemsMouseClicked

    private void jLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogMouseClicked
        if(checkRole())
        {
           _jHomePage.switchPanels(_jLog); 
        }else return;
        _jViewUsers.renderData();
        _jHomePage.switchPanels(_jViewUsers);
    }//GEN-LAST:event_jLogMouseClicked

    private void jLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogoutMouseClicked
        _jHomePage.Home();
        _jHomePage.loginUser=null;
    }//GEN-LAST:event_jLogoutMouseClicked

    private void jAddusersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddusersMouseClicked
          if(checkRole())
        {
           _jHomePage.switchPanels(_jSignUpPage); 
        }else return; 
              
    }//GEN-LAST:event_jAddusersMouseClicked

    private void jViewusersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewusersMouseClicked
        if(checkRole()){
            _jViewUsers.renderData();
            _jHomePage.switchPanels(_jViewUsers);
        }else return;
        
        
    }//GEN-LAST:event_jViewusersMouseClicked

    private void jViewcustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jViewcustomersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jViewcustomersActionPerformed

    private void jNewitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewitemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNewitemActionPerformed
    public boolean flag;
    private final jViewUsers _jViewUsers;
    private final jSignUpPage _jSignUpPage;
    private final jNewCustomer _jNewCustomer;
    private final jViewCustomers _jViewCustomers;
    private final jViewItems _jViewItems;
    private final jNewItem _jNewItem;
    private final jLog _jLog;
    private final jHomePage _jHomePage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddusers;
    private javax.swing.JButton jLog;
    private javax.swing.JButton jLogout;
    private javax.swing.JButton jNewcustomer;
    private javax.swing.JButton jNewitem;
    private javax.swing.JButton jViewcustomers;
    private javax.swing.JButton jViewitems;
    private javax.swing.JButton jViewusers;
    // End of variables declaration//GEN-END:variables
}
