package kr.co.sist.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import kr.co.sist.admin.login.AdminLoginView;
import kr.co.sist.user.UserView;
import kr.co.sist.user.login.UserLoginView;
import kr.co.sist.user.register.user.RegisterUserView;

public class LoginEvent extends WindowAdapter implements ActionListener, FocusListener {

    private UserLoginView userLoginView;


    public LoginEvent(UserLoginView userLoginView) {
        this.userLoginView = userLoginView;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // 유저 로그인 화면에서 등록 버튼 클릭시 이벤트
        if (ae.getSource() == userLoginView.getJbtnLogin()) {
            String nowLoginPass = "";
            LoginVO lVO = null;
            String nowLoginName = userLoginView.getJtfId().getText();
            char[] passwordArr = userLoginView.getJtfPw().getPassword();

            // secret_pw 배열에 저장된 암호의 자릿수 만큼 for문 돌리면서 char 에 한 글자씩 저장
            for (char passOne : passwordArr) {
                Character.toString(passOne); // char 에 저장된 값 string으로 변환
                // pw 에 저장하기, pw 에 값이 비어있으면 저장, 값이 있으면 이어서 저장하는 삼항연산자
                nowLoginPass += (passwordArr.equals("")) ? "" + passOne + "" : "" + passOne + "";
            }
            // DAO생성
            LoginDAO loginDAO = LoginDAO.getInstance();

            try {
                lVO = loginDAO.selectLoginInfo(nowLoginName, nowLoginPass);
                if (lVO == null) {
                    JOptionPane.showMessageDialog(userLoginView, "아이디 또는 비밀번호를 확인해주세요.");
                    return;
                } else {
                    userLoginView.dispose();
                    loginDAO.setCurrentUserId(nowLoginName);
                    new UserView();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ae.getSource() == userLoginView.getJbtnAdminView()) {
            new AdminLoginView();
            userLoginView.dispose();
        }
        if (ae.getSource() == userLoginView.getJbtnRegistUser()) {
            new RegisterUserView();
            userLoginView.dispose();
        }
    }

    @Override
    public void focusGained(FocusEvent fe) {
        if (fe.getSource() == userLoginView.getJtfId()) {
            userLoginView.getJtfId().setText("");
        }
        if (fe.getSource() == userLoginView.getJtfPw()) {
            userLoginView.getJtfPw().setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

}
