package Gui.Logs;

import Entities.Log;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.LogServices;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.table.DefaultTableModel;
import utils.FilterLogs;

public class jViewLogs extends javax.swing.JPanel {

    public jViewLogs(jHomePage jhp, jMainPage jmp) {
        initComponents();
        _jHomePage = jhp;
        _jMainPage = jmp;
        _LogServices = new LogServices();
        _FilterLogs = new FilterLogs();

        jLogDetails.setEditable(false);
    }
    public void renderData() { 
        String[] cols = {"ID","UserName", "Action", "Acted On" ,"Date"}; 
        DefaultTableModel model = (DefaultTableModel) jLogsTable.getModel();
        model.setColumnIdentifiers(cols);
        model.setRowCount(0);
        ArrayList<Log> logs = _LogServices.getAll();
        if(!logs.isEmpty()) { 
            String searchName = jSearchField.getText();
            String sortBy = (String) jSortByCombo.getSelectedItem();
            ArrayList<Log> filteredLogs = _FilterLogs.filter(logs, searchName,sortBy , toggle ); 
            if(!filteredLogs.isEmpty()){ 
                for(int i=0;i<filteredLogs.size();i++) { 
                    Log log = filteredLogs.get(i); 
                    Object[] objs = { log.id, log.userName, log.action, log.actedOn, log.date }; 
                    model.addRow(objs); 
                }  
            } 
        } 
    }  
    public void delete(){
        DefaultTableModel m = (DefaultTableModel) jLogsTable.getModel();
          if(jLogsTable.getSelectedRow() != -1) {
            UUID id = (UUID) m.getValueAt(jLogsTable.getSelectedRow(), 0);
            m.removeRow(jLogsTable.getSelectedRow());
             _LogServices.deleteLog(id);
             jDeleteMessage.setText("Deleted Successfully");
        }else{
              jDeleteMessage.setText("Error! Please Select Log");}
    }
    public Log getSelectedLog(){
        int row = jLogsTable.getSelectedRow();//check ! -1
        if(row!=-1){
            //jErrorShowLog.setText("");
            UUID choosedLogId = (UUID)(jLogsTable.getModel().getValueAt(row, 0));
            Log choosedLog = _LogServices.getById(choosedLogId);
            return choosedLog;
        }
        return null;
    }
    public void showLogDetails( Log log){
        jLogDetails.setText("Name : " + log.userName + "\nRole : " + log.userRole +"\nAction : " + log.action + " " +log.actedOn + " (" + log.actedOnName + ") " +" at " + log.date +" ." );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSortByCombo = new javax.swing.JComboBox<>();
        jSearchField = new javax.swing.JTextField();
        jDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLogsTable = new javax.swing.JTable();
        jToggleSort = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLogDetails = new javax.swing.JTextArea();
        jDeleteMessage = new javax.swing.JLabel();

        jBack.setText("Back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        jLabel1.setText("Search :");

        jLabel2.setText("SortBy:");

        jSortByCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User Name", "Action", "Acted On", "Date" }));
        jSortByCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSortByComboMouseClicked(evt);
            }
        });

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

        jDelete.setText("Delete");
        jDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDeleteMouseClicked(evt);
            }
        });

        jLogsTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLogsTable.setForeground(new java.awt.Color(0, 0, 0));
        jLogsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "User Name", "Action", "Acted On", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jLogsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLogsTableMouseClicked(evt);
            }
        });
        jLogsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLogsTableKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jLogsTable);

        jToggleSort.setText("↓↑\n");
        jToggleSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleSortMouseClicked(evt);
            }
        });

        jLabel3.setText("Details:");

        jLogDetails.setColumns(20);
        jLogDetails.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLogDetails.setRows(5);
        jScrollPane1.setViewportView(jLogDetails);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jSortByCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToggleSort, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jDeleteMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSortByCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleSort))
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBack)
                    .addComponent(jDelete))
                .addGap(10, 10, 10)
                .addComponent(jDeleteMessage))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        _jHomePage.switchPanels(_jMainPage);
        _jMainPage.jLog.grabFocus();
        jDeleteMessage.setText("");
    }//GEN-LAST:event_jBackMouseClicked

    private void jDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDeleteMouseClicked
        delete();
    }//GEN-LAST:event_jDeleteMouseClicked

    private void jToggleSortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleSortMouseClicked
        toggle = !toggle;
        renderData();
        jDeleteMessage.setText("");
    }//GEN-LAST:event_jToggleSortMouseClicked

    private void jLogsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogsTableMouseClicked
        showLogDetails(getSelectedLog());
    }//GEN-LAST:event_jLogsTableMouseClicked

    private void jSearchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSearchFieldKeyTyped
        renderData();
    }//GEN-LAST:event_jSearchFieldKeyTyped


    private void jSearchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchFieldMouseClicked
        jDeleteMessage.setText("");
    }//GEN-LAST:event_jSearchFieldMouseClicked

    private void jSortByComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSortByComboMouseClicked
        jDeleteMessage.setText("");
    }//GEN-LAST:event_jSortByComboMouseClicked

    private void jLogsTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLogsTableKeyPressed
        showLogDetails(getSelectedLog());
    }//GEN-LAST:event_jLogsTableKeyPressed

    
   
    private boolean toggle ;
    private final FilterLogs _FilterLogs;
    private final LogServices _LogServices;
    private final jMainPage _jMainPage;
    private final jHomePage _jHomePage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBack;
    private javax.swing.JButton jDelete;
    private javax.swing.JLabel jDeleteMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextArea jLogDetails;
    private javax.swing.JTable jLogsTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextField jSearchField;
    private javax.swing.JComboBox<String> jSortByCombo;
    private javax.swing.JButton jToggleSort;
    // End of variables declaration//GEN-END:variables
}
