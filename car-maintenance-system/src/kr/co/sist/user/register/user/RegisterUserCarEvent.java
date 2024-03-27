package kr.co.sist.user.register.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import kr.co.sist.admin.register.car.RegisteredCarVO;

public class RegisterUserCarEvent implements ActionListener {

  private RegisterUserCarDialog registerUserCarDialog;
  private RegisteredCarVO registeredCarVO;

  public RegisterUserCarEvent(RegisterUserCarDialog registerUserCarDialog) {
    this.registerUserCarDialog = registerUserCarDialog;
  }


  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == registerUserCarDialog.getJbtnCarAdd()) {

      String car_id = registerUserCarDialog.getJtfCarID().getText();
      String car_model = registerUserCarDialog.getJtfCarModel().getText();
      String production_date = registerUserCarDialog.getJtfProductionDate().getText();
      String distance = registerUserCarDialog.getJtfDriveDistance().getText();

      if (car_id.isEmpty()) {
        JOptionPane.showMessageDialog(registerUserCarDialog, "차량번호를 입력하세요.");
        return;
      }
      if (car_model.isEmpty()) {
        JOptionPane.showMessageDialog(registerUserCarDialog, "차종을 입력하세요.");
        return;
      }
      if (distance.isEmpty()) {
        JOptionPane.showMessageDialog(registerUserCarDialog, "주행거리를 입력하세요.");
        return;
      }
      if (production_date.isEmpty()) {
        JOptionPane.showMessageDialog(registerUserCarDialog, "제조일자를 입력하세요.");
        return;
      }

      UserManageDAO userManageDAO = UserManageDAO.getInstance();
      try {
        userManageDAO.addCar(car_id, car_model, production_date, distance);
        JOptionPane.showMessageDialog(registerUserCarDialog, "차량이 등록되었습니다.");
        registerUserCarDialog.dispose();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (ae.getSource() == registerUserCarDialog.getJbtnCancel()) {
      registerUserCarDialog.dispose();
    }


  }

  public RegisteredCarVO getCarVO() {
    return registeredCarVO;
  }

}
