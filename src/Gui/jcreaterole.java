package Gui;
import Entities.Role;
import Services.RoleServices;
public class jcreaterole extends javax.swing.JPanel {

    public jcreaterole(jHomePage jhp,jMainPage jmp) {
        initComponents();
        _jRole=new Role();
        _jHomePage=jhp;
        _jMainPage=jmp;
        _RoleServices =new RoleServices();
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
       Role role=new Role();
       role.name=jRoleNameField.getText();
       role.canCreateCustomer=JCreateCustomer.isSelected();
       role.canCreateItem=jCreateItem.isSelected();
       role.canCreateLog=jCreateLogs.isSelected();
       role.canCreateUser=jCreateUser.isSelected();
       role.canDeleteCustomer=JDeleteCustomer.isSelected();
       role.canDeleteItem=jDeleteItem.isSelected();
       role.canUpdateCustomer=jUpdateCustomer.isSelected();
       role.canUpdateItem=jUpdateItem.isSelected();
       role.canViewCustomers=jViewCustomer.isSelected();
       role.canViewItems=jViewItem.isSelected();
       role.canViewLogs=JviewLogs.isSelected();
       role.canViewUsers=jViewUser.isSelected();  
       _RoleServices.create(role);    
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

        jDone.setText("Create");
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBack)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JDeleteCustomer)
                            .addComponent(jViewCustomer)
                            .addComponent(JCreateCustomer)
                            .addComponent(jUpdateCustomer)
                            .addComponent(jCreateItem)
                            .addComponent(jViewItem)
                            .addComponent(jRoleNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jChosedPermissions, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
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
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jDone)
                                        .addComponent(jCreateLogs)))
                                .addContainerGap())))))
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
                    .addComponent(jDone))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jDoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDoneMouseClicked
        assighnPermissions();
        jChosedPermissions.setText("Permissions are assigned successfully");
        clearCreateRolePage();
    }//GEN-LAST:event_jDoneMouseClicked

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
       _jHomePage.switchPanels(_jMainPage);
       jChosedPermissions.setText("");
       clearCreateRolePage();
    }//GEN-LAST:event_jBackMouseClicked
    private final jHomePage _jHomePage;
    private Role _jRole;
    private final jMainPage _jMainPage;
    private final RoleServices _RoleServices;
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
