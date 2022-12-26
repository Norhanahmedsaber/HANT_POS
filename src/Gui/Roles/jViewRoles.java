package Gui.Roles;

import Entities.Role;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.RoleServices;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import utils.filterRoles;

public class jViewRoles extends javax.swing.JPanel {

    public jViewRoles(jHomePage jhp, JPanel parent, jNewRole jnr) {
        initComponents();
        _jHomePage = jhp;
        _parent= parent;  
        _RoleServices = new RoleServices();
        _jNewRole = jnr;
        _filterRoles = new filterRoles();
    }
    
     
     public void changecolor(java.awt.Color c1,java.awt.Color c2,java.awt.Color c3,java.awt.Color c4,java.awt.Color c5)
    { 
        setBackground(c1);
        jBack.setBackground(c2);
        jBack.setForeground(c4);
        jComboBox1.setBackground(c5);
        jEdit.setBackground(c2);
        jEdit.setForeground(c4);
        jLabel1.setForeground(c3);
        jLabel2.setForeground(c3);
        jRoles.setBackground(c2);
        jScrollPane1.setBackground(c5);
        jSearch.setBackground(c5);
    }
    public void clearViewRoles() {
        jSearch.setText("");
        renderData();
    }
    Role getSelectedRole() {
        String roleName = jRoles.getSelectedValue();
        if(roleName != null){
            Role role = _RoleServices.getByName(roleName);
            return role;
        }
        return null;
    }
    public void renderData() {
        DefaultListModel model = new DefaultListModel();
        ArrayList<String> roleNames = _RoleServices.getAll();
        allRoles = roleNames;
        if(!roleNames.isEmpty()) {
            String searchName = jSearch.getText().trim();
            ArrayList<String> filteredRoles = _filterRoles.filter(roleNames, searchName);
            if(!filteredRoles.isEmpty()) {
                for( String roleName : filteredRoles ) {
                    model.addElement(roleName);
                }
            }
        }
        jRoles.setModel(model);
    }
     public void updateData() {
        DefaultListModel model = new DefaultListModel();
        ArrayList<String> roleNames = allRoles;
        if(!roleNames.isEmpty()) {
            String searchName = jSearch.getText().trim();
            ArrayList<String> filteredRoles = _filterRoles.filter(roleNames, searchName);
            if(!filteredRoles.isEmpty()) {
                for( String roleName : filteredRoles ) {
                    model.addElement(roleName);
                }
            }
        }
        jRoles.setModel(model);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jBack = new javax.swing.JButton();
        jEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jRoles = new javax.swing.JList<>();
        jSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setBackground(new java.awt.Color(87, 118, 130));
        setForeground(new java.awt.Color(255, 255, 255));

        jBack.setBackground(new java.awt.Color(217, 156, 69));
        jBack.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jBack.setForeground(new java.awt.Color(255, 255, 255));
        jBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Roles/back.png"))); // NOI18N
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

        jEdit.setBackground(new java.awt.Color(217, 156, 69));
        jEdit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jEdit.setForeground(new java.awt.Color(255, 255, 255));
        jEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Roles/editing.png"))); // NOI18N
        jEdit.setMnemonic('e');
        jEdit.setText("    Edit  ");
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

        jRoles.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jRoles.setForeground(new java.awt.Color(0, 31, 78));
        jRoles.setSelectionBackground(new java.awt.Color(217, 156, 69));
        jScrollPane1.setViewportView(jRoles);

        jSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jSearchKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Roles Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(350, 350, 350)
                        .addComponent(jEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
       jMainPage MainPage=(jMainPage)_parent;
        clearViewRoles();
        _jHomePage.switchPanels(_parent);
        MainPage.jViewRoles.grabFocus();
        
    }//GEN-LAST:event_jBackMouseClicked

    private void jEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEditMouseClicked
       jMainPage MainPage=(jMainPage)_parent;
            if(MainPage.canUpdateRole()) {
                _jNewRole.DoneButton();
                _jNewRole._jRole = getSelectedRole();
                if(_jNewRole._jRole == null) {
                    JOptionPane.showMessageDialog(null, "Please Select a Role to Edit!");
                    return;
                }
                _jNewRole.renderData();
                _jHomePage.switchPanels(_jNewRole);
            }
    }//GEN-LAST:event_jEditMouseClicked

    private void jSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSearchKeyTyped
        updateData();
    }//GEN-LAST:event_jSearchKeyTyped

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        jMainPage MainPage=(jMainPage)_parent;
        clearViewRoles();
        _jHomePage.switchPanels(_parent);
        MainPage.jViewRoles.grabFocus();
    }//GEN-LAST:event_jBackActionPerformed

    private void jEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditActionPerformed
        jMainPage MainPage=(jMainPage)_parent;
            if(MainPage.canUpdateRole()) {
                _jNewRole.DoneButton();
                _jNewRole._jRole = getSelectedRole();
                if(_jNewRole._jRole == null) {
                    JOptionPane.showMessageDialog(null, "Please Select a Role to Edit!");
                    return;
                }
                _jNewRole.renderData();
                _jHomePage.switchPanels(_jNewRole);
            }
    }//GEN-LAST:event_jEditActionPerformed
    private ArrayList<String> allRoles;
    private jNewRole _jNewRole;
    private filterRoles _filterRoles;
    private RoleServices _RoleServices;
    private jHomePage _jHomePage;
    private final JPanel _parent;
    private jMainPage _jMainPage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBack;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JButton jEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jRoles;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField jSearch;
    // End of variables declaration//GEN-END:variables
}
