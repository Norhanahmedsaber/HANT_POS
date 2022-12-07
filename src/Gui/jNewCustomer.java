package Gui;

import Entities.Customer;
import Services.CustomerServices;
import java.util.Date;

public class jNewCustomer extends javax.swing.JPanel {

    public jNewCustomer(jHomePage jhp, jMainPage jmp) {
        initComponents();
        _jChooseItem = new jChooseItem(this,jhp);
        _jHomePage = jhp;
        _jMainPage = jmp;
        _CustomerServices = new CustomerServices();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jNationalIdField = new javax.swing.JTextField();
        jNameField = new javax.swing.JTextField();
        jPhoneNoField = new javax.swing.JTextField();
        jIncomeField = new javax.swing.JTextField();
        jJobField = new javax.swing.JTextField();
        jAddressField = new javax.swing.JTextField();
        jAgeField = new javax.swing.JTextField();
        jAddCustomer = new javax.swing.JButton();
        jChooseItem = new javax.swing.JButton();
        jBack = new javax.swing.JButton();
        jErrorMessege = new javax.swing.JLabel();
        jGenderComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jEmailField = new javax.swing.JTextField();
        jHome = new javax.swing.JButton();
        jAddedCustomer = new javax.swing.JLabel();

        jLabel1.setText("National ID");

        jLabel2.setText("Phone No");

        jLabel3.setText("Address");

        jLabel4.setText("Income");

        jLabel5.setText("purchases");

        jLabel6.setText("Age");

        jLabel7.setText("Job");

        jLabel8.setText("gender");

        jLabel9.setText("Name");

        jAddCustomer.setText("Add Customer");
        jAddCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddCustomerMouseClicked(evt);
            }
        });

        jChooseItem.setText("Choose Item");
        jChooseItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jChooseItemMouseClicked(evt);
            }
        });

        jBack.setText("Back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        jErrorMessege.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jErrorMessege.setForeground(new java.awt.Color(255, 0, 51));
        jErrorMessege.setToolTipText("");

        jGenderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", " " }));

        jLabel10.setText("Email");

        jHome.setText("Home");
        jHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jHomeMouseClicked(evt);
            }
        });

        jAddedCustomer.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jAddedCustomer.setForeground(new java.awt.Color(0, 255, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jAddedCustomer)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jChooseItem, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10))
                                .addGap(81, 81, 81)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jAddressField)
                                    .addComponent(jNationalIdField)
                                    .addComponent(jPhoneNoField)
                                    .addComponent(jJobField)
                                    .addComponent(jIncomeField)
                                    .addComponent(jAgeField)
                                    .addComponent(jGenderComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(jErrorMessege, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jAddCustomer)
                        .addGap(18, 18, 18)
                        .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jHome, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jErrorMessege))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jNationalIdField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPhoneNoField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jAddressField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jIncomeField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jJobField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGenderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jChooseItem, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(35, 35, 35)
                .addComponent(jAddedCustomer)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBack)
                    .addComponent(jAddCustomer)
                    .addComponent(jHome))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        _jHomePage.switchPanels(_jMainPage);
    }//GEN-LAST:event_jBackMouseClicked

    private void jAddCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddCustomerMouseClicked
        
        // is empty (nameField)
        //if(jNameField.getText().isEmpty()) {
        //   jErrorMessege.setText("Name Field Is Empty!");
        //   return;
        //}else jErrorMessege.setText("");
        // is valid (Name)
        
        // is empty (National ID)
        // is valid (National ID)
        
        // is empty (Phone NO)
        // is valid (Phone NO)
        
        // is empty (Address)
        // is valid (Address)
        
        // is empty (Income)
        // is valid (Income)
        
        // is empty (job)
        // is valid (job)
        
        // is empty (age)
        // is valid (age)
        
        // is empty (purchase)
        
        // messege added successfully 
        jAddedCustomer.setText("Added Successfully!");
        // clear all fields
        
        Customer _Customer =new Customer();
        _Customer.name = jNameField.getText();
        _Customer.age = Integer.parseInt(jAgeField.getText());
        _Customer.job = jJobField.getText();
        _Customer.nationalId = jNationalIdField.getText();
        _Customer.income = Integer.parseInt(jIncomeField.getText());
        _Customer.email = jEmailField.getText();
        _Customer.address = jAddressField.getText();
        _Customer.gender = (String)jGenderComboBox.getSelectedItem();
        _Customer.phoneNumber = jPhoneNoField.getText();
        _Customer.purchaseDate=new Date();
        _CustomerServices.create(_Customer);
        
    }//GEN-LAST:event_jAddCustomerMouseClicked

    private void jChooseItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChooseItemMouseClicked
        _jHomePage.switchPanels(_jChooseItem);
    }//GEN-LAST:event_jChooseItemMouseClicked

    private void jHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeMouseClicked
        _jHomePage.switchPanels(_jMainPage);
    }//GEN-LAST:event_jHomeMouseClicked
    
    private final CustomerServices _CustomerServices;
    private final jChooseItem _jChooseItem;
    private final jMainPage _jMainPage;
    private final jHomePage _jHomePage;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddCustomer;
    private javax.swing.JLabel jAddedCustomer;
    private javax.swing.JTextField jAddressField;
    private javax.swing.JTextField jAgeField;
    private javax.swing.JButton jBack;
    private javax.swing.JButton jChooseItem;
    private javax.swing.JTextField jEmailField;
    private javax.swing.JLabel jErrorMessege;
    private javax.swing.JComboBox<String> jGenderComboBox;
    private javax.swing.JButton jHome;
    private javax.swing.JTextField jIncomeField;
    private javax.swing.JTextField jJobField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jNameField;
    private javax.swing.JTextField jNationalIdField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jPhoneNoField;
    // End of variables declaration//GEN-END:variables
}
