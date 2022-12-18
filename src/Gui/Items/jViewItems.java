package Gui.Items;

import Entities.Item;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.ItemServices;
import java.util.ArrayList;
import java.util.UUID;
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
        _jViewItem = new jViewItem(jhp,this,jmp);
        toggle=false;
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
        jItem = new javax.swing.JTable();
        jadditem = new javax.swing.JButton();
        jdelete = new javax.swing.JButton();
        jToggleSort = new javax.swing.JButton();
        jErrorShowItem = new javax.swing.JLabel();
        jShowItem = new javax.swing.JButton();
        jDeleteMessage = new javax.swing.JLabel();

        jsortitemsby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Date", "Category", "Price" }));
        jsortitemsby.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jsortitemsbyMouseClicked(evt);
            }
        });

        jLabel1.setText("All Items :");

        jLabel2.setText("Search:");

        jsearchitems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jsearchitemsMouseClicked(evt);
            }
        });
        jsearchitems.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jsearchitemsKeyTyped(evt);
            }
        });

        jLabel3.setText("Sort by :");

        jBack.setText("Back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        jItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jItem.setGridColor(new java.awt.Color(0, 31, 78));
        jScrollPane2.setViewportView(jItem);

        jadditem.setText("Add Item");
        jadditem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jadditemMouseClicked(evt);
            }
        });

        jdelete.setText("delete");
        jdelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jdeleteMouseClicked(evt);
            }
        });

        jToggleSort.setText("↓↑\n");
        jToggleSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleSortMouseClicked(evt);
            }
        });

        jErrorShowItem.setForeground(new java.awt.Color(255, 0, 51));

        jShowItem.setText("Show Item");
        jShowItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jShowItemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jsearchitems, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jsortitemsby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jToggleSort, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jErrorShowItem, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jShowItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jadditem)))
                        .addContainerGap(22, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jDeleteMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsearchitems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsortitemsby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleSort))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(jErrorShowItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jadditem)
                    .addComponent(jdelete)
                    .addComponent(jBack)
                    .addComponent(jShowItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDeleteMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void showItems (){
            String [] titles= {"Id", "Name","Category","Price","CreatedAt"};
            DefaultTableModel m = (DefaultTableModel) jItem.getModel();
            m.setColumnIdentifiers(titles);
            m.setRowCount(0);
            ArrayList<Item> _items =_ItemServices.getAllItems();  
            String search=jsearchitems.getText();
            String Sortitemsby=(String)jsortitemsby.getSelectedItem();
            ArrayList<Item> _filtereditems = _jfilterItems.filter(_items,search,Sortitemsby,toggle);  
            if(!_filtereditems.isEmpty()) {
                for (int i=0;i<_filtereditems .size();i++)
                { 
                    Item item = _filtereditems .get(i);
                    Object [] items = { item.id, item.name,item.category,item.price,item.createdAt } ;
                    m.addRow(items);
                }
            }
        }
    private void deleteItem(){
         DefaultTableModel m = (DefaultTableModel) jItem.getModel();
          if(jItem.getSelectedRow() != -1) {
            UUID id = (UUID) m.getValueAt(jItem.getSelectedRow(), 0);
            m.removeRow(jItem.getSelectedRow());
            Item item = _ItemServices.getById(id);
            _jHomePage.createLog("Deleted", "Item", item.name);
            _ItemServices.delete(id);
            jDeleteMessage.setText("Item Deleted Successfully");
    }else{
              jDeleteMessage.setText("Error! Please Select Item");}
    }
    public Item getSelectedItem(){
        int row = jItem.getSelectedRow();//check ! -1
        if(row!=-1){
            jErrorShowItem.setText("");
            UUID choosedItemId = (UUID)(jItem.getModel().getValueAt(row, 0));
            Item choosedItem = _ItemServices.getById(choosedItemId);
            return choosedItem;
        }
        return null;
    }
   
    
    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        _jHomePage.switchPanels(_jMainPage);
        _jMainPage.jViewitems.grabFocus();
        jDeleteMessage.setText("");
    }//GEN-LAST:event_jBackMouseClicked

    private void jadditemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jadditemMouseClicked
        if(_jMainPage.canCreateItem()) {
           _jHomePage.switchPanels(_jNewItem);
           _jNewItem.jNameField.grabFocus();
       }
        jDeleteMessage.setText("");
    }//GEN-LAST:event_jadditemMouseClicked


    private void jsearchitemsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jsearchitemsKeyTyped
        showItems();
    }//GEN-LAST:event_jsearchitemsKeyTyped

    private void jdeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdeleteMouseClicked
       if(_jMainPage.canDeleteItem())
       {
           deleteItem();
       }
    }//GEN-LAST:event_jdeleteMouseClicked

    private void jToggleSortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleSortMouseClicked
       toggle = !toggle;
       showItems();
       jDeleteMessage.setText("");
    }//GEN-LAST:event_jToggleSortMouseClicked

    private void jShowItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jShowItemMouseClicked
        _jViewItem.resetViewItemPage();
        Item item  = getSelectedItem();
        if(item != null){
            _jViewItem.choosedItem = item;
            _jHomePage.switchPanels(_jViewItem);
            _jViewItem.jNameField.grabFocus();
            _jViewItem.renderData();
        }else{
            jErrorShowItem.setText("Please choose item from table");
        }
        jDeleteMessage.setText("");
    }//GEN-LAST:event_jShowItemMouseClicked

    private void jsearchitemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jsearchitemsMouseClicked
       jDeleteMessage.setText("");
    }//GEN-LAST:event_jsearchitemsMouseClicked

    private void jsortitemsbyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jsortitemsbyMouseClicked
       jDeleteMessage.setText("");
    }//GEN-LAST:event_jsortitemsbyMouseClicked

    private boolean toggle;
    public final jViewItem _jViewItem;
    private final ItemServices _ItemServices;
    private final jMainPage _jMainPage;
    private final jHomePage _jHomePage;
    private final jNewItem _jNewItem;
    private final filterItems _jfilterItems;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBack;
    private javax.swing.JLabel jDeleteMessage;
    private javax.swing.JLabel jErrorShowItem;
    public javax.swing.JTable jItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jShowItem;
    private javax.swing.JButton jToggleSort;
    public javax.swing.JButton jadditem;
    public javax.swing.JButton jdelete;
    public javax.swing.JTextField jsearchitems;
    private javax.swing.JComboBox<String> jsortitemsby;
    // End of variables declaration//GEN-END:variables
}
