package Gui.Users;
import Entities.User;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.UserServices;
import java.awt.Color;
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
        _jSignUpPage = new jNewUsers(jhp , jmp);
        _jViewUser = new jViewUser(this , jhp);
        toggle = false;
    }
     public void changecolor(int x, int y ,int z)
    { 
        setBackground(new java.awt.Color(x, y, z));
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
              }else{
              jDeleteMessage.setText("Error! Please Select User");}
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
        jAllItemsLabel = new javax.swing.JLabel();
        jShowButton = new javax.swing.JButton();
        jBackButton = new javax.swing.JButton();
        jDeleteMessage = new javax.swing.JLabel();
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
        jAddButton.setText("Add User");
        jAddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddButtonMouseClicked(evt);
            }
        });

        jDeleteButton.setBackground(new java.awt.Color(217, 156, 69));
        jDeleteButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jDeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        jDeleteButton.setText("Delete");
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
        jShowButton.setText("Show User");
        jShowButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jShowButtonMouseClicked(evt);
            }
        });

        jBackButton.setBackground(new java.awt.Color(217, 156, 69));
        jBackButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jBackButton.setForeground(new java.awt.Color(255, 255, 255));
        jBackButton.setText("Back");
        jBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackButtonMouseClicked(evt);
            }
        });

        jDeleteMessage.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jDeleteMessage.setForeground(new java.awt.Color(51, 255, 0));

        jsearchLabel.setBackground(new java.awt.Color(255, 255, 255));
        jsearchLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jsearchLabel.setForeground(new java.awt.Color(255, 255, 255));
        jsearchLabel.setText("search by name :");

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
        jSortByCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSortByComboMouseClicked(evt);
            }
        });

        jToggleSort.setBackground(new java.awt.Color(217, 156, 69));
        jToggleSort.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jToggleSort.setForeground(new java.awt.Color(255, 255, 255));
        jToggleSort.setText("↓↑\n");
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
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jShowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jsearchLabel)
                            .addComponent(jSortLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSortByCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleSort))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jAllItemsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDeleteMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsearchLabel)
                    .addComponent(jSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSortByCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleSort)
                    .addComponent(jSortLabel))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAllItemsLabel)
                    .addComponent(jDeleteMessage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jShowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackButtonMouseClicked
        _jHomePage.switchPanels(_jMainPage);
        _jMainPage.jViewusers.grabFocus();
        jDeleteMessage.setText("");
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
         jDeleteMessage.setText("");
    }//GEN-LAST:event_jShowButtonMouseClicked

    private void jAddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddButtonMouseClicked
        if(_jMainPage.canCreateUser()) {
            _jHomePage.switchPanels(_jSignUpPage);
            _jSignUpPage.jNameField.grabFocus();
        }
        jDeleteMessage.setText("");
    }//GEN-LAST:event_jAddButtonMouseClicked

    private void jSearchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchFieldMouseClicked
        jDeleteMessage.setText("");
    }//GEN-LAST:event_jSearchFieldMouseClicked

    private void jSearchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSearchFieldKeyTyped
        renderData();
    }//GEN-LAST:event_jSearchFieldKeyTyped

    private void jSortByComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSortByComboMouseClicked
        jDeleteMessage.setText("");
    }//GEN-LAST:event_jSortByComboMouseClicked

    private void jToggleSortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleSortMouseClicked
        // TODO add your handling code here:
        toggle = !toggle;
        renderData();
        jDeleteMessage.setText("");
    }//GEN-LAST:event_jToggleSortMouseClicked

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
