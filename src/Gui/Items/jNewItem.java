package Gui.Items;
import Entities.Item;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.ItemServices;
import java.awt.Color;
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
    
      public void changecolor(int x, int y ,int z)
    { 
        setBackground(new java.awt.Color(x, y, z));
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
        return isValidCatgory();
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
            Integer.valueOf(jPriceField.getText().trim());
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
        item.price=Integer.parseInt(jPriceField.getText().trim());
        item.name=jNameField.getText().trim();
        item.category=jCatgoryField.getText().trim();
        item.description=jDescriptionField.getText().trim();
        item.createdAt=new Date(); 
        item.id=UUID.randomUUID();
        _itemServices.create(item);
        _jHomePage.createLog("Created", "Item", item.name);
    }
    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    public void addItemButton(){
        if(!checkAllValidations()){
           return;
        }else
        saveItemData();   
        jAddedSuccessfuly.setText("Added Succesfully");
        clearNewitemPage();
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

        setBackground(new java.awt.Color(87, 118, 130));
        setForeground(new java.awt.Color(0, 31, 78));

        jLabel0.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel0.setForeground(new java.awt.Color(255, 255, 255));
        jLabel0.setText("New Item :");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Description:");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Price:");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Catgory:");

        jAddItem.setBackground(new java.awt.Color(217, 156, 69));
        jAddItem.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jAddItem.setForeground(new java.awt.Color(255, 255, 255));
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

        jNameField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jNameField.setForeground(new java.awt.Color(0, 31, 78));
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

        jPriceField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPriceField.setForeground(new java.awt.Color(0, 31, 78));
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

        jDescriptionField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jDescriptionField.setForeground(new java.awt.Color(0, 31, 78));
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

        jCatgoryField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jCatgoryField.setForeground(new java.awt.Color(0, 31, 78));
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

        jBack.setBackground(new java.awt.Color(217, 156, 69));
        jBack.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jBack.setForeground(new java.awt.Color(255, 255, 255));
        jBack.setText("Back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        jErrorName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jErrorName.setForeground(new java.awt.Color(0, 31, 78));
        jErrorName.setToolTipText("");

        jErrorDescription.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jErrorDescription.setForeground(new java.awt.Color(0, 31, 78));

        jErrorPrice.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jErrorPrice.setForeground(new java.awt.Color(0, 31, 78));

        jErrorCatgory.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jErrorCatgory.setForeground(new java.awt.Color(0, 31, 78));

        jAddedSuccessfuly.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jAddedSuccessfuly.setForeground(new java.awt.Color(0, 255, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jAddedSuccessfuly, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel0))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCatgoryField, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                    .addComponent(jPriceField, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                    .addComponent(jDescriptionField, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                    .addComponent(jNameField)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jErrorName, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jErrorCatgory, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jErrorPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(jErrorDescription, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 70, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel0)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jErrorName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jErrorDescription))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jErrorPrice)
                    .addComponent(jLabel3)
                    .addComponent(jPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCatgoryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jErrorCatgory))
                    .addComponent(jLabel4))
                .addGap(37, 37, 37)
                .addComponent(jAddedSuccessfuly)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        if(_parent instanceof jViewItems)
        {
          jViewItems viewitems= (jViewItems) _parent;
          viewitems.showItems();
        }
        else 
        {
            jMainPage mainPage=(jMainPage)_parent;
            mainPage.jNewitem.grabFocus();
              jAddedSuccessfuly.setText("");
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

    private void jNameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNameFieldMouseClicked
          jAddedSuccessfuly.setText("");
    }//GEN-LAST:event_jNameFieldMouseClicked

    private void jDescriptionFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDescriptionFieldMouseClicked
          jAddedSuccessfuly.setText("");
    }//GEN-LAST:event_jDescriptionFieldMouseClicked

    private void jPriceFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPriceFieldMouseClicked
          jAddedSuccessfuly.setText("");
    }//GEN-LAST:event_jPriceFieldMouseClicked

    private void jCatgoryFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCatgoryFieldMouseClicked
          jAddedSuccessfuly.setText("");
    }//GEN-LAST:event_jCatgoryFieldMouseClicked
    
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
