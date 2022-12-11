package Gui.Items;

import Gui.Items.jViewItems;
import Entities.Item;
import Gui.jHomePage;
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
    public void resetNewitemPage(){
        jNameField.setText("");
        jDescriptionField.setText("");
        jCatgoryField.setText("");
        jPriceField.setText("");  
    }
    public boolean checkAllValidations(){
        
        if(!isValidName()){
            return false;
        }
        if (!isValidDescription()){
            return false;
        }
        if (!isValidPrice()){
            return false;
        }
        if (!isValidCatgory()){
            return false;
        }
        return true;
    }
    public boolean isValidName(){
        
        // chck name is empty
        if (jNameField.getText().trim().isEmpty())
        {
            jErrorName.setText("Cant be empty!");
            return false;
        }else jErrorName.setText("");
        
        
        // check name is valid
        for(int i=0 ; i < jNameField.getText().trim().length();i++){
            char x = jNameField.getText().trim().charAt(i);
            if(!(x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z' || x==' ')){
            jErrorName.setText("you must enter chars only.");
            return false;
            }else jErrorName.setText("");
        }
        return true;
    }
    public boolean isValidDescription(){
        if(jDescriptionField.getText().trim().isEmpty())
        {
            jErrorDescription.setText("Cant be empty!");
            return false;
        }else jErrorDescription.setText("");
        return true;
    }
    public boolean isValidPrice(){
        // is empty (Price)
        if(jPriceField.getText().trim().isEmpty()) {
           jErrorPrice.setText("Cant be empty!");
           return false;
        }else jErrorPrice.setText("");
        
        // is valid (Price)
        try {
            Integer.parseInt(jPriceField.getText());
        }catch(NumberFormatException e) {
            jErrorPrice.setText("you must enter number.");
            return false;
        }
        return true;
    }
    public boolean isValidCatgory(){
        if(jCatgoryField.getText().isEmpty())
        {
            jErrorCatgory.setText("Cant be empty!");
            return false;
        }else jErrorCatgory.setText("");
        
        return true;
    }
    public void saveItemData(){
        Item item =  new Item();
        item.price=Integer.parseInt(jPriceField.getText());
        item.name=jNameField.getText();
        item.category=jCatgoryField.getText();
        item.description=jDescriptionField.getText();
        item.createdAt=new Date(); 
        item.id=UUID.randomUUID();
        _itemServices.create(item);
    }
    public void addItemButton(){
        if(!checkAllValidations()){
           return;
        }else
        saveItemData();
        jAddedSuccessfuly.setText("Added Succesfully");
        resetNewitemPage();
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
        jNameField = new javax.swing.JTextField();
        jPriceField = new javax.swing.JTextField();
        jDescriptionField = new javax.swing.JTextField();
        jCatgoryField = new javax.swing.JTextField();
        jBack = new javax.swing.JButton();
        jErrorName = new javax.swing.JLabel();
        jErrorDescription = new javax.swing.JLabel();
        jErrorPrice = new javax.swing.JLabel();
        jErrorCatgory = new javax.swing.JLabel();
        jAddedSuccessfuly = new javax.swing.JLabel();

        jLabel0.setText("New Item :");

        jLabel1.setText("Name");

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

        jNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNameFieldKeyPressed(evt);
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

        jErrorName.setForeground(new java.awt.Color(255, 0, 51));
        jErrorName.setToolTipText("");

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
                                .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCatgoryField, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jErrorCatgory)
                    .addComponent(jErrorName)
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
                    .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jErrorName))
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
        addItemButton();
    }//GEN-LAST:event_jAddItemMouseClicked

    private void jNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNameFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addItemButton();
        }

    }//GEN-LAST:event_jNameFieldKeyPressed

    private void jAddItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jAddItemKeyPressed
         if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addItemButton();
        }
    }//GEN-LAST:event_jAddItemKeyPressed

    private void jDescriptionFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDescriptionFieldKeyPressed
         if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addItemButton();
        }
    }//GEN-LAST:event_jDescriptionFieldKeyPressed

    private void jCatgoryFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCatgoryFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addItemButton();
        }
    }//GEN-LAST:event_jCatgoryFieldKeyPressed

    private void jPriceFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPriceFieldKeyPressed
         if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
             addItemButton();
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
    private javax.swing.JLabel jErrorName;
    private javax.swing.JLabel jErrorPrice;
    private javax.swing.JLabel jLabel0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JTextField jNameField;
    private javax.swing.JTextField jPriceField;
    // End of variables declaration//GEN-END:variables
}