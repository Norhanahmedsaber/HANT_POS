package Gui;

import Entities.Item;
import Services.ItemServices;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.UUID;
import javax.swing.JPanel;

public class jNewItem extends javax.swing.JPanel {

    public jNewItem(jHomePage jhp,JPanel parent) {
        initComponents();
        _jHomePage = jhp;
        _parent = parent;
        _itemServices = new ItemServices();
       
    }
    void resetpannel()
    {
    }
    public void createItem()
     {
         if (jIdField.getText().isEmpty())
        {
            jErrorId.setText("please Enter This");
            return;
        }else jErrorId.setText(""); 
        if(jDescriptionField.getText().isEmpty())
        {
            jErrorDescription.setText("please Enter This");
            return;
        }else jErrorDescription.setText("");
        if(jPriceField.getText().isEmpty())
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
        if(jCatgoryField.getText().isEmpty())
        {
            jErrorCatgory.setText("Please Enter This");
            return;
        }else jErrorCatgory.setText("");

        Item item =  new Item();
        item.id = UUID.randomUUID();
        item.name=jIdField.getText();
        item.category=jCatgoryField.getText();
        item.description=jDescriptionField.getText();
        try{
            
            item.price=Integer.parseInt(jPriceField.getText());
        }catch(NumberFormatException e ){
            jErrorPrice.setText("you must enter number, chars not allowed.");
            return ;
        }
        item.createdAt=new Date(); 
        item.id=UUID.randomUUID();
        _itemServices.create(item);
        jIdField.setText("");
        jDescriptionField.setText("");
        jCatgoryField.setText("");
        jPriceField.setText("");
        jAddedSuccessfuly.setText("Added Succesfully");
       
         
     }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel0 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jAddItem = new javax.swing.JButton();
        jIdField = new javax.swing.JTextField();
        jPriceField = new javax.swing.JTextField();
        jDescriptionField = new javax.swing.JTextField();
        jCatgoryField = new javax.swing.JTextField();
        jBack = new javax.swing.JButton();
        jErrorId = new javax.swing.JLabel();
        jErrorDescription = new javax.swing.JLabel();
        jErrorPrice = new javax.swing.JLabel();
        jErrorCatgory = new javax.swing.JLabel();
        jAddedSuccessfuly = new javax.swing.JLabel();

        jLabel0.setText("New Item :");

        jLabel1.setText("ID");

        jLabel2.setText("Description");

        jLabel3.setText("price");

        jLabel4.setText("Catgory");

        jAddItem.setText("Add Item");
        jAddItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddItemMouseClicked(evt);
            }
        });
        jAddItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jAddItemKeyPressed(evt);
            }
        });

        jIdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jIdFieldKeyPressed(evt);
            }
        });

        jPriceField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPriceFieldKeyPressed(evt);
            }
        });

        jDescriptionField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDescriptionFieldKeyPressed(evt);
            }
        });

        jCatgoryField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCatgoryFieldKeyPressed(evt);
            }
        });

        jBack.setText("Back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        jErrorId.setForeground(new java.awt.Color(255, 0, 51));

        jErrorDescription.setForeground(new java.awt.Color(255, 0, 51));

        jErrorPrice.setForeground(new java.awt.Color(255, 0, 51));

        jErrorCatgory.setForeground(new java.awt.Color(255, 0, 0));

        jAddedSuccessfuly.setForeground(new java.awt.Color(51, 204, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jAddItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel0)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jAddedSuccessfuly, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCatgoryField, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jErrorCatgory)
                    .addComponent(jErrorId)
                    .addComponent(jErrorDescription)
                    .addComponent(jErrorPrice))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jErrorId))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jErrorDescription))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jErrorPrice))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCatgoryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jErrorCatgory)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jAddedSuccessfuly)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAddItem)
                    .addComponent(jBack))
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
      if(_parent instanceof jViewItems)
      {
          jViewItems viewitems= (jViewItems) _parent;
          
          viewitems.showItems();
      }
        _jHomePage.switchPanels(_parent);
    }//GEN-LAST:event_jBackMouseClicked

    private void jAddItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddItemMouseClicked

        createItem();
    }//GEN-LAST:event_jAddItemMouseClicked

    private void jIdFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jIdFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
             createItem();
        }

    }//GEN-LAST:event_jIdFieldKeyPressed

    private void jAddItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jAddItemKeyPressed
         if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            createItem();
        }
    }//GEN-LAST:event_jAddItemKeyPressed

    private void jDescriptionFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDescriptionFieldKeyPressed
         if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            createItem();
        }
    }//GEN-LAST:event_jDescriptionFieldKeyPressed

    private void jCatgoryFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCatgoryFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            createItem();
        }
    }//GEN-LAST:event_jCatgoryFieldKeyPressed

    private void jPriceFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPriceFieldKeyPressed
         if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
             createItem();
        }
    }//GEN-LAST:event_jPriceFieldKeyPressed
    
    private final JPanel _parent;
    private final ItemServices _itemServices;
    private final jHomePage _jHomePage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddItem;
    private javax.swing.JLabel jAddedSuccessfuly;
    private javax.swing.JButton jBack;
    private javax.swing.JTextField jCatgoryField;
    private javax.swing.JTextField jDescriptionField;
    private javax.swing.JLabel jErrorCatgory;
    private javax.swing.JLabel jErrorDescription;
    private javax.swing.JLabel jErrorId;
    private javax.swing.JLabel jErrorPrice;
    public javax.swing.JTextField jIdField;
    private javax.swing.JLabel jLabel0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jPriceField;
    // End of variables declaration//GEN-END:variables
}
