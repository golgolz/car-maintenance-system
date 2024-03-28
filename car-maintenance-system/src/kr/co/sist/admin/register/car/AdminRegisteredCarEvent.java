package kr.co.sist.admin.register.car;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminRegisteredCarEvent extends WindowAdapter implements ActionListener, MouseListener {
    private AdminRegisteredCarView adminRegisteredCarView;
    // private CarModifyDialog carModifydialog;

    public AdminRegisteredCarEvent(AdminRegisteredCarView adminRegisteredCarView) throws SQLException {
        this.adminRegisteredCarView = adminRegisteredCarView;

        // RegisteredCarDAO.getInstance().selectAllCar();
    }// AdminRegisteredCarEvent

    public void actionPerformed(ActionEvent ae) {
        int selectedRow = adminRegisteredCarView.getCarTable().getSelectedRow();
        if (selectedRow != -1) { // 선택된 행이 있는지 확인
            // 선택된 행의 데이터 가져오기
            String column1Value = adminRegisteredCarView.getCarTable().getValueAt(selectedRow, 0).toString();
            String column2Value = adminRegisteredCarView.getCarTable().getValueAt(selectedRow, 1).toString();
            // 가져온 데이터 활용하기
            System.out.println("Selected Row Data: " + column1Value + ", " + column2Value);
        } else {
            System.out.println("행이 선택되지 않았습니다.");
        }

        if (ae.getSource() == adminRegisteredCarView.getJbtnAddCar()) {
            new CarAddDialog(adminRegisteredCarView);
        }

        if (ae.getSource() == adminRegisteredCarView.getJbtnModify()) {
            // new CarModifyDialog(adminRegisteredCarView.getCarTable().getValueAt(selectedRow, 0).toString());
            // new CarModifyDialog(adminRegisteredCarView.getCarTable().getValueAt(selectedRow, 1).toString());
            // new CarModifyDialog(adminRegisteredCarView.getCarTable().getValueAt(selectedRow, 2).toString());
            // new CarModifyDialog(adminRegisteredCarView.getCarTable().getValueAt(selectedRow, 3).toString());
            // new CarModifyDialog(adminRegisteredCarView.getCarTable().getValueAt(selectedRow, 4).toString());

            String ownerId = adminRegisteredCarView.getCarTable().getValueAt(selectedRow, 1).toString();
            String carId = adminRegisteredCarView.getCarTable().getValueAt(selectedRow, 0).toString();
            String carModel = adminRegisteredCarView.getCarTable().getValueAt(selectedRow, 2).toString();
            int driveDistance =
                    Integer.parseInt(adminRegisteredCarView.getCarTable().getValueAt(selectedRow, 4).toString());

            Date productionDate = null;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                productionDate = new Date(dateFormat
                        .parse(adminRegisteredCarView.getCarTable().getValueAt(selectedRow, 3).toString()).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            new CarModifyDialog(adminRegisteredCarView, ownerId, carId, carModel, driveDistance, productionDate);
        }


        if (ae.getSource() == adminRegisteredCarView.getJbtnSearch()) {
            selectCarInfo();

        }
        if (ae.getSource() == adminRegisteredCarView.getJbtnRemove()) {

            removeCarInfo();
        }

    }// end actionPerformed

    private void selectCarInfo() {
        RegisteredCarDAO rscDAO = RegisteredCarDAO.getInstance();
        try {
            List<RegisteredCarVO> list = rscDAO.selectAllCar(adminRegisteredCarView.getJtfCarId().getText().trim(),
                    adminRegisteredCarView.getJtfId().getText().trim());

            RegisteredCarVO tempRVO = null;
            DefaultTableModel carRegist = adminRegisteredCarView.getCarRegist();
            carRegist.setRowCount(0);///////

            String[] rawData = new String[6];
            for (int i = 0; i < list.size(); i++) {
                tempRVO = list.get(i);
                rawData[0] = tempRVO.getCarId();
                rawData[1] = tempRVO.getOwnerId();
                rawData[2] = tempRVO.getCarModel();
                rawData[3] = String.valueOf(tempRVO.getRegistrationDate());
                rawData[4] = String.valueOf(tempRVO.getCarYear());
                rawData[5] = String.valueOf(tempRVO.getDriveDistance());

                carRegist.addRow(rawData);
            } // end for
        } catch (SQLException e) {
            e.printStackTrace();
        } // end catch
    }// selectCarInfo

    private void removeCarInfo() {
        DefaultTableModel carRegist = adminRegisteredCarView.getCarRegist();
        JTable table = adminRegisteredCarView.getCarTable(); // 테이블 가져오기

        System.out.println(adminRegisteredCarView.getCarTable().getRowCount());

        int selectedRow = table.getSelectedRow(); // 선택된 행의 인덱스 가져오기

        if (selectedRow != -1) { // 선택된 행이 있는 경우
            carRegist.removeRow(selectedRow); // 해당 행 삭제
            JOptionPane.showMessageDialog(adminRegisteredCarView, "삭제되었습니다.");
        } else {
            JOptionPane.showMessageDialog(adminRegisteredCarView, "선택된 행이 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
        }
    }


    // private void removeCarInfo() {
    // DefaultTableModel carRegist = adminRegisteredCarView.getCarRegist();
    // JTable table = adminRegisteredCarView.getCarTable(); // 테이블 가져오기
    //
    // int selectedRow = table.getSelectedRow(); // 선택된 행의 인덱스 가져오기
    //
    // if (selectedRow != -1) { // 선택된 행이 있는 경우
    // carRegist.removeRow(selectedRow); // 해당 행 삭제
    // } else {
    // JOptionPane.showMessageDialog(adminRegisteredCarView, "선택된 행이 없습니다.", "경고",
    // JOptionPane.WARNING_MESSAGE);
    // }
    // System.out.println(selectedRow);
    // }// deleteCarInfo


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(adminRegisteredCarView.getCarTable().getSelectedRow());


    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}



}// class
