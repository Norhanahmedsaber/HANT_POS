package Gui.Users;
import Entities.User;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.UserServices;
import java.awt.Color;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.FilterUsers;

public class jViewUsers extends javax.swing.JPanel {
    private final jMainPage _jMainPage;
    private final jHomePage _jHomePage;
    
    
    public jViewUsers(jHomePage jhp , jMainPage jmp, jNewUsers jnu) {
        initComponents();
        _jHomePage = jhp;
        _jMainPage = jmp;
        _UserServices = new UserServices(); 
        _filterUsers = new FilterUsers();
        _jSignUpPage = jnu;
        _jViewUser = new jViewUser(this , jhp);
        toggle = false;
    }
     
    public void changecolor(java.awt.Color c1,java.awt.Color c2,java.awt.Color c3,java.awt.Color c4,java.awt.Color c5)
    { 
        setBackground(c1);
        jAddButton.setBackground(c2);
        jAddButton.setForeground(c4);
        jAllItemsLabel.setForeground(c3);
        jBackButton.setBackground(c2);
        jBackButton.setForeground(c4);
        jDeleteButton.setBackground(c2);
        jDeleteButton.setForeground(c4);
        jScrollPane3.setBackground(c5);
        jSearchField.setBackground(c5);
        jShowButton.setBackground(c2);
        jShowButton.setForeground(c4);
        jSortByCombo.setBackground(c5);
        jSortLabel.setForeground(c3);
        jToggleSort.setBackground(c2);
        jToggleSort.setForeground(c4);
        jUsersTable.setBackground(c2);
        jsearchLabel.setForeground(c3);
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
                  JOptionPane.showMessageDialog(null, "Deleted Successfully!");
              }else{
              JOptionPane.showMessageDialog(null, "Please Select a User Delete!");
              }
    }
    private User selectedUser(){ 
        DefaultTableModel m = (DefaultTableModel) jUsersTable.getModel();
            if(jUsersTable.getSelectedRow() != -1){
                UUID id = (UUID) m.getValueAt(jUsersTable.getSelectedRow(), 0);
               return  _UserServices.getById(id);
        }
            else {
                JOptionPane.showMessageDialog(null, "Please Select a User to View!");
                return null;
            }

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jAddButton = new javax.swing.JButton();
        jDeleteButton = new javax.swing.JButton();
        jAllItemsLabel = new javax.swing.JLabel();
        jShowButton = new javax.swing.JButton();
        jBackButton = new javax.swing.JButton();
        jsearchLabel = new javax.swing.JLabel();
        jSearchField = new javax.swing.JTextField();
        jSortLabel = new javax.swing.JLabel();
        jSortByCombo = new javax.swing.JComboBox<>();
        jToggleSort = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jUsersTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(87, 118, 130));

        jAddButton.setBackground(new java.awt.Color(217, 156, 69));
        jAddButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jAddButton.setForeground(new java.awt.Color(255, 255, 255));
        jAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Users/addcustomer.png"))); // NOI18N
        jAddButton.setText("   Add User");
        jAddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddButtonMouseClicked(evt);
            }
        });

        jDeleteButton.setBackground(new java.awt.Color(217, 156, 69));
        jDeleteButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jDeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        jDeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Users/delete.png"))); // NOI18N
        jDeleteButton.setText("    Delete  ");
        jDeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDeleteButtonMouseClicked(evt);
            }
        });

        jAllItemsLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jAllItemsLabel.setForeground(new java.awt.Color(255, 255, 255));
        jAllItemsLabel.setText("All Items :");

        jShowButton.setBackground(new java.awt.Color(217, 156, 69));
        jShowButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jShowButton.setForeground(new java.awt.Color(255, 255, 255));
        jShowButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Users/showCustomer.png"))); // NOI18N
        jShowButton.setText("   Show User");
        jShowButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jShowButtonMouseClicked(evt);
            }
        });

        jBackButton.setBackground(new java.awt.Color(217, 156, 69));
        jBackButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jBackButton.setForeground(new java.awt.Color(255, 255, 255));
        jBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Users/back.png"))); // NOI18N
        jBackButton.setText("    Back   ");
        jBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackButtonMouseClicked(evt);
            }
        });

        jsearchLabel.setBackground(new java.awt.Color(255, 255, 255));
        jsearchLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jsearchLabel.setForeground(new java.awt.Color(255, 255, 255));
        jsearchLabel.setText("Search by name :");

        jSearchField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jSearchField.setForeground(new java.awt.Color(0, 31, 78));
        jSearchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSearchFieldMouseClicked(evt);
            }
        });
        jSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jSearchFieldKeyTyped(evt);
            }
        });

        jSortLabel.setBackground(new java.awt.Color(255, 255, 255));
        jSortLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jSortLabel.setForeground(new java.awt.Color(255, 255, 255));
        jSortLabel.setText("Sort by :");

        jSortByCombo.setBackground(new java.awt.Color(217, 156, 69));
        jSortByCombo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jSortByCombo.setForeground(new java.awt.Color(0, 31, 78));
        jSortByCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Role" }));
        jSortByCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jSortByComboItemStateChanged(evt);
            }
        });
        jSortByCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSortByComboMouseClicked(evt);
            }
        });

        jToggleSort.setBackground(new java.awt.Color(217, 156, 69));
        jToggleSort.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jToggleSort.setForeground(new java.awt.Color(255, 255, 255));
        jToggleSort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Users/sort3.png"))); // NOI18N
        jToggleSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleSortMouseClicked(evt);
            }
        });

        jUsersTable.setBackground(new java.awt.Color(217, 156, 69));
        jUsersTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jUsersTable.setForeground(new java.awt.Color(255, 255, 255));
        jUsersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jUsersTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jUsersTable.setGridColor(new java.awt.Color(0, 31, 78));
        jUsersTable.setOpaque(false);
        jUsersTable.setSelectionBackground(new java.awt.Color(87, 118, 130));
        jScrollPane3.setViewportView(jUsersTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jShowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jsearchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSortLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSortByCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jToggleSort, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jAllItemsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsearchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSortByCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleSort, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSortLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jAllItemsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jShowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackButtonMouseClicked
        _jHomePage.switchPanels(_jMainPage);
        _jMainPage.jViewusers.grabFocus();
    }//GEN-LAST:event_jBackButtonMouseClicked

    private void jDeleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDeleteButtonMouseClicked
        if(_jMainPage.canDeleteUser()) {
            deleteUser();
        }
    }//GEN-LAST:event_jDeleteButtonMouseClicked

    private void jShowButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jShowButtonMouseClicked
        User user = selectedUser();
         if (user!=null)
         { 
            _jViewUser.choosedUser = user;
            _jViewUser.renderData();
            _jViewUser.removeUpdateANdCancelButtons();
            _jViewUser.disableUserFields();
            _jViewUser.jRolesCombo.selectWithKeyChar(user.role.name.charAt(0));
            _jHomePage.switchPanels(_jViewUser);
            _jViewUser.jNameField.grabFocus();
         }
    }//GEN-LAST:event_jShowButtonMouseClicked

    private void jAddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddButtonMouseClicked
        if(_jMainPage.canCreateUser()) {
            _jHomePage.switchPanels(_jSignUpPage);
            _jSignUpPage.jNameField.grabFocus();
        }
        
    }//GEN-LAST:event_jAddButtonMouseClicked

    private void jSearchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchFieldMouseClicked
       
    }//GEN-LAST:event_jSearchFieldMouseClicked

    private void jSearchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSearchFieldKeyTyped
        renderData();
    }//GEN-LAST:event_jSearchFieldKeyTyped

    private void jSortByComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSortByComboMouseClicked
        
    }//GEN-LAST:event_jSortByComboMouseClicked

    private void jToggleSortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleSortMouseClicked
        // TODO add your handling code here:
        toggle = !toggle;
        renderData();
    }//GEN-LAST:event_jToggleSortMouseClicked

    private void jSortByComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jSortByComboItemStateChanged
        renderData();
    }//GEN-LAST:event_jSortByComboItemStateChanged

    private boolean toggle ;
    private final UserServices _UserServices;
    private final FilterUsers _filterUsers;
    private final jNewUsers _jSignUpPage;
    public final jViewUser _jViewUser;
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jAddButton;
    private javax.swing.JLabel jAllItemsLabel;
    private javax.swing.JButton jBackButton;
    public javax.swing.JButton jDeleteButton;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTextField jSearchField;
    private javax.swing.JButton jShowButton;
    private javax.swing.JComboBox<String> jSortByCombo;
    private javax.swing.JLabel jSortLabel;
    private javax.swing.JButton jToggleSort;
    private javax.swing.JTable jUsersTable;
    private javax.swing.JLabel jsearchLabel;
    // End of variables declaration//GEN-END:variables
}
