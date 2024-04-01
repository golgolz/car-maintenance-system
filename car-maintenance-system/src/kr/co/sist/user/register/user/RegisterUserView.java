package kr.co.sist.user.register.user;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import kr.co.sist.FontSingleton;

@SuppressWarnings("serial")
public class RegisterUserView extends JFrame {

    private RegisterUserEvent registerUserEvent;

    private JLabel jlRegisterUser;// 회원가입
    private JLabel jlID;// ID
    private JTextField jtfID;
    private JLabel jlIDMsg;// 10자 이하 영/숫자 가능
    private JButton jbtnDoubleCheck;// 중복확인 버튼
    private JLabel jlPW;// 비밀번호
    private JTextField jtfPW;
    private JLabel jlPWMsg;// 10자 이하 영/숫자 가능
    private JLabel jlPWConfirm;// 비밀번호확인
    private JTextField jtfPWConfirm;
    private JLabel jlPWConfirmMsg;// 비밀번호가 일치하지 않습니다.
    private JLabel jlName;// 이름
    private JTextField jtfName;
    private JLabel jlTel;// 연락처
    private JTextField jtfTel;
    private JLabel jlAddr;// 주소
    private JTextField jtfAddr;
    private JButton jbtnRegisterCar;// 차량추가 버튼
    private JButton jbtnCancel;// 취소버튼
    private JButton jbtnRegisterUserConfirm;// 가입신청 버튼

