package kr.co.sist.admin.register.car;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CarModifyDialogEvent implements ActionListener {
    private CarModifyDialog carModifyDialog;
    private AdminRegisteredCarView adminRegisteredCarView;

    public CarModifyDialogEvent(CarModifyDialog carModifyDialog) {
        this.carModifyDialog = carModifyDialog;
        // this.registeredCarVO = registeredCarVO;

    }// CarModifyDialogEvent

    public void modifyCar() {
        RegisteredCarDAO rscDAO = RegisteredCarDAO.getInstance();
        RegisteredCarVO rVO = new RegisteredCarVO();
        rVO.setOwnerId(carModifyDialog.getJtfOwnerId().getText());
        rVO.setCarId(carModifyDialog.getJtfCarId().getText());
        rVO.setCarModel(carModifyDialog.getJtfCarModel().getText());
        rVO.setDriveDistance(Integer.parseInt(carModifyDialog.getJtfDriveDistance().getText()));


        try {
            rscDAO.updateCar(rVO);
            JOptionPane.showMessageDialog(carModifyDialog, "차량 정보가 수정되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(carModifyDialog, "차량 정보 수정에 실패하셨습니다.");
        } // end catch
    }// end addCar

    @Override
    public void actionPerformed(ActionEvent ae) {



        if (carModifyDialog.getJbtnOk() == ae.getSource()) {
            modifyCar();
        }
        if (carModifyDialog.getJbtnCancel() == ae.getSource()) {
            carModifyDialog.dispose();
        }
    }// actionPerformed

}// class
