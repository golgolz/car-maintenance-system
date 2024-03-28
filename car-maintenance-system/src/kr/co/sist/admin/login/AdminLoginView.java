package kr.co.sist.admin.login;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import kr.co.sist.FontSingleton;

@SuppressWarnings("serial")
public class AdminLoginView extends JFrame {
    private AdminLoginView adminLoginView;
    private JTextField jtfId;// 아이디입력
    private JPasswordField jtfPw;// 비밀번호입력
    // private JButton jbtnRegistUser;// 회원가입버튼
    private JButton jbtnUserView;// 관리자버튼
    private JButton jbtnLogin;// 로그인버튼
    private JLabel jlLogin;// 로그인라벨
    private JLabel jlCarManagementSystem;// 차량정비관리시스템라벨

    public AdminLoginView() {
        super("관리자 로그인");
        setLayout(null);
        this.getContentPane().setBackground(Color.decode("#002347"));

        jlCarManagementSystem = new JLabel("차량 정비 관리 시스템");
        JLabel jlGolgolz = new JLabel("(주)골골즈");
        jlLogin = new JLabel("관리자 로그인");
        jtfId = new JTextField("관리자ID");
        jtfPw = new JPasswordField("PASS");
        jbtnLogin = new JButton("로그인");
        // jbtnRegistUser = new JButton("회원가입");
        jbtnUserView = new JButton("사용자 로그인으로 전환");

        jlCarManagementSystem.setBounds(35, 240, 500, 150);
        jlGolgolz.setBounds(150, 300, 350, 100);
        jlLogin.setBounds(420, 100, 350, 100);
        jtfId.setBounds(560, 135, 150, 35);
        jtfPw.setBounds(560, 180, 150, 35);
        jbtnLogin.setBounds(580, 230, 100, 35);
        // jbtnRegistUser.setBounds(620, 230, 100, 35);
        jbtnUserView.setBounds(580, 15, 215, 35);

        jlCarManagementSystem.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 35f));
        jlGolgolz.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
        jlLogin.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));
        jbtnLogin.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));
        // jbtnRegistUser.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));
        jbtnUserView.setFont(FontSingleton.getInstance().bonGodic.deriveFont(18f));



        jlCarManagementSystem.setForeground(Color.WHITE);
        jlGolgolz.setForeground(Color.WHITE);
        jlLogin.setForeground(Color.WHITE);
        jbtnLogin.setForeground(Color.WHITE);
        // jbtnRegistUser.setForeground(Color.WHITE);
        jbtnUserView.setForeground(Color.WHITE);
        jbtnLogin.setBackground(Color.decode("#065535"));
        // jbtnRegistUser.setBackground(Color.decode("#5586EB"));
        jbtnUserView.setBackground(Color.decode("#cf2216"));

        add(jlCarManagementSystem);
        add(jlGolgolz);
        add(jlLogin);
        add(jtfId);
        add(jtfPw);
        add(jbtnLogin);
        // add(jbtnRegistUser);
        add(jbtnUserView);

        AdminLoginEvent adminLoginEvent = new AdminLoginEvent(this);
        jbtnLogin.addActionListener(adminLoginEvent);
        jbtnUserView.addActionListener(adminLoginEvent);
        jtfId.addFocusListener(adminLoginEvent);
        jtfPw.addFocusListener(adminLoginEvent);

        setSize(840, 480);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public AdminLoginView getAdminLoginView() {
        return adminLoginView;
    }

    public JTextField getJtfId() {
        return jtfId;
    }

    public JPasswordField getJtfPw() {
        return jtfPw;
    }

    // public JButton getJbtnRegistUser() {
    // return jbtnRegistUser;
    // }

    public JButton getJbtnUserView() {
        return jbtnUserView;
    }

    public JButton getJbtnLogin() {
        return jbtnLogin;
    }

    public JLabel getJlLogin() {
        return jlLogin;
    }

    public JLabel getJlCarManagementSystem() {
        return jlCarManagementSystem;
    }


}
