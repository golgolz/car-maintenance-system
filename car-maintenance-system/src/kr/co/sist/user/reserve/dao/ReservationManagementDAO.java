package kr.co.sist.user.reserve.dao;


public class ReservationManagementDAO {

  private static ReservationManagementDAO rmDAO;

  private ReservationManagementDAO() {}

  public static ReservationManagementDAO getInstance() {
    if (rmDAO == null) {
      rmDAO = new ReservationManagementDAO();
    } // end if

    return rmDAO;
  }// getInstance



}
