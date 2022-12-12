package Gui.Roles;

import Entities.Role;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.RoleServices;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import utils.filterRoles;

public class jViewRoles extends javax.swing.JPanel {

    public jViewRoles(jHomePage jhp, JPanel parent) {
        initComponents();
        _jHomePage = jhp;
        _parent= parent;  
        _RoleServices = new RoleServices();
        _jNewRole = new jNewRole(jhp, this);
        _filterRoles = new filterRoles();
    }
    public void clearViewRoles() {
        jSearch.setText("");
        renderData();
    }
    public void renderData() {
        DefaultListModel model = new DefaultListModel();
        ArrayList<Role> roles = _RoleServices.getAll();
        if(!roles.isEmpty()) {
            String searchName = jSearch.getText().trim();
            ArrayList<Role> filteredRoles = _filterRoles.filter(roles, searchName);
            if(!filteredRoles.isEmpty()) {
                for( Role role : roles ) {
                    model.addElement(role.name);
                }
            }
        }
        jRoles.setModel(model);
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBack = new javax.swing.JButton();
        jEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jRoles = new javax.swing.JList<>();
        jSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jBack.setText("Back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        jEdit.setText("Edit");
        jEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEditMouseClicked(evt);
            }
        });

        jRoles.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jRoles.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jRoles);

        jSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jSearchKeyTyped(evt);
            }
        });

        jLabel1.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jEdit)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBack)
                    .addComponent(jEdit))
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
       jMainPage MainPage=(jMainPage)_parent;
        clearViewRoles();
        _jHomePage.switchPanels(_parent);
    }//GEN-LAST:event_jBackMouseClicked

    private void jEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEditMouseClicked
       jMainPage MainPage=(jMainPage)_parent;
            if(MainPage.canUpdateRole()) {
            _jNewRole.DoneButton();
            _jHomePage.switchPanels(_jNewRole);
           
        }
    }//GEN-LAST:event_jEditMouseClicked

    private void jSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSearchKeyTyped
        renderData();
    }//GEN-LAST:event_jSearchKeyTyped
    private jNewRole _jNewRole;
    private filterRoles _filterRoles;
    private RoleServices _RoleServices;
    private jHomePage _jHomePage;
    private final JPanel _parent;
    private jMainPage _jMainPage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBack;
    private javax.swing.JButton jEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jRoles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSearch;
    // End of variables declaration//GEN-END:variables
}
