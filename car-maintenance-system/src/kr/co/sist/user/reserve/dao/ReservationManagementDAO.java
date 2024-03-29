package kr.co.sist.user.reserve.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kr.co.sist.dao.DBConnection;
import kr.co.sist.user.reserve.common.ReservationManagementVO;

public class ReservationManagementDAO {

    private static ReservationManagementDAO rmDAO;

    private ReservationManagementDAO() {}// ReservationManagementDAO

    public static ReservationManagementDAO getInstance() {
        if (rmDAO == null) {
            rmDAO = new ReservationManagementDAO();
        } // end if
        return rmDAO;
    }

    /**
     * 모든 예약 차량 리스트를 조회하는 method
     * 
     * @param maintenanceClassification
     * @return
     * @throws SQLException
     */
    public List<ReservationManagementVO> selectAllReservation() throws SQLException {
        ReservationManagementVO rmVO = null;
        List<ReservationManagementVO> reservationCarList = new ArrayList<ReservationManagementVO>();

        // 1.드라이버 로딩
        DBConnection dbCon = DBConnection.getInstance();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 2.Connection 얻기
        try {
            con = dbCon.getConnection();

            // 3. 쿼리문 생성 객체 얻기
            StringBuilder selectReservationAll = new StringBuilder();

            selectReservationAll.append(
                    "select rs.car_id,ow.name,ow.tel,rs.owner_id,rsi_car.car_model,rsi_car.drive_distance,rser_car.maintenance_status,rsi_car.production_date,rs.reservation_date,rs.reservation_reason ")
                    .append("from reservation rs, owner ow , resisted_car rsi_car , reserved_car rser_car ")
                    .append("where (rs.owner_id = ow.owner_id and rs.car_id = rsi_car.car_id and rs.car_id = rser_car.car_id)");

            pstmt = con.prepareStatement(selectReservationAll.toString());

            // 5. 쿼리문 수행 후 결과 얻기
            rs = pstmt.executeQuery();

            while (rs.next()) {
                rmVO = new ReservationManagementVO(rs.getString("car_id"), rs.getString("name"), rs.getString("tel"),
                        rs.getString("owner_id"), rs.getString("car_model"), rs.getInt("drive_distance"),
                        rs.getString("maintenance_status"), rs.getDate("production_date"),
                        rs.getString("reservation_date"), rs.getString("reservation_reason"));
                reservationCarList.add(rmVO);
            }

        } finally {
            // 6. 연결 끊기
            dbCon.dbClose(con, pstmt, rs);
        }

        return reservationCarList;
    }// selectAllReservation

    /**
     * 정비 분류를 매개변수로 받아 해당 정비의 예약 차량 리스트 전체를 조회하는 method 정비 분류는 일반,정기,리콜 로 분류됨
     * 
     * @param maintenanceClassification
     * @return
     * @throws SQLException
     */
    public List<ReservationManagementVO> selectReservation(String maintenanceClassification) throws SQLException {
        ReservationManagementVO rmVO = null;
        List<ReservationManagementVO> reservationCarList = new ArrayList<ReservationManagementVO>();

        // 1.드라이버 로딩
        DBConnection dbCon = DBConnection.getInstance();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 2.Connection 얻기
        try {
            con = dbCon.getConnection();

            // 3. 쿼리문 생성 객체 얻기
            StringBuilder selectReservationAll = new StringBuilder();

            selectReservationAll.append(
                    "select rs.car_id,ow.name,ow.tel,rs.owner_id,rsi_car.car_model,rsi_car.drive_distance,rser_car.maintenance_status,rsi_car.production_date,rs.reservation_date,rs.reservation_reason ")
                    .append("from reservation rs, owner ow , resisted_car rsi_car , reserved_car rser_car ")
                    .append("where (rs.owner_id = ow.owner_id and rs.car_id = rsi_car.car_id and rs.car_id = rser_car.car_id) and rs.maintenance_classification=?");

            pstmt = con.prepareStatement(selectReservationAll.toString());
            // 4.바인드 변수 값 설정
            pstmt.setString(1, maintenanceClassification);

            // 5. 쿼리문 수행 후 결과 얻기
            rs = pstmt.executeQuery();

            while (rs.next()) {
                rmVO = new ReservationManagementVO(rs.getString("car_id"), rs.getString("name"), rs.getString("tel"),
                        rs.getString("owner_id"), rs.getString("car_model"), rs.getInt("drive_distance"),
                        rs.getString("maintenance_status"), rs.getDate("production_date"),
                        rs.getString("reservation_date"), rs.getString("reservation_reason"));
                reservationCarList.add(rmVO);
            }

        } finally {
            // 6. 연결 끊기
            dbCon.dbClose(con, pstmt, rs);
        }

        return reservationCarList;
    }// selectReservation



