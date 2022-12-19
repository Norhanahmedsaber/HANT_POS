package Gui.Items;

import Gui.Customers.jViewCustomer;
import Entities.Item;
import Gui.jHomePage;
import Gui.Customers.jNewCustomer;
import Services.CustomerServices;
import Services.ItemServices;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import utils.filterItems;

public class jChooseItem extends javax.swing.JPanel {
    public jChooseItem(jHomePage jhp,JPanel parent ) {
        initComponents();
        _jHomePage = jhp;
        _ItemServices = new ItemServices();
        _CustomerServices= new CustomerServices();
        _filterItems = new filterItems();
        _parent= parent;   
        if (parent instanceof jNewCustomer )
        {
            //fn tzabat el gui
            _jNewCustomer =(jNewCustomer)parent;
            _jViewCustomer=null;
          // jNewCustomer.
        }
        else 
        {   
           _jViewCustomer =(jViewCustomer)parent;
           _jNewCustomer=null;
        } 

    }
    public void edit()
    {
        _jViewCustomer.updateflag=!_jViewCustomer.updateflag;
        jedit.setEnabled(false);
        jupdate.setEnabled(true);
        jcancel.setEnabled(true);
        jRemove.setEnabled(true);
        jAdd.setEnabled(true);
        jBack.setEnabled(true);
        jItems.setEnabled(true);
    }
    void update()
    {        
        _jViewCustomer.updateflag=!_jViewCustomer.updateflag;
        jedit.setEnabled(true);
        jDone.setVisible(false);
        jupdate.setEnabled(false);
        jcancel.setEnabled(false);
        jRemove.setEnabled(false);
        jBack.setEnabled(true);
        jAdd.setEnabled(false);
        renderData();
    }
    void Cancel()
    {        _jViewCustomer.updateflag=!_jViewCustomer.updateflag;
        jedit.setEnabled(true);
        jBack.setEnabled(true);
        jupdate.setEnabled(false);
        jcancel.setEnabled(false);
        jRemove.setEnabled(false);
        jAdd.setEnabled(false);
        _jViewCustomer.updateflag=!_jViewCustomer.updateflag;      
    }
    void setDefault()
    {
        jcancel.setVisible(true);
        jedit.setVisible(true); 
        jupdate.setVisible(true);
        jRemove.setVisible(true);
        jDone.setVisible(true);
        jBack.setVisible(true);
        jAddedItems.setVisible(true);
        jItems.setVisible(true);
        jcancel.setEnabled(true);
        jedit.setEnabled(true); 
        jupdate.setEnabled(true);
        jRemove.setEnabled(true);
        jDone.setEnabled(true);
        jBack.setEnabled(true);
        jAddedItems.setEnabled(true);
        jItems.setEnabled(true);
       
        
    }
    void guisetforshowpurchases()
    {
        jcancel.setEnabled(false);
        jupdate.setEnabled(false);
        jRemove.setEnabled(false);
        jDone.setVisible(false);
        jAdd.setEnabled(false);
        jItems.setEnabled(false);
        
    }
    void guisetforupdatepurchases()
    {
        jDone.setVisible(false);
        jedit.setEnabled(false);
        jBack.setEnabled(false);
    }
    void guisetnewcustomer()
    {
        jcancel.setVisible(false);
        jedit.setVisible(false);
        jupdate.setVisible(false);
        
    }
    
