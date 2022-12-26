package Gui.Customers;

import Entities.Customer;
import Entities.Item;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.CustomerServices;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.filterCustomers;

public final class jViewCustomers extends javax.swing.JPanel  {

    public jViewCustomers(jHomePage jhp, jMainPage jmp, jNewCustomer jnc) { 
        initComponents(); 
        _jHomePage = jhp; 
        _jMainPage = jmp; 
        _CustomerServices = new CustomerServices(); 
        _filterCustomers = new filterCustomers();
        _jNewCustomer = jnc;
        _jViewCustomer = new jViewCustomer(this, jhp, jmp);
        toggle = false;
        
    }
    public void changecolor(java.awt.Color c)
    { 
        setBackground(c);
    }
    public void renderData() { 
        String[] cols = {"ID","Name", "Email", "PurchaseDate", "PhoneNumber"}; 
        DefaultTableModel model = (DefaultTableModel) jCustomersTable.getModel();
        model.setColumnIdentifiers(cols);
        model.setRowCount(0);
        ArrayList<Customer> customers = _CustomerServices.getAll();
        allCustomers = customers;
        if(!customers.isEmpty()) { 
            String searchName = jSearchName.getText(); 
            String sortBy = (String) jSortBy.getSelectedItem();
            ArrayList<Customer> filteredCustomers = _filterCustomers.filter(customers, searchName,sortBy , toggle ); 
            if(!filteredCustomers.isEmpty()){ 
                for(int i=0;i<filteredCustomers.size();i++) { 
                    Customer customer = filteredCustomers.get(i); 
                    Object[] objs = {customer.id, customer.name, customer.email, customer.purchaseDate, customer.phoneNumber}; 
                    model.addRow(objs); 
                } 
            } 
        } 
    }
    public void updateData() {
        String[] cols = {"ID","Name", "Email", "PurchaseDate", "PhoneNumber"}; 
        DefaultTableModel model = (DefaultTableModel) jCustomersTable.getModel();
        ArrayList<Customer> customers = allCustomers;
        model.setColumnIdentifiers(cols);
        model.setRowCount(0);
        if(!customers.isEmpty()) { 
            String searchName = jSearchName.getText(); 
            String sortBy = (String) jSortBy.getSelectedItem();
            ArrayList<Customer> filteredCustomers = _filterCustomers.filter(customers, searchName,sortBy , toggle ); 
            if(!filteredCustomers.isEmpty()){ 
                for(int i=0;i<filteredCustomers.size();i++) { 
                    Customer customer = filteredCustomers.get(i); 
                    Object[] objs = {customer.id, customer.name, customer.email, customer.purchaseDate, customer.phoneNumber}; 
                    model.addRow(objs); 
                } 
            } 
        } 
    }
    private void deleteCustomer(){
            DefaultTableModel m = (DefaultTableModel) jCustomersTable.getModel();
            if(jCustomersTable.getSelectedRow() != -1) {
                UUID id = (UUID) m.getValueAt(jCustomersTable.getSelectedRow(), 0);
                String name = (String) m.getValueAt(jCustomersTable.getSelectedRow(), 1);
                int answer = JOptionPane.showConfirmDialog(null, "Are you Sure you want to delete this Customer?");
                if(answer == JOptionPane.YES_OPTION) {
                    _jHomePage.createLog("Deleted", "Customer", name);
                    m.removeRow(jCustomersTable.getSelectedRow());
                    _CustomerServices.delete(id);
                    JOptionPane.showMessageDialog(null, "Deleted Successfully!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Please Select a Customer to be Deleted!");
            }
            renderData();
    }
    private Customer selectcustomer(){ 
        DefaultTableModel m = (DefaultTableModel) jCustomersTable.getModel();
            if(jCustomersTable.getSelectedRow() != -1){
                UUID id = (UUID) m.getValueAt(jCustomersTable.getSelectedRow(), 0);
               return  _CustomerServices.getById(id);
        }
            else return null;

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jSearchName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSortBy = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jBackButton = new javax.swing.JButton();
        jDeleteButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jCustomersTable = new javax.swing.JTable();
        jToggleSort = new javax.swing.JButton();
        jShowButton = new javax.swing.JButton();
        jAddButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(87, 118, 130));
        setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search by name :");

        jSearchName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jSearchName.setForeground(new java.awt.Color(0, 31, 78));
        jSearchName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSearchNameMouseClicked(evt);
            }
        });
        jSearchName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jSearchNameKeyTyped(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sort by :");

        jSortBy.setBackground(new java.awt.Color(217, 156, 69));
        jSortBy.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jSortBy.setForeground(new java.awt.Color(0, 31, 78));
        jSortBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Date" }));
        jSortBy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSortByMouseClicked(evt);
            }
        });
        jSortBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSortByActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("All Customers :");

        jBackButton.setBackground(new java.awt.Color(217, 156, 69));
        jBackButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jBackButton.setForeground(new java.awt.Color(255, 255, 255));
        jBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Customers/back.png"))); // NOI18N
        jBackButton.setMnemonic('b');
        jBackButton.setText("    Back  ");
        jBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackButtonMouseClicked(evt);
            }
        });
        jBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackButtonActionPerformed(evt);
            }
        });

        jDeleteButton.setBackground(new java.awt.Color(217, 156, 69));
        jDeleteButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jDeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        jDeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Customers/delete.png"))); // NOI18N
        jDeleteButton.setMnemonic('d');
        jDeleteButton.setText("Delete");
        jDeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDeleteButtonMouseClicked(evt);
            }
        });
        jDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteButtonActionPerformed(evt);
            }
        });

        jCustomersTable.setBackground(new java.awt.Color(217, 156, 69));
        jCustomersTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jCustomersTable.setForeground(new java.awt.Color(255, 255, 255));
        jCustomersTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jCustomersTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCustomersTable.setGridColor(new java.awt.Color(0, 31, 78));
        jCustomersTable.setOpaque(false);
        jCustomersTable.setSelectionBackground(new java.awt.Color(87, 118, 130));
        jScrollPane2.setViewportView(jCustomersTable);

        jToggleSort.setBackground(new java.awt.Color(217, 156, 69));
        jToggleSort.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jToggleSort.setForeground(new java.awt.Color(255, 255, 255));
        jToggleSort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Customers/sort3.png"))); // NOI18N
        jToggleSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleSortMouseClicked(evt);
            }
        });

        jShowButton.setBackground(new java.awt.Color(217, 156, 69));
        jShowButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jShowButton.setForeground(new java.awt.Color(255, 255, 255));
        jShowButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Customers/showCustomer.png"))); // NOI18N
        jShowButton.setMnemonic('s');
        jShowButton.setText("Show Customer");
        jShowButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jShowButtonMouseClicked(evt);
            }
        });
        jShowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowButtonActionPerformed(evt);
            }
        });

        jAddButton.setBackground(new java.awt.Color(217, 156, 69));
        jAddButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jAddButton.setForeground(new java.awt.Color(255, 255, 255));
        jAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Customers/addcustomer.png"))); // NOI18N
        jAddButton.setMnemonic('a');
        jAddButton.setText("Add Customer");
        jAddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddButtonMouseClicked(evt);
            }
        });
        jAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jShowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSortBy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(20, 20, 20)
                                .addComponent(jToggleSort, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSearchName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToggleSort, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jShowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackButtonMouseClicked
        _jHomePage.switchPanels(_jMainPage);
        _jMainPage.jViewcustomers.grabFocus();
    }//GEN-LAST:event_jBackButtonMouseClicked


    private void jSearchNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSearchNameKeyTyped
        updateData();
    }//GEN-LAST:event_jSearchNameKeyTyped

    private void jDeleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDeleteButtonMouseClicked
        if(_jMainPage.canDeleteCustomer())
        {
            deleteCustomer();
        }
    }//GEN-LAST:event_jDeleteButtonMouseClicked

    private void jToggleSortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleSortMouseClicked
        // TODO add your handling code here:
        toggle = !toggle;
        updateData();
    }//GEN-LAST:event_jToggleSortMouseClicked

    private void jShowButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jShowButtonMouseClicked
        Customer customer = selectcustomer();

        if (customer!=null)
        { 
            _jViewCustomer._chosencustomer=customer;
            _jViewCustomer.renderData();
            _jHomePage.switchPanels(_jViewCustomer);
            _jViewCustomer.jNameField.grabFocus();
            _jViewCustomer.jgenderCombobox.setEnabled(false);
        }else {
            JOptionPane.showMessageDialog(null, "Please Select Customer to View!");
        }

    }//GEN-LAST:event_jShowButtonMouseClicked

    private void jAddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddButtonMouseClicked
        
        if(_jMainPage.canCreateCustomer()) {
            _jHomePage.switchPanels(_jNewCustomer);
            _jNewCustomer.jNameField.grabFocus();
        }
    }//GEN-LAST:event_jAddButtonMouseClicked

    private void jSearchNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchNameMouseClicked

    }//GEN-LAST:event_jSearchNameMouseClicked

    private void jSortByMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSortByMouseClicked
  
    }//GEN-LAST:event_jSortByMouseClicked

    private void jBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackButtonActionPerformed
        _jHomePage.switchPanels(_jMainPage);
        _jMainPage.jViewcustomers.grabFocus();
    }//GEN-LAST:event_jBackButtonActionPerformed

    private void jDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteButtonActionPerformed
        if(_jMainPage.canDeleteCustomer())
        {
            deleteCustomer();
        }
    }//GEN-LAST:event_jDeleteButtonActionPerformed

    private void jShowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jShowButtonActionPerformed
        Customer customer = selectcustomer();

        if (customer!=null)
        { 
            _jViewCustomer._chosencustomer=customer;
            _jViewCustomer.renderData();
            _jHomePage.switchPanels(_jViewCustomer);
            _jViewCustomer.jNameField.grabFocus();
            _jViewCustomer.jgenderCombobox.setEnabled(false);
        }else {
            JOptionPane.showMessageDialog(null, "Please Select Customer to View!");
        }
    }//GEN-LAST:event_jShowButtonActionPerformed

    private void jAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddButtonActionPerformed
        if(_jMainPage.canCreateCustomer()) {
            _jHomePage.switchPanels(_jNewCustomer);
            _jNewCustomer.jNameField.grabFocus();
        }
    }//GEN-LAST:event_jAddButtonActionPerformed

    private void jSortByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSortByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSortByActionPerformed
    
    private boolean toggle ;
    private ArrayList<Customer> allCustomers;
    public  jViewCustomer _jViewCustomer;
    private final filterCustomers _filterCustomers; 
    private final CustomerServices _CustomerServices; 
    private final jNewCustomer _jNewCustomer;
    private final jMainPage _jMainPage; 
    private final jHomePage _jHomePage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jAddButton;
    private javax.swing.JButton jBackButton;
    private javax.swing.JTable jCustomersTable;
    public javax.swing.JButton jDeleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextField jSearchName;
    private javax.swing.JButton jShowButton;
    private javax.swing.JComboBox<String> jSortBy;
    private javax.swing.JButton jToggleSort;
    // End of variables declaration//GEN-END:variables
}
