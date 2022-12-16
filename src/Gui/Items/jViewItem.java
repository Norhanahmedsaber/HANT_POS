
package Gui.Items;

import Entities.Item;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.ItemServices;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class jViewItem extends javax.swing.JPanel {

    public jViewItem(jHomePage jhp,jViewItems  jvi, jMainPage jmp) {
        initComponents();
        _jHomePage = jhp;
        _jMainPage = jmp;
        _jViewItems = jvi;
        choosedItem = null;
        _itemServices = new ItemServices();
        isEditing = false;
    }
    public void clearNewitemPage(){
        jNameField.setText("");
        jDescriptionField.setText("");
        jCatgoryField.setText("");
        jPriceField.setText("");
        jErrorCatgory.setText("");
        jErrorDescription.setText("");
        jErrorName.setText("");
        jErrorPrice.setText("");
       
    }
    public void renderData(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");     
        jNameField.setText(choosedItem.name);
        jCatgoryField.setText(choosedItem.category);
        jCreatedAt.setText(dateFormat.format(choosedItem.createdAt));
        jDescriptionField.setText(choosedItem.description);
        jPriceField.setText(Integer.toString(choosedItem.price));
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
    public void resetViewItemPage(){
        jNameField.setText("");
        jPriceField.setText("");
        jCatgoryField.setText("");
        jCreatedAt.setText("");
        jDescriptionField.setText("");
        removeUpdateANdCancelButtons();
    }
    public void updateItemData(){
        Item item =  choosedItem;
        item.name=jNameField.getText();
        item.category=jCatgoryField.getText();
        item.description=jDescriptionField.getText();
        item.price=Integer.parseInt(jPriceField.getText());
        _itemServices.update(choosedItem.id,item);
        choosedItem = _itemServices.getById(choosedItem.id);
        _jHomePage.createLog("Updated", "Item", item.name);
    }
    public void disableItemFields(){
        jCatgoryField.setEditable(false);
        jDescriptionField.setEditable(false);
        jNameField.setEditable(false);
        jPriceField.setEditable(false);
    }
    public void enableItemFields(){
        jCatgoryField.setEditable(true);
        jDescriptionField.setEditable(true);
        jNameField.setEditable(true);
        jPriceField.setEditable(true);
    }
    public void removeUpdateANdCancelButtons(){
        jCancel.setEnabled(false);
        jUpdate.setEnabled(false);
        jEdit.setEnabled(true);
        jBack.setEnabled(true);
    }
    public void enableUpdateANdCancelButtons(){
        jCancel.setEnabled(true);
        jUpdate.setEnabled(true);
        jEdit.setEnabled(false);
        jBack.setEnabled(false);
    }
    public void updateButton(){
        if(!checkAllValidations()){
           return;
        }else
        updateItemData();
        renderData();
        isEditing = false;
        jUpdatedSuccessfuly.setText("Updated Successfully!");
        disableItemFields();
        removeUpdateANdCancelButtons();
    }
    public void cancelButton(){
        removeUpdateANdCancelButtons();
        disableItemFields();
        renderData();
        isEditing = false;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jEdit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jNameField = new javax.swing.JTextField();
        jPriceField = new javax.swing.JTextField();
        jDescriptionField = new javax.swing.JTextField();
        jCreatedAt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jCatgoryField = new javax.swing.JTextField();
        jBack = new javax.swing.JButton();
        jCancel = new javax.swing.JButton();
        jUpdate = new javax.swing.JButton();
        jErrorName = new javax.swing.JLabel();
        jErrorDescription = new javax.swing.JLabel();
        jErrorPrice = new javax.swing.JLabel();
        jErrorCatgory = new javax.swing.JLabel();
        jUpdatedSuccessfuly = new javax.swing.JLabel();

        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jLabel2.setText("Description");

        jEdit.setText("Edit");
        jEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEditMouseClicked(evt);
            }
        });

        jLabel3.setText("Catgory");

        jLabel4.setText("Created At");

        jLabel5.setText("Price");

        jNameField.setEditable(false);
        jNameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNameFieldMouseClicked(evt);
            }
        });
        jNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNameFieldKeyPressed(evt);
            }
        });

        jPriceField.setEditable(false);
        jPriceField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPriceFieldMouseClicked(evt);
            }
        });
        jPriceField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPriceFieldKeyPressed(evt);
            }
        });

        jDescriptionField.setEditable(false);
        jDescriptionField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDescriptionFieldMouseClicked(evt);
            }
        });
        jDescriptionField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDescriptionFieldKeyPressed(evt);
            }
        });

        jCreatedAt.setEditable(false);
        jCreatedAt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCreatedAtMouseClicked(evt);
            }
        });
        jCreatedAt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCreatedAtKeyPressed(evt);
            }
        });

        jLabel6.setText("Item Data ");

        jLabel1.setText("Name");

        jCatgoryField.setEditable(false);
        jCatgoryField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCatgoryFieldMouseClicked(evt);
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

        jCancel.setText("Cancel");
        jCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCancelMouseClicked(evt);
            }
        });

        jUpdate.setText("Update");
        jUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateMouseClicked(evt);
            }
        });

        jErrorName.setForeground(new java.awt.Color(255, 0, 51));

        jErrorDescription.setForeground(new java.awt.Color(255, 0, 51));

        jErrorPrice.setForeground(new java.awt.Color(255, 0, 51));

        jErrorCatgory.setForeground(new java.awt.Color(255, 0, 51));

        jUpdatedSuccessfuly.setForeground(new java.awt.Color(51, 255, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jUpdate)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEdit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCatgoryField)
                            .addComponent(jCreatedAt)
                            .addComponent(jPriceField)
                            .addComponent(jDescriptionField)
                            .addComponent(jNameField)
                            .addComponent(jUpdatedSuccessfuly, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jErrorName)
                        .addComponent(jErrorDescription))
                    .addComponent(jErrorPrice)
                    .addComponent(jErrorCatgory))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jErrorName))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jErrorDescription))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jErrorPrice))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jCreatedAt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCatgoryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jErrorCatgory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jUpdatedSuccessfuly)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBack)
                    .addComponent(jEdit)
                    .addComponent(jCancel)
                    .addComponent(jUpdate))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        if(!isEditing) {
            resetViewItemPage();
            _jViewItems.showItems();
            _jHomePage.switchPanels(_jViewItems);  
            _jViewItems.jItem.grabFocus();///////////////////////////3ayza te5leeh 3al selected item bas
            jUpdatedSuccessfuly.setText("");
            
        }  
    }//GEN-LAST:event_jBackMouseClicked

    private void jEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEditMouseClicked
        if(!isEditing) {
            if(_jMainPage.canUpdateItem()) {
             enableItemFields();
             enableUpdateANdCancelButtons();
             isEditing = true;
            }
        }
    }//GEN-LAST:event_jEditMouseClicked

    private void jUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateMouseClicked
        if(isEditing) {
            updateButton();
            
        }
    }//GEN-LAST:event_jUpdateMouseClicked

    private void jCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCancelMouseClicked
        if(isEditing) {
            cancelButton();
        }
    }//GEN-LAST:event_jCancelMouseClicked

    private void jNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNameFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jNameFieldKeyPressed

    private void jDescriptionFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDescriptionFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jDescriptionFieldKeyPressed

    private void jPriceFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPriceFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jPriceFieldKeyPressed

    private void jCreatedAtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCreatedAtKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jCreatedAtKeyPressed

    private void jCatgoryFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCatgoryFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jCatgoryFieldKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jNameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNameFieldMouseClicked
            jUpdatedSuccessfuly.setText("");
    }//GEN-LAST:event_jNameFieldMouseClicked

    private void jDescriptionFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDescriptionFieldMouseClicked
            jUpdatedSuccessfuly.setText("");
    }//GEN-LAST:event_jDescriptionFieldMouseClicked

    private void jPriceFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPriceFieldMouseClicked
            jUpdatedSuccessfuly.setText("");
    }//GEN-LAST:event_jPriceFieldMouseClicked

    private void jCreatedAtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCreatedAtMouseClicked
            jUpdatedSuccessfuly.setText("");
    }//GEN-LAST:event_jCreatedAtMouseClicked

    private void jCatgoryFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCatgoryFieldMouseClicked
            jUpdatedSuccessfuly.setText("");
    }//GEN-LAST:event_jCatgoryFieldMouseClicked
    public boolean isEditing;
    public Item choosedItem;
    private final jMainPage _jMainPage;
    private final jHomePage _jHomePage;
    private final jViewItems _jViewItems;
    private final ItemServices _itemServices;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBack;
    private javax.swing.JButton jCancel;
    private javax.swing.JTextField jCatgoryField;
    private javax.swing.JTextField jCreatedAt;
    private javax.swing.JTextField jDescriptionField;
    public javax.swing.JButton jEdit;
    private javax.swing.JLabel jErrorCatgory;
    private javax.swing.JLabel jErrorDescription;
    private javax.swing.JLabel jErrorName;
    private javax.swing.JLabel jErrorPrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JTextField jNameField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jPriceField;
    private javax.swing.JButton jUpdate;
    private javax.swing.JLabel jUpdatedSuccessfuly;
    // End of variables declaration//GEN-END:variables
}
