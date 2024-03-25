package kr.co.sist.user.reserve.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import kr.co.sist.dao.DBConnection;
import kr.co.sist.user.reserve.common.ReservationManagementVO;

public class ReservationManagementDAO {

  private ReservationManagementDAO rmDAO;

  private ReservationManagementDAO() {}// ReservationManagementDAO

  public ReservationManagementDAO getInstance() {
    if (rmDAO == null) {
      rmDAO = new ReservationManagementDAO();
    } // end if
    return rmDAO;
  }

  public List<ReservationManagementVO> selectReservation(String maintenanceClassification) throws SQLException {
    List<ReservationManagementVO> list = null;

    return list;
  }// selectReservation

  public List<ReservationManagementVO> selectReservationByOwnerId(String ownerId) {
    List<ReservationManagementVO> list = null;
    return list;
  }// selectReservationByOwnerId

  public int updateReservationManagement(ReservationManagementVO rmVO) throws SQLException {
    return 0;
  }// updateReservationManagement

  public void insertReservationManagement(ReservationManagementVO rmVO) throws SQLException {

    // 0.Instance 얻기
    DBConnection dbCon = DBConnection.getInstance();
    // 1.드라이버 로딩
    Connection con = null;
    PreparedStatement pstmt = null;

    try {
      // 2.Connection 얻기
      con = dbCon.getConnection();
      // 3.쿼리문 생성 객체 얻기 (값이 들어가는 위치는 바인드 변수 (?)를 사용한다.
      String insertResrvation =
          "insert into Reservation(owner_id,car_id,reservation_date,reservation_reason,maintenance_classification) values(?,?,?,?,?,?,?)";
      pstmt = con.prepareStatement(insertResrvation);
      // reservation_id 컬럼
      // 4.바인드 변수 값 설정
      pstmt.setString(1, rmVO.getOwnerId());
      pstmt.setString(2, rmVO.getCarId());
      pstmt.setString(3, rmVO.getReserveDate() + " " + rmVO.getReserveTime());
      pstmt.setString(4, rmVO.getReserveReason());
      pstmt.setString(5, rmVO.getMaintenanceClassification());
      // 5.쿼리문 수행 후 결과 얻기
      pstmt.executeUpdate();
    } finally {
      // 6.연결 끊기
      dbCon.dbClose(con, pstmt, null);
    } // end finally

  }// insertReservationManagement

  public void deleteOneCommonMaintenance(ReservationManagementVO rmVO) {

  }// deleteOneCommonMaintenance

}
