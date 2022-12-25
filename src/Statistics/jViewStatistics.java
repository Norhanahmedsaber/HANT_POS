
package Statistics;

import Entities.CategoryInfo;
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
import Services.ItemServices;
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
        _ItemServices = new ItemServices();
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
        chart.clear();
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
        chart.start();
    }
    public void showDailyProfit() {
        chart2.clear();
        chart2.addLegend("Total Profit", new Color(189, 135, 245));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        LocalDateTime now = LocalDateTime.now();
        chart2.addData(new ModelChart(dtf.format(now.minusDays(5)), new int[] { allDays.get(0)[2] }));
        chart2.addData(new ModelChart(dtf.format(now.minusDays(4)), new int[] { allDays.get(1)[2] }));
        chart2.addData(new ModelChart(dtf.format(now.minusDays(3)), new int[] { allDays.get(2)[2] }));
        chart2.addData(new ModelChart(dtf.format(now.minusDays(2)), new int[] { allDays.get(3)[2] }));
        chart2.addData(new ModelChart(dtf.format(now.minusDays(1)), new int[] { allDays.get(4)[2] }));
        chart2.addData(new ModelChart(dtf.format(now), new int[] { allDays.get(5)[2] }));
        chart2.start();
    }
    public void showCategoriesStates() {
        chart.clear();
        chart.addLegend("Sold Today", new Color(189, 135, 245));
        chart.addLegend("Sold This Week", new Color(135, 189, 135));
        chart.addLegend("Sold This Month", new Color(245, 189, 135));
        chart.addLegend("Sold This Year", new Color(189, 245, 135));
        chart.addData(new ModelChart(cats.get(0).name, getCatInfo(0)));
        chart.addData(new ModelChart(cats.get(1).name, getCatInfo(1)));
        chart.addData(new ModelChart(cats.get(2).name, getCatInfo(2)));
        chart.addData(new ModelChart(cats.get(3).name, getCatInfo(3)));
        chart.addData(new ModelChart(cats.get(4).name, getCatInfo(4)));
        chart.start();
    }
    public void showCategoryProfit() {
        chart2.clear();
        chart2.addLegend("Profit Today", new Color(189, 135, 245));
        chart2.addLegend("Profit This Week", new Color(135, 189, 135));
        chart2.addLegend("Profit This Month", new Color(245, 189, 135));
        chart2.addLegend("Profit This Year", new Color(189, 245, 135));
        chart2.addData(new ModelChart(cats.get(0).name, getCatInfoProfit(0)));
        chart2.addData(new ModelChart(cats.get(1).name, getCatInfoProfit(1)));
        chart2.addData(new ModelChart(cats.get(2).name, getCatInfoProfit(2)));
        chart2.addData(new ModelChart(cats.get(3).name, getCatInfoProfit(3)));
        chart2.addData(new ModelChart(cats.get(4).name, getCatInfoProfit(4)));
        chart2.start();
    }
    public int[] getCatInfoProfit(int x) {
        return new int[] { cats.get(x).incomeToday, cats.get(x).incomeThisWeek, cats.get(x).incomeThisMonth, cats.get(x).incomeThisYear };
    }
    public int[] getCatInfo(int x) {
        return new int[] { cats.get(x).NumberOfItemsToday, cats.get(x).NumberOfItemsThisWeek, cats.get(x).NumberOfItemsThisMonth, cats.get(x).NumberOfItemsThisYear };
    }
    public ArrayList<CategoryInfo> getTopCategories() {
        return _ItemServices.getCatsInfo();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBack = new javax.swing.JButton();
        jSales = new javax.swing.JButton();
        jCategories = new javax.swing.JButton();
        jUsers = new javax.swing.JButton();

        setBackground(new java.awt.Color(87, 118, 130));
        setPreferredSize(new java.awt.Dimension(750, 750));

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

        jSales.setBackground(new java.awt.Color(217, 156, 69));
        jSales.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jSales.setForeground(new java.awt.Color(255, 255, 255));
        jSales.setText("Sales");
        jSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSalesMouseClicked(evt);
            }
        });
        jSales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jSalesKeyPressed(evt);
            }
        });

        jCategories.setBackground(new java.awt.Color(217, 156, 69));
        jCategories.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jCategories.setForeground(new java.awt.Color(255, 255, 255));
        jCategories.setText("Categories");
        jCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCategoriesMouseClicked(evt);
            }
        });
        jCategories.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCategoriesKeyPressed(evt);
            }
        });

        jUsers.setBackground(new java.awt.Color(217, 156, 69));
        jUsers.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jUsers.setForeground(new java.awt.Color(255, 255, 255));
        jUsers.setText("Users Activites");
        jUsers.setToolTipText("");
        jUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUsersMouseClicked(evt);
            }
        });
        jUsers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jUsersKeyPressed(evt);
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
                            .addComponent(jSales, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jSales, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 412, Short.MAX_VALUE)
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

    private void jSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalesMouseClicked
        chart = new Chart(_jHomePage, this);
        where = "sale";
        _jHomePage.switchPanels(chart);
        showItemStats();
        chart.jProfit.setSelected(false);
        chart.jItems_Customers.setSelected(true);
    }//GEN-LAST:event_jSalesMouseClicked

    private void jSalesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSalesKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            chart = new Chart(_jHomePage, this);
            where = "sale";
            _jHomePage.switchPanels(chart);
            showItemStats();
            chart.jProfit.setSelected(false);
            chart.jItems_Customers.setSelected(true);
        }
    }//GEN-LAST:event_jSalesKeyPressed

    private void jCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCategoriesMouseClicked
        chart = new Chart(_jHomePage, this);
        where = "cat";
        _jHomePage.switchPanels(chart);
        showCategoriesStates();
        chart.jProfit.setSelected(false);
        chart.jItems_Customers.setSelected(true);
    }//GEN-LAST:event_jCategoriesMouseClicked

    private void jCategoriesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCategoriesKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            chart = new Chart(_jHomePage, this);
            where = "cat";
            _jHomePage.switchPanels(chart);
            showCategoriesStates();
            chart.jProfit.setSelected(false);
            chart.jItems_Customers.setSelected(true);
        }
    }//GEN-LAST:event_jCategoriesKeyPressed

    private void jUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUsersMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jUsersMouseClicked

    private void jUsersKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jUsersKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUsersKeyPressed
    public ArrayList<int[]> fetchData() {
        ArrayList<int[]> alldays = new ArrayList<>(); 
        LocalDateTime now = LocalDateTime.now();
        cats = getTopCategories();
        alldays.add(getDayInfo(now.minusDays(5)));
        alldays.add(getDayInfo(now.minusDays(4)));
        alldays.add(getDayInfo(now.minusDays(3)));
        alldays.add(getDayInfo(now.minusDays(2)));
        alldays.add(getDayInfo(now.minusDays(1)));
        alldays.add(getDayInfo(now));
        return alldays;
    }
    public void profitClicked() {
        if(where.equals("sale")) {
            chart2 = new Chart(_jHomePage, this);
            _jHomePage.switchPanels(chart2);
            showDailyProfit();
            chart2.jProfit.setSelected(true);
            chart2.jItems_Customers.setSelected(false);
        }else if(where.equals("cat")) {
            chart2 = new Chart(_jHomePage, this);
            _jHomePage.switchPanels(chart2);
            showCategoryProfit();
            chart2.jProfit.setSelected(true);
            chart2.jItems_Customers.setSelected(false);
        }
    }
    public void item_customerClicked() {
        if(where.equals("sale")) {
            chart = new Chart(_jHomePage, this);
            _jHomePage.switchPanels(chart);
            showItemStats();
            chart.jProfit.setSelected(false);
            chart.jItems_Customers.setSelected(true);
        }else if(where.equals("cat")) {
            chart = new Chart(_jHomePage, this);
            _jHomePage.switchPanels(chart);
            showCategoriesStates();
            chart.jProfit.setSelected(false);
            chart.jItems_Customers.setSelected(true);
        }
    }
    public String where;
    private ItemServices _ItemServices;
    public ArrayList<CategoryInfo> cats;
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
    public javax.swing.JButton jCategories;
    public javax.swing.JButton jSales;
    public javax.swing.JButton jUsers;
    // End of variables declaration//GEN-END:variables
}
