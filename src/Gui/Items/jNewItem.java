package Gui.Items;
import Entities.Item;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.ItemServices;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
    public void saveItemData(){
        Item item =  new Item();
        item.price=Integer.parseInt(jPriceField.getText().trim());
        item.name=jNameField.getText().trim();
        item.category=jCatgoryField.getText().trim();
        item.description=jDescriptionField.getText().trim();
        item.createdAt=new Date(); 
        item.id=UUID.randomUUID();
        _itemServices.create(item);
        if(chosenImage != null) {
            File source = new File(chosenImage);
            File dest = new File("Images/" + item.id + ".jpg");
            try {
                copy(source,dest);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        _jHomePage.createLog("Created", "Item", item.name);
    }
    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    public void addItemButton(){
        if(!checkAllValidations()){
           return;
        }else
        saveItemData();   
        JOptionPane.showMessageDialog(null, "Added Successfully!");
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
        jPic = new javax.swing.JLabel();
        jUpload = new javax.swing.JButton();

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
        jAddItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Items/addItem1.png"))); // NOI18N
        jAddItem.setMnemonic('a');
        jAddItem.setText("   Add Item");
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
        jBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Items/back.png"))); // NOI18N
        jBack.setMnemonic('b');
        jBack.setText("    Back  ");
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

        jPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Items/photo2.png"))); // NOI18N

        jUpload.setBackground(new java.awt.Color(217, 156, 69));
        jUpload.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jUpload.setForeground(new java.awt.Color(255, 255, 255));
        jUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Items/UploadPhoto.png"))); // NOI18N
        jUpload.setMnemonic('u');
        jUpload.setText("     Upload Photo     ");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
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
                            .addComponent(jNameField))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jPic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jUpload, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel0)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCatgoryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jPic, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jUpload)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
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
          
    }//GEN-LAST:event_jNameFieldMouseClicked

    private void jDescriptionFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDescriptionFieldMouseClicked
          
    }//GEN-LAST:event_jDescriptionFieldMouseClicked

    private void jPriceFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPriceFieldMouseClicked
          
    }//GEN-LAST:event_jPriceFieldMouseClicked

    private void jCatgoryFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCatgoryFieldMouseClicked
          
    }//GEN-LAST:event_jCatgoryFieldMouseClicked

    private void jUploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUploadMouseClicked
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
    }//GEN-LAST:event_jUploadMouseClicked

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        if(_parent instanceof jViewItems)
        {
          jViewItems viewitems= (jViewItems) _parent;
          viewitems.showItems();
        }
        else 
        {
            jMainPage mainPage=(jMainPage)_parent;
            mainPage.jNewitem.grabFocus();
        }
        _jHomePage.switchPanels(_parent);
    }//GEN-LAST:event_jBackActionPerformed

    private void jAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddItemActionPerformed
        addItemButton();
    }//GEN-LAST:event_jAddItemActionPerformed

    private void jUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUploadActionPerformed
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
    
    private String chosenImage;
    private final JPanel _parent;
    private final ItemServices _itemServices;
    private final jHomePage _jHomePage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddItem;
    private javax.swing.JButton jBack;
    private javax.swing.JTextField jCatgoryField;
    private javax.swing.JTextField jDescriptionField;
    private javax.swing.JLabel jLabel0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JTextField jNameField;
    public javax.swing.JLabel jPic;
    private javax.swing.JTextField jPriceField;
    private javax.swing.JButton jUpload;
    // End of variables declaration//GEN-END:variables
}
