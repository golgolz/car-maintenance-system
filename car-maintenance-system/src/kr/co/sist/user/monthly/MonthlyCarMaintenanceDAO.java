package kr.co.sist.user.monthly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kr.co.sist.dao.DBConnection;

public class MonthlyCarMaintenanceDAO {
  // 싱글턴 패턴
  private static MonthlyCarMaintenanceDAO mcmDAO;

  // 생성자
  MonthlyCarMaintenanceDAO() {

  }// MonthlyCarMaintenanceVDAO

  static MonthlyCarMaintenanceDAO getInstance() {
    if (mcmDAO == null) {
      mcmDAO = new MonthlyCarMaintenanceDAO();
    }
    return mcmDAO;
  }// getInstance

  public List<MonthlyCarMaintenanceVO> selectAllData() throws SQLException {

    List<MonthlyCarMaintenanceVO> allData = new ArrayList<MonthlyCarMaintenanceVO>();

    // 1. 드라이버 로딩
    DBConnection dbConn = DBConnection.getInstance();

    // 2. 커넥션 객체 생성
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      // 3. 쿼리문 생성

      // 사용자(이름)x정비이력(정비 일자)X부품재고(부품명,판매가격,수량)
      String selectAllData = "SELECT\n" + "    owner.name,\n" + "    car_maintenance_settlement.car_maintenance_date,\n"
          + "    inventory.part_name,\n" + "    inventory.part_price,\n" + "    inventory.part_cnt\n" + "FROM\n"
          + "    owner\n" + "INNER JOIN\n" + "    reserved_car ON owner.owner_id = reserved_car.owner_id\n"
          + "INNER JOIN\n"
          + "    car_maintenance_settlement ON reserved_car.car_id = car_maintenance_settlement.car_id\n"
          + "INNER JOIN\n"
          + "    product_cnt ON car_maintenance_settlement.car_maintenance_id = product_cnt.car_maintenance_id\n"
          + "INNER JOIN\n" + "    inventory ON product_cnt.part_code = inventory.part_code";
      conn = dbConn.getConnection();
      pstmt = conn.prepareStatement(selectAllData);

      // 4. 바인드 변수 설정

      // 5. 쿼리 실행 및 결과 확인
      rs = pstmt.executeQuery();
      while (rs.next()) {
        allData.add(new MonthlyCarMaintenanceVO(rs.getString("owner.name"),
            rs.getDate("car_maintenance_settlement.car_maintenance_date"), rs.getString("inventory.part_name"),
            rs.getInt("inventory.part_price"), rs.getInt("inventory.part_cnt")));
      }
    } finally {
      // 6. 연결 끊기
      dbConn.dbClose(conn, pstmt, rs);
    }
    return allData;
  }// selectAllData

  public static List<String> getAllMaintenanceDates() throws SQLException {
    List<String> maintenanceDates = new ArrayList<>();

    // 1. 드라이버 로딩
    DBConnection dbConn = DBConnection.getInstance();

    // 2. 커넥션 객체 생성
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      // 3. 쿼리문 생성
      String query = "SELECT DISTINCT car_maintenance_date FROM car_maintenance_settlement";

      // 4. 커넥션 연결
      conn = dbConn.getConnection();

      // 5. PreparedStatement 객체 생성
      pstmt = conn.prepareStatement(query);

      // 6. 쿼리 실행
      rs = pstmt.executeQuery();

      // 7. 결과 처리
      while (rs.next()) {
        maintenanceDates.add(rs.getString("car_maintenance_date"));
      }
    } finally {
      // 8. 연결 종료
      dbConn.dbClose(conn, pstmt, rs);
    }

    return maintenanceDates;
  }

  public static void main(String[] args) throws SQLException {
    getAllMaintenanceDates();
  }
}
