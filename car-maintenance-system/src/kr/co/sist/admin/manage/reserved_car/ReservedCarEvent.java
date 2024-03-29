package kr.co.sist.admin.manage.reserved_car;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReservedCarEvent implements ActionListener {
    private ReservedCarView reservedCarView;

    public ReservedCarEvent(ReservedCarView reservedCarView) {
        this.reservedCarView = reservedCarView;
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
        String carId = reservedCarView.getJtfCarId().getText();
        String ownerId = reservedCarView.getJtfOwnerId().getText();
        List<ReservedCarVO> reservedCars = ReservedCarDAO.getInstance().selectSomeReservedCar(carId, ownerId);

        DefaultTableModel reservedCarModel = reservedCarView.getDtmReservedCar();

        if (reservedCars.size() == 0) {
            reservedCars = ReservedCarDAO.getInstance().selectReservedAllCar();
            JOptionPane.showMessageDialog(reservedCarView, "검색 결과가 없습니다.\n전체 목록을 출력합니다.");
        }

        reservedCarModel.setRowCount(0);
        Object[] reservedCarData = new Object[8];

        for (ReservedCarVO target : reservedCars) {
            reservedCarData[0] = target.getOwnerId();
            reservedCarData[1] = target.getCarId();
            reservedCarData[2] = target.getCarYear();
            reservedCarData[3] = target.getDriveDistance();
            reservedCarData[4] = target.getReservedDate();
            reservedCarData[5] = target.getReleasedDate();
            reservedCarData[6] = target.getMaintenanceStatus();
            reservedCarData[7] = "";
            reservedCarModel.addRow(reservedCarData);
        }
        JOptionPane.showMessageDialog(reservedCarView, "검색을 완료했습니다.");

        reservedCarView.getJtfCarId().setText("");
        reservedCarView.getJtfOwnerId().setText("");
    }
}
