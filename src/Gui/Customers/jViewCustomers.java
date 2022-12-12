package Gui.Customers;

import Entities.Customer;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.CustomerServices;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.table.DefaultTableModel;
import utils.filterCustomers;

public final class jViewCustomers extends javax.swing.JPanel  {

    public jViewCustomers(jHomePage jhp, jMainPage jmp) { 
        initComponents(); 
        _jHomePage = jhp; 
        _jMainPage = jmp; 
        _CustomerServices = new CustomerServices(); 
        _filterCustomers = new filterCustomers();
        _jViewCustomer= new jViewCustomer(this, jhp, jmp);
        _jNewCustomer = new jNewCustomer(jhp, this);
        
        toggle = false;
    }
    //Make Table unEditable:
   
    public void renderData() { 
        String[] cols = {"ID","Name", "Email", "PurchaseDate", "PhoneNumber"}; 
        DefaultTableModel model = (DefaultTableModel) jCustomersTable.getModel();
        model.setColumnIdentifiers(cols);
        model.setRowCount(0);
        ArrayList<Customer> customers = _CustomerServices.getAll(); 
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
    private UUID deleteCustomer(){
            DefaultTableModel m = (DefaultTableModel) jCustomersTable.getModel();
              if(jCustomersTable.getSelectedRow() != -1) {
                UUID id = (UUID) m.getValueAt(jCustomersTable.getSelectedRow(), 0);
                m.removeRow(jCustomersTable.getSelectedRow());
                return id;
            }else{
                return null;
            }
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

        jLabel2.setText("search by name :");

        jSearchName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jSearchNameKeyTyped(evt);
            }
        });

        jLabel3.setText("Sort by :");

        jSortBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Date" }));
        jSortBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSortByActionPerformed(evt);
            }
        });

        jLabel1.setText("All Customers :");

        jBackButton.setText("Back");
        jBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackButtonMouseClicked(evt);
            }
        });

        jDeleteButton.setText("Delete");
        jDeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDeleteButtonMouseClicked(evt);
            }
        });

        jCustomersTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jCustomersTable);

        jToggleSort.setText("↓↑\n");
        jToggleSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleSortMouseClicked(evt);
            }
        });

        jShowButton.setText("Show Customer");
        jShowButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jShowButtonMouseClicked(evt);
            }
        });

        jAddButton.setText("Add Customer");
        jAddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSearchName)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSortBy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleSort, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBackButton)
                        .addGap(12, 12, 12)
                        .addComponent(jDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jShowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jAddButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jToggleSort)))
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDeleteButton)
                    .addComponent(jShowButton)
                    .addComponent(jBackButton)
                    .addComponent(jAddButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackButtonMouseClicked
        _jHomePage.switchPanels(_jMainPage);
    }//GEN-LAST:event_jBackButtonMouseClicked


    private void jSortByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSortByActionPerformed
        renderData();
    }//GEN-LAST:event_jSortByActionPerformed

    private void jSearchNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSearchNameKeyTyped
        renderData();
    }//GEN-LAST:event_jSearchNameKeyTyped

    private void jDeleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDeleteButtonMouseClicked
        if(_jMainPage.canDeleteCustomer())
        {
            UUID id = deleteCustomer();
            if(id!= null)
            {
                _CustomerServices.delete(deleteCustomer());
            }
        }
    }//GEN-LAST:event_jDeleteButtonMouseClicked

    private void jToggleSortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleSortMouseClicked
        // TODO add your handling code here:
        toggle = !toggle;
        renderData();
    }//GEN-LAST:event_jToggleSortMouseClicked

    private void jShowButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jShowButtonMouseClicked
        Customer customer = selectcustomer();
         if (customer!=null)
         { _jViewCustomer._chosencustomer=customer;
             _jViewCustomer.renderData();
             _jHomePage.switchPanels(_jViewCustomer);
         }
    }//GEN-LAST:event_jShowButtonMouseClicked

    private void jAddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddButtonMouseClicked
        
        if(_jMainPage.canCreateCustomer()) {
            _jHomePage.switchPanels(_jNewCustomer);
            _jNewCustomer.jNameField.grabFocus();
        }
    }//GEN-LAST:event_jAddButtonMouseClicked

    private boolean toggle ;
    public  jViewCustomer _jViewCustomer;
    private final filterCustomers _filterCustomers; 
    private final CustomerServices _CustomerServices; 
    private final jNewCustomer _jNewCustomer;
    private final jMainPage _jMainPage; 
    private final jHomePage _jHomePage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddButton;
    private javax.swing.JButton jBackButton;
    private javax.swing.JTable jCustomersTable;
    public javax.swing.JButton jDeleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jSearchName;
    private javax.swing.JButton jShowButton;
    private javax.swing.JComboBox<String> jSortBy;
    private javax.swing.JButton jToggleSort;
    // End of variables declaration//GEN-END:variables
}
