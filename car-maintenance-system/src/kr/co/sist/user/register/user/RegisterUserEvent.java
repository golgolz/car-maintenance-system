package kr.co.sist.user.register.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import kr.co.sist.user.login.UserLoginView;

public class RegisterUserEvent extends WindowAdapter implements ActionListener {

  private RegisterUserView registerUserView;
  private RegisterUserCarEvent registerUserCarEvent;

  public RegisterUserEvent(RegisterUserView registerUserView) {
    this.registerUserView = registerUserView;
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == registerUserView.getJbtnDoubleCheck()) {
      UserManageDAO userManageDAO = UserManageDAO.getInstance();
      try {
        boolean flag = userManageDAO.checkId(registerUserView.getJtfID().getText());
        if (flag == true) {
          JOptionPane.showMessageDialog(registerUserView, "이미 ID가 존재합니다.");
          registerUserView.getJtfID().setText("");
          return;
        } else {
          JOptionPane.showMessageDialog(registerUserView, "사용 가능한 ID입니다.");
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (ae.getSource() == registerUserView.getJbtnRegisterCar()) {
      new RegisterUserCarDialog();
    }
    if (ae.getSource() == registerUserView.getJbtnCancel()) {
      new UserLoginView();
      registerUserView.dispose();
    }
    if (ae.getSource() == registerUserView.getJbtnRegisterUserConfirm()) {

      String owner_id = registerUserView.getJtfID().getText();
      String pw = registerUserView.getJtfPW().getText();
      String name = registerUserView.getJtfName().getText();
      String tel = registerUserView.getJtfTel().getText();
      String addr = registerUserView.getJtfAddr().getText();

      if (owner_id.isEmpty()) {
        JOptionPane.showMessageDialog(registerUserView, "아이디를 입력하세요.");
        return;
      }
      if (pw.isEmpty()) {
        JOptionPane.showMessageDialog(registerUserView, "비밀번호을 입력하세요.");
        return;
      }
      if (name.isEmpty()) {
        JOptionPane.showMessageDialog(registerUserView, "이름을 입력하세요.");
        return;
      }
      if (tel.isEmpty()) {
        JOptionPane.showMessageDialog(registerUserView, "연락처를 입력하세요.");
        return;
      }
      if (addr.isEmpty()) {
        JOptionPane.showMessageDialog(registerUserView, "주소를 입력하세요.");
        return;
      }

      UserManageDAO userManageDAO = UserManageDAO.getInstance();
      try {
        userManageDAO.addUser(owner_id, pw, tel, name, addr);
        JOptionPane.showMessageDialog(registerUserView, "회원가입이 완료되었습니다.");
      } catch (SQLException e) {
        e.printStackTrace();
      }

      // int flag = JOptionPane.showConfirmDialog(registerUserView, "회원 가입 하시겠습니까?", "가입신청",
      // JOptionPane.OK_CANCEL_OPTION);
      // switch (flag) {
      // case JOptionPane.OK_OPTION:
      // JOptionPane.showMessageDialog(registerUserView, "회원가입이 완료되었습니다.");
      // new UserLoginView();
      // registerUserView.dispose();
      // }

    }

  }



}
