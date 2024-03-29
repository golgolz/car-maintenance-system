package kr.co.sist.admin.manage.reservation.preventi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import kr.co.sist.user.reserve.common.ReservationManagementVO;
import kr.co.sist.user.reserve.dao.ReservationManagementDAO;

public class PreventiReservationEvent implements ActionListener {
    private PreventiReservationView preventiReservationView;

    public PreventiReservationEvent(PreventiReservationView preventiReservationView) {
        this.preventiReservationView = preventiReservationView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            showSearchResult();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void showSearchResult() throws SQLException {
        String ownerId = preventiReservationView.getJtfOwnerId().getText();
        List<ReservationManagementVO> reservations =
                ReservationManagementDAO.getInstance().selectPreReservationByOwnerId(ownerId);

        DefaultTableModel reservationModel = preventiReservationView.getPreventiReservations();

        if (reservations.size() == 0) {
            reservations = ReservationManagementDAO.getInstance().selectReservation("정기");
            JOptionPane.showMessageDialog(preventiReservationView, "검색 결과가 없습니다.\n전체 목록을 출력합니다.");
            reservationModel.setRowCount(0);
            Object[] reservationTargetData = new Object[8];
            for (ReservationManagementVO target : reservations) {
                reservationTargetData[0] = target.getTel();
                reservationTargetData[1] = target.getOwnerId();
                reservationTargetData[2] = target.getName();
                reservationTargetData[3] = target.getCarId();
                reservationTargetData[4] = target.getCarModel();
                reservationTargetData[5] = target.getReservationDate();
                reservationTargetData[6] = target.getReserveReason();
                reservationTargetData[7] = "정비대기";
                reservationModel.addRow(reservationTargetData);
            }
        } else {
            reservationModel.setRowCount(0);
            Object[] reservationTargetData = new Object[8];

            for (ReservationManagementVO target : reservations) {
                reservationTargetData[0] = target.getOwnerId();
                reservationTargetData[1] = target.getTel();
                reservationTargetData[2] = target.getCarId();
                reservationTargetData[3] = target.getCarModel();
                reservationTargetData[4] = target.getReserveReason();
                reservationTargetData[5] = target.getReservationDate();
                reservationTargetData[6] = target.getReserveTime();
                reservationTargetData[7] = "";
                reservationModel.addRow(reservationTargetData);
            }
            JOptionPane.showMessageDialog(preventiReservationView, "검색을 완료했습니다.");
        }

        preventiReservationView.getJtfOwnerId().setText("");
    }
}
