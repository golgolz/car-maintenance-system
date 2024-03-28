package kr.co.sist.user.monthly;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
            String selectAllData = "SELECT\n" + "    owner.name,\n"
                    + "    car_maintenance_settlement.car_maintenance_date,\n" + "    inventory.part_name,\n"
                    + "    inventory.part_price,\n" + "    inventory.part_cnt\n" + "FROM\n" + "    owner\n"
                    + "INNER JOIN\n" + "    reserved_car ON owner.owner_id = reserved_car.owner_id\n" + "INNER JOIN\n"
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
                        rs.getDate("car_maintenance_settlement.car_maintenance_date"),
                        rs.getString("inventory.part_name"), rs.getInt("inventory.part_price"),
                        rs.getInt("inventory.part_cnt")));
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

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM"); // 월까지만

            // 7. 결과 처리
            while (rs.next()) {
                Date date = rs.getDate("car_maintenance_date");
                String maintenanceMonth = sdf.format(date);
                maintenanceDates.add(maintenanceMonth);
            }
        } finally {
            // 8. 연결 종료
            dbConn.dbClose(conn, pstmt, rs);
        }

        return maintenanceDates;
    }

    static public List<MonthlyCarMaintenanceVO> getMaintenanceData(String selectedItem) throws SQLException {
        List<MonthlyCarMaintenanceVO> maintenanceData = new ArrayList<>();

        // 드라이버 로딩
        DBConnection dbConn = DBConnection.getInstance();

        // 커넥션 객체 생성
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 쿼리문 생성
            String query = "SELECT owner.name AS ownerName, "
                    + "TO_CHAR(car_maintenance_settlement.car_maintenance_date, 'YYYY-MM-DD') AS maintenanceDate "
                    + "FROM car_maintenance_settlement "
                    + "INNER JOIN reserved_car ON reserved_car.car_id = car_maintenance_settlement.car_id "
                    + "INNER JOIN owner ON owner.owner_id = reserved_car.owner_id "
                    + "WHERE TO_CHAR(car_maintenance_settlement.car_maintenance_date, 'yyyy-MM')= ?";

            // 커넥션 연결
            conn = dbConn.getConnection();

            // PreparedStatement 객체 생성
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, selectedItem);

            // 쿼리 실행
            rs = pstmt.executeQuery();


            // 7. 결과 처리

            // 결과 처리
            while (rs.next()) {
                // System.out.println(rs.getString("ownerName"));
                maintenanceData
                        .add(new MonthlyCarMaintenanceVO(rs.getString("ownerName"), rs.getString("maintenanceDate")));
            }
        } finally {
            // 연결 종료
            dbConn.dbClose(conn, pstmt, rs);
        }

        return maintenanceData;
    }

    public static List<MonthlyCarMaintenanceVO> getDetailedData(String ownerName, String maintenanceDate)
            throws SQLException {
        List<MonthlyCarMaintenanceVO> detailedData = new ArrayList<>();

        // 드라이버 로딩
        DBConnection dbConn = DBConnection.getInstance();

        // 커넥션 객체 생성
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 쿼리문 생성
            String query = "SELECT " + "inventory.part_name, " + "inventory.part_price, "
                    + "car_maintenance_settlement.part_cnt, "
                    + "(inventory.part_price * car_maintenance_settlement.part_cnt) AS total_price " + "FROM "
                    + "owner " + "INNER JOIN " + "reserved_car ON owner.owner_id = reserved_car.owner_id "
                    + "INNER JOIN "
                    + "car_maintenance_settlement ON reserved_car.car_id = car_maintenance_settlement.car_id "
                    + "INNER JOIN "
                    + "product_cnt ON car_maintenance_settlement.car_maintenance_id = product_cnt.car_maintenance_id "
                    + "INNER JOIN " + "inventory ON product_cnt.part_code = inventory.part_code " + "WHERE "
                    + "owner.name = ? AND car_maintenance_settlement.car_maintenance_date = ?";

            // 커넥션 연결
            conn = dbConn.getConnection();

            // PreparedStatement 객체 생성
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, ownerName);
            pstmt.setString(2, maintenanceDate);

            // 쿼리 실행
            rs = pstmt.executeQuery();

            // 결과 처리
            while (rs.next()) {
                String partName = rs.getString("part_name");
                int partPrice = rs.getInt("part_price");
                int partCnt = rs.getInt("part_cnt");
                int totalPrice = rs.getInt("total_price");

                // 데이터 출력 (디버그용)
                // System.out.println("Part Name: " + partName);
                // System.out.println("Part Price: " + partPrice);
                // System.out.println("Part Count: " + partCnt);
                // System.out.println(totalPrice);

                // MonthlyCarMaintenanceVO 객체에 추가
                detailedData.add(new MonthlyCarMaintenanceVO(partName, partPrice, partCnt, totalPrice));
            }
        } finally {
            // 연결 종료
            dbConn.dbClose(conn, pstmt, rs);
        }

        return detailedData;
    }

    static String str1 = "홍성강";
    static String str2 = "2024-02-02";

    public static void main(String[] args) {
        try {
            getDetailedData(str1, str2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
