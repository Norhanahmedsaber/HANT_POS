package Gui;

import Entities.Customer;
import Services.CustomerServices;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utils.filterCustomers;

public final class jViewCustomers extends javax.swing.JPanel {

    public jViewCustomers(jHomePage jhp, jMainPage jmp) { 
        initComponents(); 
        _jHomePage = jhp; 
        _jMainPage = jmp; 
        _CustomerServices = new CustomerServices(); 
        _filterCustomers = new filterCustomers(); 
    }
public void renderData() { 
        String[] cols = {"Name", "Email", "PurchaseDate", "PhoneNumber"}; 
        DefaultTableModel model = new DefaultTableModel(cols, 0); 
        jItemsTable.setModel(model); 
        ArrayList<Customer> customers = _CustomerServices.getAll(); 
        if(!customers.isEmpty()) { 
            String searchName = jSearchName.getText(); 
            String sortBy = (String) jSortBy.getSelectedItem(); 
            ArrayList<Customer> filteredCustomers = _filterCustomers.filter(customers, searchName,sortBy); 
            if(!filteredCustomers.isEmpty()){ 
                for(int i=0;i<filteredCustomers.size();i++) { 
                    Customer customer = filteredCustomers.get(i); 
                    Object[] objs = {customer.name, customer.email, customer.purchaseDate, customer.phoneNumber}; 
                    model.addRow(objs); 
                } 
            } 
        } 
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jItemsTable = new javax.swing.JTable();

        jLabel2.setText("search by name :");

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

        jItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Purchase Date", "Phone", "Email"
            }
        ));
        jItemsTable.setToolTipText("");
        jItemsTable.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jItemsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSearchName)
                            .addComponent(jSortBy, 0, 256, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBack)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        _jHomePage.switchPanels(_jMainPage);
    }//GEN-LAST:event_jBackMouseClicked

    private void jSortByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSortByActionPerformed
        renderData();
    }//GEN-LAST:event_jSortByActionPerformed
    
    private final filterCustomers _filterCustomers; 
    private final CustomerServices _CustomerServices; 
    private final jMainPage _jMainPage; 
    private final jHomePage _jHomePage;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBack;
    private javax.swing.JTable jItemsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jSearchName;
    private javax.swing.JComboBox<String> jSortBy;
    // End of variables declaration//GEN-END:variables
}
