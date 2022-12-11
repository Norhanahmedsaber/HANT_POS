package Gui;
import Entities.Role;
public class jcreaterole extends javax.swing.JPanel {

    public jcreaterole() {
        initComponents();
        _jRole=new Role();
    }
   // JCreateCustomer.getStateChanged(); 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBack = new javax.swing.JButton();
        jDone = new javax.swing.JButton();
        JCreateCustomer = new javax.swing.JCheckBox();
        jViewCustomer = new javax.swing.JCheckBox();
        JDeleteCustomer = new javax.swing.JCheckBox();
        jUpdateCustomer = new javax.swing.JCheckBox();
        jViewItem = new javax.swing.JCheckBox();
        jCreateItem = new javax.swing.JCheckBox();
        jUpdateItem = new javax.swing.JCheckBox();
        jDeleteItem = new javax.swing.JCheckBox();
        jViewUser = new javax.swing.JCheckBox();
        JviewLogs = new javax.swing.JCheckBox();
        jCreateUser = new javax.swing.JCheckBox();
        jCreateLogs = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();

        jBack.setText("back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        jDone.setText("Done");
        jDone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDoneMouseClicked(evt);
            }
        });

        JCreateCustomer.setText("Create Customer");
        JCreateCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JCreateCustomerMouseClicked(evt);
            }
        });
        JCreateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCreateCustomerActionPerformed(evt);
            }
        });

        jViewCustomer.setText("View Customer");
        jViewCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jViewCustomerMouseClicked(evt);
            }
        });

        JDeleteCustomer.setText("Delete Customer ");
        JDeleteCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JDeleteCustomerMouseClicked(evt);
            }
        });

        jUpdateCustomer.setText("Update customer");
        jUpdateCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateCustomerMouseClicked(evt);
            }
        });

        jViewItem.setText("View Item");
        jViewItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jViewItemMouseClicked(evt);
            }
        });

        jCreateItem.setText("Create Item");
        jCreateItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCreateItemMouseClicked(evt);
            }
        });

        jUpdateItem.setText("Update Item");
        jUpdateItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateItemMouseClicked(evt);
            }
        });

        jDeleteItem.setText("Delete Item");
        jDeleteItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDeleteItemMouseClicked(evt);
            }
        });

        jViewUser.setText("View User");
        jViewUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jViewUserMouseClicked(evt);
            }
        });

        JviewLogs.setText("View Logs");
        JviewLogs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JviewLogsMouseClicked(evt);
            }
        });

        jCreateUser.setText("Create User");
        jCreateUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCreateUserMouseClicked(evt);
            }
        });

        jCreateLogs.setText("Create Logs");
        jCreateLogs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCreateLogsMouseClicked(evt);
            }
        });

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JDeleteCustomer)
                            .addComponent(jViewCustomer)
                            .addComponent(JCreateCustomer)
                            .addComponent(jUpdateCustomer)
                            .addComponent(jCreateItem)
                            .addComponent(jViewItem)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jDone)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jDeleteItem)
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jUpdateItem)
                            .addComponent(jCreateUser)
                            .addComponent(jViewUser)
                            .addComponent(JviewLogs)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jBack))
                            .addComponent(jCreateLogs))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCreateCustomer)
                    .addComponent(jDeleteItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jViewCustomer)
                    .addComponent(jUpdateItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JDeleteCustomer)
                    .addComponent(jCreateUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUpdateCustomer)
                    .addComponent(jViewUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCreateItem)
                    .addComponent(jCreateLogs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jViewItem)
                    .addComponent(JviewLogs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDone)
                    .addComponent(jBack))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JCreateCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCreateCustomerMouseClicked
        //_jRole.canCreateCustomer=true;
          if (JCreateCustomer.isSelected())
         {
             System.out.println("selecteddgfh ");
         }
         else
             System.out.println("not selecteddf ");
    }//GEN-LAST:event_JCreateCustomerMouseClicked

    private void jViewCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewCustomerMouseClicked
        _jRole.canViewCustomers=true;
    }//GEN-LAST:event_jViewCustomerMouseClicked

    private void JDeleteCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JDeleteCustomerMouseClicked
       _jRole.canDeleteCustomer=true;
    }//GEN-LAST:event_JDeleteCustomerMouseClicked

    private void jUpdateCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateCustomerMouseClicked
     _jRole.canUpdateCustomer=true;
    }//GEN-LAST:event_jUpdateCustomerMouseClicked

    private void jCreateItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCreateItemMouseClicked
        _jRole.canCreateItem=true;
    }//GEN-LAST:event_jCreateItemMouseClicked

    private void jViewItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewItemMouseClicked
        _jRole.canViewItems=true;
    }//GEN-LAST:event_jViewItemMouseClicked

    private void jDeleteItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDeleteItemMouseClicked
        _jRole.canDeleteItem=true;
    }//GEN-LAST:event_jDeleteItemMouseClicked

    private void jUpdateItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateItemMouseClicked
        _jRole.canUpdateItem=true;
    }//GEN-LAST:event_jUpdateItemMouseClicked

    private void jCreateUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCreateUserMouseClicked
        _jRole.canCreateUser=true;
    }//GEN-LAST:event_jCreateUserMouseClicked

    private void jViewUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewUserMouseClicked
        _jRole.canViewUsers=true;
    }//GEN-LAST:event_jViewUserMouseClicked

    private void jCreateLogsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCreateLogsMouseClicked
        _jRole.canCreateLog=true;
    }//GEN-LAST:event_jCreateLogsMouseClicked

    private void JviewLogsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JviewLogsMouseClicked
       _jRole.canViewLogs=true;
    }//GEN-LAST:event_JviewLogsMouseClicked

    private void jDoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDoneMouseClicked
       
    }//GEN-LAST:event_jDoneMouseClicked

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBackMouseClicked

    private void JCreateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCreateCustomerActionPerformed
         if (JCreateCustomer.isSelected())
         {
             System.out.println("selected ");
         }
         else
             System.out.println("selected ");
             
    }//GEN-LAST:event_JCreateCustomerActionPerformed

    private Role _jRole;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox JCreateCustomer;
    private javax.swing.JCheckBox JDeleteCustomer;
    private javax.swing.JCheckBox JviewLogs;
    private javax.swing.JButton jBack;
    private javax.swing.JCheckBox jCreateItem;
    private javax.swing.JCheckBox jCreateLogs;
    private javax.swing.JCheckBox jCreateUser;
    private javax.swing.JCheckBox jDeleteItem;
    private javax.swing.JButton jDone;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JCheckBox jUpdateCustomer;
    private javax.swing.JCheckBox jUpdateItem;
    private javax.swing.JCheckBox jViewCustomer;
    private javax.swing.JCheckBox jViewItem;
    private javax.swing.JCheckBox jViewUser;
    // End of variables declaration//GEN-END:variables
}
