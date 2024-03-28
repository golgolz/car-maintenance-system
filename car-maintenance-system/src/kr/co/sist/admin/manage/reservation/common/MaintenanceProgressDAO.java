package kr.co.sist.admin.manage.reservation.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import kr.co.sist.dao.DBConnection;

public class MaintenanceProgressDAO {

  // 싱글턴 패턴
  private static MaintenanceProgressDAO mpDAO;
  private MaintenanceProgressView maintenanceProgressView;
  DefaultTableModel model = (DefaultTableModel) maintenanceProgressView.getMaintenanceProgressTable().getModel(); // 모델
                                                                                                                  // 가져오기

  // 생성자
  MaintenanceProgressDAO() {

  }// MaintenanceProgressDAO

  static MaintenanceProgressDAO getInstance() {
    if (mpDAO == null) {
      mpDAO = new MaintenanceProgressDAO();
    }
    return mpDAO;
  }// getInstance

  // 정비 분류가 "일반"인 데이터를 불러오는 메소드
  public List<MaintenanceProgressVO> getGeneralMaintenanceData() throws SQLException {

    List<MaintenanceProgressVO> maintenanceProgressList = new ArrayList<>();
    DBConnection dbConn = DBConnection.getInstance();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      conn = dbConn.getConnection();
      String query = "SELECT i.part_code, i.part_name, i.part_price, i.part_cnt, r.maintenance_classification "
          + "FROM inventory i " + "JOIN reservation r ON i.part_code = r.part_code "
          + "WHERE r.maintenance_classification = '일반'";
      pstmt = conn.prepareStatement(query);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        String partCode = rs.getString("i.part_code");
        String partName = rs.getString("i.part_name");
        int partPrice = rs.getInt("i.part_price");
        int partCnt = rs.getInt("i.part_cnt");
        String maintenanceClassification = rs.getString("r.maintenance_classification");

        MaintenanceProgressVO maintenanceProgressVO =
            new MaintenanceProgressVO(partCode, partName, partPrice, partCnt, maintenanceClassification);
        maintenanceProgressList.add(maintenanceProgressVO);
      }
    } finally {
      dbConn.dbClose(conn, pstmt, rs);
    }

    return maintenanceProgressList;
  }// MaintenanceProgressDAO

  // 부품 정보 추가 메서드
  public void addPartInfo(String maintenanceClassification) throws SQLException {
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      conn = DBConnection.getInstance().getConnection();
      String insertPartInfoQuery =
          "INSERT INTO car_maintenance_settlement(part_code, part_cnt,  MAINTENANCE_CLASSIFICATION, maintenance_reason) VALUES (?, ?, ?, ?)";

      for (int row = 0; row < model.getRowCount(); row++) { // 각 행을 반복하면서
        String partCode = (String) model.getValueAt(row, 0); // 부품 코드 가져오기
        int partCnt = (int) model.getValueAt(row, 2); // 수량 가져오기
        String partName = (String) model.getValueAt(row, 1); // 부품명 가져오기

        pstmt.setString(1, partCode); // PreparedStatement에 값 설정
        pstmt.setInt(2, partCnt);
        pstmt.setString(3, maintenanceClassification);
        pstmt.setString(4, partName);

        pstmt.executeUpdate(); // 실행
      }
    } finally {
      // Close resources
      DBConnection.getInstance().close(conn, pstmt);
    }
  }

}
