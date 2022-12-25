package Gui.Customers;
 
import Gui.Items.jChooseItem;
import Entities.Customer;
import Entities.Item;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.CustomerServices;
import Services.ItemServices;
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
    public ArrayList<Item> getselecteditems(){ 
        return _chosenitems ;
    }
    public void setselecteditems(ArrayList<Item> selecteditems){
        _chosenitems=selecteditems;
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
    public boolean isValidCity(){
        // is empty (City)
        if(jCityField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "City Can't be Empty!");
            return false;
        }
        return true;
    }  
    public boolean isValidIncome(){
        // is empty (Income)
        if(jIncomeField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Income Can't be Empty!");
            return false;
        }
        // is valid (Income)
        try {
            Integer.valueOf(jIncomeField.getText());
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please Enter A number in the income field!");
            return false;
        }
        return true;
    }
    public boolean isValidJop(){
        // is empty (job)
        if(jJobField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Job can't be Empty!");
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
        _Customer.job = jJobField.getText().trim();
        _Customer.nationalId = jNationalIdField.getText().trim();
        _Customer.income = Integer.parseInt(jIncomeField.getText().trim());
        _Customer.email = jEmailField.getText().trim();
        _Customer.city = jCityField.getText().trim();
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
        jIncomeField.setText("");
        jPhoneNoField.setText("");
        jNationalIdField.setText("");
        jCityField.setText("");
        jJobField.setText("");   
        
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

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("City:");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Income:");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Purchases:");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Age:");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Job:");

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

        jIncomeField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jIncomeField.setForeground(new java.awt.Color(0, 31, 78));
        jIncomeField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jIncomeFieldMouseClicked(evt);
            }
        });
        jIncomeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jIncomeFieldKeyPressed(evt);
            }
        });

        jJobField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jJobField.setForeground(new java.awt.Color(0, 31, 78));
        jJobField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jJobFieldMouseClicked(evt);
            }
        });
        jJobField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jJobFieldKeyPressed(evt);
            }
        });

        jCityField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jCityField.setForeground(new java.awt.Color(0, 31, 78));
        jCityField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCityFieldMouseClicked(evt);
            }
        });
        jCityField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCityFieldKeyPressed(evt);
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
        jAddCustomer.setText("Add Customer");
        jAddCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddCustomerMouseClicked(evt);
            }
        });

        jChooseItem.setBackground(new java.awt.Color(217, 156, 69));
        jChooseItem.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jChooseItem.setForeground(new java.awt.Color(255, 255, 255));
        jChooseItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Customers/chooseItem.png"))); // NOI18N
        jChooseItem.setText("      Choose Item    ");
        jChooseItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jChooseItemMouseClicked(evt);
            }
        });

        jBack.setBackground(new java.awt.Color(217, 156, 69));
        jBack.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jBack.setForeground(new java.awt.Color(255, 255, 255));
        jBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Customers/back.png"))); // NOI18N
        jBack.setText("    Back  ");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        jGenderComboBox.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jGenderComboBox.setForeground(new java.awt.Color(255, 255, 255));
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
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCityField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(38, 38, 38)
                                .addComponent(jIncomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jJobField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jGenderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPhoneNoField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jNationalIdField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jNameField)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(39, 39, 39)
                                .addComponent(jChooseItem, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jAddCustomer)))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addGap(356, 356, 356))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jNationalIdField)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPhoneNoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jCityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jIncomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jJobField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGenderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jChooseItem))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
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

    private void jNameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNameFieldMouseClicked
          
    }//GEN-LAST:event_jNameFieldMouseClicked

    private void jEmailFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEmailFieldMouseClicked
      
    }//GEN-LAST:event_jEmailFieldMouseClicked

    private void jNationalIdFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNationalIdFieldMouseClicked
   
    }//GEN-LAST:event_jNationalIdFieldMouseClicked

    private void jPhoneNoFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPhoneNoFieldMouseClicked
    
    }//GEN-LAST:event_jPhoneNoFieldMouseClicked

    private void jCityFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCityFieldMouseClicked
   
    }//GEN-LAST:event_jCityFieldMouseClicked

    private void jIncomeFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jIncomeFieldMouseClicked
      
    }//GEN-LAST:event_jIncomeFieldMouseClicked

    private void jJobFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jJobFieldMouseClicked
     
    }//GEN-LAST:event_jJobFieldMouseClicked

    private void jAgeFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAgeFieldMouseClicked
          
    }//GEN-LAST:event_jAgeFieldMouseClicked

    private final JPanel _parent;
    private final CustomerServices _CustomerServices;
    private final jChooseItem _jChooseItem;
    private final jHomePage _jHomePage;
    public ArrayList<Item> _chosenitems;
    private ItemServices _jItemServices;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddCustomer;
    private javax.swing.JTextField jAgeField;
    private javax.swing.JButton jBack;
    private javax.swing.JButton jChooseItem;
    private javax.swing.JTextField jCityField;
    private javax.swing.JTextField jEmailField;
    private javax.swing.JComboBox<String> jGenderComboBox;
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
