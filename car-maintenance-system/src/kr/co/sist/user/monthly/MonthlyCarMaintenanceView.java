package kr.co.sist.user.monthly;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MonthlyCarMaintenanceView extends JFrame {

  private MonthlyCarMaintenanceEvent monthlyCarMaintenanceEvent;

  private JLabel jlMonthlyCarMaintenanceLabel;
  private JLabel jlUserName;

  private DefaultComboBoxModel dcmMaintenanceList;
  private JComboBox<String> jcbMonthlyMaintenanceList;

  private JButton jtbnSelect;
  private JButton jbtnDetailedSelect;

  private DefaultTableModel dtmMonthlyCarMaintenanceData;
  private JTable jtabMonthlyCarMaintenanceData;
  private JScrollPane jspMonthlyCarMaintenanceData;

  private DefaultTableModel dtmDetailedCarMaintenanceData;
  private JTable jtDetailedCarMaintenanceData;
  private JScrollPane jspDetailedCarMaintenanceData;



  public MonthlyCarMaintenanceView() {
    this.monthlyCarMaintenanceEvent = new MonthlyCarMaintenanceEvent(this);

    jlMonthlyCarMaintenanceLabel = new JLabel("차량 정비 정산:");
    jlUserName = new JLabel("김철수 고객님");

    dcmMaintenanceList = new DefaultComboBoxModel();
    jcbMonthlyMaintenanceList = new JComboBox<>(dcmMaintenanceList);

    jtbnSelect = new JButton("조회");
    jbtnDetailedSelect = new JButton("세부 조회");

    dtmMonthlyCarMaintenanceData = new DefaultTableModel();
    jtabMonthlyCarMaintenanceData = new JTable(dtmMonthlyCarMaintenanceData);
    jspMonthlyCarMaintenanceData = new JScrollPane(jtabMonthlyCarMaintenanceData);

    dtmDetailedCarMaintenanceData = new DefaultTableModel();
    jtDetailedCarMaintenanceData = new JTable(dtmDetailedCarMaintenanceData);
    jspDetailedCarMaintenanceData = new JScrollPane(jtDetailedCarMaintenanceData);

    setLayout(null);

    jlMonthlyCarMaintenanceLabel.setBounds(20, 20, 100, 30);
    jlUserName.setBounds(700, 20, 100, 30);
    jcbMonthlyMaintenanceList.setBounds(20, 60, 100, 30);
    jtbnSelect.setBounds(140, 60, 100, 30);
    jbtnDetailedSelect.setBounds(680, 60, 100, 30);
    jspMonthlyCarMaintenanceData.setBounds(20, 100, 780, 130);
    jspDetailedCarMaintenanceData.setBounds(20, 260, 780, 170);
    add(jlMonthlyCarMaintenanceLabel);
    add(jlUserName);
    add(jcbMonthlyMaintenanceList);
    add(jtbnSelect);
    add(jbtnDetailedSelect);
    add(jspMonthlyCarMaintenanceData);
    add(jspDetailedCarMaintenanceData);

    jcbMonthlyMaintenanceList.addActionListener(monthlyCarMaintenanceEvent);

    setBounds(200, 320, 840, 480);
    setVisible(true);
    setResizable(false);
  }



  public MonthlyCarMaintenanceEvent getMonthlyCarMaintenanceEvent() {
    return monthlyCarMaintenanceEvent;
  }



  public JLabel getJlMonthlyCarMaintenanceLabel() {
    return jlMonthlyCarMaintenanceLabel;
  }



  public JLabel getJlUserName() {
    return jlUserName;
  }



  public DefaultComboBoxModel getDcmMaintenanceList() {
    return dcmMaintenanceList;
  }



  public JComboBox<String> getJcbMonthlyMaintenanceList() {
    return jcbMonthlyMaintenanceList;
  }



  public JButton getJtbnSelect() {
    return jtbnSelect;
  }



  public JButton getJbtnDetailedSelect() {
    return jbtnDetailedSelect;
  }



  public DefaultTableModel getDtmMonthlyCarMaintenanceData() {
    return dtmMonthlyCarMaintenanceData;
  }



  public JTable getJtabMonthlyCarMaintenanceData() {
    return jtabMonthlyCarMaintenanceData;
  }



  public JScrollPane getJspMonthlyCarMaintenanceData() {
    return jspMonthlyCarMaintenanceData;
  }



  public DefaultTableModel getDtmDetailedCarMaintenanceData() {
    return dtmDetailedCarMaintenanceData;
  }



  public JTable getJtDetailedCarMaintenanceData() {
    return jtDetailedCarMaintenanceData;
  }



  public JScrollPane getJspDetailedCarMaintenanceData() {
    return jspDetailedCarMaintenanceData;
  }



  public static void main(String[] args) {
    new MonthlyCarMaintenanceView();
  }
}
