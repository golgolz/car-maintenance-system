package kr.co.sist.admin.register.car;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminRegisteredCarEvent extends WindowAdapter implements ActionListener, MouseListener {
    private AdminRegisteredCarView adminRegisteredCarView;

    public AdminRegisteredCarEvent(AdminRegisteredCarView adminRegisteredCarView) throws SQLException {
        this.adminRegisteredCarView = adminRegisteredCarView;

        // RegisteredCarDAO.getInstance().selectAllCar();
    }// AdminRegisteredCarEvent

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == adminRegisteredCarView.getJbtnAddCar()) {
            new CarAddDialog();
        }

        if (ae.getSource() == adminRegisteredCarView.getJbtnModify()) {
            new CarModifyDialog();
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
        System.out.println("------" + adminRegisteredCarView.getCarTable().getSelectedRow());


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
