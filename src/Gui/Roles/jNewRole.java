package Gui.Roles;
import Entities.Role;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.RoleServices;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class jNewRole extends javax.swing.JPanel {
 
   public jNewRole(jHomePage jhp,JPanel parent) {
        initComponents();
        _jRole=new Role();
        _jHomePage=jhp;
        _RoleServices =new RoleServices();
        _parent= parent;  
    }
   
    
    public void changecolor(java.awt.Color c1,java.awt.Color c2,java.awt.Color c3,java.awt.Color c4,java.awt.Color c5)
    {  
        setBackground(c1);
        JCreateCustomer.setForeground(c3);
        JDeleteCustomer.setForeground(c3);
        JDeleteLog.setForeground(c3);
        JDeleteUser.setForeground(c3);
        JUpdateRole.setForeground(c3);
        JUpdateUser1.setForeground(c3);
        JviewLogs.setForeground(c3);
        jBack.setBackground(c2);
        jBack.setForeground(c4);
        jCreateItem.setForeground(c3);
        jCreateRole.setForeground(c3);
        jCreateUser.setForeground(c3);
        jDeleteItem.setForeground(c3);
        jDone.setBackground(c2);
        jDone.setForeground(c4);
        jLabel1.setForeground(c3);
        jRoleNameField.setBackground(c5);
        jUpdateCustomer.setForeground(c3);
        jUpdateItem.setForeground(c3);
        jViewCustomer.setForeground(c3);
        jViewItem.setForeground(c3);
        jViewRole.setForeground(c3);
        jViewUser.setForeground(c3);
    }
   public void clearCreateRolePage(){
        jRoleNameField.setText("");
        JCreateCustomer.setSelected(false);
        jCreateItem.setSelected(false);
        jCreateUser.setSelected(false);
        JDeleteCustomer.setSelected(false);
        jDeleteItem.setSelected(false);
        jUpdateCustomer.setSelected(false);
        jUpdateItem.setSelected(false);
        jViewCustomer.setSelected(false);
        jViewItem.setSelected(false);
        JviewLogs.setSelected(false);
        jViewUser.setSelected(false);
        JDeleteUser.setSelected(false);
        JDeleteLog.setSelected(false);
        jCreateRole.setSelected(false);
        JUpdateRole.setSelected(false);
        jViewRole.setSelected(false);
    }
   public void assignPermissions(){   
        Role newRole = getData();
        if(newRole != null) {
            _RoleServices.create(newRole); 
            _jHomePage.createLog("Created", "Role", newRole.name);
            JOptionPane.showMessageDialog(null, "Permissions are assigned successfully!");
        }
        
   }
    public Role getData(){
        _jRole.name=jRoleNameField.getText();
        if(!"".equals(_jRole.name)) {
            _jRole.canCreateCustomer=JCreateCustomer.isSelected();
            _jRole.canCreateItem=jCreateItem.isSelected();
            _jRole.canCreateUser=jCreateUser.isSelected();
            _jRole.canDeleteCustomer=JDeleteCustomer.isSelected();
            _jRole.canDeleteItem=jDeleteItem.isSelected();
            _jRole.canUpdateCustomer=jUpdateCustomer.isSelected();
            _jRole.canUpdateItem=jUpdateItem.isSelected();
            _jRole.canViewCustomers=jViewCustomer.isSelected();
            _jRole.canViewItems=jViewItem.isSelected();
            _jRole.canViewLogs=JviewLogs.isSelected();
            _jRole.canViewUsers=jViewUser.isSelected();  
            _jRole.canDeleteUser = JDeleteUser.isSelected();
            _jRole.canCreateRole = jCreateRole.isSelected();
            _jRole.canUpdateRole = JUpdateRole.isSelected();
            _jRole.canViewRoles = jViewRole.isSelected();
            _jRole.canDeleteLog = JDeleteLog.isSelected();
            return _jRole;
        }else {
            JOptionPane.showMessageDialog(null, "Role Name Can't be Empty!");
            return null;
        }
       
       
   }
  
   public void DoneButton(){ 
        if (_parent instanceof jViewRoles ){   
            jRoleNameField.setEditable(false);
            jDone.setText("Update");
            System.out.println("xxjxnxjx");
        }
        else{
            jDone.setText("Create");
        }
   }
   private void DoneButtonClicked(){
        if (_parent instanceof jMainPage ){
            assignPermissions();
            clearCreateRolePage();
        }
        else{
            Role role = getData();
            JOptionPane.showMessageDialog(null, "Permissions are assigned successfully!");
            _jHomePage.createLog("Updated", "Role", role.name); 
            _RoleServices.update(_RoleServices.getByName(_jRole.name).id, role);
          
        }
   }
   public void renderData(){
        jRoleNameField.setText(_jRole.name);
        if(_jRole.canCreateCustomer)
        { 
            JCreateCustomer.setSelected(true);
        }
        if(_jRole.canCreateItem)
        {
            jCreateItem.setSelected(true);
        }
        if(_jRole.canCreateUser)
        {
            jCreateUser.setSelected(true);
        }
        if(_jRole.canDeleteCustomer)
        {
            JDeleteCustomer.setSelected(true);
        }
        if(_jRole.canDeleteItem)
        {
            jDeleteItem.setSelected(true);
        }
        if(_jRole.canUpdateCustomer)
        {
            jUpdateCustomer.setSelected(true);
        }
        if(_jRole.canUpdateItem)
        {
            jUpdateItem.setSelected(true);
        }
        if(_jRole.canViewCustomers)
        {
            jViewCustomer.setSelected(true);
        }
        if( _jRole.canViewItems)
        {
            jViewItem.setSelected(true);
        }
        if( _jRole.canViewLogs)
        {
            JviewLogs.setSelected(true);
        }
        if(_jRole.canViewUsers)
        {
            jViewUser.setSelected(true);
        }
        System.err.println(_jRole.canDeleteUser);
        JDeleteUser.setSelected(_jRole.canDeleteUser);
        JDeleteLog.setSelected(_jRole.canDeleteLog);
        jCreateRole.setSelected(_jRole.canCreateRole);
        JUpdateRole.setSelected(_jRole.canUpdateRole);
        jViewRole.setSelected(_jRole.canViewRoles);

   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBack = new javax.swing.JButton();
        jDone = new javax.swing.JButton();
        JCreateCustomer = new javax.swing.JCheckBox();
        jViewCustomer = new javax.swing.JCheckBox();
        JDeleteCustomer = new javax.swing.JCheckBox();
        jUpdateCustomer = new javax.swing.JCheckBox();
        jViewItem = new javax.swing.JCheckBox();
        jCreateItem = new javax.swing.JCheckBox();
        jUpdateItem = new javax.swing.JCheckBox();
        jDeleteItem = new javax.swing.JCheckBox();
        jViewUser = new javax.swing.JCheckBox();
        JviewLogs = new javax.swing.JCheckBox();
        jCreateUser = new javax.swing.JCheckBox();
        jRoleNameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        JDeleteUser = new javax.swing.JCheckBox();
        jCreateRole = new javax.swing.JCheckBox();
        jViewRole = new javax.swing.JCheckBox();
        JDeleteLog = new javax.swing.JCheckBox();
        JUpdateRole = new javax.swing.JCheckBox();
        JUpdateUser1 = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(87, 118, 130));
        setForeground(new java.awt.Color(217, 156, 69));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jBack.setBackground(new java.awt.Color(217, 156, 69));
        jBack.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jBack.setForeground(new java.awt.Color(255, 255, 255));
        jBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Roles/back.png"))); // NOI18N
        jBack.setMnemonic('b');
        jBack.setText("    Back   ");
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

        jDone.setBackground(new java.awt.Color(217, 156, 69));
        jDone.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jDone.setForeground(new java.awt.Color(255, 255, 255));
        jDone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Roles/done1.png"))); // NOI18N
        jDone.setMnemonic('d');
        jDone.setText("    Done  ");
        jDone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDoneMouseClicked(evt);
            }
        });
        jDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDoneActionPerformed(evt);
            }
        });

        JCreateCustomer.setBackground(new java.awt.Color(217, 156, 69));
        JCreateCustomer.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        JCreateCustomer.setForeground(new java.awt.Color(255, 255, 255));
        JCreateCustomer.setText("Create Customer");
        JCreateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCreateCustomerActionPerformed(evt);
            }
        });
        JCreateCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCreateCustomerKeyPressed(evt);
            }
        });

        jViewCustomer.setBackground(new java.awt.Color(217, 156, 69));
        jViewCustomer.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jViewCustomer.setForeground(new java.awt.Color(255, 255, 255));
        jViewCustomer.setText("View Customers");
        jViewCustomer.setToolTipText("");
        jViewCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jViewCustomerKeyPressed(evt);
            }
        });

        JDeleteCustomer.setBackground(new java.awt.Color(217, 156, 69));
        JDeleteCustomer.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        JDeleteCustomer.setForeground(new java.awt.Color(255, 255, 255));
        JDeleteCustomer.setText("Delete Customer ");
        JDeleteCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JDeleteCustomerKeyPressed(evt);
            }
        });

        jUpdateCustomer.setBackground(new java.awt.Color(217, 156, 69));
        jUpdateCustomer.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jUpdateCustomer.setForeground(new java.awt.Color(255, 255, 255));
        jUpdateCustomer.setText("Update customer");
        jUpdateCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jUpdateCustomerKeyPressed(evt);
            }
        });

        jViewItem.setBackground(new java.awt.Color(217, 156, 69));
        jViewItem.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jViewItem.setForeground(new java.awt.Color(255, 255, 255));
        jViewItem.setText("View Items");
        jViewItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jViewItemKeyPressed(evt);
            }
        });

        jCreateItem.setBackground(new java.awt.Color(217, 156, 69));
        jCreateItem.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jCreateItem.setForeground(new java.awt.Color(255, 255, 255));
        jCreateItem.setText("Create Item");
        jCreateItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCreateItemKeyPressed(evt);
            }
        });

        jUpdateItem.setBackground(new java.awt.Color(217, 156, 69));
        jUpdateItem.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jUpdateItem.setForeground(new java.awt.Color(255, 255, 255));
        jUpdateItem.setText("Update Item");
        jUpdateItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jUpdateItemKeyPressed(evt);
            }
        });

        jDeleteItem.setBackground(new java.awt.Color(217, 156, 69));
        jDeleteItem.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jDeleteItem.setForeground(new java.awt.Color(255, 255, 255));
        jDeleteItem.setText("Delete Item");
        jDeleteItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDeleteItemKeyPressed(evt);
            }
        });

        jViewUser.setBackground(new java.awt.Color(217, 156, 69));
        jViewUser.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jViewUser.setForeground(new java.awt.Color(255, 255, 255));
        jViewUser.setText("View User");
        jViewUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jViewUserKeyPressed(evt);
            }
        });

        JviewLogs.setBackground(new java.awt.Color(217, 156, 69));
        JviewLogs.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        JviewLogs.setForeground(new java.awt.Color(255, 255, 255));
        JviewLogs.setText("View Logs");
        JviewLogs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JviewLogsKeyPressed(evt);
            }
        });

        jCreateUser.setBackground(new java.awt.Color(217, 156, 69));
        jCreateUser.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jCreateUser.setForeground(new java.awt.Color(255, 255, 255));
        jCreateUser.setText("Create User");
        jCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreateUserActionPerformed(evt);
            }
        });
        jCreateUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCreateUserKeyPressed(evt);
            }
        });

        jRoleNameField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jRoleNameField.setForeground(new java.awt.Color(0, 31, 78));
        jRoleNameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRoleNameFieldMouseClicked(evt);
            }
        });
        jRoleNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRoleNameFieldKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Role Name :");

        JDeleteUser.setBackground(new java.awt.Color(217, 156, 69));
        JDeleteUser.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        JDeleteUser.setForeground(new java.awt.Color(255, 255, 255));
        JDeleteUser.setText("Delete User");
        JDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JDeleteUserActionPerformed(evt);
            }
        });
        JDeleteUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JDeleteUserKeyPressed(evt);
            }
        });

        jCreateRole.setBackground(new java.awt.Color(217, 156, 69));
        jCreateRole.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jCreateRole.setForeground(new java.awt.Color(255, 255, 255));
        jCreateRole.setText("Create Role");
        jCreateRole.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCreateRoleKeyPressed(evt);
            }
        });

        jViewRole.setBackground(new java.awt.Color(217, 156, 69));
        jViewRole.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jViewRole.setForeground(new java.awt.Color(255, 255, 255));
        jViewRole.setText("View Roles");
        jViewRole.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jViewRoleKeyPressed(evt);
            }
        });

        JDeleteLog.setBackground(new java.awt.Color(217, 156, 69));
        JDeleteLog.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        JDeleteLog.setForeground(new java.awt.Color(255, 255, 255));
        JDeleteLog.setText("Delete Log");
        JDeleteLog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JDeleteLogKeyPressed(evt);
            }
        });

        JUpdateRole.setBackground(new java.awt.Color(217, 156, 69));
        JUpdateRole.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        JUpdateRole.setForeground(new java.awt.Color(255, 255, 255));
        JUpdateRole.setText("Update Role");
        JUpdateRole.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JUpdateRoleKeyPressed(evt);
            }
        });

        JUpdateUser1.setBackground(new java.awt.Color(217, 156, 69));
        JUpdateUser1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        JUpdateUser1.setForeground(new java.awt.Color(255, 255, 255));
        JUpdateUser1.setText("Update User");
        JUpdateUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JUpdateUser1ActionPerformed(evt);
            }
        });
        JUpdateUser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JUpdateUser1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jRoleNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jDone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JDeleteCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jUpdateCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jViewCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JCreateCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jUpdateItem, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(87, 87, 87)
                                        .addComponent(JUpdateUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCreateItem, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(87, 87, 87)
                                        .addComponent(jCreateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jViewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(87, 87, 87)
                                        .addComponent(jViewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jDeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(87, 87, 87)
                                        .addComponent(JDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(JviewLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JDeleteLog, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JUpdateRole, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jViewRole, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCreateRole, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRoleNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCreateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCreateItem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCreateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jViewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jViewCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jViewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUpdateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUpdateItem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JUpdateUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JDeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCreateRole, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JviewLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jViewRole, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JDeleteLog, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(JUpdateRole, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDone, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void jDoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDoneMouseClicked
        DoneButtonClicked();
    }//GEN-LAST:event_jDoneMouseClicked

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        if (_parent instanceof jMainPage )
        {
            clearCreateRolePage();
            jMainPage mainPage=(jMainPage)_parent;
             _jHomePage.switchPanels(_parent);
             mainPage.jNewRole.grabFocus();
        }
        else 
      {
        jViewRoles ViewRoles= (jViewRoles) _parent;
        clearCreateRolePage();
        ViewRoles.renderData();
        _jHomePage.switchPanels(_parent);
        ViewRoles.jSearch.grabFocus();
      }
       
      
    }//GEN-LAST:event_jBackMouseClicked
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            DoneButtonClicked();
        }
    }//GEN-LAST:event_formKeyPressed

    private void jViewItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jViewItemKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            DoneButtonClicked();
        }
    }//GEN-LAST:event_jViewItemKeyPressed

    private void jCreateItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCreateItemKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            DoneButtonClicked();
        }
    }//GEN-LAST:event_jCreateItemKeyPressed

    private void jUpdateCustomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jUpdateCustomerKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            DoneButtonClicked();
        }
    }//GEN-LAST:event_jUpdateCustomerKeyPressed

    private void JDeleteCustomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDeleteCustomerKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            DoneButtonClicked();
        }
    }//GEN-LAST:event_JDeleteCustomerKeyPressed

    private void jViewCustomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jViewCustomerKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            DoneButtonClicked();
        }
    }//GEN-LAST:event_jViewCustomerKeyPressed

    private void JCreateCustomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCreateCustomerKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            DoneButtonClicked();
        }
    }//GEN-LAST:event_JCreateCustomerKeyPressed

    private void JviewLogsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JviewLogsKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            DoneButtonClicked();
        }
    }//GEN-LAST:event_JviewLogsKeyPressed

    private void jViewUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jViewUserKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            DoneButtonClicked();
        }
    }//GEN-LAST:event_jViewUserKeyPressed

    private void jCreateUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCreateUserKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            DoneButtonClicked();
        }
    }//GEN-LAST:event_jCreateUserKeyPressed

    private void jUpdateItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jUpdateItemKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            DoneButtonClicked();
        }
    }//GEN-LAST:event_jUpdateItemKeyPressed

    private void jDeleteItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDeleteItemKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            DoneButtonClicked();
        }
    }//GEN-LAST:event_jDeleteItemKeyPressed

    private void jRoleNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRoleNameFieldKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            DoneButtonClicked();
        }
    }//GEN-LAST:event_jRoleNameFieldKeyPressed

    private void jRoleNameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRoleNameFieldMouseClicked
            //jAddedRoleSuccessfully.setText("");
    }//GEN-LAST:event_jRoleNameFieldMouseClicked

    private void JCreateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCreateCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCreateCustomerActionPerformed

    private void JDeleteUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDeleteUserKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JDeleteUserKeyPressed

    private void JDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JDeleteUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JDeleteUserActionPerformed

    private void jCreateRoleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCreateRoleKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCreateRoleKeyPressed

    private void jViewRoleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jViewRoleKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jViewRoleKeyPressed

    private void JDeleteLogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDeleteLogKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JDeleteLogKeyPressed

    private void JUpdateRoleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JUpdateRoleKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JUpdateRoleKeyPressed

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        if (_parent instanceof jMainPage )
        {
            clearCreateRolePage();
            jMainPage mainPage=(jMainPage)_parent;
             _jHomePage.switchPanels(_parent);
             mainPage.jNewRole.grabFocus();
        }
        else 
      {
        jViewRoles ViewRoles= (jViewRoles) _parent;
        clearCreateRolePage();
        ViewRoles.renderData();
        _jHomePage.switchPanels(_parent);
        ViewRoles.jSearch.grabFocus();
      }
    }//GEN-LAST:event_jBackActionPerformed

    private void jDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDoneActionPerformed
        DoneButtonClicked();
    }//GEN-LAST:event_jDoneActionPerformed

    private void jCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreateUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCreateUserActionPerformed

    private void JUpdateUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JUpdateUser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JUpdateUser1ActionPerformed

    private void JUpdateUser1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JUpdateUser1KeyPressed
        
            
    }//GEN-LAST:event_JUpdateUser1KeyPressed

    
    
    
    
    private final jHomePage _jHomePage;
    public Role _jRole;
    private final RoleServices _RoleServices;
    private final JPanel _parent;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox JCreateCustomer;
    private javax.swing.JCheckBox JDeleteCustomer;
    private javax.swing.JCheckBox JDeleteLog;
    private javax.swing.JCheckBox JDeleteUser;
    private javax.swing.JCheckBox JUpdateRole;
    private javax.swing.JCheckBox JUpdateUser1;
    private javax.swing.JCheckBox JviewLogs;
    private javax.swing.JButton jBack;
    private javax.swing.JCheckBox jCreateItem;
    private javax.swing.JCheckBox jCreateRole;
    private javax.swing.JCheckBox jCreateUser;
    private javax.swing.JCheckBox jDeleteItem;
    private javax.swing.JButton jDone;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JTextField jRoleNameField;
    private javax.swing.JCheckBox jUpdateCustomer;
    private javax.swing.JCheckBox jUpdateItem;
    private javax.swing.JCheckBox jViewCustomer;
    private javax.swing.JCheckBox jViewItem;
    private javax.swing.JCheckBox jViewRole;
    private javax.swing.JCheckBox jViewUser;
    // End of variables declaration//GEN-END:variables
}
