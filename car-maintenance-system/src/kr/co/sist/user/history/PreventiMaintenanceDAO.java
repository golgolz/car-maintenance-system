package kr.co.sist.user.history;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kr.co.sist.dao.DBConnection;

public class PreventiMaintenanceDAO {

  private static PreventiMaintenanceDAO pmDAO;

  PreventiMaintenanceDAO() {

  }

  static PreventiMaintenanceDAO getInstance() {
    if (pmDAO == null) {
      pmDAO = new PreventiMaintenanceDAO();
    }
    return pmDAO;
  }// getInstance

  // DB에서 데이터를 조회하여 리스트로 반환하는 메소드
  public List<PreventiMaintenanceVO> getAllPreventiMaintenance() throws SQLException {

    DBConnection dbConn = DBConnection.getInstance();
    List<PreventiMaintenanceVO> preventiMaintenanceList = new ArrayList<>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    // 재작성
    try {
      conn = DBConnection.getInstance().getConnection();
      String query = "SELECT CAR_ID, CAR_MAINTENANCE_DATE, maintenance_reason FROM car_maintenance_settlement";
      pstmt = conn.prepareStatement(query);
      rs = pstmt.executeQuery();

      // dtmPreventiData.addColumn("차량 번호");
      // dtmPreventiData.addColumn("정비 일자");
      // dtmPreventiData.addColumn("정비 내역");
      while (rs.next()) {
        String carId = rs.getString("CAR_ID");
        Date carMaintenaceDate = rs.getDate("CAR_MAINTENANCE_DATE");
        String maintenanceReason = rs.getString("maintenance_reason");

        System.out.println("CAR_ID: " + carId + ", CAR_MAINTENANCE_DATE: " + carMaintenaceDate
            + ", MAINTENANCE_REASON: " + maintenanceReason);

        PreventiMaintenanceVO preventiMaintenanceVO =
            new PreventiMaintenanceVO(carId, carMaintenaceDate, maintenanceReason);
        preventiMaintenanceList.add(preventiMaintenanceVO);
      }
    } finally {
      dbConn.dbClose(conn, pstmt, rs);
    }

    return preventiMaintenanceList;
  }

  public List<PreventiMaintenanceVO> getNormalMaintenanceData() throws SQLException {
    DBConnection dbConn = DBConnection.getInstance();
    List<PreventiMaintenanceVO> normalMaintenanceList = new ArrayList<>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      conn = DBConnection.getInstance().getConnection();
      String query =
          "SELECT CAR_ID, CAR_MAINTENANCE_DATE, MAINTENANCE_REASON FROM car_maintenance_settlement WHERE MAINTENANCE_CLASSIFICATION = ?";
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, "일반");
      rs = pstmt.executeQuery();

      // 디버깅 코드: 쿼리 실행 결과를 콘솔에 출력
      System.out.println("Debugging: Printing data retrieved from the database for '일반' maintenance...");
      while (rs.next()) {
        String carId = rs.getString("CAR_ID");
        Date carMaintenaceDate = rs.getDate("CAR_MAINTENANCE_DATE");
        String maintenanceReason = rs.getString("MAINTENANCE_REASON");

        System.out.println("CAR_ID: " + carId + ", CAR_MAINTENANCE_DATE: " + carMaintenaceDate
            + ", MAINTENANCE_REASON: " + maintenanceReason);

        PreventiMaintenanceVO normalMaintenanceVO =
            new PreventiMaintenanceVO(carId, carMaintenaceDate, maintenanceReason);
        normalMaintenanceList.add(normalMaintenanceVO);
      }
      System.out.println("Debugging: Data retrieval from the database for '일반' maintenance complete.");
    } finally {
      dbConn.dbClose(conn, pstmt, rs);
    }

    return normalMaintenanceList;
  }

  // public static void main(String[] args) {
  //
  // }
}
