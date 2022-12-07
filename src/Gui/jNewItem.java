package Gui;

import Entities.Item;
import Services.ItemServices;
import java.util.Date;

public class jNewItem extends javax.swing.JPanel {

    public jNewItem(jHomePage jhp, jMainPage jmp) {
        initComponents();
        _jHomePage = jhp;
        _jMainPage = jmp;
        _itemServices = new ItemServices();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jAddItem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jid = new javax.swing.JTextField();
        jprice = new javax.swing.JTextField();
        jDescription = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jcatgory = new javax.swing.JTextField();
        jBack = new javax.swing.JButton();
        jErrorid = new javax.swing.JLabel();
        jErrordescription = new javax.swing.JLabel();
        jErrorPrice = new javax.swing.JLabel();
        jErrorId2 = new javax.swing.JLabel();
        jErrorcatgory = new javax.swing.JLabel();

        jLabel2.setText("Description");

        jAddItem.setText("Add Item");
        jAddItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddItemMouseClicked(evt);
            }
        });
        jAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddItemActionPerformed(evt);
            }
        });

        jLabel3.setText("Catgory");

        jLabel4.setText("Entry date");

        jLabel5.setText("price");

        jid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jidActionPerformed(evt);
            }
        });

        jprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpriceActionPerformed(evt);
            }
        });

        jDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDescriptionActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel6.setText("New Item :");

        jLabel1.setText("ID");

        jBack.setText("Back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jAddItem)
                                .addGap(137, 137, 137))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jErrorId2)
                                    .addComponent(jErrorcatgory)
                                    .addComponent(jcatgory, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6))
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jErrorid)
                                    .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jErrordescription)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(98, 98, 98))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(68, 68, 68)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jErrorPrice)
                                    .addComponent(jDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jprice, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(62, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBack))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jErrorid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jErrordescription)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jErrorPrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jErrorId2)
                                .addGap(26, 26, 26)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jErrorcatgory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcatgory, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jAddItem)
                .addGap(11, 11, 11)
                .addComponent(jBack))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAddItemActionPerformed

    private void jidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jidActionPerformed

    private void jpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpriceActionPerformed

    private void jDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDescriptionActionPerformed

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        _jHomePage.switchPanels(_jMainPage);
    }//GEN-LAST:event_jBackMouseClicked

    private void jAddItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddItemMouseClicked
        if (jid.getText().isEmpty())
        {
            jErrorid.setText("please Enter This");
            return;
        }else jErrorid.setText(""); 
        if(jDescription.getText().isEmpty())
        {
            jErrordescription.setText("please Enter This");
            return;
        }else jErrordescription.setText("");
        if(jprice.getText().isEmpty())
        {
            System.out.print("hhhhhhhh");
            jErrorPrice.setText("please Enter This");
            return;
        }else jErrorPrice.setText("");
        //if(jentrydate.getText().isEmpty())
        //{
        //    jErrorentrydate.setText("please Enter This");
        //    return;
        //}else jErrorentrydate.setText("");
        if(jcatgory.getText().isEmpty())
        {
            jErrorcatgory.setText("Please Enter This");
            return;
        }else jErrorcatgory.setText("");

        Item item =  new Item();
        item.name=jid.getText();
        item.category=jcatgory.getText();
        item.description=jDescription.getText();
        item.price=Integer.parseInt(jprice.getText());
        item.createdAt=new Date(); 
        _itemServices.create(item);
    }//GEN-LAST:event_jAddItemMouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed
    private ItemServices _itemServices;
    private jMainPage _jMainPage;
    private jHomePage _jHomePage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddItem;
    private javax.swing.JButton jBack;
    private javax.swing.JTextField jDescription;
    private javax.swing.JLabel jErrorId2;
    private javax.swing.JLabel jErrorPrice;
    private javax.swing.JLabel jErrorcatgory;
    private javax.swing.JLabel jErrordescription;
    private javax.swing.JLabel jErrorid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jcatgory;
    private javax.swing.JTextField jid;
    private javax.swing.JTextField jprice;
    // End of variables declaration//GEN-END:variables
}
