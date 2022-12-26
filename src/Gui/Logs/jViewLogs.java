package Gui.Logs;

import Entities.Log;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.LogServices;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JOptionPane;
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
   public void changecolor(java.awt.Color c1,java.awt.Color c2,java.awt.Color c3,java.awt.Color c4,java.awt.Color c5)
    {
    // setBackground(c);
//         private javax.swing.JButton jBack;
   //  jBack.setBackground(c2);
     //   jBack.setForeground(c4);
//    private javax.swing.JButton jDelete;
//    private javax.swing.JLabel jLabel1;
//    private javax.swing.JLabel jLabel2;
//    private javax.swing.JLabel jLabel3;
//    private javax.swing.JTextArea jLogDetails;
//    private javax.swing.JTable jLogsTable;
//    private javax.swing.JScrollPane jScrollPane1;
//    private javax.swing.JScrollPane jScrollPane3;
//    public javax.swing.JTextField jSearchField;
//    private javax.swing.JComboBox<String> jSortByCombo;
//    private javax.swing.JButton jToggleSort;
   }
   
    public void renderData() { 
        String[] cols = {"ID","UserName", "Action", "Acted On" ,"Date"}; 
        DefaultTableModel model = (DefaultTableModel) jLogsTable.getModel();
        model.setColumnIdentifiers(cols);
        model.setRowCount(0);
        ArrayList<Log> logs = _LogServices.getAll();
        allLogs = logs;
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
    public void updateData() {
        String[] cols = {"ID","UserName", "Action", "Acted On" ,"Date"}; 
        DefaultTableModel model = (DefaultTableModel) jLogsTable.getModel();
        model.setColumnIdentifiers(cols);
        model.setRowCount(0);
        ArrayList<Log> logs = allLogs;
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
            int answer = JOptionPane.showConfirmDialog(null, "Are you Sure you want to delete this Log?");
            if(answer == JOptionPane.YES_OPTION) {
                m.removeRow(jLogsTable.getSelectedRow());
                _LogServices.deleteLog(id);
                JOptionPane.showMessageDialog(null, "Deleted Successfully!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please Select a Log to be Deleted!");
        }
        renderData();
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
        jToggleSort = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLogDetails = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLogsTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(87, 118, 130));
        setForeground(new java.awt.Color(87, 118, 130));

        jBack.setBackground(new java.awt.Color(217, 156, 69));
        jBack.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jBack.setForeground(new java.awt.Color(255, 255, 255));
        jBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Logs/back.png"))); // NOI18N
        jBack.setMnemonic('b');
        jBack.setText("   Back  ");
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

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search :");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SortBy:");

        jSortByCombo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jSortByCombo.setForeground(new java.awt.Color(0, 31, 78));
        jSortByCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User Name", "Action", "Acted On", "Date" }));
        jSortByCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSortByComboMouseClicked(evt);
            }
        });

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

        jDelete.setBackground(new java.awt.Color(217, 156, 69));
        jDelete.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jDelete.setForeground(new java.awt.Color(255, 255, 255));
        jDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Logs/delete.png"))); // NOI18N
        jDelete.setMnemonic('d');
        jDelete.setText("   Delete  ");
        jDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDeleteMouseClicked(evt);
            }
        });
        jDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteActionPerformed(evt);
            }
        });

        jToggleSort.setBackground(new java.awt.Color(217, 156, 69));
        jToggleSort.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jToggleSort.setForeground(new java.awt.Color(255, 255, 255));
        jToggleSort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Logs/sort3.png"))); // NOI18N
        jToggleSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleSortMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Details:");

        jLogDetails.setColumns(20);
        jLogDetails.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLogDetails.setForeground(new java.awt.Color(0, 31, 78));
        jLogDetails.setRows(5);
        jScrollPane1.setViewportView(jLogDetails);

        jLogsTable.setBackground(new java.awt.Color(217, 156, 69));
        jLogsTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLogsTable.setForeground(new java.awt.Color(255, 255, 255));
        jLogsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jLogsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLogsTable.setGridColor(new java.awt.Color(0, 31, 78));
        jLogsTable.setOpaque(false);
        jLogsTable.setSelectionBackground(new java.awt.Color(87, 118, 130));
        jLogsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLogsTableMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(jLogsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jSortByCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jToggleSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jLabel3))
                        .addGap(0, 69, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSortByCombo)
                            .addComponent(jToggleSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        _jHomePage.switchPanels(_jMainPage);
        _jMainPage.jLog.grabFocus();
    }//GEN-LAST:event_jBackMouseClicked

    private void jDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDeleteMouseClicked
        delete();
    }//GEN-LAST:event_jDeleteMouseClicked

    private void jToggleSortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleSortMouseClicked
        toggle = !toggle;
        updateData();
    }//GEN-LAST:event_jToggleSortMouseClicked

    private void jSearchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSearchFieldKeyTyped
        updateData();
    }//GEN-LAST:event_jSearchFieldKeyTyped


    private void jSearchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchFieldMouseClicked
        
    }//GEN-LAST:event_jSearchFieldMouseClicked

    private void jSortByComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSortByComboMouseClicked
        
    }//GEN-LAST:event_jSortByComboMouseClicked

    private void jLogsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogsTableMousePressed
         showLogDetails(getSelectedLog());
    }//GEN-LAST:event_jLogsTableMousePressed

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
       _jHomePage.switchPanels(_jMainPage);
        _jMainPage.jLog.grabFocus();
    }//GEN-LAST:event_jBackActionPerformed

    private void jDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteActionPerformed
        delete();
    }//GEN-LAST:event_jDeleteActionPerformed

    
    private ArrayList<Log> allLogs;
    private boolean toggle ;
    private final FilterLogs _FilterLogs;
    private final LogServices _LogServices;
    private final jMainPage _jMainPage;
    private final jHomePage _jHomePage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBack;
    private javax.swing.JButton jDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextArea jLogDetails;
    private javax.swing.JTable jLogsTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTextField jSearchField;
    private javax.swing.JComboBox<String> jSortByCombo;
    private javax.swing.JButton jToggleSort;
    // End of variables declaration//GEN-END:variables
}
