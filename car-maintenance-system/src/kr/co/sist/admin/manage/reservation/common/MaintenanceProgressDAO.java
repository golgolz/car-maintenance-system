package kr.co.sist.admin.manage.reservation.common;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.table.DefaultTableModel;
import kr.co.sist.dao.DBConnection;

public class MaintenanceProgressDAO {

  // 싱글턴 패턴
  private static MaintenanceProgressDAO mpDAO;
  private MaintenanceProgressView maintenanceProgressView;
  private DefaultTableModel model;

  // 생성자
  MaintenanceProgressDAO(MaintenanceProgressView maintenanceProgressView) {
    this.maintenanceProgressView = maintenanceProgressView;
    this.model = (DefaultTableModel) maintenanceProgressView.getMaintenanceProgressTable().getModel();
  }

  static MaintenanceProgressDAO getInstance(MaintenanceProgressView maintenanceProgressView) {
    if (mpDAO == null) {
      mpDAO = new MaintenanceProgressDAO(maintenanceProgressView);
    }
    return mpDAO;
  }

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
          + "FROM inventory i " + "JOIN reservation r ON i.part_name = r.reservation_reason "
          + "WHERE r.maintenance_classification = '일반'";
      pstmt = conn.prepareStatement(query);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        String partCode = rs.getString("part_code");
        String partName = rs.getString("part_name");
        int partPrice = rs.getInt("part_price");
        int partCnt = rs.getInt("part_cnt");
        String maintenanceClassification = rs.getString("maintenance_classification");

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
  public void addPartInfo(String partCode, int partCnt, String partName, String maintenanceClassification)
      throws SQLException {
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      conn = DBConnection.getInstance().getConnection();
      String insertPartInfoQuery =
          "INSERT INTO car_maintenance_settlement(car_id, CAR_MAINTENANCE_ID, part_code, part_cnt, MAINTENANCE_CLASSIFICATION, maintenance_reason, CAR_MAINTENANCE_DATE) "
              + "VALUES (?, ?, ?, ?, ?, ?, ?)";
      // for (int row = 0; row < model.getRowCount(); row++) { // 각 행을 반복하면서
      // String partCode = (String) model.getValueAt(row, 0); // 부품 코드 가져오기
      // int partCnt = (int) model.getValueAt(row, 2); // 수량 가져오기
      // String partName = (String) model.getValueAt(row, 1); // 부품명 가져오기

      pstmt = conn.prepareStatement(insertPartInfoQuery);
      String carid = "234오6789";

      pstmt.setString(1, carid);

      // Random 객체 생성
      Random random = new Random();

      // CAR_MAINTENANCE_ID 값을 5부터 999 사이의 랜덤한 정수로 설정
      int carMaintenanceId = random.nextInt(995) + 6;


      pstmt.setInt(2, carMaintenanceId);

      // 정수1 생성 (100부터 999 사이의 랜덤한 정수)
      int num1 = random.nextInt(900) + 100;

      // 문자 '가' 추가
      String character = "가";

      // 정수2 생성 (1000부터 9999 사이의 랜덤한 정수)
      int num2 = random.nextInt(9000) + 1000;

      // car_id 형식에 맞게 조합
      String carId = num1 + character + num2;
      // pstmt.setString(2, carId);

      pstmt.setString(3, partCode);
      pstmt.setInt(4, partCnt);
      pstmt.setString(5, maintenanceClassification);
      pstmt.setString(6, partName);

      // 현재 시간을 가져와서 포맷팅
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String currentDate = sdf.format(new Date());

      pstmt.setString(7, currentDate);

      pstmt.executeUpdate(); // 실행

    } finally {
      // Close resources
      DBConnection.getInstance().close(conn, pstmt);
    }
  }

}
