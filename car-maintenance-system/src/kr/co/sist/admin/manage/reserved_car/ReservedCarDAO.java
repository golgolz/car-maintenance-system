package kr.co.sist.admin.manage.reserved_car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import kr.co.sist.dao.DBConnection;

public class ReservedCarDAO {

    private static ReservedCarDAO rcDAO;

    private ReservedCarDAO() {}

    public static ReservedCarDAO getInstance() {
        if (rcDAO == null) {
            rcDAO = new ReservedCarDAO();
        }
        return rcDAO;
    }

    /**
     * 모든 입고 차량을 조회하는 method
     * 
     * @return
     * @throws SQLException
     */
    public List<ReservedCarVO> selectReservedAllCar() throws SQLException {
        List<ReservedCarVO> reservedList = new ArrayList<ReservedCarVO>();
        ReservedCarVO rcVO = null;

        // 드라이버 로딩
        DBConnection dbCon = DBConnection.getInstance();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Connection 얻기
            con = dbCon.getConnection();

            // 쿼리문 생성 객체 얻기
            StringBuilder selectReservedAll = new StringBuilder();

            selectReservedAll.append(
                    "select rc.car_id,rc.car_year,rc.drive_distance,rc.reserved_date,rc.released_date,rc.owner_id,rs.maintenance_classification,rc.maintenance_status ")
                    .append("from reserved_car rc, reservation rs ").append("where rc.car_id=rs.car_id");

            pstmt = con.prepareStatement(selectReservedAll.toString());

            // 쿼리문 수행 후 결과 얻기
            rs = pstmt.executeQuery();

            while (rs.next()) {
                rcVO = new ReservedCarVO(rs.getString("car_id"), rs.getString("owner_id"), rs.getString("car_model"),
                        rs.getDate("reserved_date"), rs.getDate("released_date"), rs.getInt("car_year"),
                        rs.getInt("drive_distance"), rs.getString("maintenance_status"));

                reservedList.add(rcVO);
            } // end while

        } finally {
            // 연결 끊기
            dbCon.dbClose(con, pstmt, rs);
        } // end finally

        return reservedList;
    }


    /**
     * 사용자 ID를 입력받아 입고 차량을 조회하는 method
     * 
     * @return
     * @throws SQLException
     */
    public List<ReservedCarVO> selectReservedCarByOwnerId() throws SQLException {
        List<ReservedCarVO> reservedList = new ArrayList<ReservedCarVO>();
        ReservedCarVO rcVO = null;

        DBConnection dbCon = DBConnection.getInstance();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = dbCon.getConnection();

            StringBuilder selectReservedById = new StringBuilder();

            selectReservedById.append(
                    "select rc.car_id,rc.car_year,rc.drive_distance,rc.reserved_date,rc.released_date,rc.owner_id,rs.maintenance_classification,rc.maintenance_status ")
                    .append("from reserved_car rc, reservation rs ")
                    .append("where (rc.car_id=rs.car_id) and rc.owner_id=?");

            pstmt = con.prepareStatement(selectReservedById.toString());

            rs = pstmt.executeQuery();

            while (rs.next()) {
                rcVO = new ReservedCarVO(rs.getString("car_id"), rs.getString("owner_id"), rs.getString("car_model"),
                        rs.getDate("reserved_date"), rs.getDate("released_date"), rs.getInt("car_year"),
                        rs.getInt("drive_distance"), rs.getString("maintenance_status"));

                reservedList.add(rcVO);
            } // end while
        } finally {
            dbCon.dbClose(con, pstmt, rs);
        } // end finally
        return reservedList;
    }

    /**
     * 입고 차량 테이블에 차량을 추가 하는 method
     * 
     * @throws SQLException
     */
    public void insertReservedCar(ReservedCarVO rcVO) throws SQLException {
        DBConnection dbCon = DBConnection.getInstance();

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = dbCon.getConnection();

            String insertReservedCar =
                    "insert into reserved_car(car_id,owner_id,car_model,reserved_date,released_date,car_year,drive_distance,maintenance_status) values(?,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(insertReservedCar);

            pstmt.setString(1, rcVO.getCarId());
            pstmt.setString(2, rcVO.getOwnerId());
            pstmt.setString(3, rcVO.getCarModel());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            pstmt.setString(4, dateFormat.format(rcVO.getReservedDate()));
            pstmt.setString(5, dateFormat.format(rcVO.getReleasedDate()));
            pstmt.setInt(6, rcVO.getCarYear());
            pstmt.setInt(7, rcVO.getDriveDistance());
            pstmt.setString(8, rcVO.getMaintenanceStatus());

            pstmt.executeUpdate();
        } finally {
            dbCon.close(con, pstmt);
        } // end finally
    }// insertReservedCar


    /**
     * 입고 차량의 차량 ID 중복 체크 하는 method
     * 
     * @param carId
     * @return
     * @throws SQLException
     */
    public boolean checkCarIdDuplication(String carId) throws SQLException {
        boolean checkCarIdFlag = false;

        // 1.드라이버 로딩
        DBConnection dbCon = DBConnection.getInstance();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 2.Connection 얻기
        try {
            con = dbCon.getConnection();

            // 3. 쿼리문 생성 객체 얻기
            StringBuilder checkCarId = new StringBuilder();

            checkCarId.append("select car_id ").append(" from reserved_car ").append("where car_id=?");

            pstmt = con.prepareStatement(checkCarId.toString());

            // 바인드 변수 값 설정
            pstmt.setString(1, carId);
            // 쿼리문 실행 객체 얻기
            rs = pstmt.executeQuery();

            while (rs.next()) {
                checkCarIdFlag = true;
            }

        } finally {
            dbCon.dbClose(con, pstmt, rs);
        } // end finally

        return checkCarIdFlag;
    }

}
