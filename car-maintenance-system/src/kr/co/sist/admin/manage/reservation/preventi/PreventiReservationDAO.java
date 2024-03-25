package kr.co.sist.admin.manage.reservation.preventi;

public class PreventiReservationDAO {
    static private PreventiReservationDAO preventiReservationDAO;

    private PreventiReservationDAO() {}

    public PreventiReservationDAO getInstance() {
        if (preventiReservationDAO == null) {
            preventiReservationDAO = new PreventiReservationDAO();
        }

        return preventiReservationDAO;
    }

    // public List<ReservationVO> selectAllPreventiReservations() {
    //
    // }
}