    public void done() {
        DefaultTableModel m= (DefaultTableModel) jAddedItems.getModel();
        int row=m.getRowCount();
        int col=5;
        ArrayList<Item> items =new ArrayList<>();
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
        _jHomePage.switchPanels(_parent);
        
    }
    public void updateCustomer() {
        DefaultTableModel addedModel= (DefaultTableModel) jAddedItems.getModel();
        int row = addedModel.getRowCount();
        ArrayList<UUID> itemsIds =new ArrayList<>();
        for (int r = 0;r < row; r++)
        {
            itemsIds.add((UUID) addedModel.getValueAt(r, 0));
        }
        _CustomerServices.updateAssignedItemsToCustomer(_jViewCustomer._chosencustomer.id, itemsIds);
        
    }
    public void resetPanel() {
        String [] titles= {"Id", "Name","Category","Price","CreatedAt"};
        DefaultTableModel m1 = (DefaultTableModel) jItems.getModel();
        m1.setColumnIdentifiers(titles);
        m1.setRowCount(0);
        DefaultTableModel m2 = (DefaultTableModel) jAddedItems.getModel();
        m2.setColumnIdentifiers(titles);
        m2.setRowCount(0);
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
            ArrayList<Item> filteredItems = _filterItems.filter(items, search, sortBy, false);
            if(!filteredItems.isEmpty()) {
                resetPanel();
                DefaultTableModel model = (DefaultTableModel) jItems.getModel();
                 
                for(int i=0;i<filteredItems.size();i++) {
                    Item item = filteredItems.get(i);
                    Object[] data = { item.id, item.name, item.category, item.price, item.createdAt };
                    model.addRow(data);
                }
            }
        }
        ArrayList<Item> item ;
        if (_parent instanceof jNewCustomer){
            item =_jNewCustomer.getselecteditems();
        }
        else 
        {
            UUID id=_jViewCustomer._chosencustomer.id;
            item = _CustomerServices.getAssignedItems(id);
        }
        DefaultTableModel m=(DefaultTableModel) jAddedItems.getModel();
        for(int i=0;i<item.size();i++)
        {
            Item it= item.get(i);
            Object[] data= { it.id, it.name, it.category, it.price, it.createdAt };
            m.addRow(data);
        }
        if(_parent instanceof jViewCustomer && _jViewCustomer.updateflag)
        {
            setDefault();
            guisetforupdatepurchases();
            
        }
        else if (_parent instanceof jViewCustomer && !_jViewCustomer.updateflag)
        {
           // setDefault();
            guisetforshowpurchases();
        }
        else 
        {
            setDefault();
            guisetnewcustomer();
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
        jRemove = new javax.swing.JButton();
        jDone = new javax.swing.JButton();
        jError = new javax.swing.JLabel();
        jedit = new javax.swing.JButton();
        jupdate = new javax.swing.JButton();
        jcancel = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jItems = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jAddedItems = new javax.swing.JTable();
        jToggleSort = new javax.swing.JButton();

        setBackground(new java.awt.Color(87, 118, 130));

        jBack.setBackground(new java.awt.Color(217, 156, 69));
        jBack.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jBack.setForeground(new java.awt.Color(255, 255, 255));
        jBack.setText("Back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        jAdd.setBackground(new java.awt.Color(217, 156, 69));
        jAdd.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jAdd.setForeground(new java.awt.Color(255, 255, 255));
        jAdd.setText("ADD");
        jAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search :");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sort By :");

        jSearch.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jSearch.setForeground(new java.awt.Color(0, 31, 78));

        jItemsCombo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jItemsCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Category", "Name", "ID", "Price" }));

        jRemove.setBackground(new java.awt.Color(217, 156, 69));
        jRemove.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jRemove.setForeground(new java.awt.Color(255, 255, 255));
        jRemove.setText("Remove");
        jRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRemoveMouseClicked(evt);
            }
        });

        jDone.setBackground(new java.awt.Color(217, 156, 69));
        jDone.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jDone.setForeground(new java.awt.Color(255, 255, 255));
        jDone.setText("Done");
        jDone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDoneMouseClicked(evt);
            }
        });

        jError.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jError.setForeground(new java.awt.Color(0, 31, 78));

        jedit.setBackground(new java.awt.Color(217, 156, 69));
        jedit.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jedit.setForeground(new java.awt.Color(255, 255, 255));
        jedit.setText("Edit");
        jedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jeditMouseClicked(evt);
            }
        });

        jupdate.setBackground(new java.awt.Color(217, 156, 69));
        jupdate.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jupdate.setForeground(new java.awt.Color(255, 255, 255));
        jupdate.setText("Update");
        jupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jupdateMouseClicked(evt);
            }
        });

        jcancel.setBackground(new java.awt.Color(217, 156, 69));
        jcancel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jcancel.setForeground(new java.awt.Color(255, 255, 255));
        jcancel.setText("Cancel");
        jcancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcancelMouseClicked(evt);
            }
        });

        jItems.setBackground(new java.awt.Color(217, 156, 69));
        jItems.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jItems.setForeground(new java.awt.Color(255, 255, 255));
        jItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
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
        jItems.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jItems.setGridColor(new java.awt.Color(0, 31, 78));
        jItems.setOpaque(false);
        jItems.setSelectionBackground(new java.awt.Color(87, 118, 130));
        jScrollPane3.setViewportView(jItems);

        jAddedItems.setBackground(new java.awt.Color(217, 156, 69));
        jAddedItems.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jAddedItems.setForeground(new java.awt.Color(255, 255, 255));
        jAddedItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
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
        jAddedItems.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jAddedItems.setGridColor(new java.awt.Color(0, 31, 78));
        jAddedItems.setOpaque(false);
        jAddedItems.setSelectionBackground(new java.awt.Color(87, 118, 130));
        jScrollPane4.setViewportView(jAddedItems);

        jToggleSort.setBackground(new java.awt.Color(217, 156, 69));
        jToggleSort.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jToggleSort.setForeground(new java.awt.Color(255, 255, 255));
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                            .addComponent(jScrollPane4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jcancel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jedit, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jDone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jupdate, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jError, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jItemsCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jToggleSort))
                                .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 89, Short.MAX_VALUE)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSearch)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jItemsCombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jToggleSort)))
                .addGap(18, 18, 18)
                .addComponent(jError, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jedit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDone, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        _jHomePage.switchPanels(_parent);
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

    private void jupdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jupdateMouseClicked
        updateCustomer();
        setDefault();
        update();
    }//GEN-LAST:event_jupdateMouseClicked
     
    private void jeditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jeditMouseClicked
       setDefault();
       edit();
    }//GEN-LAST:event_jeditMouseClicked
    private void jcancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcancelMouseClicked
        setDefault();
        Cancel();
    }//GEN-LAST:event_jcancelMouseClicked

    private void jToggleSortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleSortMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jToggleSortMouseClicked
     private final JPanel _parent;
    private final ItemServices _ItemServices;
    private final CustomerServices _CustomerServices; 
    private final jHomePage _jHomePage;
    private final jNewCustomer _jNewCustomer;
    private final jViewCustomer _jViewCustomer;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTextField jSearch;
    private javax.swing.JButton jToggleSort;
    private javax.swing.JButton jcancel;
    private javax.swing.JButton jedit;
    private javax.swing.JButton jupdate;
    // End of variables declaration//GEN-END:variables

    
}
