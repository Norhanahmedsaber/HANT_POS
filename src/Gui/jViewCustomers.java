package Gui;

import Entities.Customer;
import Services.CustomerServices;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.table.DefaultTableModel;
import utils.filterCustomers;

public final class jViewCustomers extends javax.swing.JPanel {

    public jViewCustomers(jHomePage jhp, jMainPage jmp) { 
        initComponents(); 
        _jHomePage = jhp; 
        _jMainPage = jmp; 
        _CustomerServices = new CustomerServices(); 
        _filterCustomers = new filterCustomers();
        _jViewCustomer= new jViewCustomer();
        //_chosencustomer=new Customer();
    }
public void renderData() { 
        String[] cols = {"ID","Name", "Email", "PurchaseDate", "PhoneNumber"}; 
        DefaultTableModel model = new DefaultTableModel(cols, 0); 
        jCustomersTable.setModel(model); 
        ArrayList<Customer> customers = _CustomerServices.getAll(); 
        if(!customers.isEmpty()) { 
            String searchName = jSearchName.getText(); 
            String sortBy = (String) jSortBy.getSelectedItem(); 
            ArrayList<Customer> filteredCustomers = _filterCustomers.filter(customers, searchName,sortBy); 
            if(!filteredCustomers.isEmpty()){ 
                for(int i=0;i<filteredCustomers.size();i++) { 
                    Customer customer = filteredCustomers.get(i); 
                    Object[] objs = {customer.id, customer.name, customer.email, customer.purchaseDate, customer.phoneNumber}; 
                    model.addRow(objs); 
                } 
            } 
        } 
    }
private UUID deleteCustomer()
{
        DefaultTableModel m = (DefaultTableModel) jCustomersTable.getModel();
          if(jCustomersTable.getSelectedRow() != -1) {
            UUID id = (UUID) m.getValueAt(jCustomersTable.getSelectedRow(), 0);
            m.removeRow(jCustomersTable.getSelectedRow());
            return id;
        }else{
            return null;
        }
}

    
private Customer selectcustomer()
{ 
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
        jBack = new javax.swing.JButton();
        jDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jCustomersTable = new javax.swing.JTable();
        jviewCustomer = new javax.swing.JButton();

        jLabel2.setText("search by name :");

        jSearchName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jSearchNameKeyTyped(evt);
            }
        });

        jLabel3.setText("sort by :");

        jSortBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NameAscendingly", "NameDescendingly", "DateAscendingly", "DateDescendingly" }));
        jSortBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSortByActionPerformed(evt);
            }
        });

        jLabel1.setText("All Customers :");

        jBack.setText("Back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        jDelete.setText("Delete");
        jDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDeleteMouseClicked(evt);
            }
        });

        jCustomersTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jCustomersTable);

        jviewCustomer.setText("view Customer");
        jviewCustomer.setPreferredSize(new java.awt.Dimension(59, 25));
        jviewCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jviewCustomerMouseClicked(evt);
            }
        });
        jviewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jviewCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSearchName)
                            .addComponent(jSortBy, 0, 391, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jviewCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBack)
                        .addComponent(jDelete))
                    .addComponent(jviewCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        _jHomePage.switchPanels(_jMainPage);
    }//GEN-LAST:event_jBackMouseClicked


    private void jSortByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSortByActionPerformed
        renderData();
    }//GEN-LAST:event_jSortByActionPerformed

    private void jSearchNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSearchNameKeyTyped
        renderData();
    }//GEN-LAST:event_jSearchNameKeyTyped

    private void jDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDeleteMouseClicked
        UUID id = deleteCustomer();
        if(id!= null)
        {
            _CustomerServices.delete(id);
        }
    }//GEN-LAST:event_jDeleteMouseClicked

    private void jviewCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jviewCustomerMouseClicked
       Customer customer = selectcustomer();
         if (customer!=null)
         { _jViewCustomer._chosencustomer=customer;
             _jViewCustomer.renderData();
             _jHomePage.switchPanels(_jViewCustomer);
         }
    }//GEN-LAST:event_jviewCustomerMouseClicked

    private void jviewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jviewCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jviewCustomerActionPerformed
    private  jViewCustomer _jViewCustomer;
    private final filterCustomers _filterCustomers; 
    private final CustomerServices _CustomerServices; 
    private final jMainPage _jMainPage; 
    private final jHomePage _jHomePage;
   // public Customer _chosencustomer;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBack;
    private javax.swing.JTable jCustomersTable;
    private javax.swing.JButton jDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jSearchName;
    private javax.swing.JComboBox<String> jSortBy;
    private javax.swing.JButton jviewCustomer;
    // End of variables declaration//GEN-END:variables
}
