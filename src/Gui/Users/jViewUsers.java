package Gui.Users;

import Entities.Customer;
import Entities.User;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.UserServices;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.table.DefaultTableModel;
import utils.FilterUsers;

public class jViewUsers extends javax.swing.JPanel {
    private final jMainPage _jMainPage;
    private final jHomePage _jHomePage;
    
    
    public jViewUsers(jHomePage jhp , jMainPage jmp) {
        initComponents();
        _jHomePage = jhp;
        _jMainPage = jmp;
        _UserServices = new UserServices(); 
        _filterUsers = new FilterUsers();
        _jSignUpPage = new jNewUsers(jhp , jmp );
        _jViewUser = new jViewUser(this , jhp );

        toggle = false;
    }
    public void renderData() { 
        String[] cols = {"ID","Name", "User Name", "Role"}; 
        DefaultTableModel m = (DefaultTableModel) jUsersTable.getModel();
            m.setColumnIdentifiers(cols);
            m.setRowCount(0);
        ArrayList<User> users = _UserServices.getAll(); 
        if(!users.isEmpty()) { 
            String searchName = jSearchField.getText(); 
            String sortBy = (String) jSortByCombo.getSelectedItem();
            ArrayList<User> filteredUsers = _filterUsers.filter(users, searchName,sortBy , toggle ); 
            if(!filteredUsers.isEmpty()){ 
                for(int i=0;i<filteredUsers.size();i++) { 
                    User user = filteredUsers.get(i); 
                    Object[] objs = {user.id, user.name, user.userName, user.role.name}; 
                    m.addRow(objs); 
                }  
            } 
        } 
    }
    private void deleteUser(){
            DefaultTableModel m = (DefaultTableModel) jUsersTable.getModel();
              if(jUsersTable.getSelectedRow() != -1) {
                UUID id = (UUID) m.getValueAt(jUsersTable.getSelectedRow(), 0);
                String username = (String) m.getValueAt(jUsersTable.getSelectedRow(), 1);
                _jHomePage.createLog("Deleted", "User", username);
                m.removeRow(jUsersTable.getSelectedRow());
                _UserServices.delete(id);
                jDeleteMessage.setText("Deleted Successfully");
              }
    }
    private User selectedUser(){ 
        DefaultTableModel m = (DefaultTableModel) jUsersTable.getModel();
            if(jUsersTable.getSelectedRow() != -1){
                UUID id = (UUID) m.getValueAt(jUsersTable.getSelectedRow(), 0);
               return  _UserServices.getById(id);
        }
            else return null;

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jAddButton = new javax.swing.JButton();
        jDeleteButton = new javax.swing.JButton();
        jToggleSort = new javax.swing.JButton();
        jSortByCombo = new javax.swing.JComboBox<>();
        jAllItemsLabel = new javax.swing.JLabel();
        jShowButton = new javax.swing.JButton();
        jSearchLabel = new javax.swing.JLabel();
        jSearchField = new javax.swing.JTextField();
        jSortLabel = new javax.swing.JLabel();
        jBackButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jUsersTable = new javax.swing.JTable();
        jDeleteMessage = new javax.swing.JLabel();

        jAddButton.setText("Add User");
        jAddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddButtonMouseClicked(evt);
            }
        });

        jDeleteButton.setText("Delete");
        jDeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDeleteButtonMouseClicked(evt);
            }
        });

        jToggleSort.setText("↓↑\n");
        jToggleSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleSortMouseClicked(evt);
            }
        });

        jSortByCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Role" }));
        jSortByCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSortByComboActionPerformed(evt);
            }
        });

        jAllItemsLabel.setText("All Items :");

        jShowButton.setText("Show User");
        jShowButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jShowButtonMouseClicked(evt);
            }
        });

        jSearchLabel.setText("Search:");

        jSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jSearchFieldKeyTyped(evt);
            }
        });

        jSortLabel.setText("Sort by :");

        jBackButton.setText("Back");
        jBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackButtonMouseClicked(evt);
            }
        });

        jUsersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jUsersTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jAllItemsLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSortLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSearchLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jSortByCombo, 0, 218, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jToggleSort, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSearchField)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDeleteMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jBackButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDeleteButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jShowButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jAddButton))))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSearchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSortByCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSortLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleSort))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAllItemsLabel)
                    .addComponent(jDeleteMessage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAddButton)
                    .addComponent(jDeleteButton)
                    .addComponent(jBackButton)
                    .addComponent(jShowButton))
                .addGap(63, 63, 63))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackButtonMouseClicked
        _jHomePage.switchPanels(_jMainPage);
    }//GEN-LAST:event_jBackButtonMouseClicked

    private void jDeleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDeleteButtonMouseClicked
        if(_jMainPage.canDeleteUser()) {
            deleteUser();
        }
    }//GEN-LAST:event_jDeleteButtonMouseClicked

    private void jSortByComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSortByComboActionPerformed
        renderData();
    }//GEN-LAST:event_jSortByComboActionPerformed

    private void jSearchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSearchFieldKeyTyped
        renderData();
    }//GEN-LAST:event_jSearchFieldKeyTyped

    private void jToggleSortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleSortMouseClicked
        toggle = !toggle;
        renderData();
    }//GEN-LAST:event_jToggleSortMouseClicked

    private void jShowButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jShowButtonMouseClicked
        User user = selectedUser();
         if (user!=null)
         { 
            _jViewUser.choosedUser = user;
            _jViewUser.renderData();
            _jViewUser.removeUpdateANdCancelButtons();
            _jViewUser.disableUserFields();
            _jHomePage.switchPanels(_jViewUser);
         }
    }//GEN-LAST:event_jShowButtonMouseClicked

    private void jAddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddButtonMouseClicked
        if(_jMainPage.canCreateUser()) {
            _jHomePage.switchPanels(_jSignUpPage);
            _jSignUpPage.jNameField.grabFocus();
        }
    }//GEN-LAST:event_jAddButtonMouseClicked

    private boolean toggle ;
    private final UserServices _UserServices;
    private final FilterUsers _filterUsers;
    private final jNewUsers _jSignUpPage;
    private final jViewUser _jViewUser;
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jAddButton;
    private javax.swing.JLabel jAllItemsLabel;
    private javax.swing.JButton jBackButton;
    public javax.swing.JButton jDeleteButton;
    private javax.swing.JLabel jDeleteMessage;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jSearchField;
    private javax.swing.JLabel jSearchLabel;
    private javax.swing.JButton jShowButton;
    private javax.swing.JComboBox<String> jSortByCombo;
    private javax.swing.JLabel jSortLabel;
    private javax.swing.JButton jToggleSort;
    private javax.swing.JTable jUsersTable;
    // End of variables declaration//GEN-END:variables
}