    /**
     * 사용자 ID를 입력받아 해당 ID의 정비 분류가 '일반'인 차량의 리스트를 조회하는 method
     * 
     * @param ownerId
     * @return
     * @throws SQLException
     */
    public List<ReservationManagementVO> selectComReservationByOwnerId(String ownerId) throws SQLException {
        ReservationManagementVO rmVO = null;
        List<ReservationManagementVO> reservationCarList = new ArrayList<ReservationManagementVO>();

        DBConnection dbCon = DBConnection.getInstance();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = dbCon.getConnection();

            StringBuilder selectResrvationId = new StringBuilder();
            selectResrvationId.append(
                    "select rs.car_id,ow.name,ow.tel,rs.owner_id,rsi_car.car_model,rsi_car.drive_distance,rser_car.maintenance_status,rsi_car.production_date,rs.reservation_date,rs.reservation_reason ")
                    .append("from reservation rs, owner ow , resisted_car rsi_car , reserved_car rser_car ")
                    .append("where (rs.owner_id = ow.owner_id and rs.car_id = rsi_car.car_id and rs.car_id = rser_car.car_id) and rs.maintenance_classification='일반' and rs.owner_id=?");

            pstmt = con.prepareStatement(selectResrvationId.toString());

            pstmt.setString(1, ownerId);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                rmVO = new ReservationManagementVO(rs.getString("car_id"), rs.getString("name"), rs.getString("tel"),
                        rs.getString("owner_id"), rs.getString("car_model"), rs.getInt("drive_distance"),
                        rs.getString("maintenance_status"), rs.getDate("production_date"),
                        rs.getString("reservation_date"), rs.getString("reservation_reason"));
                reservationCarList.add(rmVO);
            } // end while

        } finally {
            dbCon.dbClose(con, pstmt, rs);
        } // end finally

        return reservationCarList;
    }// selectReservationByOwnerId

    /**
     * 사용자 ID를 입력받아 해당 ID의 정비 분류가 '정기(예방)'인 차량의 리스트를 조회하는 method
     * 
     * @param ownerId
     * @return
     * @throws SQLException
     */
    public List<ReservationManagementVO> selectPreReservationByOwnerId(String ownerId) throws SQLException {
        ReservationManagementVO rmVO = null;
        List<ReservationManagementVO> reservationCarList = new ArrayList<ReservationManagementVO>();

        DBConnection dbCon = DBConnection.getInstance();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = dbCon.getConnection();

            StringBuilder selectResrvationId = new StringBuilder();
            selectResrvationId.append(
                    "select ow.name,rs.owner_id,ow.tel,rs.car_id,rsi_car.car_model,rs.reservation_date,rs.reservation_reason,rser_car.maintenance_status ")
                    .append("from reservation rs, owner ow , resisted_car rsi_car , reserved_car rser_car ")
                    .append("where (rs.owner_id = ow.owner_id and rs.car_id = rsi_car.car_id and rs.car_id = rser_car.car_id) and rs.maintenance_classification='정기' and rs.owner_id=?");

            pstmt = con.prepareStatement(selectResrvationId.toString());

            pstmt.setString(1, ownerId);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                rmVO = new ReservationManagementVO(rs.getString("name"), rs.getString("owner_id"), rs.getString("tel"),
                        rs.getString("car_id"), rs.getString("car_model"), rs.getString("reservation_date"),
                        rs.getString("reservation_reason"), rs.getString("maintenance_status"));
                reservationCarList.add(rmVO);
            } // end while

        } finally {
            dbCon.dbClose(con, pstmt, rs);
        } // end finally

        return reservationCarList;
    }// selectPreReservationByOwnerId



    /**
     * 예약 상태를 변경하는 method
     * 
     * @param rmVO
     * @return
     * @throws SQLException
     */
    public int updateReservationManagement(ReservationManagementVO rmVO) throws SQLException {
        return 0;
    }// updateReservationManagement


    /**
     * 예약 테이블에 예약을 추가하는 method
     * 
     * @param rmVO
     * @throws SQLException
     */
    public void insertReservationManagement(ReservationManagementVO rmVO) throws SQLException {

        // 0.Instance 얻기
        DBConnection dbCon = DBConnection.getInstance();
        // 1.드라이버 로딩
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            // 2.Connection 얻기
            // String id = "car";
            // String pass = "golgol";
            con = dbCon.getConnection();
            // 3.쿼리문 생성 객체 얻기 (값이 들어가는 위치는 바인드 변수 (?)를 사용한다.
            String insertResrvation =
                    "insert into Reservation(owner_id,car_id,reservation_date,reservation_reason,maintenance_classification) values(?,?,?,?,?)";
            pstmt = con.prepareStatement(insertResrvation);
            // 4.바인드 변수 값 설정
            pstmt.setString(1, rmVO.getOwnerId());
            pstmt.setString(2, rmVO.getCarId());
            pstmt.setString(3, rmVO.getReservationDate() + " " + rmVO.getReserveTime());
            pstmt.setString(4, rmVO.getReserveReason());
            pstmt.setString(5, rmVO.getMaintenanceClassification());
            // 5.쿼리문 수행 후 결과 얻기
            pstmt.executeUpdate();
        } finally {
            // 6.연결 끊기
            dbCon.close(con, pstmt);
        } // end finally

    }// insertReservationManagement


    /**
     * 예약 시간 중복 체크를 위해 시간을 조회하는 method
     * 
     * @return
     * @throws SQLException
     */
    public boolean checkDateDuplication(String date) throws SQLException {
        boolean checkDateFlag = false;

        // 1.드라이버 로딩
        DBConnection dbCon = DBConnection.getInstance();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 2.Connection 얻기
        try {
            con = dbCon.getConnection();

            // 3. 쿼리문 생성 객체 얻기
            StringBuilder checkDate = new StringBuilder();

            checkDate.append("select reservation_date").append(" from reservation").append(" where reservation_date=?");

            pstmt = con.prepareStatement(checkDate.toString());

            // 바인드 변수 값 설정
            pstmt.setString(1, date);
            // 쿼리문 실행 객체 얻기
            rs = pstmt.executeQuery();

            while (rs.next()) {
                checkDateFlag = true;
            }

        } finally {
            dbCon.dbClose(con, pstmt, rs);
        }

        return checkDateFlag;
    }



    /**
     * 조건을 충족해 예약 테이블에서 예약 정보를 삭제하는 method
     * 
     * @param rmVO
     */
    public void deleteOneCommonMaintenance(ReservationManagementVO rmVO) {}// deleteOneCommonMaintenance



}
