package kr.co.sist.admin.manage.reserved_car;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class ReservedCarView extends JFrame {
  private ReservedCarEvent reservedCarEvent;

  private JLabel jlReservedCarView;
  private JLabel jlCarId;
  private JLabel jlOwnerId;

  private JTextField jtfCarId;
  private JTextField jtfOwnerId;
  private JButton jbtnSearch;
  private JButton jbtnMaintenanceProgress;

  private DefaultTableModel dtmReservedCar;
  private JTable jtReservedCar;
  private JScrollPane jspReservedCarData;

  private String maintenanceStatusText;

  public ReservedCarView() {
    this.reservedCarEvent = reservedCarEvent;

    jlReservedCarView = new JLabel("입고 차량 관리");
    jlCarId = new JLabel("차량 번호");
    jlOwnerId = new JLabel("ID");

    jtfCarId = new JTextField();
    jtfOwnerId = new JTextField();
    jbtnSearch = new JButton("조회");
    jbtnMaintenanceProgress = new JButton("정비 대기");


    maintenanceStatusText = jbtnMaintenanceProgress.getText();

    dtmReservedCar = new DefaultTableModel();
    jtReservedCar = new JTable(dtmReservedCar);
    jspReservedCarData = new JScrollPane(jtReservedCar);

    dtmReservedCar.addColumn("차량번호");
    dtmReservedCar.addColumn("연식");
    dtmReservedCar.addColumn("주행거리");
    dtmReservedCar.addColumn("정비입고일");
    dtmReservedCar.addColumn("정비출고일");
    dtmReservedCar.addColumn("사용자ID");
    dtmReservedCar.addColumn("정비분류");
    dtmReservedCar.addColumn("정비상태");

    showAllReservedcarData();

    jtReservedCar.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());

    jtReservedCar.getColumnModel().getColumn(0).setPreferredWidth(100);
    jtReservedCar.getColumnModel().getColumn(1).setPreferredWidth(100);
    jtReservedCar.getColumnModel().getColumn(2).setPreferredWidth(100);
    jtReservedCar.getColumnModel().getColumn(3).setPreferredWidth(100);
    jtReservedCar.getColumnModel().getColumn(4).setPreferredWidth(100);
    jtReservedCar.getColumnModel().getColumn(5).setPreferredWidth(100);
    jtReservedCar.getColumnModel().getColumn(6).setPreferredWidth(100);
    jtReservedCar.getColumnModel().getColumn(7).setPreferredWidth(100);


    // Set layout
    setLayout(null);

    jlReservedCarView.setBounds(20, 10, 100, 30);
    jlCarId.setBounds(20, 50, 100, 30);
    jlOwnerId.setBounds(150, 50, 100, 30);
    jtfCarId.setBounds(20, 90, 100, 30);
    jtfOwnerId.setBounds(150, 90, 100, 30);
    jbtnSearch.setBounds(280, 90, 80, 30);
    jspReservedCarData.setBounds(20, 140, 780, 280);


    add(jlReservedCarView);
    add(jlCarId);
    add(jtfCarId);
    add(jlOwnerId);
    add(jtfOwnerId);
    add(jbtnSearch);
    add(jbtnMaintenanceProgress);
    add(jspReservedCarData);

    setBounds(200, 320, 840, 480);
    setVisible(true);
    setResizable(false);
  }

  public void showAllReservedcarData() {
    Object[][] exampleData =
        {{"ABC123", "2018", "10000", "2024-03-24", "2024-03-25", "user1", "일반", jbtnMaintenanceProgress.getText()}};

    for (Object[] rowData : exampleData) {
      dtmReservedCar.addRow(rowData);
    }

  }

  // Button renderer class
  class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
      setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
        int row, int column) {
      setText((value == null) ? "" : value.toString());
      return this;
    }
  }

  public static void main(String[] args) {
    new ReservedCarView();
  }
}
