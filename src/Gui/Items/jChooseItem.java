package Gui.Items;

import Gui.Customers.jViewCustomer;
import Entities.Item;
import Gui.jHomePage;
import Gui.Customers.jNewCustomer;
import Services.CustomerServices;
import Services.ItemServices;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import javax.swing.JOptionPane;
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
     
    public void changecolor(java.awt.Color c1,java.awt.Color c2,java.awt.Color c3,java.awt.Color c4,java.awt.Color c5)
    { 
        setBackground(c1);
        jBack.setBackground(c2);
        jBack.setForeground(c4);
        jAdd.setBackground(c2);
        jAdd.setForeground(c4);
        jDone.setBackground(c2);
        jDone.setForeground(c4);
        jItems.setBackground(c2);
        jAddedItems.setForeground(c4);
        jItemsCombo.setBackground(c5);
        jLabel2.setForeground(c3);
        jLabel3.setForeground(c3);
        jRemove.setBackground(c2);
        jRemove.setForeground(c4);
        jScrollPane3.setBackground(c5);
        jScrollPane4.setBackground(c5);
        jSearch.setBackground(c5);
        jToggleSort.setBackground(c2);
        jToggleSort.setForeground(c4);
        jcancel.setBackground(c2);
        jcancel.setForeground(c4);
        jedit.setBackground(c2);
        jedit.setForeground(c4);
        jupdate.setBackground(c2);
        jupdate.setForeground(c4);
        jAddedItems.setBackground(c2);
         jAddedItems.setForeground(c4);
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
        jDone.setVisible(false);
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
        jDone.setVisible(false);
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
        jDone.setVisible(true);
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
        JOptionPane.showMessageDialog(null, "Updated Successfully!");
        
    }
    public void resetPanel() {
        String [] titles= {"Id", "Name","Category","Price","CreatedAt"};
        DefaultTableModel m1 = (DefaultTableModel) jItems.getModel();
        m1.setColumnIdentifiers(titles);
        m1.setRowCount(0);
        DefaultTableModel m2 = (DefaultTableModel) jAddedItems.getModel();
        m2.setColumnIdentifiers(titles);
        m2.setRowCount(0);
        jItemsCombo.selectWithKeyChar('n');
    }
    private boolean removeItemFromPreviewTable() {
        if(jAddedItems.getSelectedRow() != -1) {
            DefaultTableModel m = (DefaultTableModel) jAddedItems.getModel();
            m.removeRow(jAddedItems.getSelectedRow());
            return true;
        }else {
            JOptionPane.showMessageDialog(null, "Plese Select an Item to Remove it!");
            return false;
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
        }else {
            JOptionPane.showMessageDialog(null, "Plese Select an Item to be added!");
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
            //setDefault();
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
        jedit = new javax.swing.JButton();
        jupdate = new javax.swing.JButton();
        jcancel = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jItems = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jAddedItems = new javax.swing.JTable();
        jToggleSort = new javax.swing.JButton();

        setBackground(new java.awt.Color(87, 118, 130));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jBack.setBackground(new java.awt.Color(217, 156, 69));
        jBack.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jBack.setForeground(new java.awt.Color(255, 255, 255));
        jBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Items/back.png"))); // NOI18N
        jBack.setMnemonic('b');
        jBack.setText("   Back  ");
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

        jAdd.setBackground(new java.awt.Color(217, 156, 69));
        jAdd.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jAdd.setForeground(new java.awt.Color(255, 255, 255));
        jAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Items/addItem1.png"))); // NOI18N
        jAdd.setMnemonic('a');
        jAdd.setText("  ADD       ");
        jAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddActionPerformed(evt);
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
        jSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jSearchKeyTyped(evt);
            }
        });

        jItemsCombo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jItemsCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Category", "Name", "ID", "Price" }));

        jRemove.setBackground(new java.awt.Color(217, 156, 69));
        jRemove.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jRemove.setForeground(new java.awt.Color(255, 255, 255));
        jRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Items/delete.png"))); // NOI18N
        jRemove.setMnemonic('r');
        jRemove.setText("   Remove  ");
        jRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRemoveActionPerformed(evt);
            }
        });

        jDone.setBackground(new java.awt.Color(217, 156, 69));
        jDone.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jDone.setForeground(new java.awt.Color(255, 255, 255));
        jDone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Items/done1.png"))); // NOI18N
        jDone.setMnemonic('d');
        jDone.setText("   Done  ");
        jDone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDoneMouseClicked(evt);
            }
        });
        jDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDoneActionPerformed(evt);
            }
        });

        jedit.setBackground(new java.awt.Color(217, 156, 69));
        jedit.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jedit.setForeground(new java.awt.Color(255, 255, 255));
        jedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Items/editing.png"))); // NOI18N
        jedit.setMnemonic('e');
        jedit.setText("  Edit    ");
        jedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jeditMouseClicked(evt);
            }
        });
        jedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jeditActionPerformed(evt);
            }
        });

        jupdate.setBackground(new java.awt.Color(217, 156, 69));
        jupdate.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jupdate.setForeground(new java.awt.Color(255, 255, 255));
        jupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Items/UpdateItem.png"))); // NOI18N
        jupdate.setMnemonic('u');
        jupdate.setText("   Update  ");
        jupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jupdateMouseClicked(evt);
            }
        });
        jupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jupdateActionPerformed(evt);
            }
        });

        jcancel.setBackground(new java.awt.Color(217, 156, 69));
        jcancel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jcancel.setForeground(new java.awt.Color(255, 255, 255));
        jcancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Items/cancel1.png"))); // NOI18N
        jcancel.setMnemonic('c');
        jcancel.setText("   Cancel    ");
        jcancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcancelMouseClicked(evt);
            }
        });
        jcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcancelActionPerformed(evt);
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
        jToggleSort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Items/sort3.png"))); // NOI18N
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
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jedit, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jDone, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane4)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, 0)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jItemsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(jToggleSort, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jItemsCombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jToggleSort, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jedit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDone, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        _jHomePage.switchPanels(_parent);
    }//GEN-LAST:event_jBackMouseClicked

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

    private void jcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcancelActionPerformed
        setDefault();
        Cancel();
    }//GEN-LAST:event_jcancelActionPerformed

    private void jeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jeditActionPerformed
        setDefault();
       edit();
    }//GEN-LAST:event_jeditActionPerformed

    private void jupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jupdateActionPerformed
        updateCustomer();
        setDefault();
        update();
    }//GEN-LAST:event_jupdateActionPerformed

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        _jHomePage.switchPanels(_parent);
    }//GEN-LAST:event_jBackActionPerformed

    private void jRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRemoveActionPerformed
       removeItemFromPreviewTable();
    }//GEN-LAST:event_jRemoveActionPerformed

    private void jDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDoneActionPerformed
        done();
    }//GEN-LAST:event_jDoneActionPerformed

    private void jAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddActionPerformed
        addItemToPreviewTable();
    }//GEN-LAST:event_jAddActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        
    }//GEN-LAST:event_formKeyTyped

    private void jSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSearchKeyTyped
      renderData();
    }//GEN-LAST:event_jSearchKeyTyped
   

    
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
