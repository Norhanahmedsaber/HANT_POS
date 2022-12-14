package Gui.Roles;
import Entities.Role;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.RoleServices;
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
   public void clearCreateRolePage(){
        jRoleNameField.setText("");
        JCreateCustomer.setSelected(false);
        jCreateItem.setSelected(false);
        jCreateLogs.setSelected(false);
        jCreateUser.setSelected(false);
        JDeleteCustomer.setSelected(false);
        jDeleteItem.setSelected(false);
        jUpdateCustomer.setSelected(false);
        jUpdateItem.setSelected(false);
        jViewCustomer.setSelected(false);
        jViewItem.setSelected(false);
        JviewLogs.setSelected(false);
        jViewUser.setSelected(false);
        jAddedRoleSuccessfully.setText("");
    }
   public void assignPermissions(){   
       Role newRole = getData();
       _RoleServices.create(newRole); 
       _jHomePage.createLog("Created", "Role", newRole.name);
   }
   public Role getData(){
       Role newRole=new Role();
       newRole.name=jRoleNameField.getText();
       newRole.canCreateCustomer=JCreateCustomer.isSelected();
       newRole.canCreateItem=jCreateItem.isSelected();
       newRole.canCreateLog=jCreateLogs.isSelected();
       newRole.canCreateUser=jCreateUser.isSelected();
       newRole.canDeleteCustomer=JDeleteCustomer.isSelected();
       newRole.canDeleteItem=jDeleteItem.isSelected();
       newRole.canUpdateCustomer=jUpdateCustomer.isSelected();
       newRole.canUpdateItem=jUpdateItem.isSelected();
       newRole.canViewCustomers=jViewCustomer.isSelected();
       newRole.canViewItems=jViewItem.isSelected();
       newRole.canViewLogs=JviewLogs.isSelected();
       newRole.canViewUsers=jViewUser.isSelected();  
       return newRole;
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
       if(_jRole.canCreateLog)
       {
           jCreateLogs.setSelected(true);
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

   }
   public void DoneButton(){ 
        if (_parent instanceof jViewRoles ){  
            jViewRoles ViewRoles= (jViewRoles) _parent;   
            jRoleNameField.setEditable(false);
            jDone.setText("Update");
        }
        else{
            jDone.setText("Create");
        }
   }
   private void DoneButtonClicked(){
        if (_parent instanceof jMainPage ){
            jMainPage MainPage=(jMainPage)_parent;
            assignPermissions();
            jAddedRoleSuccessfully.setText("Permissions are assigned successfully");
            clearCreateRolePage();
        }
        else{
            jViewRoles ViewRoles= (jViewRoles) _parent;
            renderData();
            jAddedRoleSuccessfully.setText("Updated successfully");
            Role role = getData();
            _jHomePage.createLog("Updated", "Role", role.name);
            _RoleServices.update(_jRole.id,role);   
        }
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
        jCreateLogs = new javax.swing.JCheckBox();
        jRoleNameField = new javax.swing.JTextField();
        jAddedRoleSuccessfully = new javax.swing.JLabel();

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jBack.setText("back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        jDone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDoneMouseClicked(evt);
            }
        });

        JCreateCustomer.setText("Create Customer");
        JCreateCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCreateCustomerKeyPressed(evt);
            }
        });

        jViewCustomer.setText("View Customer");
        jViewCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jViewCustomerKeyPressed(evt);
            }
        });

        JDeleteCustomer.setText("Delete Customer ");
        JDeleteCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JDeleteCustomerKeyPressed(evt);
            }
        });

        jUpdateCustomer.setText("Update customer");
        jUpdateCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jUpdateCustomerKeyPressed(evt);
            }
        });

        jViewItem.setText("View Item");
        jViewItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jViewItemKeyPressed(evt);
            }
        });

        jCreateItem.setText("Create Item");
        jCreateItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCreateItemKeyPressed(evt);
            }
        });

        jUpdateItem.setText("Update Item");
        jUpdateItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jUpdateItemKeyPressed(evt);
            }
        });

        jDeleteItem.setText("Delete Item");
        jDeleteItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDeleteItemKeyPressed(evt);
            }
        });

        jViewUser.setText("View User");
        jViewUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jViewUserKeyPressed(evt);
            }
        });

        JviewLogs.setText("View Logs");
        JviewLogs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JviewLogsKeyPressed(evt);
            }
        });

        jCreateUser.setText("Create User");
        jCreateUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCreateUserKeyPressed(evt);
            }
        });

        jCreateLogs.setText("Create Logs");
        jCreateLogs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCreateLogsKeyPressed(evt);
            }
        });

        jRoleNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRoleNameFieldKeyPressed(evt);
            }
        });

        jAddedRoleSuccessfully.setForeground(new java.awt.Color(102, 255, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JDeleteCustomer)
                    .addComponent(jViewCustomer)
                    .addComponent(JCreateCustomer)
                    .addComponent(jUpdateCustomer)
                    .addComponent(jCreateItem)
                    .addComponent(jViewItem)
                    .addComponent(jRoleNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAddedRoleSuccessfully, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jDeleteItem)
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jUpdateItem)
                            .addComponent(jCreateUser)
                            .addComponent(jViewUser)
                            .addComponent(JviewLogs)
                            .addComponent(jCreateLogs))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jBack)
                .addGap(201, 201, 201)
                .addComponent(jDone, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jRoleNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCreateCustomer)
                    .addComponent(jDeleteItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jViewCustomer)
                    .addComponent(jUpdateItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JDeleteCustomer)
                    .addComponent(jCreateUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUpdateCustomer)
                    .addComponent(jViewUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCreateItem)
                    .addComponent(jCreateLogs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jViewItem)
                    .addComponent(JviewLogs))
                .addGap(18, 18, 18)
                .addComponent(jAddedRoleSuccessfully, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBack)
                    .addComponent(jDone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
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
             _jHomePage.switchPanels(_parent);
        }
        else 
      {
        jViewRoles ViewRoles= (jViewRoles) _parent;
        clearCreateRolePage();
        ViewRoles.renderData();
        _jHomePage.switchPanels(_parent);
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

    private void jCreateLogsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCreateLogsKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            DoneButtonClicked();
        }
    }//GEN-LAST:event_jCreateLogsKeyPressed

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

    
    
    
    
    private final jHomePage _jHomePage;
    public Role _jRole;
    //private final jMainPage _jMainPage;
    //private final jViewRoles _jViewRoles;
    private final RoleServices _RoleServices;
    private final JPanel _parent;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox JCreateCustomer;
    private javax.swing.JCheckBox JDeleteCustomer;
    private javax.swing.JCheckBox JviewLogs;
    private javax.swing.JLabel jAddedRoleSuccessfully;
    private javax.swing.JButton jBack;
    private javax.swing.JCheckBox jCreateItem;
    private javax.swing.JCheckBox jCreateLogs;
    private javax.swing.JCheckBox jCreateUser;
    private javax.swing.JCheckBox jDeleteItem;
    private javax.swing.JButton jDone;
    private javax.swing.JTextField jRoleNameField;
    private javax.swing.JCheckBox jUpdateCustomer;
    private javax.swing.JCheckBox jUpdateItem;
    private javax.swing.JCheckBox jViewCustomer;
    private javax.swing.JCheckBox jViewItem;
    private javax.swing.JCheckBox jViewUser;
    // End of variables declaration//GEN-END:variables
}