    public RegisterUserView() {
        super("회원가입");
        setLayout(null);
        this.getContentPane().setBackground(Color.decode("#002347"));

        registerUserEvent = new RegisterUserEvent(this);

        jlRegisterUser = new JLabel("회원가입");
        jlID = new JLabel("ID");
        jtfID = new JTextField();
        jlIDMsg = new JLabel("10자 이하 영/숫자 가능");
        jbtnDoubleCheck = new JButton("중복 확인");
        jlPW = new JLabel("비밀번호");
        jtfPW = new JTextField();
        jlPWMsg = new JLabel("10자 이하 영/숫자 가능");
        jlPWConfirm = new JLabel("비밀번호 확인");
        jtfPWConfirm = new JTextField();
        jlPWConfirmMsg = new JLabel("비밀번호가 일치하지 않습니다.");
        jlName = new JLabel("이름");
        jtfName = new JTextField();
        jlTel = new JLabel("연락처");
        jtfTel = new JTextField();
        jlAddr = new JLabel("주소");
        jtfAddr = new JTextField();
        jbtnRegisterCar = new JButton("차량추가");
        jbtnCancel = new JButton("취소");
        jbtnRegisterUserConfirm = new JButton("가입신청");

        jlRegisterUser.setBounds(20, 20, 150, 30);
        jlID.setBounds(20, 75, 160, 30);
        jtfID.setBounds(170, 75, 160, 30);
        jlIDMsg.setBounds(360, 75, 220, 30);
        jbtnDoubleCheck.setBounds(580, 75, 130, 30);
        jlPW.setBounds(20, 125, 160, 30);
        jtfPW.setBounds(170, 125, 160, 30);
        jlPWMsg.setBounds(360, 125, 220, 30);
        jlPWConfirm.setBounds(20, 175, 160, 30);
        jtfPWConfirm.setBounds(170, 175, 160, 30);
        jlPWConfirmMsg.setBounds(360, 175, 240, 30);
        jlName.setBounds(20, 225, 160, 30);
        jtfName.setBounds(170, 225, 160, 30);
        jlTel.setBounds(20, 275, 160, 30);
        jtfTel.setBounds(170, 275, 160, 30);
        jlAddr.setBounds(20, 325, 160, 30);
        jtfAddr.setBounds(170, 325, 350, 30);
        jbtnRegisterCar.setBounds(30, 385, 160, 35);
        jbtnCancel.setBounds(200, 385, 160, 35);
        jbtnRegisterUserConfirm.setBounds(600, 385, 160, 35);

        jlRegisterUser.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 27f));
        jlID.setFont(FontSingleton.getInstance().bonGodic.deriveFont(22f));
        jtfID.setFont(FontSingleton.getInstance().bonGodic.deriveFont(22f));
        jlIDMsg.setFont(FontSingleton.getInstance().bonGodic.deriveFont(18f));
        jbtnDoubleCheck.setFont(FontSingleton.getInstance().bonGodic.deriveFont(18f));
        jlPW.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));
        jtfPW.setFont(FontSingleton.getInstance().bonGodic.deriveFont(22f));
        jlPWMsg.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 18f));
        jlPWConfirm.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));
        jtfPWConfirm.setFont(FontSingleton.getInstance().bonGodic.deriveFont(22f));
        jlPWConfirmMsg.setFont(FontSingleton.getInstance().bonGodic.deriveFont(17f));
        jlName.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));
        jtfName.setFont(FontSingleton.getInstance().bonGodic.deriveFont(22f));
        jlTel.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));
        jtfTel.setFont(FontSingleton.getInstance().bonGodic.deriveFont(22f));
        jlAddr.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));
        jtfAddr.setFont(FontSingleton.getInstance().bonGodic.deriveFont(22f));
        jbtnRegisterCar.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
        jbtnCancel.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
        jbtnRegisterUserConfirm.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));

        jlRegisterUser.setForeground(Color.WHITE);
        jlID.setForeground(Color.WHITE);
        jlIDMsg.setForeground(Color.WHITE);
        jbtnDoubleCheck.setForeground(Color.WHITE);
        jbtnDoubleCheck.setBackground(Color.decode("#065535"));
        jlPW.setForeground(Color.WHITE);
        jlPWMsg.setForeground(Color.WHITE);
        jlPWConfirm.setForeground(Color.WHITE);
        jlPWConfirmMsg.setForeground(Color.RED);
        jlName.setForeground(Color.WHITE);
        jlTel.setForeground(Color.WHITE);
        jlAddr.setForeground(Color.WHITE);
        jbtnRegisterCar.setForeground(Color.WHITE);
        jbtnRegisterCar.setBackground(Color.decode("#065535"));
        jbtnCancel.setForeground(Color.WHITE);
        jbtnCancel.setBackground(Color.decode("#5D5D5D"));
        jbtnRegisterUserConfirm.setForeground(Color.WHITE);
        jbtnRegisterUserConfirm.setBackground(Color.decode("#5586EB"));

        add(jlRegisterUser);
        add(jlID);
        add(jtfID);
        add(jlIDMsg);
        add(jbtnDoubleCheck);
        add(jlPW);
        add(jtfPW);
        add(jlPWMsg);
        add(jlPWConfirm);
        add(jtfPWConfirm);
        add(jlPWConfirmMsg);
        add(jlName);
        add(jtfName);
        add(jlTel);
        add(jtfTel);
        add(jlAddr);
        add(jtfAddr);
        add(jbtnRegisterCar);
        add(jbtnCancel);
        add(jbtnRegisterUserConfirm);

        jbtnDoubleCheck.addActionListener(registerUserEvent);
        jbtnRegisterCar.addActionListener(registerUserEvent);
        jbtnCancel.addActionListener(registerUserEvent);
        jbtnRegisterUserConfirm.addActionListener(registerUserEvent);

        setSize(840, 480);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public JLabel getJlRegisterUser() {
        return jlRegisterUser;
    }

    public JLabel getJlID() {
        return jlID;
    }

    public JTextField getJtfID() {
        return jtfID;
    }

    public JLabel getJlIDMsg() {
        return jlIDMsg;
    }

    public JButton getJbtnDoubleCheck() {
        return jbtnDoubleCheck;
    }

    public JLabel getJlPW() {
        return jlPW;
    }

    public JTextField getJtfPW() {
        return jtfPW;
    }

    public JLabel getJlPWMsg() {
        return jlPWMsg;
    }

    public JLabel getJlPWConfirm() {
        return jlPWConfirm;
    }

    public JTextField getJtfPWConfirm() {
        return jtfPWConfirm;
    }

    public JLabel getJlPWConfirmMsg() {
        return jlPWConfirmMsg;
    }

    public JLabel getJlName() {
        return jlName;
    }

    public JTextField getJtfName() {
        return jtfName;
    }

    public JLabel getJlTel() {
        return jlTel;
    }

    public JTextField getJtfTel() {
        return jtfTel;
    }

    public JLabel getJlAddr() {
        return jlAddr;
    }

    public JTextField getJtfAddr() {
        return jtfAddr;
    }

    public JButton getJbtnRegisterCar() {
        return jbtnRegisterCar;
    }

    public JButton getJbtnCancel() {
        return jbtnCancel;
    }

    public JButton getJbtnRegisterUserConfirm() {
        return jbtnRegisterUserConfirm;
    }


}
