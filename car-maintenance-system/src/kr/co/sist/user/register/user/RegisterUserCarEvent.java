package kr.co.sist.user.register.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class RegisterUserCarEvent implements ActionListener {

  private RegisterUserCarDialog registerUserCarDialog;

  public RegisterUserCarEvent(RegisterUserCarDialog registerUserCarDialog) {
    this.registerUserCarDialog = registerUserCarDialog;
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == registerUserCarDialog.getJbtnCarAdd()) {
      JOptionPane.showMessageDialog(registerUserCarDialog, "차량 등록이 완료되었습니다.");
      registerUserCarDialog.dispose();
    }
    if (ae.getSource() == registerUserCarDialog.getJbtnCancel()) {
      registerUserCarDialog.dispose();
    }

  }

}
