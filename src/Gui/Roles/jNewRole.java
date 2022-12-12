package Gui.Roles;
import Entities.Role;
import Gui.jHomePage;
import Gui.jMainPage;
import Gui.Roles.jViewRoles;
import Services.RoleServices;
import javax.swing.JPanel;
public class jNewRole extends javax.swing.JPanel {

    public jNewRole(jHomePage jhp,JPanel parent ) {
        initComponents();
        _jRole=new Role();
        _jHomePage=jhp;
        _RoleServices =new RoleServices();
         _parent= parent;  
    }
  
    public void clearCreateRolePage()
    {
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
    }
   public void assighnPermissions()
   {   
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
       _RoleServices.create(newRole);    
   }
   public void renderData()
   {
       if(_jRole.canCreateCustomer)
       { 
           JCreateCustomer.setSelected(true);
       }
       if(_jRole.canCreateItem)
       {
           jCreateItem.setSelected(true);
           System.out.println("true");
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
   public void DoneButton() 
   { if (_parent instanceof jViewRoles )
        {  
                jViewRoles ViewRoles= (jViewRoles) _parent;            
                jDone.setText("Update");
        }
        else 
      {
          
           jDone.setText("Create");
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
        jChosedPermissions = new javax.swing.JLabel();

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

        jViewCustomer.setText("View Customer");

        JDeleteCustomer.setText("Delete Customer ");

        jUpdateCustomer.setText("Update customer");

        jViewItem.setText("View Item");

        jCreateItem.setText("Create Item");

        jUpdateItem.setText("Update Item");

        jDeleteItem.setText("Delete Item");

        jViewUser.setText("View User");

        JviewLogs.setText("View Logs");

        jCreateUser.setText("Create User");

        jCreateLogs.setText("Create Logs");

        jChosedPermissions.setForeground(new java.awt.Color(102, 255, 0));

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
                    .addComponent(jChosedPermissions, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jChosedPermissions, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBack)
                    .addComponent(jDone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void JCreateCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCreateCustomerMouseClicked

        
    }//GEN-LAST:event_JCreateCustomerMouseClicked

    private void jViewCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewCustomerMouseClicked

    }//GEN-LAST:event_jViewCustomerMouseClicked

    private void JDeleteCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JDeleteCustomerMouseClicked
      
    }//GEN-LAST:event_JDeleteCustomerMouseClicked

    private void jUpdateCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateCustomerMouseClicked
     
    }//GEN-LAST:event_jUpdateCustomerMouseClicked

    private void jCreateItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCreateItemMouseClicked
        
    }//GEN-LAST:event_jCreateItemMouseClicked

    private void jViewItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewItemMouseClicked
       
    }//GEN-LAST:event_jViewItemMouseClicked

    private void jDeleteItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDeleteItemMouseClicked
       
    }//GEN-LAST:event_jDeleteItemMouseClicked

    private void jUpdateItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateItemMouseClicked
       
    }//GEN-LAST:event_jUpdateItemMouseClicked

    private void jCreateUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCreateUserMouseClicked
        
    }//GEN-LAST:event_jCreateUserMouseClicked

    private void jViewUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewUserMouseClicked
        
    }//GEN-LAST:event_jViewUserMouseClicked

    private void jCreateLogsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCreateLogsMouseClicked
        
    }//GEN-LAST:event_jCreateLogsMouseClicked

    private void JviewLogsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JviewLogsMouseClicked
      
    }//GEN-LAST:event_JviewLogsMouseClicked

    private void jDoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDoneMouseClicked
       if (_parent instanceof jMainPage )
        {
            jMainPage MainPage=(jMainPage)_parent;
            assighnPermissions();
            jChosedPermissions.setText("Permissions are assigned successfully");
            clearCreateRolePage();
        }
        else 
      {
          jViewRoles ViewRoles= (jViewRoles) _parent;
          renderData();
          jChosedPermissions.setText("Updated successfully");
          //_RoleServices.update(_jRole.id,role);   
      }
        
    }//GEN-LAST:event_jDoneMouseClicked

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        if (_parent instanceof jMainPage )
        {
            jMainPage MainPage=(jMainPage)_parent;
            jChosedPermissions.setText("");
            clearCreateRolePage();
             _jHomePage.switchPanels(_parent);
        }
        else 
      {
          jViewRoles ViewRoles= (jViewRoles) _parent;
         _jHomePage.switchPanels(_parent);
      }
       
      
    }//GEN-LAST:event_jBackMouseClicked

    private final jHomePage _jHomePage;


    private void JCreateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCreateCustomerActionPerformed
     
             
    }//GEN-LAST:event_JCreateCustomerActionPerformed
    
    private Role _jRole;
    //private final jMainPage _jMainPage;
    //private final jViewRoles _jViewRoles;
    private final RoleServices _RoleServices;
    private final JPanel _parent;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox JCreateCustomer;
    private javax.swing.JCheckBox JDeleteCustomer;
    private javax.swing.JCheckBox JviewLogs;
    private javax.swing.JButton jBack;
    private javax.swing.JLabel jChosedPermissions;
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
