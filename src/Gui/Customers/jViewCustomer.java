package Gui.Customers;

import Entities.Customer;
import Gui.Items.jChooseItem;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.CustomerServices;
import java.awt.event.KeyEvent;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        jUpdatedSuccesfully.setText("");
        _jChooseItem =new jChooseItem(jhp, this);
        isEditing = false;
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
        if (!isValidCity()){
            return false;
        }
        if (!isValidIncome()){
            return false;
        }
        if (!isValidJop()){
            return false;
        }
        if (!isValidAge()){
            return false;
        }
        
        return true;
    }

    public void editButton(){   jBack.setEnabled(false);
        jUpdate.setEnabled(true);
        jCancel.setEnabled(true);
        jUpdatedSuccesfully.setVisible(true);
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
        jCityField.setText(_chosencustomer.city);
        jPurchaseDateField.setText( purchaseDate); 
        jEmailField.setText(_chosencustomer.email);
        jIncomeField.setText(Integer.toString(_chosencustomer.income) ); 
        jJobField.setText(_chosencustomer.job);
        jAgeField.setText(Integer.toString(_chosencustomer.age));
    }
    private void settextfielsenabled(){
        jNameField.setEditable(true);
        jNationalIdField.setEditable(true);
        jPhoneNoField.setEditable(true);
        jCityField.setEditable(true);
        jPurchaseDateField.setEditable(false);
        jEmailField.setEditable(true);
        jIncomeField.setEditable(true);       
        jJobField.setEditable(true);    
        jAgeField.setEditable(true);
        jgenderCombobox.setEnabled(false);
                
    }
    private void settextfielsdisabled(){
        jNameField.setEditable(false);
        jNationalIdField.setEditable(false);
        jPhoneNoField.setEditable(false);
        jCityField.setEditable(false);
        jPurchaseDateField.setEditable(false);
        jEmailField.setEditable(false);
        jIncomeField.setEditable(false);       
        jJobField.setEditable(false);           
        jAgeField.setEditable(false);
        jgenderCombobox.setEnabled(false);
                
    }
    public boolean isValidName() {
        // is empty (nameField)
        if(jNameField.getText().trim().isEmpty()) {
           jErrorName.setText("Cant be empty!");
           return false;
        }else jErrorName.setText("");
        //is valid (Name)
        for (int i=0 ; i < jNameField.getText().trim().length();i++){
            char x = jNameField.getText().trim().charAt(i);
            if(!(x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z' || x==' ')){
            jErrorName.setText("you must enter chars only.");
            return false;
            }else jErrorName.setText("");
        }
        return true;
    }
    public boolean isValidEmail() {
        // is empty (Email)
        if(jEmailField.getText().trim().isEmpty()) {
           jErrorEmail.setText("Cant be empty!");
           return false;
        }else jErrorEmail.setText("");
        // is valid (email)
        if (!emailAdressen(jEmailField.getText().trim())){
            jErrorEmail.setText("your email format is false");
            return false;
        }
        return true;
    }
    public boolean isValidNationalId(){ 
        // is empty (National ID)
        if(jNationalIdField.getText().trim().isEmpty()) {
           jErrorNationalId.setText("Cant be empty!");
           return false;
        }else jErrorNationalId.setText("");       
        // is valid (National ID)
        for (int i=0 ; i < jNationalIdField.getText().trim().length();i++){
            char x = jNationalIdField.getText().trim().charAt(i);
            if((x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z' || x==' ')){
            jErrorNationalId.setText("you must enter numbers only.");
            return false;
            }else jErrorNationalId.setText("");
        }
        if(jNationalIdField.getText().trim().length() != 14) {
           jErrorNationalId.setText("it must be 14 number.");
           return false;
        }else jErrorNationalId.setText("");
        return true;
    }
    public boolean isValidPhoneNo(){
        // is empty (Phone NO)
        if(jPhoneNoField.getText().trim().isEmpty()) {
           jErrorPhoneNo.setText("Cant be empty!");
           return false;
        }else jErrorPhoneNo.setText("");    
        // is valid (Phone NO)
        try {
            Integer.parseInt(jPhoneNoField.getText());
        }catch(NumberFormatException e) {
            jErrorPhoneNo.setText("you must enter number, chars not allowed.");
            return false;
        }
        if(!(jPhoneNoField.getText().trim().startsWith("01"))) {
           jErrorPhoneNo.setText("the number must start with 01 .");
           return false;
        }else jErrorPhoneNo.setText("");
        if(jPhoneNoField.getText().trim().length()!= 11) {
           jErrorPhoneNo.setText("it must be 11 number.");
           return false;
        }else jErrorPhoneNo.setText("");
        return true;
    }
    public boolean isValidCity(){
        // is empty (City)
        if(jCityField.getText().trim().isEmpty()) {
           jErrorCity.setText("Cant be empty!");
           return false;
        }else jErrorCity.setText("");
        // is valid (City)
        for (int i=0 ; i < jCityField.getText().trim().length();i++){
            char x = jCityField.getText().trim().charAt(i);
            if(!(x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z' || x==' ')){
            jErrorCity.setText("you must enter chars only.");
            return false;
            }else jErrorCity.setText("");
        }
        return true;
    }  
    public boolean isValidIncome(){
        // is empty (Income)
        if(jIncomeField.getText().trim().isEmpty()) {
           jErrorIncome.setText("Cant be empty!");
           return false;
        }else jErrorIncome.setText("");
        // is valid (Income)
        try {
            Integer.parseInt(jIncomeField.getText());
        }catch(NumberFormatException e) {
            jErrorIncome.setText("you must enter number.");
            return false;
        }
        return true;
    }
    public boolean isValidJop(){
        // is empty (job)
        if(jJobField.getText().trim().isEmpty()) {
           jErrorJob.setText("Cant be empty!");
           return false;
        }else jErrorJob.setText("");
        // is valid (job)
        for (int i=0 ; i < jJobField.getText().trim().length();i++){
            char x = jJobField.getText().trim().charAt(i);
            if(!(x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z' || x==' ')){
            jErrorJob.setText("you must enter chars only.");
            return false;
            }else jErrorJob.setText("");
        }
        return true;
    }
    public boolean isValidAge(){
        // is empty (age)
        if(jAgeField.getText().trim().isEmpty()) {
           jErrorAge.setText("Cant be empty!");
           return false;
        }else jErrorAge.setText("");
        // is valid (age)
        for (int i=0 ; i < jAgeField.getText().trim().length();i++){
            char x = jAgeField.getText().trim().charAt(i);
            if((x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z' || x==' ')){
            jErrorAge.setText("you must enter numbers only.");
            return false;
            }else jErrorAge.setText("");
        }
        try {
            if(Integer.parseInt(jAgeField.getText())<18){
                jErrorAge.setText("Cant be less than 18 years.");
                return false;
            }else jErrorAge.setText("");
        }catch(NumberFormatException e) {
            jErrorAge.setText("you must enter number.");
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
        customer.name = jNameField.getText();
        customer.age = Integer.parseInt(jAgeField.getText());
        customer.job = jJobField.getText();
        customer.nationalId = jNationalIdField.getText();
        customer.income = Integer.parseInt(jIncomeField.getText());
        customer.email = jEmailField.getText();
        customer.city = jCityField.getText();
        customer.gender = jgenderCombobox.getName();
        customer.phoneNumber = jPhoneNoField.getText();
        return customer;
    }
    public void updateButton(){
        jUpdate.setEnabled(false);
        jCancel.setEnabled(false);
        jUpdatedSuccesfully.setText("Updated succesfully");
        settextfielsdisabled();
        jEdit.setEnabled(true);
        jBack.setEnabled(true);
        isEditing = false;
     //if(!checkAllValidations()){
       //  return;
     //}else{
        Customer updatedCustomer = updateCustomerData();
        _CustomerServices.update(_chosencustomer.id , updatedCustomer);
        _jHomePage.createLog("Updated", "Customer", _chosencustomer.name);
        _chosencustomer = _CustomerServices.getById(_chosencustomer.id);
        renderData();
        updateflag=!updateflag;
     //}
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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jNationalIdField = new javax.swing.JTextField();
        jNameField = new javax.swing.JTextField();
        jPhoneNoField = new javax.swing.JTextField();
        jIncomeField = new javax.swing.JTextField();
        jCityField = new javax.swing.JTextField();
        jAgeField = new javax.swing.JTextField();
        jShowpurchases = new javax.swing.JButton();
        jEmailField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPurchaseDateField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jJobField = new javax.swing.JTextField();
        jErrorCity = new javax.swing.JLabel();
        jErrorEmail = new javax.swing.JLabel();
        jErrorNationalId = new javax.swing.JLabel();
        jErrorPhoneNo = new javax.swing.JLabel();
        jErrorIncome = new javax.swing.JLabel();
        jErrorJob = new javax.swing.JLabel();
        jErrorAge = new javax.swing.JLabel();
        jErrorName = new javax.swing.JLabel();
        jgenderCombobox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jUpdate = new javax.swing.JButton();
        jBack = new javax.swing.JButton();
        jCancel = new javax.swing.JButton();
        jEdit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jUpdatedSuccesfully = new javax.swing.JLabel();

        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jLabel1.setText("National ID");

        jLabel2.setText("Phone No");

        jLabel3.setText("Address");

        jLabel4.setText("Income");

        jLabel5.setText("Purchases");

        jLabel8.setText("Gender");

        jLabel9.setText("Name");

        jNationalIdField.setEditable(false);
        jNationalIdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNationalIdFieldKeyPressed(evt);
            }
        });

        jNameField.setEditable(false);
        jNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNameFieldKeyPressed(evt);
            }
        });

        jPhoneNoField.setEditable(false);
        jPhoneNoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPhoneNoFieldKeyPressed(evt);
            }
        });

        jIncomeField.setEditable(false);
        jIncomeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jIncomeFieldKeyPressed(evt);
            }
        });

        jCityField.setEditable(false);
        jCityField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCityFieldKeyPressed(evt);
            }
        });

        jAgeField.setEditable(false);
        jAgeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jAgeFieldKeyPressed(evt);
            }
        });

        jShowpurchases.setText("Show purchases");
        jShowpurchases.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jShowpurchasesMouseClicked(evt);
            }
        });

        jEmailField.setEditable(false);
        jEmailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jEmailFieldKeyPressed(evt);
            }
        });

        jLabel10.setText("Email");

        jPurchaseDateField.setEditable(false);
        jPurchaseDateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPurchaseDateFieldKeyPressed(evt);
            }
        });

        jLabel12.setText("job");

        jJobField.setEditable(false);
        jJobField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jJobFieldKeyPressed(evt);
            }
        });

        jErrorCity.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jErrorCity.setForeground(new java.awt.Color(255, 0, 51));
        jErrorCity.setToolTipText("");

        jErrorEmail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jErrorEmail.setForeground(new java.awt.Color(255, 0, 51));
        jErrorEmail.setToolTipText("");

        jErrorNationalId.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jErrorNationalId.setForeground(new java.awt.Color(255, 0, 51));
        jErrorNationalId.setToolTipText("");

        jErrorPhoneNo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jErrorPhoneNo.setForeground(new java.awt.Color(255, 0, 51));
        jErrorPhoneNo.setToolTipText("");

        jErrorIncome.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jErrorIncome.setForeground(new java.awt.Color(255, 0, 51));
        jErrorIncome.setToolTipText("");

        jErrorJob.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jErrorJob.setForeground(new java.awt.Color(255, 0, 51));
        jErrorJob.setToolTipText("");

        jErrorAge.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jErrorAge.setForeground(new java.awt.Color(255, 0, 51));
        jErrorAge.setToolTipText("");

        jErrorName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jErrorName.setForeground(new java.awt.Color(255, 0, 51));
        jErrorName.setToolTipText("");

        jgenderCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Femal" }));
        jgenderCombobox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jgenderComboboxKeyPressed(evt);
            }
        });

        jLabel6.setText("Age");

        jUpdate.setText("update");
        jUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateMouseClicked(evt);
            }
        });

        jBack.setText("Back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        jCancel.setText("Cancel");
        jCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCancelMouseClicked(evt);
            }
        });

        jEdit.setText("Edit");
        jEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEditMouseClicked(evt);
            }
        });

        jLabel7.setText("purchase date");

        jUpdatedSuccesfully.setForeground(new java.awt.Color(102, 204, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(40, 40, 40)))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jgenderCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jIncomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPurchaseDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jShowpurchases, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(77, 77, 77)
                                    .addComponent(jCityField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel12))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jNationalIdField, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jPhoneNoField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                            .addComponent(jJobField))
                                        .addComponent(jNameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jErrorJob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jErrorName, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(jErrorIncome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jErrorCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jErrorPhoneNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jErrorNationalId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jErrorAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jErrorEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jUpdate)
                        .addGap(96, 96, 96)
                        .addComponent(jCancel)
                        .addGap(52, 52, 52)
                        .addComponent(jEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jUpdatedSuccesfully, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jErrorName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jJobField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jErrorJob, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNationalIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jErrorNationalId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jErrorPhoneNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jPhoneNoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jErrorCity, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jErrorIncome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jIncomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jgenderCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jErrorAge, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jErrorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPurchaseDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jShowpurchases)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jUpdatedSuccesfully, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUpdate)
                    .addComponent(jBack)
                    .addComponent(jCancel)
                    .addComponent(jEdit))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
       if(!isEditing) {
           _jViewCustomers.renderData();
           _jHomePage.switchPanels(_jViewCustomers);
           _jViewCustomers.jSearchName.grabFocus();
       }
    }//GEN-LAST:event_jBackMouseClicked

    private void jEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEditMouseClicked
        if(!isEditing) {
            if(_jMainPage.canUpdateCustomer()) {
                editButton();
            }
        }
    }//GEN-LAST:event_jEditMouseClicked

    private void jUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateMouseClicked
        if(isEditing) {
            updateButton();
        }
    }//GEN-LAST:event_jUpdateMouseClicked

    private void jCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCancelMouseClicked
        if(isEditing) {
            cancelButton();
        }
    }//GEN-LAST:event_jCancelMouseClicked

    private void jShowpurchasesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jShowpurchasesMouseClicked
        _jChooseItem.renderData();
        _jHomePage.switchPanels(_jChooseItem);
    }//GEN-LAST:event_jShowpurchasesMouseClicked

    private void jNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNameFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jNameFieldKeyPressed

    private void jJobFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jJobFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jJobFieldKeyPressed

    private void jNationalIdFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNationalIdFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jNationalIdFieldKeyPressed

    private void jPhoneNoFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPhoneNoFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jPhoneNoFieldKeyPressed

    private void jCityFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCityFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jCityFieldKeyPressed

    private void jIncomeFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jIncomeFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jIncomeFieldKeyPressed

    private void jgenderComboboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jgenderComboboxKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jgenderComboboxKeyPressed

    private void jAgeFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jAgeFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jAgeFieldKeyPressed

    private void jEmailFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jEmailFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jEmailFieldKeyPressed

    private void jPurchaseDateFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPurchaseDateFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jPurchaseDateFieldKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            updateButton();
        }
    }//GEN-LAST:event_jPanel1KeyPressed
   
    
    
    private boolean isEditing;
    private final jMainPage _jMainPage;
    private final jViewCustomers _jViewCustomers;
    public CustomerServices _CustomerServices;
    public Customer _chosencustomer;
    private final jChooseItem _jChooseItem;
    public boolean  updateflag=false ;
    private final jHomePage _jHomePage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAgeField;
    private javax.swing.JButton jBack;
    private javax.swing.JButton jCancel;
    private javax.swing.JTextField jCityField;
    public javax.swing.JButton jEdit;
    private javax.swing.JTextField jEmailField;
    private javax.swing.JLabel jErrorAge;
    private javax.swing.JLabel jErrorCity;
    private javax.swing.JLabel jErrorEmail;
    private javax.swing.JLabel jErrorIncome;
    private javax.swing.JLabel jErrorJob;
    private javax.swing.JLabel jErrorName;
    private javax.swing.JLabel jErrorNationalId;
    private javax.swing.JLabel jErrorPhoneNo;
    private javax.swing.JTextField jIncomeField;
    private javax.swing.JTextField jJobField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JTextField jNameField;
    private javax.swing.JTextField jNationalIdField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jPhoneNoField;
    private javax.swing.JTextField jPurchaseDateField;
    private javax.swing.JButton jShowpurchases;
    private javax.swing.JButton jUpdate;
    private javax.swing.JLabel jUpdatedSuccesfully;
    private javax.swing.JComboBox<String> jgenderCombobox;
    // End of variables declaration//GEN-END:variables
}
