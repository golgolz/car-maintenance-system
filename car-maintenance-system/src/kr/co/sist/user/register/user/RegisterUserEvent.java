package kr.co.sist.user.register.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import javax.swing.JOptionPane;
import kr.co.sist.user.login.UserLoginView;

public class RegisterUserEvent extends WindowAdapter implements ActionListener {

  private RegisterUserView registerUserView;

  public RegisterUserEvent(RegisterUserView registerUserView) {
    this.registerUserView = registerUserView;
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == registerUserView.getJbtnDoubleCheck()) {

    }
    if (ae.getSource() == registerUserView.getJbtnRegisterCar()) {
      new RegisterUserCarDialog();
    }
    if (ae.getSource() == registerUserView.getJbtnCancel()) {
      new UserLoginView();
      registerUserView.dispose();
    }
    if (ae.getSource() == registerUserView.getJbtnRegisterUserConfirm()) {
      int flag = JOptionPane.showConfirmDialog(registerUserView, "회원 가입 하시겠습니까?", "가입신청", JOptionPane.OK_CANCEL_OPTION);
      switch (flag) {
        case JOptionPane.OK_OPTION:
          JOptionPane.showMessageDialog(registerUserView, "회원가입이 완료되었습니다.");
          new UserLoginView();
          registerUserView.dispose();
      }

    }

  }



}
