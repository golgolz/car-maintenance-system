package kr.co.sist.user.history;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PreventiMaintenanceView extends JFrame {
  private JLabel jlPreventiMaintenance;
  private JScrollPane jspPreventiData;
  private DefaultTableModel dtmPreventiData;
  private JTable jtPreventiTable;

  public PreventiMaintenanceView() {
    jlPreventiMaintenance = new JLabel("예방 정비 내역");
    dtmPreventiData = new DefaultTableModel();
    jtPreventiTable = new JTable(dtmPreventiData);
    jspPreventiData = new JScrollPane(jtPreventiTable);

    // Set up the table model
    dtmPreventiData.addColumn("정비 일자");
    dtmPreventiData.addColumn("차량 번호");
    dtmPreventiData.addColumn("정비 내역");
    dtmPreventiData.addColumn("주행 거리");

    setLayout(null);

    jlPreventiMaintenance.setBounds(20, 10, 100, 30);
    jspPreventiData.setBounds(20, 80, 780, 300);

    add(jlPreventiMaintenance);
    add(jspPreventiData);


    showAllPreventiMaintenances();
    setBounds(200, 320, 840, 480);
    setVisible(true);
    setResizable(false);
  }

  public void showAllPreventiMaintenances() {
    Object[][] exampleData = {{"2024-01-01", "123사3456", "범퍼", "12,000km"},};

    for (Object[] rowData : exampleData) {
      dtmPreventiData.addRow(rowData);
    }

  }

  public static void main(String[] args) {
    new PreventiMaintenanceView();
  }
}
