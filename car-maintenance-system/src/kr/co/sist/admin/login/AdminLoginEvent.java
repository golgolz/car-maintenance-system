package kr.co.sist.admin.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import kr.co.sist.admin.AdminView;
import kr.co.sist.login.LoginDAO;
import kr.co.sist.login.LoginVO;
import kr.co.sist.user.login.UserLoginView;

public class AdminLoginEvent extends WindowAdapter implements ActionListener, FocusListener {

  private AdminLoginView adminLoginView;

  public AdminLoginEvent(AdminLoginView adminLoginView) {
    this.adminLoginView = adminLoginView;
  }

  @SuppressWarnings("unlikely-arg-type")
  @Override
  public void actionPerformed(ActionEvent ae) {
    // 관리자 화면에서 로그인 버튼 클릭시 이벤트
    if (ae.getSource() == adminLoginView.getJbtnLogin()) {
      String nowLoginPass = "";
      LoginVO lVO = null;
      String nowLoginName = adminLoginView.getJtfId().getText();
      char[] passwordArr = adminLoginView.getJtfPw().getPassword();

      // secret_pw 배열에 저장된 암호의 자릿수 만큼 for문 돌리면서 char 에 한 글자씩 저장
      for (char passOne : passwordArr) {
        Character.toString(passOne); // char 에 저장된 값 string으로 변환
        // pw 에 저장하기, pw 에 값이 비어있으면 저장, 값이 있으면 이어서 저장하는 삼항연산자
        nowLoginPass += (passwordArr.equals("")) ? "" + passOne + "" : "" + passOne + "";
      }
      // DAO생성
      LoginDAO loginDAO = LoginDAO.getInstance();

      try {
        lVO = loginDAO.selectLoginAdmin(nowLoginName, nowLoginPass);
        if (lVO == null) {
          JOptionPane.showMessageDialog(adminLoginView, "아이디 또는 비밀번호를 확인해주세요.");
          return;
        } else {
          new AdminView();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (ae.getSource() == adminLoginView.getJbtnUserView()) {
      new UserLoginView();
      adminLoginView.dispose();
    }
  }

  @Override
  public void focusGained(FocusEvent fe) {
    if (fe.getSource() == adminLoginView.getJtfId()) {
      adminLoginView.getJtfId().setText("");
    }
    if (fe.getSource() == adminLoginView.getJtfPw()) {
      adminLoginView.getJtfPw().setText("");
    }
  }

  @Override
  public void focusLost(FocusEvent e) {
    // TODO Auto-generated method stub

  }

}
