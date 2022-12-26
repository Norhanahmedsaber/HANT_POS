package Gui.Customers;

import Entities.Customer;
import static Gui.Customers.jNewCustomer.emailAdressen;
import Gui.Items.jChooseItem;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.CustomerServices;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class jViewCustomer extends javax.swing.JPanel {
    
    public jViewCustomer(jViewCustomers jvc,jHomePage jhp, jMainPage jmp) {
        initComponents();
        _jViewCustomers = jvc;
        _chosencustomer = null;
        _jHomePage = jhp;
        _CustomerServices = new CustomerServices();
        _jMainPage = jmp;
        jUpdate.setEnabled(false);
        jCancel.setEnabled(false);
        _jChooseItem = new jChooseItem(jhp, this);
        isEditing = false;
        
    }
     
    public void changecolor(java.awt.Color c1,java.awt.Color c2,java.awt.Color c3,java.awt.Color c4,java.awt.Color c5)
    { 
        jPanel1.setBackground(c1); 
        jAgeField.setBackground(c5);
        jBack.setBackground(c2);
        jBack.setForeground(c4);
        jCancel.setBackground(c2);
        jCancel.setForeground(c4);
         jEdit.setBackground(c2);
        jEdit.setForeground(c4);
        jEmailField.setBackground(c5);
        jLabel1.setForeground(c3);
         jLabel10.setForeground(c3);
         jLabel2.setForeground(c3);
         jLabel5.setForeground(c3);
         jLabel6.setForeground(c3);
        jLabel7.setForeground(c3);
        jLabel8.setForeground(c3);
         jLabel9.setForeground(c3);
        jNameField.setBackground(c5);
        jNationalIdField.setBackground(c5);
         jPhoneNoField.setBackground(c5);
        jPurchaseDateField.setBackground(c5);
        jShowpurchases.setBackground(c2);
        jShowpurchases.setForeground(c4);
        jUpdate.setBackground(c2);
        jUpdate.setForeground(c4);
        jgenderCombobox.setBackground(c5);
    }
    public boolean checkAllValidations(){
        if(!isValidName()){
            return false;
        }
        if (!isValidEmail()){
            return false;
        }
        
        if (!isValidNationalId()){
            return false;
        }
        if (!isValidPhoneNo()){
            return false;
        }
        
        return isValidAge();
    }
 
    public void editButton(){   jBack.setEnabled(false);
        jUpdate.setEnabled(true);
        jCancel.setEnabled(true);
        settextfielsenabled();
        jEdit.setEnabled(false);
        isEditing = true;
    }
    public void cancelButton(){
        jUpdate.setEnabled(false);
        jCancel.setEnabled(false);
        settextfielsdisabled();
        jEdit.setEnabled(true);
        jBack.setEnabled(true);
        renderData();
        isEditing = false;
    }
    public void renderData ( ){  
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String purchaseDate = formatter.format(_chosencustomer.purchaseDate);
        jNameField.setText(_chosencustomer.name);
        jNationalIdField.setText(_chosencustomer.nationalId); 
        jPhoneNoField.setText(_chosencustomer.phoneNumber); 
        jPurchaseDateField.setText( purchaseDate); 
        jEmailField.setText(_chosencustomer.email);
        jAgeField.setText(Integer.toString(_chosencustomer.age));
        jgenderCombobox.selectWithKeyChar(_chosencustomer.gender.charAt(0));
    }
    private void settextfielsenabled(){
        jNameField.setEditable(true);
        jNationalIdField.setEditable(true);
        jPhoneNoField.setEditable(true);
        jPurchaseDateField.setEditable(false);
        jEmailField.setEditable(true);   
        jAgeField.setEditable(true);
        jgenderCombobox.setEnabled(true);
                
    }
    private void settextfielsdisabled(){
        jNameField.setEditable(false);
        jNationalIdField.setEditable(false);
        jPhoneNoField.setEditable(false);
        jPurchaseDateField.setEditable(false);
        jEmailField.setEditable(false);           
        jAgeField.setEditable(false);
        jgenderCombobox.setEnabled(false);
                
    }
    public boolean isValidName() {
        // is empty (nameField)
        if(jNameField.getText().trim().isEmpty()) {
           JOptionPane.showMessageDialog(null, "Name Can't be Empty");
           return false;
        }
        //is valid (Name)
        for (int i=0 ; i < jNameField.getText().trim().length();i++){
            char x = jNameField.getText().trim().charAt(i);
            if(!(x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z' || x==' ')){
                JOptionPane.showMessageDialog(null, "Name Can Only Have Letters!");
                return false;
            }
        }
        return true;
    }
    public boolean isValidEmail() {
        // is empty (Email)
        if(jEmailField.getText().trim().isEmpty()) {
           JOptionPane.showMessageDialog(null, "Email Can't be Empty");
           return false;
        }
        // is valid (email)
        if (!emailAdressen(jEmailField.getText().trim())){
            JOptionPane.showMessageDialog(null, "Please Type an Email with the right format!");
            return false;
        }
        return true;
    }
    public boolean isValidNationalId(){ 
        // is empty (National ID)
        if(jNationalIdField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "National ID Can't be Empty");
            return false;
        }      
        // is valid (National ID)
        for (int i=0 ; i < jNationalIdField.getText().trim().length();i++){
            char x = jNationalIdField.getText().trim().charAt(i);
            if((x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z' || x==' ')){
                JOptionPane.showMessageDialog(null, "National ID Can't Have Chars in it!");
                return false;
            }
        }
        if(jNationalIdField.getText().trim().length() != 14) {
            JOptionPane.showMessageDialog(null, "National ID should be 14 Digits!");
            return false;
        }
        return true;
    }
    public boolean isValidPhoneNo(){
        // is empty (Phone NO)
        if(jPhoneNoField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Phone Number Can't be Empty!");
           return false;
        }
        // is valid (Phone NO)
        try {
            Integer.valueOf(jPhoneNoField.getText());
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Phone Number Can't Have Chars in it!");
            return false;
        }
        if(!(jPhoneNoField.getText().trim().startsWith("01"))) {
            JOptionPane.showMessageDialog(null, "Phone Number Must start with 01");
            return false;
        }
        if(jPhoneNoField.getText().trim().length()!= 11) {
            JOptionPane.showMessageDialog(null, "Phone Number Must be 11 Digits!");
           return false;
        }
        return true;
    }
    
    
    public boolean isValidAge(){
        // is empty (age)
        if(jAgeField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Age Can't be Empty!");
            return false;
        }
        // is valid (age)
        for (int i=0 ; i < jAgeField.getText().trim().length();i++){
            char x = jAgeField.getText().trim().charAt(i);
            if((x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z' || x==' ')){
            JOptionPane.showMessageDialog(null, "Age Can't Have Chars in it!");
            return false;
            }
        }
        try {
            Integer.parseInt(jAgeField.getText());
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Age Can't Have Chars in it!");
            return false;
        }
        return true;
    }
    public static boolean emailAdressen(String emailAdressen) {
        Pattern pattern = Pattern.compile("^[A-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[A-Z0-9_!#$%&'*+/=?`{|}~^-]+↵\n" +")*@[A-Z0-9-]+(?:\\.[A-Z0-9-]+)*$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(emailAdressen);
        return matcher.find();
    }
    public Customer updateCustomerData(){
        Customer customer = _chosencustomer;
        customer.name = jNameField.getText().trim();
        customer.age = Integer.parseInt(jAgeField.getText().trim());
        customer.nationalId = jNationalIdField.getText().trim();
        customer.email = jEmailField.getText().trim();
        customer.gender = (String)jgenderCombobox.getSelectedItem();
        customer.phoneNumber = jPhoneNoField.getText().trim();
        return customer;
    }
    public void updateButton(){
        if(!checkAllValidations()){
            return;
        }else{
            jUpdate.setEnabled(false);
            jCancel.setEnabled(false);
            settextfielsdisabled();
            jEdit.setEnabled(true);
            jBack.setEnabled(true);
            isEditing = false;
            Customer updatedCustomer = updateCustomerData();
            _CustomerServices.update(_chosencustomer.id , updatedCustomer);
            _jHomePage.createLog("Updated", "Customer", _chosencustomer.name);
            _chosencustomer = _CustomerServices.getById(_chosencustomer.id);
            renderData();
            updateflag=!updateflag;
            JOptionPane.showMessageDialog(null, "Updated Successfully!");
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jNationalIdField = new javax.swing.JTextField();
        jNameField = new javax.swing.JTextField();
        jPhoneNoField = new javax.swing.JTextField();
        jAgeField = new javax.swing.JTextField();
        jShowpurchases = new javax.swing.JButton();
        jEmailField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPurchaseDateField = new javax.swing.JTextField();
        jgenderCombobox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jUpdate = new javax.swing.JButton();
        jBack = new javax.swing.JButton();
        jCancel = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jEdit = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(750, 580));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(87, 118, 130));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 580));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("National ID:");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Phone No:");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Purchases:");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Gender:");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Name:");

        jNationalIdField.setEditable(false);
        jNationalIdField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jNationalIdField.setForeground(new java.awt.Color(0, 31, 78));
        jNationalIdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNationalIdFieldKeyPressed(evt);
            }
        });

        jNameField.setEditable(false);
        jNameField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jNameField.setForeground(new java.awt.Color(0, 31, 78));
        jNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNameFieldKeyPressed(evt);
            }
        });

        jPhoneNoField.setEditable(false);
        jPhoneNoField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPhoneNoField.setForeground(new java.awt.Color(0, 31, 78));
        jPhoneNoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPhoneNoFieldKeyPressed(evt);
            }
        });

        jAgeField.setEditable(false);
        jAgeField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jAgeField.setForeground(new java.awt.Color(0, 31, 78));
        jAgeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jAgeFieldKeyPressed(evt);
            }
        });

        jShowpurchases.setBackground(new java.awt.Color(217, 156, 69));
        jShowpurchases.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jShowpurchases.setForeground(new java.awt.Color(255, 255, 255));
        jShowpurchases.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Customers/showPurchases.png"))); // NOI18N
        jShowpurchases.setMnemonic('s');
        jShowpurchases.setText(" Show purchases");
        jShowpurchases.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jShowpurchasesMouseClicked(evt);
            }
        });
        jShowpurchases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowpurchasesActionPerformed(evt);
            }
        });

        jEmailField.setEditable(false);
        jEmailField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jEmailField.setForeground(new java.awt.Color(0, 31, 78));
        jEmailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jEmailFieldKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Email:");

        jPurchaseDateField.setEditable(false);
        jPurchaseDateField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPurchaseDateField.setForeground(new java.awt.Color(0, 31, 78));
        jPurchaseDateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPurchaseDateFieldKeyPressed(evt);
            }
        });

        jgenderCombobox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jgenderCombobox.setForeground(new java.awt.Color(0, 31, 78));
        jgenderCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jgenderCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jgenderComboboxActionPerformed(evt);
            }
        });
        jgenderCombobox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jgenderComboboxKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Age:");

        jUpdate.setBackground(new java.awt.Color(217, 156, 69));
        jUpdate.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Customers/update.png"))); // NOI18N
        jUpdate.setMnemonic('u');
        jUpdate.setText("   Update");
        jUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateMouseClicked(evt);
            }
        });
        jUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUpdateActionPerformed(evt);
            }
        });

        jBack.setBackground(new java.awt.Color(217, 156, 69));
        jBack.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jBack.setForeground(new java.awt.Color(255, 255, 255));
        jBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Customers/back.png"))); // NOI18N
        jBack.setMnemonic('b');
        jBack.setText("     Back  ");
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

        jCancel.setBackground(new java.awt.Color(217, 156, 69));
        jCancel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jCancel.setForeground(new java.awt.Color(255, 255, 255));
        jCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Customers/cancel1.png"))); // NOI18N
        jCancel.setMnemonic('c');
        jCancel.setText("   Cancel ");
        jCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCancelMouseClicked(evt);
            }
        });
        jCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("purchase date:");

        jEdit.setBackground(new java.awt.Color(217, 156, 69));
        jEdit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jEdit.setForeground(new java.awt.Color(255, 255, 255));
        jEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Customers/editCustomer.png"))); // NOI18N
        jEdit.setMnemonic('e');
        jEdit.setText("     Edit   ");
        jEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEditMouseClicked(evt);
            }
        });
        jEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(377, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jShowpurchases, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(22, 22, 22)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jPhoneNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jNationalIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGap(25, 25, 25)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jgenderCombobox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jAgeField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPurchaseDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNationalIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPhoneNoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jgenderCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jPurchaseDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jShowpurchases))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEditMouseClicked
        if(!isEditing) {
            if(_jMainPage.canUpdateCustomer()) {
                editButton();
            }
        }
    }//GEN-LAST:event_jEditMouseClicked

    private void jCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCancelMouseClicked
        if(isEditing) {
            cancelButton();
        }
    }//GEN-LAST:event_jCancelMouseClicked

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        if(!isEditing) {
            _jViewCustomers.renderData();
            _jHomePage.switchPanels(_jViewCustomers);
            _jViewCustomers.jSearchName.grabFocus();
        }
    }//GEN-LAST:event_jBackMouseClicked

    private void jUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateMouseClicked
        if(isEditing) {
            updateButton();
        }
    }//GEN-LAST:event_jUpdateMouseClicked

    private void jgenderComboboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jgenderComboboxKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jgenderComboboxKeyPressed

    private void jgenderComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jgenderComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jgenderComboboxActionPerformed

    private void jPurchaseDateFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPurchaseDateFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jPurchaseDateFieldKeyPressed

    private void jEmailFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jEmailFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jEmailFieldKeyPressed

    private void jShowpurchasesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jShowpurchasesMouseClicked
        _jChooseItem.renderData();
        _jHomePage.switchPanels(_jChooseItem);
    }//GEN-LAST:event_jShowpurchasesMouseClicked

    private void jAgeFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jAgeFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jAgeFieldKeyPressed

    private void jPhoneNoFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPhoneNoFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jPhoneNoFieldKeyPressed

    private void jNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNameFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jNameFieldKeyPressed

    private void jNationalIdFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNationalIdFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jNationalIdFieldKeyPressed

    private void jShowpurchasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jShowpurchasesActionPerformed
        _jChooseItem.renderData();
        _jHomePage.switchPanels(_jChooseItem);
    }//GEN-LAST:event_jShowpurchasesActionPerformed

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        if(!isEditing) {
            _jViewCustomers.renderData();
            _jHomePage.switchPanels(_jViewCustomers);
            _jViewCustomers.jSearchName.grabFocus();
        }
    }//GEN-LAST:event_jBackActionPerformed

    private void jCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelActionPerformed
        if(isEditing) {
            cancelButton();
        }
    }//GEN-LAST:event_jCancelActionPerformed

    private void jUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUpdateActionPerformed
        if(isEditing) {
            updateButton();
        }
    }//GEN-LAST:event_jUpdateActionPerformed

    private void jEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditActionPerformed
        if(!isEditing) {
            if(_jMainPage.canUpdateCustomer()) {
                editButton();
            }
        }
    }//GEN-LAST:event_jEditActionPerformed
       
    
    
    private boolean isEditing;
    private final jMainPage _jMainPage;
    public final jViewCustomers _jViewCustomers;
    public CustomerServices _CustomerServices;
    public Customer _chosencustomer;
    public final jChooseItem _jChooseItem;
    public boolean  updateflag=false ;
    private final jHomePage _jHomePage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAgeField;
    private javax.swing.JButton jBack;
    private javax.swing.JButton jCancel;
    public javax.swing.JButton jEdit;
    private javax.swing.JTextField jEmailField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JTextField jNameField;
    private javax.swing.JTextField jNationalIdField;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jPhoneNoField;
    private javax.swing.JTextField jPurchaseDateField;
    private javax.swing.JButton jShowpurchases;
    private javax.swing.JButton jUpdate;
    public javax.swing.JComboBox<String> jgenderCombobox;
    // End of variables declaration//GEN-END:variables
}
