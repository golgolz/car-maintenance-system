package kr.co.sist.admin.login;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AdminLoginView extends JFrame {

  private JTextField jtfId;// 아이디입력
  private JPasswordField jtfPw;// 비밀번호입력
  private JButton jbtnRegistUser;// 회원가입버튼
  private JButton jbtnAdminView;// 관리자버튼
  private JButton jbtnLogin;// 로그인버튼
  private JLabel jlLogin;// 로그인라벨
  private JLabel jlCarManagementSystem;// 차량정비관리시스템라벨

  public AdminLoginView() {
    super("관리자 로그인");
    setLayout(null);
    this.getContentPane().setBackground(Color.decode("#002347"));

    jlCarManagementSystem = new JLabel("차량 정비 관리 시스템");
    JLabel jlGolgolz = new JLabel("(주)골골즈");
    jlLogin = new JLabel("로그인");
    jtfId = new JTextField("관리자ID");
    jtfPw = new JPasswordField("PASS");
    jbtnLogin = new JButton("로그인");
    jbtnRegistUser = new JButton("회원가입");
    jbtnAdminView = new JButton("관리자");

    jlCarManagementSystem.setBounds(35, 240, 500, 150);
    jlGolgolz.setBounds(150, 300, 350, 100);
    jlLogin.setBounds(480, 100, 350, 100);
    jtfId.setBounds(560, 135, 150, 35);
    jtfPw.setBounds(560, 180, 150, 35);
    jbtnLogin.setBounds(500, 230, 100, 35);
    jbtnRegistUser.setBounds(620, 230, 100, 35);
    jbtnAdminView.setBounds(700, 15, 100, 35);

    jlCarManagementSystem.setFont(new Font("나눔고딕", Font.BOLD, 35));
    jlGolgolz.setFont(new Font("나눔고딕", Font.BOLD, 23));
    jlLogin.setFont(new Font("나눔고딕", Font.BOLD, 22));
    jbtnLogin.setFont(new Font("나눔고딕", Font.PLAIN, 16));
    jbtnRegistUser.setFont(new Font("나눔고딕", Font.PLAIN, 16));
    jbtnAdminView.setFont(new Font("나눔고딕", Font.PLAIN, 16));



    jlCarManagementSystem.setForeground(Color.WHITE);
    jlGolgolz.setForeground(Color.WHITE);
    jlLogin.setForeground(Color.WHITE);
    jbtnLogin.setForeground(Color.WHITE);
    jbtnRegistUser.setForeground(Color.WHITE);
    jbtnAdminView.setForeground(Color.WHITE);
    jbtnLogin.setBackground(Color.decode("#47C83E"));
    jbtnRegistUser.setBackground(Color.decode("#5586EB"));
    jbtnAdminView.setBackground(Color.decode("#2F9D27"));

    add(jlCarManagementSystem);
    add(jlGolgolz);
    add(jlLogin);
    add(jtfId);
    add(jtfPw);
    add(jbtnLogin);
    add(jbtnRegistUser);
    add(jbtnAdminView);

    setSize(840, 480);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

  }

}
