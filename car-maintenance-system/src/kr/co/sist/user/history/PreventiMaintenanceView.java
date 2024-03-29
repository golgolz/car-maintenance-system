package kr.co.sist.user.history;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import kr.co.sist.FontSingleton;

public class PreventiMaintenanceView extends JFrame {

  private JLabel jlPreventiMaintenance;
  private JScrollPane jspPreventiData;
  private DefaultTableModel dtmPreventiData;
  private JTable jtPreventiTable;
  private PreventiMaintenanceView preventiMaintenanceView;
  private MaintenanceManagementView maintenanceManagementView;


  public PreventiMaintenanceView() {
    super("예방정비이력");

    this.getContentPane().setBackground(Color.decode("#002347"));
    jlPreventiMaintenance = new JLabel("예방 정비 내역");

    String[] Header = {"정비 번호", "정비 일자", "부품 코드"};
    dtmPreventiData = new DefaultTableModel();
    jtPreventiTable = new JTable(dtmPreventiData);
    jspPreventiData = new JScrollPane(jtPreventiTable);

    // 테이블 헤더 폰트 설정 방법
    jtPreventiTable.getTableHeader().setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
    // 테이블 정렬
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
    jtPreventiTable.setDefaultRenderer(Object.class, centerRenderer);

    // Set up the table model
    dtmPreventiData.addColumn("정비 번호");
    dtmPreventiData.addColumn("정비 일자");
    dtmPreventiData.addColumn("정비 내역");

    setLayout(null);

    jlPreventiMaintenance.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));

    jlPreventiMaintenance.setBounds(20, 10, 200, 30);
    jspPreventiData.setBounds(20, 80, 780, 300);

    add(jlPreventiMaintenance);
    add(jspPreventiData);

    jlPreventiMaintenance.setForeground(Color.WHITE);


    // try {
    // showAllPreventiMaintenances();
    // } catch (SQLException e) {
    // e.printStackTrace();
    // }

    setBounds(200, 320, 840, 480);
    setVisible(true);
    setResizable(false);
  }

  // 데이터 로드 메서드를 생성자 밖으로 이동
  public void loadData() throws SQLException {
    // 기존 데이터 삭제
    dtmPreventiData.setRowCount(0);
    // DAO를 사용하여 데이터 가져오기
    PreventiMaintenanceDAO preventiMaintenanceDAO = PreventiMaintenanceDAO.getInstance();
    List<PreventiMaintenanceVO> preventiMaintenanceList = preventiMaintenanceDAO.getAllPreventiMaintenance();
    // 가져온 데이터를 테이블에 추가
    for (PreventiMaintenanceVO maintenanceVO : preventiMaintenanceList) {
      addRowToTable(maintenanceVO);
    }
  }


  // public Object[][] showAllPreventiMaintenances() throws SQLException {
  // // DAO를 사용하여 데이터 가져오기
  // PreventiMaintenanceDAO preventiMaintenanceDAO = PreventiMaintenanceDAO.getInstance();
  //
  // List<PreventiMaintenanceVO> preventiMaintenanceList =
  // preventiMaintenanceDAO.getAllPreventiMaintenance();
  // // 가져온 데이터를 PreventiMaintenanceView의 테이블에 추가
  // Object[][] preventiTargetModel = new Object[preventiMaintenanceList.size()][10];
  // for (PreventiMaintenanceVO maintenanceVO : preventiMaintenanceList) {
  //
  // maintenanceManagementView.getPreventiMaintenanceView().addRowToTable(maintenanceVO);
  // }
  // return preventiTargetModel;
  // }


  public PreventiMaintenanceView getPreventiMaintenanceView() {
    return preventiMaintenanceView;
  }

  public JLabel getJlPreventiMaintenance() {
    return jlPreventiMaintenance;
  }

  public JScrollPane getJspPreventiData() {
    return jspPreventiData;
  }

  public DefaultTableModel getDtmPreventiData() {
    return dtmPreventiData;
  }

  public JTable getJtPreventiTable() {
    return jtPreventiTable;
  }

  // 테이블에 행을 추가하는 메소드
  public void addRowToTable(PreventiMaintenanceVO maintenanceVO) {
    Object[] rowData =
        {maintenanceVO.getCarId(), maintenanceVO.getCarMaintenanceDate(), maintenanceVO.getMaintenanceReason()};
    dtmPreventiData.addRow(rowData);
  }

  public static void main(String[] args) {
    new PreventiMaintenanceView();
  }
}
