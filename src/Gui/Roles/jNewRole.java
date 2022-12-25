package Gui.Roles;
import Entities.Role;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.RoleServices;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
public class jNewRole extends javax.swing.JPanel {
 
   public jNewRole(jHomePage jhp,JPanel parent ) {
        initComponents();
        _jRole=new Role();
        _jHomePage=jhp;
        _RoleServices =new RoleServices();
         _parent= parent;  
    }
   
   public void changecolor(int x, int y ,int z)
    { 
        setBackground(new java.awt.Color(x, y, z));
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
       _RoleServices.create(newRole); 
       _jHomePage.createLog("Created", "Role", newRole.name);
   }
   public Role getData(){
      /// Role newRole=new Role();
       _jRole.name=jRoleNameField.getText();
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
   }
  
   public void DoneButton(){ 
        if (_parent instanceof jViewRoles ){   
            jRoleNameField.setEditable(false);
            jDone.setText("Update");
        }
        else{
            jDone.setText("Create");
        }
   }
   private void DoneButtonClicked(){
        if (_parent instanceof jMainPage ){
            assignPermissions();
            jAddedRoleSuccessfully.setText("Permissions are assigned successfully");
            clearCreateRolePage();
        }
        else{
            jAddedRoleSuccessfully.setText("Updated successfully");
            Role role = getData();
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
        jAddedRoleSuccessfully = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JDeleteUser = new javax.swing.JCheckBox();
        jCreateRole = new javax.swing.JCheckBox();
        jViewRole = new javax.swing.JCheckBox();
        JDeleteLog = new javax.swing.JCheckBox();
        JUpdateRole = new javax.swing.JCheckBox();

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
        jBack.setText("back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        jDone.setBackground(new java.awt.Color(217, 156, 69));
        jDone.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jDone.setForeground(new java.awt.Color(255, 255, 255));
        jDone.setText("Done");
        jDone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDoneMouseClicked(evt);
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

        jAddedRoleSuccessfully.setForeground(new java.awt.Color(102, 255, 0));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jViewRole, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(JUpdateRole, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jViewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCreateRole, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(141, 141, 141)
                                    .addComponent(JviewLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jCreateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JDeleteLog, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(JDeleteCustomer)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jUpdateCustomer)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jUpdateItem, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jViewCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jViewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(JCreateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCreateItem, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(jRoleNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(154, 154, 154)
                            .addComponent(jDone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(216, 216, 216)
                .addComponent(jAddedRoleSuccessfully, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRoleNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCreateCustomer)
                    .addComponent(jCreateItem))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jViewItem)
                    .addComponent(jViewCustomer))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUpdateCustomer)
                    .addComponent(jUpdateItem))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jDeleteItem))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JDeleteCustomer)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jCreateUser)
                        .addGap(18, 18, 18)
                        .addComponent(jViewUser))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(JDeleteLog)
                        .addGap(18, 18, 18)
                        .addComponent(jCreateRole)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JDeleteUser)
                    .addComponent(JviewLogs))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jAddedRoleSuccessfully, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jViewRole)
                        .addComponent(JUpdateRole)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDone, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void jDoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDoneMouseClicked
        DoneButtonClicked();
    }//GEN-LAST:event_jDoneMouseClicked

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        if (_parent instanceof jMainPage )
        {
            jAddedRoleSuccessfully.setText("");
            clearCreateRolePage();
            jMainPage mainPage=(jMainPage)_parent;
             _jHomePage.switchPanels(_parent);
             mainPage.jNewRole.grabFocus();
              jAddedRoleSuccessfully.setText("");
        }
        else 
      {
        jViewRoles ViewRoles= (jViewRoles) _parent;
        clearCreateRolePage();
        ViewRoles.renderData();
        _jHomePage.switchPanels(_parent);
        ViewRoles.jSearch.grabFocus();
        jAddedRoleSuccessfully.setText("");
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
            jAddedRoleSuccessfully.setText("");
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

    
    
    
    
    private final jHomePage _jHomePage;
    public Role _jRole;
    //private final jMainPage _jMainPage;
    //private final jViewRoles _jViewRoles;
    private final RoleServices _RoleServices;
    private final JPanel _parent;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox JCreateCustomer;
    private javax.swing.JCheckBox JDeleteCustomer;
    private javax.swing.JCheckBox JDeleteLog;
    private javax.swing.JCheckBox JDeleteUser;
    private javax.swing.JCheckBox JUpdateRole;
    private javax.swing.JCheckBox JviewLogs;
    private javax.swing.JLabel jAddedRoleSuccessfully;
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
