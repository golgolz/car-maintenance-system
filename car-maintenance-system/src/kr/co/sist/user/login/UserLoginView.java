package kr.co.sist.user.login;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import kr.co.sist.FontSingleton;
import kr.co.sist.login.LoginEvent;

@SuppressWarnings("serial")
public class UserLoginView extends JFrame {
    private UserLoginView userLoginView;

    private JTextField jtfId;// 아이디입력
    private JPasswordField jtfPw;// 비밀번호입력
    private JButton jbtnRegistUser;// 회원가입버튼
    private JButton jbtnAdminView;// 사용자버튼
    private JButton jbtnLogin;// 로그인버튼
    private JLabel jlLogin;// 로그인라벨
    private JLabel jlCarManagementSystem;// 차량정비관리시스템라벨

    public UserLoginView() {
        super("사용자 로그인");
        setLayout(null);
        this.getContentPane().setBackground(Color.decode("#002347"));

        jlCarManagementSystem = new JLabel("차량 정비 관리 시스템");
        JLabel jlGolgolz = new JLabel("(주)골골즈");
        jlLogin = new JLabel("사용자 로그인");
        jtfId = new JTextField("사용자ID");
        jtfPw = new JPasswordField("PASS");
        jbtnLogin = new JButton("로그인");
        jbtnRegistUser = new JButton("회원가입");
        jbtnAdminView = new JButton("관리자 로그인으로 전환");

        jlCarManagementSystem.setBounds(35, 240, 500, 150);
        jlGolgolz.setBounds(150, 300, 350, 100);
        jlLogin.setBounds(420, 100, 350, 100);
        jtfId.setBounds(560, 135, 150, 35);
        jtfPw.setBounds(560, 180, 150, 35);
        jbtnLogin.setBounds(500, 230, 100, 35);
        jbtnRegistUser.setBounds(620, 230, 100, 35);
        jbtnAdminView.setBounds(580, 15, 215, 35);

        jtfId.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        jlCarManagementSystem.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 35f));
        jlGolgolz.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
        jlLogin.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));
        jbtnLogin.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));
        jbtnRegistUser.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));
        jbtnAdminView.setFont(FontSingleton.getInstance().bonGodic.deriveFont(18f));



        jlCarManagementSystem.setForeground(Color.WHITE);
        jlGolgolz.setForeground(Color.WHITE);
        jlLogin.setForeground(Color.WHITE);
        jbtnLogin.setForeground(Color.WHITE);
        jbtnRegistUser.setForeground(Color.WHITE);
        jbtnAdminView.setForeground(Color.WHITE);
        jbtnLogin.setBackground(Color.decode("#065535"));
        jbtnRegistUser.setBackground(Color.decode("#5586EB"));
        jbtnAdminView.setBackground(Color.decode("#cf2216"));


        add(jlCarManagementSystem);
        add(jlGolgolz);
        add(jlLogin);
        add(jtfId);
        add(jtfPw);
        add(jbtnLogin);
        add(jbtnRegistUser);
        add(jbtnAdminView);

        LoginEvent loginEvent = new LoginEvent(this);
        jbtnAdminView.addActionListener(loginEvent);
        jbtnLogin.addActionListener(loginEvent);
        jbtnRegistUser.addActionListener(loginEvent);
        jtfId.addFocusListener(loginEvent);
        jtfPw.addFocusListener(loginEvent);

        setSize(840, 480);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public JTextField getJtfId() {
        return jtfId;
    }

    public void setJtfId(JTextField jtfId) {
        this.jtfId = jtfId;
    }

    public JPasswordField getJtfPw() {
        return jtfPw;
    }

    public void setJtfPw(JPasswordField jtfPw) {
        this.jtfPw = jtfPw;
    }

    public JButton getJbtnRegistUser() {
        return jbtnRegistUser;
    }

    public JButton getJbtnAdminView() {
        return jbtnAdminView;
    }

    public JButton getJbtnLogin() {
        return jbtnLogin;
    }

}

