package Gui;

import Entities.Item;
import Services.ItemServices;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import javax.swing.table.DefaultTableModel;
import sun.security.x509.PKIXExtensions;
import utils.filterItems;

public class jChooseItem extends javax.swing.JPanel {
    public jChooseItem(jNewCustomer jnc,jHomePage jhp ) {
        initComponents();
        _jNewCustomer = jnc;
        _jHomePage = jhp;
        _ItemServices = new ItemServices();
        _filterItems = new filterItems();
        toggle = false;
    }
    public void done() {
        DefaultTableModel m= (DefaultTableModel) jAddedItems.getModel();
        int row=m.getRowCount();
        int col=5;
        ArrayList<Item> items =new ArrayList<Item>();
        for (int r=0;r<row;r++)
        {   
            Object [] itemdata=new Object[col];
            for(int c=0;c<col;c++)
            {
                itemdata[c]= m.getValueAt(r, c);
            }
            Item item =new Item();
            item.id=(UUID) itemdata[0];
            item.name= (String) itemdata[1];
            item.category=(String) itemdata[2];
            item.price=(int) itemdata[3];
            item.createdAt=(Date) itemdata[4];
            items.add(item);
        }
        _jNewCustomer.setselecteditems(items);
        _jHomePage.switchPanels(_jNewCustomer);
        
    }
    public void resetPanel() {
        String [] titles= {"Id", "Name","Category","Price","CreatedAt"};
        DefaultTableModel model = new DefaultTableModel(titles,0);
        jItems.setModel(model);
        DefaultTableModel model2 = new DefaultTableModel(titles,0);
        jItems.setModel(model2);
        jAddedItems.setModel(model);
        jSearch.setText("");
        jItemsCombo.selectWithKeyChar('n');
        jError.setText("");
    }
    private void removeItemFromPreviewTable() {
        if(jAddedItems.getSelectedRow() != -1) {
            DefaultTableModel m = (DefaultTableModel) jAddedItems.getModel();
            m.removeRow(jAddedItems.getSelectedRow());
            
         }
    }
    private void addItemToPreviewTable() {
        int row = jItems.getSelectedRow();//check ! -1
        if(row!=-1)
        {
            int colNumber = 5;
            Object[] result = new Object[colNumber];
            for (int i = 0; i < colNumber; i++) {
                result[i] = jItems.getModel().getValueAt(row, i);
            }
            DefaultTableModel model = (DefaultTableModel) jAddedItems.getModel();
            model.addRow(result);
        }
    }
    public void renderData() {
        ArrayList<Item> items = _ItemServices.getAllItems();
        if(!items.isEmpty()) {
            String search = jSearch.getText();
            String sortBy = (String) jItemsCombo.getSelectedItem();
            ArrayList<Item> filteredItems = _filterItems.filter(items, search, sortBy , toggle);
            if(!filteredItems.isEmpty()) {
                String [] titles= {"Id", "Name","Category","Price","CreatedAt"};
                DefaultTableModel model = new DefaultTableModel(titles,0);
                jItems.setModel(model);
                for(int i=0;i<filteredItems.size();i++) {
                    Item item = filteredItems.get(i);
                    Object[] data = { item.id, item.name, item.category, item.price, item.createdAt };
                    model.addRow(data);
                }
            }
        }
        ArrayList<Item> item =_jNewCustomer.getselecteditems();
        DefaultTableModel m=(DefaultTableModel) jAddedItems.getModel();
        for(int i=0;i<item.size();i++)
        {
            Item it= item.get(i);
            Object[] data= { it.id, it.name, it.category, it.price, it.createdAt };
            m.addRow(data);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBack = new javax.swing.JButton();
        jAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSearch = new javax.swing.JTextField();
        jItemsCombo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jItems = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jAddedItems = new javax.swing.JTable();
        jRemove = new javax.swing.JButton();
        jDone = new javax.swing.JButton();
        jError = new javax.swing.JLabel();
        jToggleSort = new javax.swing.JButton();

        jBack.setText("Back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        jAdd.setText("ADD");
        jAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddMouseClicked(evt);
            }
        });

        jLabel2.setText("Search :");

        jLabel3.setText("Sort By :");

        jItemsCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Category", "Name", "ID", "Price" }));

        jItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Category", "Name", "ID", "Price"
            }
        ));
        jScrollPane1.setViewportView(jItems);

        jAddedItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Category", "Name", "ID", "Price"
            }
        ));
        jScrollPane2.setViewportView(jAddedItems);

        jRemove.setText("Remove");
        jRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRemoveMouseClicked(evt);
            }
        });

        jDone.setText("Done");
        jDone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDoneMouseClicked(evt);
            }
        });

        jError.setForeground(new java.awt.Color(255, 0, 0));

        jToggleSort.setText("↓↑\n");
        jToggleSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleSortMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jItemsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jToggleSort, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRemove)
                        .addGap(18, 18, 18)
                        .addComponent(jAdd)
                        .addGap(18, 18, 18)
                        .addComponent(jBack)))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jItemsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleSort))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBack)
                    .addComponent(jAdd)
                    .addComponent(jRemove)
                    .addComponent(jDone)
                    .addComponent(jError))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        _jHomePage.switchPanels(_jNewCustomer);
    }//GEN-LAST:event_jBackMouseClicked

    private void jAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddMouseClicked
        addItemToPreviewTable();
    }//GEN-LAST:event_jAddMouseClicked

    private void jRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRemoveMouseClicked
        removeItemFromPreviewTable();
    }//GEN-LAST:event_jRemoveMouseClicked

    private void jDoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDoneMouseClicked
        done();
    }//GEN-LAST:event_jDoneMouseClicked

    private void jToggleSortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleSortMouseClicked
        toggle = !toggle;
        renderData();

    }//GEN-LAST:event_jToggleSortMouseClicked
    private boolean toggle;
    private final ItemServices _ItemServices;
    private final jNewCustomer _jNewCustomer;
    private final jHomePage _jHomePage;
    private final filterItems _filterItems;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAdd;
    private javax.swing.JTable jAddedItems;
    private javax.swing.JButton jBack;
    private javax.swing.JButton jDone;
    private javax.swing.JLabel jError;
    private javax.swing.JTable jItems;
    private javax.swing.JComboBox<String> jItemsCombo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextField jSearch;
    private javax.swing.JButton jToggleSort;
    // End of variables declaration//GEN-END:variables

    
}
