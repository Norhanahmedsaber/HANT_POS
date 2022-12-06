
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jNewitem = new javax.swing.JButton();
        jViewitems = new javax.swing.JButton();
        jViewcustomers = new javax.swing.JButton();
        jLog = new javax.swing.JButton();
        jNewcustomer = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

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
        jLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogActionPerformed(evt);
            }
        });

        jNewcustomer.setText("New Customer");
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

        jButton1.setText("Logout");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLog)
                        .addComponent(jViewcustomers))
                    .addComponent(jNewcustomer))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNewitem)
                    .addComponent(jViewitems)
                    .addComponent(jButton1))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNewcustomer)
                    .addComponent(jNewitem))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jViewcustomers)
                    .addComponent(jViewitems))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLog)
                    .addComponent(jButton1))
                .addContainerGap(106, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jNewitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewitemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNewitemActionPerformed

    private void jLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLogActionPerformed

    private void jViewcustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jViewcustomersActionPerformed

    }//GEN-LAST:event_jViewcustomersActionPerformed

    private void jNewcustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewcustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNewcustomerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jNewcustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNewcustomerMouseClicked
        _jHomePage.switchPanels(_jNewCustomer);
    }//GEN-LAST:event_jNewcustomerMouseClicked

    private void jViewcustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewcustomersMouseClicked
        _jHomePage.switchPanels(_jViewCustomers);
    }//GEN-LAST:event_jViewcustomersMouseClicked

    private void jNewitemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNewitemMouseClicked
        _jHomePage.switchPanels(_jNewItem);
    }//GEN-LAST:event_jNewitemMouseClicked

    private void jViewitemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewitemsMouseClicked
        _jHomePage.switchPanels(_jViewItems);
    }//GEN-LAST:event_jViewitemsMouseClicked

    private void jLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogMouseClicked
        _jHomePage.switchPanels(_jLog);
    }//GEN-LAST:event_jLogMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        _jHomePage.Home();
    }//GEN-LAST:event_jButton1MouseClicked
    private final jNewCustomer _jNewCustomer;
    private final jViewCustomers _jViewCustomers;
    private final jViewItems _jViewItems;
    private final jNewItem _jNewItem;
    private final jLog _jLog;
    private final jHomePage _jHomePage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jLog;
    private javax.swing.JButton jNewcustomer;
    private javax.swing.JButton jNewitem;
    private javax.swing.JButton jViewcustomers;
    private javax.swing.JButton jViewitems;
    // End of variables declaration//GEN-END:variables
}
