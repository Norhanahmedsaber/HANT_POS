
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
      
    }
    public void checkRole(){
        if(_jHomePage.loginUser.role != "manager")
        {
            jAddusers.disable();
            jViewusers.disable();
        }
        else
        {
            jAddusers.enable();
            jViewusers.enable();
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

        jAddusers.setText("Add Users");
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
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jAddusers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jViewcustomers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jNewcustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jNewitem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jViewitems, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(jLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jViewusers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNewcustomer)
                    .addComponent(jNewitem))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jViewcustomers)
                    .addComponent(jViewitems))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLog)
                    .addComponent(jLogout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAddusers)
                    .addComponent(jViewusers)))
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
        _jNewItem.jIdField.grabFocus();
    }//GEN-LAST:event_jNewitemMouseClicked

    private void jViewitemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewitemsMouseClicked

        _jHomePage.switchPanels(_jViewItems);
        _jViewItems.showItems();

    }//GEN-LAST:event_jViewitemsMouseClicked

    private void jLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogMouseClicked
        _jHomePage.switchPanels(_jLog);
    }//GEN-LAST:event_jLogMouseClicked

    private void jLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogoutMouseClicked
        _jHomePage.Home();
        _jHomePage.loginUser=null;
    }//GEN-LAST:event_jLogoutMouseClicked

    private void jAddusersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddusersMouseClicked
        _jHomePage.switchPanels(_jSignUpPage);
    }//GEN-LAST:event_jAddusersMouseClicked

    private void jViewusersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewusersMouseClicked
       
    }//GEN-LAST:event_jViewusersMouseClicked
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
