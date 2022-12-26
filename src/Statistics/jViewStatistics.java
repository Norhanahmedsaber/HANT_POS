
package Statistics;

import Entities.CategoryInfo;
import Entities.Customer;
import Entities.Item;
import Entities.UserInfo;
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
import Services.UserServices;
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
        chart2 = new Chart(jhp,this);
        _CustomerServices = new CustomerServices();
        _ItemServices = new ItemServices();
        _filterCustomers = new filterCustomers();
        _UserServices = new UserServices();
        changecolor(new java.awt.Color(87, 118, 130), new java.awt.Color(217, 156, 69), new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255));
    }
    public void changecolor(java.awt.Color c1,java.awt.Color c2,java.awt.Color c3,java.awt.Color c4,java.awt.Color c5)
    {
        colors = new java.awt.Color []{c1, c2, c3, c4, c5};
        setBackground(c1);
        jBack.setBackground(c2);
        jBack.setForeground(c4);
        jCategories.setBackground(c2);
        jCategories.setForeground(c4);
        jSales.setBackground(c2);
        jSales.setForeground(c4);
        jUsers.setBackground(c2);
        jUsers.setForeground(c4);
        
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
        allDays = fetchData();
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
        allDays = fetchData();
        chart.clear();
        chart.addLegend("Total Profit", new Color(189, 135, 245));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        LocalDateTime now = LocalDateTime.now();
        chart.addData(new ModelChart(dtf.format(now.minusDays(5)), new int[] { allDays.get(0)[2] }));
        chart.addData(new ModelChart(dtf.format(now.minusDays(4)), new int[] { allDays.get(1)[2] }));
        chart.addData(new ModelChart(dtf.format(now.minusDays(3)), new int[] { allDays.get(2)[2] }));
        chart.addData(new ModelChart(dtf.format(now.minusDays(2)), new int[] { allDays.get(3)[2] }));
        chart.addData(new ModelChart(dtf.format(now.minusDays(1)), new int[] { allDays.get(4)[2] }));
        chart.addData(new ModelChart(dtf.format(now), new int[] { allDays.get(5)[2] }));
        chart.start();
    }
    public void showCategoriesStates() {
        allDays = fetchData();
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
        allDays = fetchData();
        chart.clear();
        chart.addLegend("Profit Today", new Color(189, 135, 245));
        chart.addLegend("Profit This Week", new Color(135, 189, 135));
        chart.addLegend("Profit This Month", new Color(245, 189, 135));
        chart.addLegend("Profit This Year", new Color(189, 245, 135));
        chart.addData(new ModelChart(cats.get(0).name, getCatInfoProfit(0)));
        chart.addData(new ModelChart(cats.get(1).name, getCatInfoProfit(1)));
        chart.addData(new ModelChart(cats.get(2).name, getCatInfoProfit(2)));
        chart.addData(new ModelChart(cats.get(3).name, getCatInfoProfit(3)));
        chart.addData(new ModelChart(cats.get(4).name, getCatInfoProfit(4)));
        chart.start();
    }
    public void showUserActivitesToday() {
        allDays=fetchData();
        chart.clear();
        chart.addLegend("Number Of Deals", new Color(135, 189, 245));
        chart.addLegend("Number Of Items Sold", new Color(189, 135, 245));
        chart.addLegend("Number Of Items Imported", new Color(245, 135, 189));
        chart.addData(new ModelChart(users.get(0).username, new int[] {users.get(0).dealsDoneToday, users.get(0).itemsSoldToday, users.get(0).itemsImportedToday}));
        chart.addData(new ModelChart(users.get(1).username, new int[] {users.get(1).dealsDoneToday, users.get(1).itemsSoldToday, users.get(1).itemsImportedToday}));
        chart.addData(new ModelChart(users.get(2).username, new int[] {users.get(2).dealsDoneToday, users.get(2).itemsSoldToday, users.get(2).itemsImportedToday}));
        chart.addData(new ModelChart(users.get(3).username, new int[] {users.get(3).dealsDoneToday, users.get(3).itemsSoldToday, users.get(3).itemsImportedToday}));
        chart.start();
    }
    public void showUserProfitToday() {
        allDays=fetchData();
        chart.clear();
        chart.addLegend("Number Of Deals", new Color(135, 189, 245));
        chart.addData(new ModelChart(users.get(0).username, new int[] {users.get(0).profitToday}));
        chart.addData(new ModelChart(users.get(1).username, new int[] {users.get(1).profitToday}));
        chart.addData(new ModelChart(users.get(2).username, new int[] {users.get(2).profitToday}));
        chart.addData(new ModelChart(users.get(3).username, new int[] {users.get(3).profitToday}));
        chart.start();
    }
    public void showUserActivitiesThisWeek() {
        allDays=fetchData();
        chart.clear();
        chart.addLegend("Number Of Deals", new Color(135, 189, 245));
        chart.addLegend("Number Of Items Sold", new Color(189, 135, 245));
        chart.addLegend("Number Of Items Imported", new Color(245, 135, 189));
        chart.addData(new ModelChart(users.get(0).username, new int[] {users.get(0).dealsDoneThisWeek, users.get(0).itemsSoldThisWeek, users.get(0).itemsImportedThisWeek}));
        chart.addData(new ModelChart(users.get(1).username, new int[] {users.get(1).dealsDoneThisWeek, users.get(1).itemsSoldThisWeek, users.get(1).itemsImportedThisWeek}));
        chart.addData(new ModelChart(users.get(2).username, new int[] {users.get(2).dealsDoneThisWeek, users.get(2).itemsSoldThisWeek, users.get(2).itemsImportedThisWeek}));
        chart.addData(new ModelChart(users.get(3).username, new int[] {users.get(3).dealsDoneThisWeek, users.get(3).itemsSoldThisWeek, users.get(3).itemsImportedThisWeek}));
        chart.start();
    }
    public void showUserProfitThisWeek() {
        allDays=fetchData();
        chart.clear();
        chart.addLegend("Number Of Deals", new Color(135, 189, 245));
        chart.addData(new ModelChart(users.get(0).username, new int[] {users.get(0).profitThisWeek}));
        chart.addData(new ModelChart(users.get(1).username, new int[] {users.get(1).profitThisWeek}));
        chart.addData(new ModelChart(users.get(2).username, new int[] {users.get(2).profitThisWeek}));
        chart.addData(new ModelChart(users.get(3).username, new int[] {users.get(3).profitThisWeek}));
        chart.start();
    }
    public void showUserActivitesThisMonth() {
        allDays=fetchData();
        chart.clear();
        chart.addLegend("Number Of Deals", new Color(135, 189, 245));
        chart.addLegend("Number Of Items Sold", new Color(189, 135, 245));
        chart.addLegend("Number Of Items Imported", new Color(245, 135, 189));
        chart.addData(new ModelChart(users.get(0).username, new int[] {users.get(0).dealsDoneThisMonth, users.get(0).itemsSoldThisMonth, users.get(0).itemsImportedThisMonth}));
        chart.addData(new ModelChart(users.get(1).username, new int[] {users.get(1).dealsDoneThisMonth, users.get(1).itemsSoldThisMonth, users.get(1).itemsImportedThisMonth}));
        chart.addData(new ModelChart(users.get(2).username, new int[] {users.get(2).dealsDoneThisMonth, users.get(2).itemsSoldThisMonth, users.get(2).itemsImportedThisMonth}));
        chart.addData(new ModelChart(users.get(3).username, new int[] {users.get(3).dealsDoneThisMonth, users.get(3).itemsSoldThisMonth, users.get(3).itemsImportedThisMonth}));
        chart.start();
    }
    public void showUserProfitThisMonth() {
        allDays=fetchData();
        chart.clear();
        chart.addLegend("Number Of Deals", new Color(135, 189, 245));
        chart.addData(new ModelChart(users.get(0).username, new int[] {users.get(0).profitThisMonth}));
        chart.addData(new ModelChart(users.get(1).username, new int[] {users.get(1).profitThisMonth}));
        chart.addData(new ModelChart(users.get(2).username, new int[] {users.get(2).profitThisMonth}));
        chart.addData(new ModelChart(users.get(3).username, new int[] {users.get(3).profitThisMonth}));
        chart.start();
    }
    public void showUserActivitesThisYear() {
        allDays=fetchData();
        chart.clear();
        chart.addLegend("Number Of Deals", new Color(135, 189, 245));
        chart.addLegend("Number Of Items Sold", new Color(189, 135, 245));
        chart.addLegend("Number Of Items Imported", new Color(245, 135, 189));
        chart.addData(new ModelChart(users.get(0).username, new int[] {users.get(0).dealsDoneThisYear, users.get(0).itemsSoldThisYear, users.get(0).itemsImportedThisYear}));
        chart.addData(new ModelChart(users.get(1).username, new int[] {users.get(1).dealsDoneThisYear, users.get(1).itemsSoldThisYear, users.get(1).itemsImportedThisYear}));
        chart.addData(new ModelChart(users.get(2).username, new int[] {users.get(2).dealsDoneThisYear, users.get(2).itemsSoldThisYear, users.get(2).itemsImportedThisYear}));
        chart.addData(new ModelChart(users.get(3).username, new int[] {users.get(3).dealsDoneThisYear, users.get(3).itemsSoldThisYear, users.get(3).itemsImportedThisYear}));
        chart.start();
    }
    public void showUserProfitThisYear(){
        allDays=fetchData();
        chart.clear();
        chart.addLegend("Number Of Deals", new Color(135, 189, 245));
        chart.addData(new ModelChart(users.get(0).username, new int[] {users.get(0).profitThisYear}));
        chart.addData(new ModelChart(users.get(1).username, new int[] {users.get(1).profitThisYear}));
        chart.addData(new ModelChart(users.get(2).username, new int[] {users.get(2).profitThisYear}));
        chart.addData(new ModelChart(users.get(3).username, new int[] {users.get(3).profitThisYear}));
        chart.start();
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
    public ArrayList<UserInfo> getUsers() {
        return _UserServices.getUsersInfo();
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
        jBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Statistics/back.png"))); // NOI18N
        jBack.setMnemonic('b');
        jBack.setText("    Back   ");
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
        jBack.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBackKeyPressed(evt);
            }
        });

        jSales.setBackground(new java.awt.Color(217, 156, 69));
        jSales.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jSales.setForeground(new java.awt.Color(255, 255, 255));
        jSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Statistics/Sales.png"))); // NOI18N
        jSales.setMnemonic('s');
        jSales.setText("                                  Sales                                                       ");
        jSales.setToolTipText("");
        jSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSalesMouseClicked(evt);
            }
        });
        jSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalesActionPerformed(evt);
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
        jCategories.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Statistics/Item stst.png"))); // NOI18N
        jCategories.setMnemonic('c');
        jCategories.setText("                                 Categories                                             ");
        jCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCategoriesMouseClicked(evt);
            }
        });
        jCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCategoriesActionPerformed(evt);
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
        jUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Statistics/userStat.png"))); // NOI18N
        jUsers.setMnemonic('u');
        jUsers.setText("                                Users Activites                                     ");
        jUsers.setToolTipText("");
        jUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUsersMouseClicked(evt);
            }
        });
        jUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsersActionPerformed(evt);
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
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jSales, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jSales, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170)
                .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        
    }//GEN-LAST:event_jBackMouseClicked

    private void jBackKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBackKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            _jHomePage.switchPanels(_jMainPage);
        }
    }//GEN-LAST:event_jBackKeyPressed

    private void jSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalesMouseClicked
        
    }//GEN-LAST:event_jSalesMouseClicked

    private void jSalesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSalesKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            chart = new Chart(_jHomePage, this);
            chart.changecolor(colors[0], colors[1], colors[2], colors[3], colors[4]);
            where = "sale";
            _jHomePage.switchPanels(chart);
            showItemStats();
            chart.jProfit.setSelected(false);
            chart.jItems_Customers.setSelected(true);
            allDays = fetchData();
            chart.jRadioButton1.setVisible(false);
            chart.jRadioButton2.setVisible(false);
            chart.jRadioButton3.setVisible(false);
            chart.jRadioButton4.setVisible(false);
        }
    }//GEN-LAST:event_jSalesKeyPressed

    private void jCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCategoriesMouseClicked
        
    }//GEN-LAST:event_jCategoriesMouseClicked

    private void jCategoriesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCategoriesKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            chart = new Chart(_jHomePage, this);
            chart.changecolor(colors[0], colors[1], colors[2], colors[3], colors[4]);
            where = "cat";
            _jHomePage.switchPanels(chart);
            showCategoriesStates();
            chart.jProfit.setSelected(false);
            chart.jItems_Customers.setSelected(true);
            allDays = fetchData();
            chart.jRadioButton1.setVisible(false);
            chart.jRadioButton2.setVisible(false);
            chart.jRadioButton3.setVisible(false);
            chart.jRadioButton4.setVisible(false);
        }
    }//GEN-LAST:event_jCategoriesKeyPressed

    private void jUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUsersMouseClicked
        
    }//GEN-LAST:event_jUsersMouseClicked

    private void jUsersKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jUsersKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            chart = new Chart(_jHomePage, this);
            chart.changecolor(colors[0], colors[1], colors[2], colors[3], colors[4]);
            where = "user";
            _jHomePage.switchPanels(chart);
            showUserActivitesToday();
            chart.jProfit.setSelected(false);
            chart.jItems_Customers.setSelected(true);
            allDays = fetchData();
            chart.jRadioButton1.setSelected(true);
        }
    }//GEN-LAST:event_jUsersKeyPressed

    private void jSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalesActionPerformed
        chart = new Chart(_jHomePage, this);
        chart.changecolor(colors[0], colors[1], colors[2], colors[3], colors[4]);
        where = "sale";
        _jHomePage.switchPanels(chart);
        showItemStats();
        chart.jProfit.setSelected(false);
        chart.jItems_Customers.setSelected(true);
        allDays = fetchData();
        chart.jRadioButton1.setVisible(false);
        chart.jRadioButton2.setVisible(false);
        chart.jRadioButton3.setVisible(false);
        chart.jRadioButton4.setVisible(false);
    }//GEN-LAST:event_jSalesActionPerformed

    private void jCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCategoriesActionPerformed
        chart = new Chart(_jHomePage, this);
        chart.changecolor(colors[0], colors[1], colors[2], colors[3], colors[4]);
        where = "cat";
        _jHomePage.switchPanels(chart);
        showCategoriesStates();
        chart.jProfit.setSelected(false);
        chart.jItems_Customers.setSelected(true);
        allDays = fetchData();
        chart.jRadioButton1.setVisible(false);
        chart.jRadioButton2.setVisible(false);
        chart.jRadioButton3.setVisible(false);
        chart.jRadioButton4.setVisible(false);
    }//GEN-LAST:event_jCategoriesActionPerformed

    private void jUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsersActionPerformed
        chart = new Chart(_jHomePage, this);
        chart.changecolor(colors[0], colors[1], colors[2], colors[3], colors[4]);
        where = "user";
        _jHomePage.switchPanels(chart);
        showUserActivitesToday();
        chart.jProfit.setSelected(false);
        chart.jItems_Customers.setSelected(true);
        allDays = fetchData();
        chart.jRadioButton1.setSelected(true);
    }//GEN-LAST:event_jUsersActionPerformed

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        _jHomePage.switchPanels(_jMainPage);
    }//GEN-LAST:event_jBackActionPerformed
    public ArrayList<int[]> fetchData() {
        ArrayList<int[]> alldays = new ArrayList<>(); 
        LocalDateTime now = LocalDateTime.now();
        cats = getTopCategories();
        users = getUsers();
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
            chart = new Chart(_jHomePage, this);
            chart.changecolor(colors[0], colors[1], colors[2], colors[3], colors[4]);
            _jHomePage.switchPanels(chart);
            showDailyProfit();
            chart.jProfit.setSelected(true);
            chart.jItems_Customers.setSelected(false);
            allDays = fetchData();
            chart.jRadioButton1.setVisible(false);
            chart.jRadioButton2.setVisible(false);
            chart.jRadioButton3.setVisible(false);
            chart.jRadioButton4.setVisible(false);
        }else if(where.equals("cat")) {
            chart = new Chart(_jHomePage, this);
            _jHomePage.switchPanels(chart);
            showCategoryProfit();
            chart.jProfit.setSelected(true);
            chart.jItems_Customers.setSelected(false);
            allDays = fetchData();
            chart.jRadioButton1.setVisible(false);
            chart.jRadioButton2.setVisible(false);
            chart.jRadioButton3.setVisible(false);
            chart.jRadioButton4.setVisible(false);
        }else if(where.equals("user")) {
            if(chart.jRadioButton1.isSelected()) {
                chart = new Chart(_jHomePage, this);
                chart.jRadioButton1.setSelected(true);
                chart.changecolor(colors[0], colors[1], colors[2], colors[3], colors[4]);
                _jHomePage.switchPanels(chart);
                showUserProfitToday();
                chart.jProfit.setSelected(true);
                chart.jItems_Customers.setSelected(false);
                allDays = fetchData();
            }else if(chart.jRadioButton2.isSelected()) {
                chart = new Chart(_jHomePage, this);
                chart.jRadioButton2.setSelected(true);
                chart.changecolor(colors[0], colors[1], colors[2], colors[3], colors[4]);
                _jHomePage.switchPanels(chart);
                showUserProfitThisWeek();
                chart.jProfit.setSelected(true);
                chart.jItems_Customers.setSelected(false);
                allDays = fetchData();
            }else if(chart.jRadioButton3.isSelected()) {
                chart = new Chart(_jHomePage, this);
                chart.jRadioButton3.setSelected(true);
                chart.changecolor(colors[0], colors[1], colors[2], colors[3], colors[4]);
                _jHomePage.switchPanels(chart);
                showUserProfitThisMonth();
                chart.jProfit.setSelected(true);
                chart.jItems_Customers.setSelected(false);
                allDays = fetchData();
            }else if(chart.jRadioButton4.isSelected()) {
                chart = new Chart(_jHomePage, this);
                chart.jRadioButton4.setSelected(true);
                chart.changecolor(colors[0], colors[1], colors[2], colors[3], colors[4]);
                _jHomePage.switchPanels(chart);
                showUserProfitThisYear();
                chart.jProfit.setSelected(true);
                chart.jItems_Customers.setSelected(false);
                allDays = fetchData();
            }
            chart.jProfit.setSelected(true);
            chart.jItems_Customers.setSelected(false);
        }
    }
    public void item_customerClicked() {
        if(where.equals("sale")) {
            chart = new Chart(_jHomePage, this);
            chart.changecolor(colors[0], colors[1], colors[2], colors[3], colors[4]);
            _jHomePage.switchPanels(chart);
            showItemStats();
            chart.jProfit.setSelected(false);
            chart.jItems_Customers.setSelected(true);
            chart.jRadioButton1.setVisible(false);
            chart.jRadioButton2.setVisible(false);
            chart.jRadioButton3.setVisible(false);
            chart.jRadioButton4.setVisible(false);
            allDays = fetchData();
        }else if(where.equals("cat")) {
            chart = new Chart(_jHomePage, this);
            chart.changecolor(colors[0], colors[1], colors[2], colors[3], colors[4]);
            _jHomePage.switchPanels(chart);
            showCategoriesStates();
            chart.jProfit.setSelected(false);
            chart.jItems_Customers.setSelected(true);
            allDays = fetchData();
            chart.jRadioButton1.setVisible(false);
            chart.jRadioButton2.setVisible(false);
            chart.jRadioButton3.setVisible(false);
            chart.jRadioButton4.setVisible(false);
        }else if(where.equals("user")) {
            if(chart.jRadioButton1.isSelected()) {
                chart = new Chart(_jHomePage, this);
                chart.jRadioButton1.setSelected(true);
                chart.changecolor(colors[0], colors[1], colors[2], colors[3], colors[4]);
                _jHomePage.switchPanels(chart);
                showUserActivitesToday();
                chart.jProfit.setSelected(true);
                chart.jItems_Customers.setSelected(false);
                allDays = fetchData();
            }else if(chart.jRadioButton2.isSelected()) {
                chart = new Chart(_jHomePage, this);
                chart.jRadioButton2.setSelected(true);
                chart.changecolor(colors[0], colors[1], colors[2], colors[3], colors[4]);
                _jHomePage.switchPanels(chart);
                showUserActivitiesThisWeek();
                chart.jProfit.setSelected(true);
                chart.jItems_Customers.setSelected(false);
                allDays = fetchData();
            }else if(chart.jRadioButton3.isSelected()) {
                chart = new Chart(_jHomePage, this);
                chart.jRadioButton3.setSelected(true);
                chart.changecolor(colors[0], colors[1], colors[2], colors[3], colors[4]);
                _jHomePage.switchPanels(chart);
                showUserActivitesThisMonth();
                chart.jProfit.setSelected(true);
                chart.jItems_Customers.setSelected(false);
                allDays = fetchData();
            }else if(chart.jRadioButton4.isSelected()) {
                chart = new Chart(_jHomePage, this);
                chart.jRadioButton4.setSelected(true);
                chart.changecolor(colors[0], colors[1], colors[2], colors[3], colors[4]);
                _jHomePage.switchPanels(chart);
                showUserActivitesThisYear();
                chart.jProfit.setSelected(true);
                chart.jItems_Customers.setSelected(false);
                allDays = fetchData();
            }
            chart.jProfit.setSelected(false);
            chart.jItems_Customers.setSelected(true);
        }
    }
    public void todayClicked() {
        if(chart.jProfit.isSelected()) {
            profitClicked();;
        }else {
            item_customerClicked();
        }
    }
    public void thisWeekClicked() {
        if(chart.jProfit.isSelected()) {
            profitClicked();;
        }else {
            item_customerClicked();
        }
    }
    public void thisMonthClicked() {
        if(chart.jProfit.isSelected()) {
            profitClicked();;
        }else {
            item_customerClicked();
        }
    }
    public void thisYearClicked() {
        if(chart.jProfit.isSelected()) {
            profitClicked();;
        }else {
            item_customerClicked();
        }
    }
    private java.awt.Color[] colors;
    private UserServices _UserServices;
    public ArrayList<UserInfo> users;
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
