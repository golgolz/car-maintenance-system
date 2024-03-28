package kr.co.sist.admin.register.car;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CarAddDialogEvent implements ActionListener, MouseListener {
    private CarAddDialog carAddDialog;

    public CarAddDialogEvent(CarAddDialog carAddDialog) {
        this.carAddDialog = carAddDialog;

    }// CarAddDialogEvent


    public void addCar() {
        RegisteredCarDAO rscDAO = RegisteredCarDAO.getInstance();
        RegisteredCarVO rVO = new RegisteredCarVO();
        rVO.setOwnerId(carAddDialog.getJtfOwnerId().getText());
        rVO.setCarId(carAddDialog.getJtfCarId().getText());
        rVO.setCarModel(carAddDialog.getJtfCarModel().getText());
        rVO.setDriveDistance(Integer.parseInt(carAddDialog.getJtfDriveDistance().getText()));
        // rVO.setDriveDistance(Integer.parseInt(carAddDialog.getJtfDriveDistance().getText()));
        // rVO.setDriveDistance(carAddDialog.getJtfDriveDistance().getText());

        try {
            rscDAO.insertCar(rVO);

            JOptionPane.showMessageDialog(carAddDialog, "차량 추가에 성공하셨습니다.");
            carAddDialog.dispose();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(carAddDialog, "차량 추가에 실패하셨습니다.");

        } // end catch
    }// end addCar

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (carAddDialog.getJbtnOk() == ae.getSource()) {
            addCar();
        }
        if (carAddDialog.getJbtnCancel() == ae.getSource()) {
            carAddDialog.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}// class

