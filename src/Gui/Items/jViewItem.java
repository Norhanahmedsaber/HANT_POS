
package Gui.Items;

import Entities.Item;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.ItemServices;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


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
       
    }
    public void renderData(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");     
        jNameField.setText(choosedItem.name);
        jCatgoryField.setText(choosedItem.category);
        jCreatedAt.setText(dateFormat.format(choosedItem.createdAt));
        jDescriptionField.setText(choosedItem.description);
        jPriceField.setText(Integer.toString(choosedItem.price));
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Images/" + choosedItem.id + ".jpg"));
        } catch (Exception ex) {
            img = null;
            try {
                img = ImageIO.read(new File("Images/photo2.png"));
            } catch (IOException e) {
                Logger.getLogger(jViewItem.class.getName()).log(Level.SEVERE, null, e);
            }
            Image dimg = img.getScaledInstance(220, 220,Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            jPic.setIcon(imageIcon);
        }
        Image dimg = img.getScaledInstance(220, 220,Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        jPic.setIcon(imageIcon);
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
            JOptionPane.showMessageDialog(null, "Username cannot be Empty!");
            return false;
        }
        
        return true;
    }
    public boolean isValidDescription(){
        if(jDescriptionField.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Description can't be Empty!");
            return false;
        }
        return true;
    }
    public boolean isValidPrice(){
        // is empty (Price)
        if(jPriceField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Price can't be Empty!");
           return false;
        }
        
        // is valid (Price)
        try {
            Integer.valueOf(jPriceField.getText());
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please Enter a valid number!");
            return false;
        }
        return true;
    }
    public boolean isValidCatgory(){
        if(jCatgoryField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Category can't be Empty!");
            return false;
        }
        return true;
    }
    public void resetViewItemPage(){
        jNameField.setText("");
        jPriceField.setText("");
        jCatgoryField.setText("");
        jDescriptionField.setText("");
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Images/photo2.png"));
        } catch (IOException ex) {
            Logger.getLogger(jViewItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image dimg = img.getScaledInstance(220, 220,Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        jPic.setIcon(imageIcon);
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
        File f = new File("Images/" + item.id + ".jpg");
        f.delete();
        File source = new File(chosenImage);
        File dest = new File("Images/" + item.id + ".jpg");
        try {
            copy(source,dest);
        } catch (IOException ex) {
            System.out.println(ex);
        }
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
        jUpload.setEnabled(false);
    }
    public void enableUpdateANdCancelButtons(){
        jCancel.setEnabled(true);
        jUpdate.setEnabled(true);
        jEdit.setEnabled(false);
        jBack.setEnabled(false);
        jUpload.setEnabled(true);
    }
    public void updateButton(){
        if(!checkAllValidations()){
           return;
        }else
        updateItemData();
        renderData();
        isEditing = false;
        JOptionPane.showMessageDialog(null, "Updated Successfully!");
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
        jUpdatedSuccessfuly = new javax.swing.JLabel();
        jPic = new javax.swing.JLabel();
        jUpload = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(87, 118, 130));
        jPanel1.setForeground(new java.awt.Color(0, 31, 78));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Description:");

        jEdit.setBackground(new java.awt.Color(217, 156, 69));
        jEdit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jEdit.setForeground(new java.awt.Color(255, 255, 255));
        jEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Items/editing.png"))); // NOI18N
        jEdit.setMnemonic('e');
        jEdit.setText("   Edit  ");
        jEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEditMouseClicked(evt);
            }
        });
        jEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Catgory:");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Created At:");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Price:");

        jNameField.setEditable(false);
        jNameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
        jPriceField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
        jDescriptionField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
        jCreatedAt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Item Data :");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name:");

        jCatgoryField.setEditable(false);
        jCatgoryField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
        jBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Items/back.png"))); // NOI18N
        jBack.setMnemonic('b');
        jBack.setText("    Back   ");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });
        jBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackActionPerformed(evt);
            }
        });

        jCancel.setBackground(new java.awt.Color(217, 156, 69));
        jCancel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jCancel.setForeground(new java.awt.Color(255, 255, 255));
        jCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Items/cancel1.png"))); // NOI18N
        jCancel.setMnemonic('c');
        jCancel.setText("   Cancel");
        jCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCancelMouseClicked(evt);
            }
        });
        jCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelActionPerformed(evt);
            }
        });

        jUpdate.setBackground(new java.awt.Color(217, 156, 69));
        jUpdate.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Items/UpdateItem.png"))); // NOI18N
        jUpdate.setMnemonic('u');
        jUpdate.setText("   Update  ");
        jUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateMouseClicked(evt);
            }
        });
        jUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUpdateActionPerformed(evt);
            }
        });

        jUpdatedSuccessfuly.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jUpdatedSuccessfuly.setForeground(new java.awt.Color(0, 255, 100));

        jPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Items/photo2.png"))); // NOI18N

        jUpload.setBackground(new java.awt.Color(217, 156, 69));
        jUpload.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jUpload.setForeground(new java.awt.Color(255, 255, 255));
        jUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Items/UploadPhoto.png"))); // NOI18N
        jUpload.setMnemonic('p');
        jUpload.setText("    Upload Photo  ");
        jUpload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUploadMouseClicked(evt);
            }
        });
        jUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(jCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jUpdatedSuccessfuly, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(218, 218, 218)))
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jCreatedAt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                                    .addComponent(jPriceField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDescriptionField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jNameField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCatgoryField))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPic, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addComponent(jPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jCreatedAt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCatgoryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jPic, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jUpload)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jUpdatedSuccessfuly)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
             jUpdatedSuccessfuly.setText("");
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
            jUpdatedSuccessfuly.setText("");
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

    private void jUploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUploadMouseClicked
        if(isEditing) {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            String filename = f.getAbsolutePath();
            chosenImage = filename;
            try {
                ImageIcon ii=new ImageIcon(scaleImage(220, 220, ImageIO.read(new File(f.getAbsolutePath()))));//get the image from file chooser and scale it to match JLabel size
                jPic.setIcon(ii);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jUploadMouseClicked

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        if(!isEditing) {
            resetViewItemPage();
            _jViewItems.showItems();
            _jHomePage.switchPanels(_jViewItems);  
            _jViewItems.jItem.grabFocus();///////////////////////////3ayza te5leeh 3al selected item bas
            jUpdatedSuccessfuly.setText("");
            
        } 
    }//GEN-LAST:event_jBackActionPerformed

    private void jCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelActionPerformed
        if(isEditing) {
            cancelButton();
            jUpdatedSuccessfuly.setText("");
        }
    }//GEN-LAST:event_jCancelActionPerformed

    private void jUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUpdateActionPerformed
        if(isEditing) {
            updateButton();
        }
    }//GEN-LAST:event_jUpdateActionPerformed

    private void jEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditActionPerformed
        if(!isEditing) {
            if(_jMainPage.canUpdateItem()) {
             enableItemFields();
             enableUpdateANdCancelButtons();
             jUpdatedSuccessfuly.setText("");
             isEditing = true;
            }
        }
    }//GEN-LAST:event_jEditActionPerformed

    private void jUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUploadActionPerformed
        if(isEditing) {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            String filename = f.getAbsolutePath();
            chosenImage = filename;
            try {
                ImageIcon ii=new ImageIcon(scaleImage(220, 220, ImageIO.read(new File(f.getAbsolutePath()))));//get the image from file chooser and scale it to match JLabel size
                jPic.setIcon(ii);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jUploadActionPerformed
    public static void copy(File src, File dest) throws IOException { 
        InputStream is = null;
        OutputStream os = null;
        is = new FileInputStream(src);
        os = new FileOutputStream(dest);// buffer size 1K
        byte[] buf = new byte[1024];
        int bytesRead;
        while ((bytesRead = is.read(buf)) > 0) {
            os.write(buf, 0, bytesRead);
        }
    }


    public static BufferedImage scaleImage(int w, int h, BufferedImage img) throws Exception {
        BufferedImage bi;
        bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(img, 0, 0, w, h, null);
        g2d.dispose();
        return bi;
    }
    private String chosenImage = "Images/noImage.jpg";
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JTextField jNameField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jPic;
    private javax.swing.JTextField jPriceField;
    private javax.swing.JButton jUpdate;
    private javax.swing.JLabel jUpdatedSuccessfuly;
    private javax.swing.JButton jUpload;
    // End of variables declaration//GEN-END:variables
}
