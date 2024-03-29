package kr.co.sist.user.history;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import kr.co.sist.FontSingleton;



public class CommonMaintenanceView extends JFrame {



  private CommonMaintenanceEvent commonMaintenanceEvent;
  private JLabel jlCommonMaintenanceView;
  private DefaultTableModel dtmCommon;
  private JTable jtCommonTable;
  private JButton jbtnDelete;

  public CommonMaintenanceView() {

    super("일반 정비 내역");

    this.getContentPane().setBackground(Color.decode("#002347"));

    jlCommonMaintenanceView = new JLabel("일반 정비 내역");
    jbtnDelete = new JButton("취소");

    dtmCommon = new DefaultTableModel();
    jtCommonTable = new JTable(dtmCommon);
    JScrollPane scrollPane = new JScrollPane(jtCommonTable);

    dtmCommon.addColumn("정비 번호");
    dtmCommon.addColumn("정비 일자");
    dtmCommon.addColumn("정비 내역");

    // 비고 컬럼에 버튼 삽입
    // jtCommonTable.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());

    jtCommonTable.getColumnModel().getColumn(0).setPreferredWidth(100);
    jtCommonTable.getColumnModel().getColumn(1).setPreferredWidth(200);
    jtCommonTable.getColumnModel().getColumn(2).setPreferredWidth(100);


    // 테이블 헤더 폰트 설정 방법
    jtCommonTable.getTableHeader().setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
    // 테이블 정렬
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
    jtCommonTable.setDefaultRenderer(Object.class, centerRenderer);

    setLayout(null);


    jlCommonMaintenanceView.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));


    jlCommonMaintenanceView.setBounds(20, 10, 200, 30);
    scrollPane.setBounds(20, 80, 780, 300);

    add(jlCommonMaintenanceView);
    add(scrollPane);

    // 폰트 색상
    jlCommonMaintenanceView.setForeground(Color.WHITE);

    showAllCommonMaintenances();
    setBounds(200, 320, 840, 480);
    setVisible(true);
    setResizable(false);

    setLocationRelativeTo(null);

  }

  public void loadData2() throws SQLException {
    // 기존 데이터 삭제
    dtmCommon.setRowCount(0);
    // DAO를 사용하여 데이터 가져오기
    PreventiMaintenanceDAO commonMaintenanceViewDAO = PreventiMaintenanceDAO.getInstance();
    List<PreventiMaintenanceVO> preventiMaintenanceList = commonMaintenanceViewDAO.getNormalMaintenanceData();
    // 가져온 데이터를 테이블에 추가
    for (PreventiMaintenanceVO maintenanceVO : preventiMaintenanceList) {
      addRowToTable(maintenanceVO);
    }
  }

  public void addRowToTable(PreventiMaintenanceVO maintenanceVO) {
    Object[] rowData =
        {maintenanceVO.getCarId(), maintenanceVO.getCarMaintenanceDate(), maintenanceVO.getMaintenanceReason()};
    dtmCommon.addRow(rowData);
  }


  public void showAllCommonMaintenances() {
    Object[][] exampleData =
        {{"123사3456", "엔진오일교체", "2024-03-10",}, {"234사2345", " ", " "}, {"34주3456", " ", " "}, {"24다4678", " ", " "},};

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
