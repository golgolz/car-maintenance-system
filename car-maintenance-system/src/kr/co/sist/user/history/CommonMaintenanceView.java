package kr.co.sist.user.history;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;



public class CommonMaintenanceView extends JFrame {

  private CommonMaintenanceEvent commonMaintenanceEvent;
  private JLabel jlCommonMaintenanceView;
  private DefaultTableModel dtmCommon;
  private JTable jtCommonTable;
  private JButton jbtnDelete;

  public CommonMaintenanceView() {
    jlCommonMaintenanceView = new JLabel("일반 정비 내역");
    jbtnDelete = new JButton("삭제");

    dtmCommon = new DefaultTableModel();
    jtCommonTable = new JTable(dtmCommon);
    JScrollPane scrollPane = new JScrollPane(jtCommonTable);

    dtmCommon.addColumn("차량번호");
    dtmCommon.addColumn("일반 정비 요청 내용");
    dtmCommon.addColumn("신청날짜");
    dtmCommon.addColumn("접수상태");
    dtmCommon.addColumn("비고");

    // 비고 컬럼에 버튼 삽입
    jtCommonTable.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());

    jtCommonTable.getColumnModel().getColumn(0).setPreferredWidth(100);
    jtCommonTable.getColumnModel().getColumn(1).setPreferredWidth(200);
    jtCommonTable.getColumnModel().getColumn(2).setPreferredWidth(100);
    jtCommonTable.getColumnModel().getColumn(3).setPreferredWidth(100);
    jtCommonTable.getColumnModel().getColumn(4).setPreferredWidth(100);

    setLayout(null);
    jlCommonMaintenanceView.setBounds(20, 10, 100, 30);
    scrollPane.setBounds(20, 80, 780, 300);

    add(jlCommonMaintenanceView);
    add(scrollPane);

    showAllCommonMaintenances();
    setBounds(200, 320, 840, 480);
    setVisible(true);
    setResizable(false);

  }

  public void showAllCommonMaintenances() {
    Object[][] exampleData = {{"123사3456", "엔진오일교체", "2024-03-10", "정비 대기중", jbtnDelete.getText()}};

    for (Object[] rowData : exampleData) {
      dtmCommon.addRow(rowData);
    }

  }

  // 셀 안에 버튼 삽입
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

  public CommonMaintenanceEvent getCommonMaintenanceEvent() {
    return commonMaintenanceEvent;
  }

  public DefaultTableModel getDtmCommon() {
    return dtmCommon;
  }

  public JTable getJtCommonTable() {
    return jtCommonTable;
  }

  public JButton getJbtnDelete() {
    return jbtnDelete;
  }

  public static void main(String[] args) {
    new CommonMaintenanceView();
  }

}
