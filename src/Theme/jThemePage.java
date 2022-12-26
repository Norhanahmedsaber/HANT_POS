
package Theme;
import Gui.ThemeF;
import Gui.jHomePage;
import java.awt.Color;

public class jThemePage extends javax.swing.JPanel {


    public jThemePage(ThemeF tf) {
        initComponents();
        _ThemeF = tf;
    }
    public  void changecolor(java.awt.Color c1, java.awt.Color c2, java.awt.Color c3, java.awt.Color c4, java.awt.Color c5){
        setBackground(c1);
        jBachgroundButton.setBackground(c2);
        jButtonBackgroundButton.setBackground(c2);
        jButtonForgroundButton.setBackground(c2);
        jLabelButton.setBackground(c2);
        jTextFieldButton.setBackground(c2);
        jSaveButton.setBackground(c2);
        jCancelButton.setBackground(c2);
        jExitButton.setBackground(c2);
        jColorChooser.setBackground(c1);
        
        jBachgroundButton.setForeground(c4);
        jButtonBackgroundButton.setForeground(c4);
        jButtonForgroundButton.setForeground(c4);
        jLabelButton.setForeground(c4);
        jTextFieldButton.setForeground(c4);
        jSaveButton.setForeground(c4);
        jCancelButton.setForeground(c4);
        jExitButton.setForeground(c4);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton = new javax.swing.JButton();
        jLabel = new javax.swing.JLabel();
        jTextField = new javax.swing.JTextField();
        jRadioButton = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jCheckBox = new javax.swing.JCheckBox();
        jComboBox = new javax.swing.JComboBox<>();
        jButtonBackgroundButton = new javax.swing.JButton();
        jBachgroundButton = new javax.swing.JButton();
        jButtonForgroundButton = new javax.swing.JButton();
        jLabelButton = new javax.swing.JButton();
        jTextFieldButton = new javax.swing.JButton();
        jColorChooser = new javax.swing.JColorChooser();
        jSaveButton = new javax.swing.JButton();
        jCancelButton = new javax.swing.JButton();
        jExitButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(87, 118, 130));

        jButton.setText("Button");

        jLabel.setText("Label");

        jTextField.setText("TextField");

