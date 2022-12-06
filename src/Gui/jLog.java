package Gui;

public class jLog extends javax.swing.JPanel {

    public jLog(jHomePage jhp, jMainPage jmp) {
        initComponents();
        _jHomePage = jhp;
        _jMainPage = jmp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBack = new javax.swing.JButton();

        jBack.setText("Back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(329, Short.MAX_VALUE)
                .addComponent(jBack)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(262, Short.MAX_VALUE)
                .addComponent(jBack)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        _jHomePage.switchPanels(_jMainPage);
    }//GEN-LAST:event_jBackMouseClicked
    private jMainPage _jMainPage;
    private jHomePage _jHomePage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBack;
    // End of variables declaration//GEN-END:variables
}
