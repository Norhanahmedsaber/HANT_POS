package Gui.Graphs.Chart;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import Gui.Graphs.BlankChart.BlankPlotChart;
import Gui.Graphs.BlankChart.BlankPlotChatRender;
import Gui.Graphs.BlankChart.SeriesSize;
import Gui.jHomePage;
import Statistics.jViewStatistics;
import java.awt.event.KeyEvent;

public class Chart extends javax.swing.JPanel {

    public List<ModelLegend> legends = new ArrayList<>();
    public List<ModelChart> model = new ArrayList<>();
    public final int seriesSize = 12;
    public final int seriesSpace = 6;

    public Chart(jHomePage jhp, jViewStatistics jvs) {
        initComponents();
        _jHomePage = jhp;
        _jViewStatistics = jvs;
        blankPlotChart.setBlankPlotChatRender(new BlankPlotChatRender() {
            @Override
            public String getLabelText(int index) {
                return model.get(index).getLabel();
            }

            @Override
            public void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index) {
                double totalSeriesWidth = (seriesSize * legends.size()) + (seriesSpace * (legends.size() - 1));
                double x = (size.getWidth() - totalSeriesWidth) / 2;
                for (int i = 0; i < legends.size(); i++) {
                    ModelLegend legend = legends.get(i);
                    g2.setColor(legend.getColor());
                    double seriesValues = chart.getSeriesValuesOf(model.get(index).getValues()[i], size.getHeight());
                    g2.fillRect((int) (size.getX() + x), (int) (size.getY() + size.getHeight() - seriesValues), seriesSize, (int) seriesValues);
                    x += seriesSpace + seriesSize;
                }
            }
        });
    }
    
    public void addLegend(String name, Color color) {
        ModelLegend data = new ModelLegend(name, color);
        legends.add(data);
        panelLegend.add(new LegendItem(data));
        panelLegend.repaint();
        panelLegend.revalidate();
    }

    public void addData(ModelChart data) {
        model.add(data);
        blankPlotChart.setLabelCount(model.size());
        double max = data.getMaxValues();
        if (max > blankPlotChart.getMaxValues()) {
            blankPlotChart.setMaxValues(max);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLegend = new javax.swing.JPanel();
        blankPlotChart = new Gui.Graphs.BlankChart.BlankPlotChart();
        jBack = new javax.swing.JButton();
        jProfit = new javax.swing.JRadioButton();
        jItems_Customers = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));

        panelLegend.setOpaque(false);
        panelLegend.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

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

        jProfit.setText("Profit");
        jProfit.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jProfitStateChanged(evt);
            }
        });
        jProfit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jProfitMouseClicked(evt);
            }
        });

        jItems_Customers.setText("Items/Customers");
        jItems_Customers.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jItems_CustomersStateChanged(evt);
            }
        });
        jItems_Customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jItems_CustomersMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 366, Short.MAX_VALUE)
                        .addComponent(jProfit)
                        .addGap(18, 18, 18)
                        .addComponent(jItems_Customers)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelLegend, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(blankPlotChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jItems_Customers)
                    .addComponent(jProfit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(blankPlotChart, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLegend, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBack)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        _jHomePage.switchPanels(_jViewStatistics);
    }//GEN-LAST:event_jBackMouseClicked

    private void jBackKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBackKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            _jHomePage.switchPanels(_jViewStatistics);
        }
    }//GEN-LAST:event_jBackKeyPressed

    private void jProfitStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jProfitStateChanged
        
    }//GEN-LAST:event_jProfitStateChanged

    private void jItems_CustomersStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jItems_CustomersStateChanged
        
    }//GEN-LAST:event_jItems_CustomersStateChanged

    private void jItems_CustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jItems_CustomersMouseClicked

        _jViewStatistics.item_customerClicked();
    }//GEN-LAST:event_jItems_CustomersMouseClicked

    private void jProfitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProfitMouseClicked
      
        _jViewStatistics.profitClicked();
        
    }//GEN-LAST:event_jProfitMouseClicked
    private jHomePage _jHomePage;
    private jViewStatistics _jViewStatistics;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Gui.Graphs.BlankChart.BlankPlotChart blankPlotChart;
    public javax.swing.JButton jBack;
    public javax.swing.JRadioButton jItems_Customers;
    public javax.swing.JRadioButton jProfit;
    private javax.swing.JPanel panelLegend;
    // End of variables declaration//GEN-END:variables
}
