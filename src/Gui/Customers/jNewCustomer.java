package Gui.Customers;
 
import Gui.Items.jChooseItem;
import Entities.Customer;
import Entities.Item;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.CustomerServices;
import Services.ItemServices;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;  
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class jNewCustomer extends javax.swing.JPanel {

    public jNewCustomer(jHomePage jhp, JPanel parent) {
        initComponents();
        _jChooseItem = new jChooseItem(jhp,this);
        _jHomePage = jhp;
        _CustomerServices = new CustomerServices();
        _chosenitems=new ArrayList<>();
        _jItemServices=new ItemServices();
        _parent = parent;
    }
    
     
    public void changecolor(java.awt.Color c1,java.awt.Color c2,java.awt.Color c3,java.awt.Color c4,java.awt.Color c5)
    { 
        jPanel1.setBackground(c1);
        jAddCustomer.setBackground(c2);
        jAddCustomer.setForeground(c4);
         jAgeField.setBackground(c5);
        jBack.setBackground(c2);
        jBack.setForeground(c4);
        jChooseItem.setBackground(c2);
        jChooseItem.setForeground(c4);
         jEmailField.setBackground(c5);
        jGenderComboBox.setBackground(c5);
         jLabel1.setForeground(c3);
         jLabel10.setForeground(c3);
         jLabel2.setForeground(c3);
         jLabel5.setForeground(c3);
         jLabel6.setForeground(c3);
         jLabel8.setForeground(c3);
         jLabel9.setForeground(c3);
         jNameField.setBackground(c5);
       jNationalIdField.setBackground(c5);
        jPhoneNoField.setBackground(c5);
    }
        
    public ArrayList<Item> getselecteditems(){ 
        return _chosenitems ;
    }
    public void setselecteditems(ArrayList<Item> selecteditems){
        _chosenitems=selecteditems;
    }
    public boolean validateCustomer(Customer customer){
        // is empty (nameField)
        if(customer.name.isEmpty()) {
           return false;
        }
        //is valid (Name)
        for (int i=1 ; i < customer.name.length();i++){
            char x = customer.name.charAt(i);
            if(!(x >= 'a' && x <= 'z')){
                return false;
            }
        }
        // is empty (Email)
        if(customer.email.isEmpty()) {
           return false;
        }
        // is valid (email)
        if (!emailAdressen(customer.email)){
            return false;
        }
        if (!validateNationalId(customer.nationalId)){
            return false;
        }
        if (!validatePhoneNo(customer.phoneNumber)){
            return false;
        }

        return true;
    }
    public boolean validateNationalId(String nationalId){ 
        // is empty (National ID)
        if(nationalId.isEmpty()) {
            return false;
        }      
        // is valid (National ID)
        for (int i=0 ; i < nationalId.length();i++){
            char x = nationalId.charAt(i);
            if(((x > '9' || x < '0') || x == ' ')){
                return false;
            }
        }
        if(nationalId.length() != 14 ) {
            return false;
        }
        return true;
    }
    public boolean validatePhoneNo(String phone){
        // is empty (Phone NO)
        if(phone.isEmpty()) {
           return false;
        }
        // is valid (Phone NO)
        try {
            Integer.valueOf(phone);
        }catch(NumberFormatException e) {
            return false;
        }
        if(!(phone.startsWith("01")) && !(phone.startsWith("02"))) {
            return false;
        }
        if(phone.length() != 11 && phone.length() != 9) {
           return false;
        }
        return true;
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
    public boolean isValidChooseItem(){
        if(_chosenitems.isEmpty()){
            JOptionPane.showMessageDialog(null, "You Must Choose atleast one item!");
            return false;
        }
        return true;
    }
    public boolean checkAllValidations(){
        if(!isValidName()){
            return false;
        }
        if(!isValidEmail()){
            return false;
        }
        if (!isValidNationalId()){
            return false;
        }
        if (!isValidPhoneNo()){
            return false;
        }
        
        if (!isValidAge()){
            return false;
        }
        return isValidChooseItem();
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
        _Customer.nationalId = jNationalIdField.getText().trim();
        _Customer.email = jEmailField.getText().trim();
        _Customer.gender = (String)jGenderComboBox.getSelectedItem();
        _Customer.phoneNumber = jPhoneNoField.getText().trim();
        _Customer.purchaseDate=new Date();
        ArrayList<UUID> itemsid =new ArrayList<>();
        for(int i=0; i<getselecteditems().size();i++)
        {
            itemsid.add( _chosenitems.get(i).id);
        }
        _CustomerServices.create(_Customer, itemsid);
        _jHomePage.createLog("Created", "Customer",_Customer.name );
        JOptionPane.showMessageDialog(null, "Created Successfully");
        
    }
    public void clearNewCustomerPage() {
        jNameField.setText("");
        jAgeField.setText("");
        jEmailField.setText("");
        jPhoneNoField.setText("");
        jNationalIdField.setText("");
        
    } 
    public void addCustomerButton(){
        if(!checkAllValidations()){
           return;
        }else
        saveCustomerData(); 
        // messege added successfully  
        // clear all fields
        clearNewCustomerPage();
    }
    public void BackButton(){
        if(_parent instanceof jViewCustomers)
        {
          jViewCustomers viewCustomers= (jViewCustomers) _parent;
          viewCustomers.renderData();
               
        }
        else 
        {
            jMainPage MainPage=(jMainPage)_parent;
            MainPage.jNewcustomer.grabFocus();
        }
        _jHomePage.switchPanels(_parent);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jNationalIdField = new javax.swing.JTextField();
        jNameField = new javax.swing.JTextField();
        jPhoneNoField = new javax.swing.JTextField();
        jAgeField = new javax.swing.JTextField();
        jAddCustomer = new javax.swing.JButton();
        jChooseItem = new javax.swing.JButton();
        jBack = new javax.swing.JButton();
        jGenderComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jEmailField = new javax.swing.JTextField();

        setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(87, 118, 130));
        jPanel1.setForeground(new java.awt.Color(217, 156, 69));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 550));
        jPanel1.setRequestFocusEnabled(false);
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

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Age:");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Gender:");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Name:");

        jNationalIdField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jNationalIdField.setForeground(new java.awt.Color(0, 31, 78));
        jNationalIdField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNationalIdFieldMouseClicked(evt);
            }
        });
        jNationalIdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNationalIdFieldKeyPressed(evt);
            }
        });

        jNameField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jNameField.setForeground(new java.awt.Color(0, 31, 78));
        jNameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNameFieldMouseClicked(evt);
            }
        });
        jNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNameFieldActionPerformed(evt);
            }
        });
        jNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNameFieldKeyPressed(evt);
            }
        });

        jPhoneNoField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPhoneNoField.setForeground(new java.awt.Color(0, 31, 78));
        jPhoneNoField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPhoneNoFieldMouseClicked(evt);
            }
        });
        jPhoneNoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPhoneNoFieldKeyPressed(evt);
            }
        });

        jAgeField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jAgeField.setForeground(new java.awt.Color(0, 31, 78));
        jAgeField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAgeFieldMouseClicked(evt);
            }
        });
        jAgeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jAgeFieldKeyPressed(evt);
            }
        });

        jAddCustomer.setBackground(new java.awt.Color(217, 156, 69));
        jAddCustomer.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jAddCustomer.setForeground(new java.awt.Color(255, 255, 255));
        jAddCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Customers/addcustomer.png"))); // NOI18N
        jAddCustomer.setMnemonic('a');
        jAddCustomer.setText("Add Customer");
        jAddCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddCustomerMouseClicked(evt);
            }
        });
        jAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddCustomerActionPerformed(evt);
            }
        });

        jChooseItem.setBackground(new java.awt.Color(217, 156, 69));
        jChooseItem.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jChooseItem.setForeground(new java.awt.Color(255, 255, 255));
        jChooseItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Customers/chooseItem.png"))); // NOI18N
        jChooseItem.setMnemonic('c');
        jChooseItem.setText("      Choose Item    ");
        jChooseItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jChooseItemMouseClicked(evt);
            }
        });
        jChooseItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChooseItemActionPerformed(evt);
            }
        });

        jBack.setBackground(new java.awt.Color(217, 156, 69));
        jBack.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jBack.setForeground(new java.awt.Color(255, 255, 255));
        jBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Customers/back.png"))); // NOI18N
        jBack.setMnemonic('b');
        jBack.setText("    Back  ");
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

        jGenderComboBox.setBackground(new java.awt.Color(217, 156, 69));
        jGenderComboBox.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jGenderComboBox.setForeground(new java.awt.Color(0, 31, 78));
        jGenderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", " " }));

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Email:");

        jEmailField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jEmailField.setForeground(new java.awt.Color(0, 31, 78));
        jEmailField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEmailFieldMouseClicked(evt);
            }
        });
        jEmailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jEmailFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPhoneNoField)
                            .addComponent(jNationalIdField)
                            .addComponent(jNameField)
                            .addComponent(jEmailField)
                            .addComponent(jGenderComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jChooseItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(350, 350, 350))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNationalIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPhoneNoField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGenderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChooseItem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        BackButton();
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

    private void jAgeFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jAgeFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            addCustomerButton();
        }
    }//GEN-LAST:event_jAgeFieldKeyPressed

    private void jNameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNameFieldMouseClicked
          
    }//GEN-LAST:event_jNameFieldMouseClicked

    private void jEmailFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEmailFieldMouseClicked
      
    }//GEN-LAST:event_jEmailFieldMouseClicked

    private void jNationalIdFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNationalIdFieldMouseClicked
   
    }//GEN-LAST:event_jNationalIdFieldMouseClicked

    private void jPhoneNoFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPhoneNoFieldMouseClicked
    
    }//GEN-LAST:event_jPhoneNoFieldMouseClicked

    private void jAgeFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAgeFieldMouseClicked
          
    }//GEN-LAST:event_jAgeFieldMouseClicked


    private void jChooseItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChooseItemActionPerformed
        _jChooseItem.resetPanel();
        _jChooseItem.renderData();
        _jHomePage.switchPanels(_jChooseItem);
        _jChooseItem.jSearch.grabFocus();
    }//GEN-LAST:event_jChooseItemActionPerformed

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        BackButton();
    }//GEN-LAST:event_jBackActionPerformed

    private void jAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddCustomerActionPerformed
        addCustomerButton(); 
    }//GEN-LAST:event_jAddCustomerActionPerformed

    private void jNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNameFieldActionPerformed

    private final JPanel _parent;
    private final CustomerServices _CustomerServices;
    public final jChooseItem _jChooseItem;
    private final jHomePage _jHomePage;
    public ArrayList<Item> _chosenitems;
    private ItemServices _jItemServices;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jAddCustomer;
    public javax.swing.JTextField jAgeField;
    public javax.swing.JButton jBack;
    public javax.swing.JButton jChooseItem;
    public javax.swing.JTextField jEmailField;
    public javax.swing.JComboBox<String> jGenderComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JTextField jNameField;
    public javax.swing.JTextField jNationalIdField;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jPhoneNoField;
    // End of variables declaration//GEN-END:variables
}