        jRadioButton.setText("Radio Button");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"hant", "bouns"},
                {"hadeer", "<3"}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        jCheckBox.setText("Check Box");

        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Combo Box", " ", " ", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jButtonBackgroundButton.setBackground(new java.awt.Color(217, 156, 69));
        jButtonBackgroundButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButtonBackgroundButton.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBackgroundButton.setMnemonic('u');
        jButtonBackgroundButton.setText("Button");
        jButtonBackgroundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackgroundButtonActionPerformed(evt);
            }
        });

        jBachgroundButton.setBackground(new java.awt.Color(217, 156, 69));
        jBachgroundButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jBachgroundButton.setForeground(new java.awt.Color(255, 255, 255));
        jBachgroundButton.setMnemonic('b');
        jBachgroundButton.setText("Background");
        jBachgroundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBachgroundButtonActionPerformed(evt);
            }
        });

        jButtonForgroundButton.setBackground(new java.awt.Color(217, 156, 69));
        jButtonForgroundButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButtonForgroundButton.setForeground(new java.awt.Color(255, 255, 255));
        jButtonForgroundButton.setMnemonic('o');
        jButtonForgroundButton.setText("Button Text");
        jButtonForgroundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForgroundButtonActionPerformed(evt);
            }
        });

        jLabelButton.setBackground(new java.awt.Color(217, 156, 69));
        jLabelButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelButton.setForeground(new java.awt.Color(255, 255, 255));
        jLabelButton.setMnemonic('l');
        jLabelButton.setText("Label");
        jLabelButton.setToolTipText("");
        jLabelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLabelButtonActionPerformed(evt);
            }
        });

        jTextFieldButton.setBackground(new java.awt.Color(217, 156, 69));
        jTextFieldButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jTextFieldButton.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldButton.setMnemonic('t');
        jTextFieldButton.setText("TextField &Table");
        jTextFieldButton.setActionCommand("TextField / Table");
        jTextFieldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldButtonActionPerformed(evt);
            }
        });

        jColorChooser.setBackground(new java.awt.Color(87, 118, 130));

        jSaveButton.setBackground(new java.awt.Color(217, 156, 69));
        jSaveButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jSaveButton.setForeground(new java.awt.Color(255, 255, 255));
        jSaveButton.setMnemonic('s');
        jSaveButton.setText("Save");
        jSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveButtonActionPerformed(evt);
            }
        });

        jCancelButton.setBackground(new java.awt.Color(217, 156, 69));
        jCancelButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jCancelButton.setForeground(new java.awt.Color(255, 255, 255));
        jCancelButton.setMnemonic('r');
        jCancelButton.setText("Reset Default");
        jCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelButtonActionPerformed(evt);
            }
        });

        jExitButton.setBackground(new java.awt.Color(217, 156, 69));
        jExitButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jExitButton.setForeground(new java.awt.Color(255, 255, 255));
        jExitButton.setMnemonic('e');
        jExitButton.setText("Exit");
        jExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonBackgroundButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonForgroundButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBachgroundButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBachgroundButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButtonBackgroundButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButtonForgroundButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jTextFieldButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBachgroundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBachgroundButtonActionPerformed
        c1 = jColorChooser.getColor();
        jPanel1.setBackground(c1);
    }//GEN-LAST:event_jBachgroundButtonActionPerformed

    private void jLabelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLabelButtonActionPerformed
        c3 = jColorChooser.getColor();
        jLabel.setForeground(c3);
        jRadioButton.setForeground(c3);
        jCheckBox.setForeground(c3);
    }//GEN-LAST:event_jLabelButtonActionPerformed

    private void jButtonBackgroundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackgroundButtonActionPerformed
        
        c2 = jColorChooser.getColor();
        jButton.setBackground(c2);
    }//GEN-LAST:event_jButtonBackgroundButtonActionPerformed

    private void jButtonForgroundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForgroundButtonActionPerformed
        
        c4 = jColorChooser.getColor();
        
        jTable.setForeground(c4);
        jButton.setForeground(c4);
    }//GEN-LAST:event_jButtonForgroundButtonActionPerformed

    private void jTextFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldButtonActionPerformed
        
        c5 = jColorChooser.getColor();
        jTextField.setBackground(c5);
        jTable.setBackground(c5);
        jComboBox.setBackground(c5);
    }//GEN-LAST:event_jTextFieldButtonActionPerformed

    private void jSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveButtonActionPerformed
        _ThemeF.saveColor(c1, c2, c3, c4, c5);
    }//GEN-LAST:event_jSaveButtonActionPerformed

    private void jCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelButtonActionPerformed
        c1=new java.awt.Color(242,242,242);
        c2=new java.awt.Color(255,255,255);
        c3=new java.awt.Color(0,0,0);
        c4=new java.awt.Color(0,0,0);
        c5=new java.awt.Color(255,255,255);
        jPanel1.setBackground(c1);
        jLabel.setForeground(c3);
        jRadioButton.setForeground(c3);
        jCheckBox.setForeground(c3);
        jButton.setBackground(c2);
        jButton.setForeground(c4);
        jTextField.setBackground(c5);
        jTable.setBackground(c5);
        jComboBox.setBackground(c5);
    }//GEN-LAST:event_jCancelButtonActionPerformed

    private void jExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitButtonActionPerformed
        _ThemeF.dispose();
    }//GEN-LAST:event_jExitButtonActionPerformed
    private ThemeF _ThemeF;
        private java.awt.Color c1 ;
        private java.awt.Color c2 ;
        private java.awt.Color c3 ;
        private java.awt.Color c4 ;
        private java.awt.Color c5 ;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBachgroundButton;
    private javax.swing.JButton jButton;
    private javax.swing.JButton jButtonBackgroundButton;
    private javax.swing.JButton jButtonForgroundButton;
    private javax.swing.JButton jCancelButton;
    private javax.swing.JCheckBox jCheckBox;
    private javax.swing.JColorChooser jColorChooser;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JButton jExitButton;
    private javax.swing.JLabel jLabel;
    private javax.swing.JButton jLabelButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton;
    private javax.swing.JButton jSaveButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField;
    private javax.swing.JButton jTextFieldButton;
    // End of variables declaration//GEN-END:variables
}
