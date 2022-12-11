package Gui;

import Entities.Customer;
import Entities.Item;
import Services.CustomerServices;
import Services.ItemServices;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;  

public class jNewCustomer extends javax.swing.JPanel {

    public jNewCustomer(jHomePage jhp, jMainPage jmp) {
        initComponents();
        _jChooseItem = new jChooseItem(jhp,this);
        _jHomePage = jhp;
        _jMainPage = jmp;
        _CustomerServices = new CustomerServices();
         _chosenitems=new ArrayList<Item>();
         _jItemServices=new ItemServices();
    }
    public ArrayList<Item> getselecteditems()
    { 
        return _chosenitems ;
    }
    public void setselecteditems(ArrayList<Item> selecteditems)
    {
        _chosenitems=selecteditems;
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
    public boolean isValidChooseItem(){
       
        return !_chosenitems.isEmpty();
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
        if (!isValidChooseItem()){
            return false;
        }
        return true;
    }
    
    public static boolean emailAdressen(String emailAdressen) {
        Pattern pattern = Pattern.compile("^[A-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[A-Z0-9_!#$%&'*+/=?`{|}~^-]+↵\n" +")*@[A-Z0-9-]+(?:\\.[A-Z0-9-]+)*$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(emailAdressen);
        return matcher.find();
    }
    public void saveCustomerData(){
        Customer _Customer =new Customer();
        _Customer.id = UUID.randomUUID();
        _Customer.name = jNameField.getText().trim();
        _Customer.age = Integer.parseInt(jAgeField.getText().trim());
        _Customer.job = jJobField.getText().trim();
        _Customer.nationalId = jNationalIdField.getText().trim();
        _Customer.income = Integer.parseInt(jIncomeField.getText().trim());
        _Customer.email = jEmailField.getText().trim();
        _Customer.city = jCityField.getText().trim();
        _Customer.gender = (String)jGenderComboBox.getSelectedItem();
        _Customer.phoneNumber = jPhoneNoField.getText().trim();
        _Customer.purchaseDate=new Date();
        ArrayList<UUID> itemsid =new ArrayList<UUID>();
        for(int i=0; i<getselecteditems().size();i++)
        {
          itemsid.add( _chosenitems.get(i).id);
        }
         _CustomerServices.create(_Customer);
        _jItemServices.addItemsToCustomer(_Customer.id, itemsid);
        
    }
    public void clearNewCustomerPage() {
        jNameField.setText("");
        jAgeField.setText("");
        jEmailField.setText("");
        jIncomeField.setText("");
        jPhoneNoField.setText("");
        jNationalIdField.setText("");
        jCityField.setText("");
        jJobField.setText("");
    } 
    public void addCustomerButton(){
       /* if(!checkAllValidations()){
           return;
        }else*/
        saveCustomerData();
        
        // messege added successfully 
        jAddedCustomer.setText("Added Successfully!");
        
        // clear all fields
        clearNewCustomerPage();
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
        jCityField = new javax.swing.JTextField();
        jAgeField = new javax.swing.JTextField();
        jAddCustomer = new javax.swing.JButton();
        jChooseItem = new javax.swing.JButton();
        jBack = new javax.swing.JButton();
        jErrorName = new javax.swing.JLabel();
        jGenderComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jEmailField = new javax.swing.JTextField();
        jHome = new javax.swing.JButton();
        jAddedCustomer = new javax.swing.JLabel();
        jErrorCity = new javax.swing.JLabel();
        jErrorEmail = new javax.swing.JLabel();
        jErrorNationalId = new javax.swing.JLabel();
        jErrorPhoneNo = new javax.swing.JLabel();
        jErrorChooseItem = new javax.swing.JLabel();
        jErrorIncome = new javax.swing.JLabel();
        jErrorJob = new javax.swing.JLabel();
        jErrorAge = new javax.swing.JLabel();

        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jLabel1.setText("National ID");

        jLabel2.setText("Phone No");

        jLabel3.setText("City");

        jLabel4.setText("Income");

        jLabel5.setText("purchases");

        jLabel6.setText("Age");

        jLabel7.setText("Job");

        jLabel8.setText("gender");

        jLabel9.setText("Name");

        jNationalIdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNationalIdFieldKeyPressed(evt);
            }
        });

        jNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNameFieldKeyPressed(evt);
            }
        });

        jPhoneNoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPhoneNoFieldKeyPressed(evt);
            }
        });

        jIncomeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jIncomeFieldKeyPressed(evt);
            }
        });

        jJobField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jJobFieldKeyPressed(evt);
            }
        });

        jCityField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCityFieldKeyPressed(evt);
            }
        });

        jAgeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jAgeFieldKeyPressed(evt);
            }
        });

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

        jErrorName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jErrorName.setForeground(new java.awt.Color(255, 0, 51));
        jErrorName.setToolTipText("");

        jGenderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", " " }));

        jLabel10.setText("Email");

        jEmailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jEmailFieldKeyPressed(evt);
            }
        });

        jHome.setText("Home");
        jHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jHomeMouseClicked(evt);
            }
        });

        jAddedCustomer.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jAddedCustomer.setForeground(new java.awt.Color(0, 255, 0));

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

        jErrorChooseItem.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jErrorChooseItem.setForeground(new java.awt.Color(255, 0, 51));
        jErrorChooseItem.setToolTipText("");

        jErrorIncome.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jErrorIncome.setForeground(new java.awt.Color(255, 0, 51));
        jErrorIncome.setToolTipText("");

        jErrorJob.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jErrorJob.setForeground(new java.awt.Color(255, 0, 51));
        jErrorJob.setToolTipText("");

        jErrorAge.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jErrorAge.setForeground(new java.awt.Color(255, 0, 51));
        jErrorAge.setToolTipText("");

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
                                    .addComponent(jCityField)
                                    .addComponent(jNationalIdField)
                                    .addComponent(jPhoneNoField)
                                    .addComponent(jJobField)
                                    .addComponent(jIncomeField)
                                    .addComponent(jAgeField)
                                    .addComponent(jGenderComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jErrorName, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jErrorCity, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jErrorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jErrorNationalId, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jErrorPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jErrorChooseItem, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jErrorIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jErrorJob, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jErrorAge, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jAddCustomer)
                        .addGap(18, 18, 18)
                        .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jHome, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jErrorName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(jErrorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jNationalIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jErrorNationalId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jPhoneNoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jErrorPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jErrorCity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jIncomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jErrorIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jJobField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jErrorJob, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jErrorAge, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGenderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jChooseItem)
                        .addComponent(jErrorChooseItem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        addCustomerButton();
        
    }//GEN-LAST:event_jAddCustomerMouseClicked

    private void jChooseItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChooseItemMouseClicked
        _jChooseItem.resetPanel();
        _jChooseItem.renderData();
        _jHomePage.switchPanels(_jChooseItem);
        _jChooseItem.jSearch.grabFocus();
    }//GEN-LAST:event_jChooseItemMouseClicked

    private void jHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeMouseClicked
        _jHomePage.switchPanels(_jMainPage);
    }//GEN-LAST:event_jHomeMouseClicked

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addCustomerButton();
        }
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNameFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addCustomerButton();
        }
    }//GEN-LAST:event_jNameFieldKeyPressed

    private void jEmailFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jEmailFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addCustomerButton();
        }
    }//GEN-LAST:event_jEmailFieldKeyPressed

    private void jNationalIdFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNationalIdFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addCustomerButton();
        }
    }//GEN-LAST:event_jNationalIdFieldKeyPressed

    private void jPhoneNoFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPhoneNoFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addCustomerButton();
        }
    }//GEN-LAST:event_jPhoneNoFieldKeyPressed

    private void jCityFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCityFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addCustomerButton();
        }
    }//GEN-LAST:event_jCityFieldKeyPressed

    private void jIncomeFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jIncomeFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addCustomerButton();
        }
    }//GEN-LAST:event_jIncomeFieldKeyPressed

    private void jJobFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jJobFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addCustomerButton();
        }
    }//GEN-LAST:event_jJobFieldKeyPressed

    private void jAgeFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jAgeFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addCustomerButton();
        }
    }//GEN-LAST:event_jAgeFieldKeyPressed
    
    private final CustomerServices _CustomerServices;
    private final jChooseItem _jChooseItem;
    private final jMainPage _jMainPage;
    private final jHomePage _jHomePage;
    public ArrayList<Item> _chosenitems;
    private ItemServices _jItemServices;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddCustomer;
    private javax.swing.JLabel jAddedCustomer;
    private javax.swing.JTextField jAgeField;
    private javax.swing.JButton jBack;
    private javax.swing.JButton jChooseItem;
    private javax.swing.JTextField jCityField;
    private javax.swing.JTextField jEmailField;
    private javax.swing.JLabel jErrorAge;
    private javax.swing.JLabel jErrorChooseItem;
    private javax.swing.JLabel jErrorCity;
    private javax.swing.JLabel jErrorEmail;
    private javax.swing.JLabel jErrorIncome;
    private javax.swing.JLabel jErrorJob;
    private javax.swing.JLabel jErrorName;
    private javax.swing.JLabel jErrorNationalId;
    private javax.swing.JLabel jErrorPhoneNo;
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
    public javax.swing.JTextField jNameField;
    private javax.swing.JTextField jNationalIdField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jPhoneNoField;
    // End of variables declaration//GEN-END:variables
}
