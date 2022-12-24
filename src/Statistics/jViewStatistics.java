
package Statistics;

import Entities.Customer;
import Entities.Item;
import Gui.Graphs.BlankChart.BlankPlotChart;
import Gui.Graphs.BlankChart.BlankPlotChatRender;
import Gui.Graphs.BlankChart.SeriesSize;
import Gui.Graphs.Chart.Chart;
import Gui.Graphs.Chart.ModelChart;
import Gui.Graphs.Chart.ModelLegend;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.CustomerServices;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import utils.filterCustomers;

public class jViewStatistics extends javax.swing.JPanel {

    public jViewStatistics(jHomePage jhp, jMainPage jmp) {
        initComponents();
        _jHomePage = jhp;
        _jMainPage = jmp;
        chart = new Chart(jhp,this);
        _CustomerServices = new CustomerServices();
        _filterCustomers = new filterCustomers();
    }
    // {No Items Sold, No Customer, Total profit}
    private int[] getDayInfo(LocalDateTime ldt) {
        int noItems, noCustomers, profit = 0;
        //Total Profit
        //No Items Sold
        noItems = 0;
        ArrayList<Customer> customers = _CustomerServices.getDayCustomers(java.util.Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant()));
        for(Customer customer : customers) {
            ArrayList<Item> items = _CustomerServices.getAssignedItems(customer.id);
            noItems += items.size();
            for(Item item : items) {
                profit += item.price;
            }
        }
        //No Customers
        noCustomers = customers.size();
        return new int[] {noItems, noCustomers, profit};
    }
    public void showItemStats() {
        allCustomers = _CustomerServices.getAll();
        chart.legends = new ArrayList<>();
        chart.model = new ArrayList<>();
        chart.blankPlotChart.setLabelCount(0);
        chart.addLegend("Number Of Items Sold", new Color(135, 189, 245));
        chart.addLegend("Number Of Customers", new Color(245, 189, 135));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        LocalDateTime now = LocalDateTime.now();
        chart.addData(new ModelChart(dtf.format(now.minusDays(5)), new int[] { allDays.get(0)[0], allDays.get(0)[1] }));
        chart.addData(new ModelChart(dtf.format(now.minusDays(4)), new int[] { allDays.get(1)[0], allDays.get(1)[1] }));
        chart.addData(new ModelChart(dtf.format(now.minusDays(3)), new int[] { allDays.get(2)[0], allDays.get(2)[1] }));
        chart.addData(new ModelChart(dtf.format(now.minusDays(2)), new int[] { allDays.get(3)[0], allDays.get(3)[1] }));
        chart.addData(new ModelChart(dtf.format(now.minusDays(1)), new int[] { allDays.get(4)[0], allDays.get(4)[1] }));
        chart.addData(new ModelChart(dtf.format(now), new int[] { allDays.get(5)[0], allDays.get(5)[1] }));
    }
    public void showDailyProfit() {
        chart2.addLegend("Total Profit", new Color(189, 135, 245));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        LocalDateTime now = LocalDateTime.now();
        chart2.addData(new ModelChart(dtf.format(now.minusDays(5)), new int[] { allDays.get(0)[2] }));
        chart2.addData(new ModelChart(dtf.format(now.minusDays(4)), new int[] { allDays.get(1)[2] }));
        chart2.addData(new ModelChart(dtf.format(now.minusDays(3)), new int[] { allDays.get(2)[2] }));
        chart2.addData(new ModelChart(dtf.format(now.minusDays(2)), new int[] { allDays.get(3)[2] }));
        chart2.addData(new ModelChart(dtf.format(now.minusDays(1)), new int[] { allDays.get(4)[2] }));
        chart2.addData(new ModelChart(dtf.format(now), new int[] { allDays.get(5)[2] }));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBack = new javax.swing.JButton();
        jShowGraph1 = new javax.swing.JButton();
        jShowGraph2 = new javax.swing.JButton();
        jShowGraph3 = new javax.swing.JButton();

        jBack.setBackground(new java.awt.Color(217, 156, 69));
        jBack.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jBack.setForeground(new java.awt.Color(255, 255, 255));
        jBack.setText("Back");
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });
        jBack.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBackKeyPressed(evt);
            }
        });

        jShowGraph1.setBackground(new java.awt.Color(217, 156, 69));
        jShowGraph1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jShowGraph1.setForeground(new java.awt.Color(255, 255, 255));
        jShowGraph1.setText("Sales");
        jShowGraph1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jShowGraph1MouseClicked(evt);
            }
        });
        jShowGraph1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jShowGraph1KeyPressed(evt);
            }
        });

        jShowGraph2.setBackground(new java.awt.Color(217, 156, 69));
        jShowGraph2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jShowGraph2.setForeground(new java.awt.Color(255, 255, 255));
        jShowGraph2.setText("Categories");
        jShowGraph2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jShowGraph2MouseClicked(evt);
            }
        });
        jShowGraph2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jShowGraph2KeyPressed(evt);
            }
        });

        jShowGraph3.setBackground(new java.awt.Color(217, 156, 69));
        jShowGraph3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jShowGraph3.setForeground(new java.awt.Color(255, 255, 255));
        jShowGraph3.setText("Users Activites");
        jShowGraph3.setToolTipText("");
        jShowGraph3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jShowGraph3MouseClicked(evt);
            }
        });
        jShowGraph3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jShowGraph3KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jShowGraph1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jShowGraph2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jShowGraph3, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jShowGraph1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jShowGraph2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jShowGraph3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 419, Short.MAX_VALUE)
                .addComponent(jBack)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        _jHomePage.switchPanels(_jMainPage);
    }//GEN-LAST:event_jBackMouseClicked

    private void jBackKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBackKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            _jHomePage.switchPanels(_jMainPage);
        }
    }//GEN-LAST:event_jBackKeyPressed

    private void jShowGraph1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jShowGraph1MouseClicked
        chart = new Chart(_jHomePage, this);
        _jHomePage.switchPanels(chart);
        showItemStats();
        chart.jProfit.setSelected(false);
        chart.jItems_Customers.setSelected(true);
    }//GEN-LAST:event_jShowGraph1MouseClicked

    private void jShowGraph1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jShowGraph1KeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            chart = new Chart(_jHomePage, this);
            _jHomePage.switchPanels(chart);
            showItemStats();
            chart.jProfit.setSelected(false);
            chart.jItems_Customers.setSelected(true);
        }
    }//GEN-LAST:event_jShowGraph1KeyPressed

    private void jShowGraph2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jShowGraph2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jShowGraph2MouseClicked

    private void jShowGraph2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jShowGraph2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jShowGraph2KeyPressed

    private void jShowGraph3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jShowGraph3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jShowGraph3MouseClicked

    private void jShowGraph3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jShowGraph3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jShowGraph3KeyPressed
    public ArrayList<int[]> fetchData() {
        ArrayList<int[]> alldays = new ArrayList<>(); 
        LocalDateTime now = LocalDateTime.now();
        alldays.add(getDayInfo(now.minusDays(5)));
        alldays.add(getDayInfo(now.minusDays(4)));
        alldays.add(getDayInfo(now.minusDays(3)));
        alldays.add(getDayInfo(now.minusDays(2)));
        alldays.add(getDayInfo(now.minusDays(1)));
        alldays.add(getDayInfo(now));
        return alldays;
    }
    public void profitClicked() {
        chart2 = new Chart(_jHomePage, this);
        _jHomePage.switchPanels(chart2);
        showDailyProfit();
        chart2.jProfit.setSelected(true);
        chart2.jItems_Customers.setSelected(false);
    }
    public void item_customerClicked() {
        chart = new Chart(_jHomePage, this);
        _jHomePage.switchPanels(chart);
        showItemStats();
        chart.jProfit.setSelected(false);
        chart.jItems_Customers.setSelected(true);
    }
    public Chart chart2;
    public ArrayList<int[]> allDays;
    private ArrayList<Customer> allCustomers;
    private filterCustomers _filterCustomers;
    private CustomerServices _CustomerServices;
    public Chart chart;
    private final jHomePage _jHomePage;
    private final jMainPage _jMainPage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBack;
    public javax.swing.JButton jShowGraph1;
    public javax.swing.JButton jShowGraph2;
    public javax.swing.JButton jShowGraph3;
    // End of variables declaration//GEN-END:variables
}
