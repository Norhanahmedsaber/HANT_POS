package Gui;

import Entities.Item;
import Services.ItemServices;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utils.filterItems;


public class jViewItems extends javax.swing.JPanel {


    public jViewItems(jHomePage jhp, jMainPage jmp) {
        initComponents();
        _jHomePage = jhp;
        _jMainPage = jmp;
         _jfilterItems=new filterItems();
         _jNewItem = new jNewItem(jhp,this);
        _ItemServices = new ItemServices();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jsortitemsby = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jsearchitems = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jadditem = new javax.swing.JButton();

        jsortitemsby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NameAscendingly", "NameDescendingly", "DateAscendingly", "DateDescendingly", "Category" }));
        jsortitemsby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsortitemsbyActionPerformed(evt);
            }
        });

        jLabel1.setText("All Items :");

        jLabel2.setText("search:");

        jsearchitems.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jsearchitemsKeyTyped(evt);
            }
        });

        jLabel3.setText(" sort by :");

        jBack.setText("Back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jadditem.setText("Add Item");
        jadditem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jadditemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 168, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jsearchitems)
                            .addComponent(jsortitemsby, 0, 256, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jadditem)
                        .addGap(63, 63, 63)
                        .addComponent(jBack))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsearchitems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jsortitemsby)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBack)
                    .addComponent(jadditem))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    public void showItems (){
            String [] titles= {"Id", "Name","Category","Price","CreatedAt"};
            DefaultTableModel model = new DefaultTableModel(titles,0);
            jTable1.setModel(model);
            ArrayList<Item> _items = _ItemServices.getAllItems();  
            String search=jsearchitems.getText();
            String Sortitemsby=(String)jsortitemsby.getSelectedItem();
            ArrayList<Item> _filtereditems = _jfilterItems.filter(_items,search,Sortitemsby);  
            if(!_filtereditems.isEmpty()) {
                for (int i=0;i<_filtereditems .size();i++)
                { 
                    Item item = _filtereditems .get(i);
                    Object [] items = { item.id, item.name,item.category,item.price,item.createdAt } ;
                    model.addRow(items);
                }
            }
        }
    
    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        _jHomePage.switchPanels(_jMainPage);
    }//GEN-LAST:event_jBackMouseClicked

    private void jadditemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jadditemMouseClicked
       _jHomePage.switchPanels(_jNewItem);
    }//GEN-LAST:event_jadditemMouseClicked


    private void jsearchitemsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jsearchitemsKeyTyped
        showItems();
    }//GEN-LAST:event_jsearchitemsKeyTyped

    private void jsortitemsbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsortitemsbyActionPerformed
        showItems();
    }//GEN-LAST:event_jsortitemsbyActionPerformed

    private final ItemServices _ItemServices;
    private final jMainPage _jMainPage;
    private final jHomePage _jHomePage;
    private final jNewItem _jNewItem;
    private final filterItems _jfilterItems;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jadditem;
    private javax.swing.JTextField jsearchitems;
    private javax.swing.JComboBox<String> jsortitemsby;
    // End of variables declaration//GEN-END:variables
}
