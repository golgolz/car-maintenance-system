package kr.co.sist.user.manage.user;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import kr.co.sist.FontSingleton;

@SuppressWarnings("serial")
public class UserManageView extends JFrame {
    private JLabel ManageUserInfo;// 회원정보수정
    private JLabel jlID;// ID
    private JTextField jtfID;
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
    private JButton jbtnUpdateConfirm;// 수정완료 버튼
    private JButton jbtnCancel;// 취소버튼
    private JButton jbtnDelete;// 삭제버튼

    public UserManageView() {
        super("회원 정보 수정");
        setLayout(null);
        this.getContentPane().setBackground(Color.decode("#002347"));

        ManageUserInfo = new JLabel("회원 정보 수정");
        jlID = new JLabel("ID");
        jtfID = new JTextField("사용자ID");
        jlPW = new JLabel("비밀번호");
        jtfPW = new JTextField();
        jlPWMsg = new JLabel("10자 이하 영/숫자 가능");
        jlPWConfirm = new JLabel("비밀번호 확인");
        jtfPWConfirm = new JTextField();
        jlPWConfirmMsg = new JLabel("비밀번호가 일치하지 않습니다.");
        jlName = new JLabel("이름");
        jtfName = new JTextField("우미연");
        jlTel = new JLabel("연락처");
        jtfTel = new JTextField("010-1111-2222");
        jlAddr = new JLabel("주소");
        jtfAddr = new JTextField();
        jbtnUpdateConfirm = new JButton("수정완료");
        jbtnCancel = new JButton("취소");
        jbtnDelete = new JButton("삭제하기");

        ManageUserInfo.setBounds(20, 20, 200, 30);
        jlID.setBounds(20, 75, 160, 30);
        jtfID.setBounds(170, 75, 160, 30);
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
        jbtnUpdateConfirm.setBounds(30, 385, 160, 35);
        jbtnCancel.setBounds(200, 385, 160, 35);
        jbtnDelete.setBounds(600, 385, 160, 35);

        ManageUserInfo.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 27f));
        jlID.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));
        jtfID.setFont(FontSingleton.getInstance().bonGodic.deriveFont(22f));
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
        jbtnUpdateConfirm.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
        jbtnCancel.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
        jbtnDelete.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));

        ManageUserInfo.setForeground(Color.WHITE);
        jlID.setForeground(Color.WHITE);
        jlPW.setForeground(Color.WHITE);
        jlPWMsg.setForeground(Color.WHITE);
        jlPWConfirm.setForeground(Color.WHITE);
        jlPWConfirmMsg.setForeground(Color.RED);
        jlName.setForeground(Color.WHITE);
        jlTel.setForeground(Color.WHITE);
        jlAddr.setForeground(Color.WHITE);
        jbtnUpdateConfirm.setForeground(Color.WHITE);
        jbtnUpdateConfirm.setBackground(Color.decode("#065535"));
        jbtnCancel.setForeground(Color.WHITE);
        jbtnCancel.setBackground(Color.decode("#5D5D5D"));
        jbtnDelete.setForeground(Color.WHITE);
        jbtnDelete.setBackground(Color.decode("#FF0000"));

        add(ManageUserInfo);
        add(jlID);
        add(jtfID);
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
        add(jbtnUpdateConfirm);
        add(jbtnCancel);
        add(jbtnDelete);

        setSize(840, 480);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


}
