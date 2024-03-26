package kr.co.sist.admin.manage.user;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import kr.co.sist.FontSingleton;

@SuppressWarnings("serial")
public class AdminManageView extends JFrame {
  private JLabel jlAdminManageUser;// 고객 정보 관리
  private JLabel jlUserID;// 사용자 ID
  private JTextField jtfUserID;
  private JButton jbtnSelectUser;// 조회버튼
  private JTable jtSelectAllUser;// 사용자 조회 테이블

  public AdminManageView() {
    super("고객 정보 관리");
    setLayout(null);
    this.getContentPane().setBackground(Color.decode("#002347"));

    jlAdminManageUser = new JLabel("고객 정보 관리");
    jlUserID = new JLabel("사용자 ID");
    jtfUserID = new JTextField();
    jbtnSelectUser = new JButton("조회");
    jtSelectAllUser = new JTable();

    jlAdminManageUser.setBounds(20, 20, 300, 35);
    jlUserID.setBounds(20, 70, 100, 30);
    jtfUserID.setBounds(130, 70, 120, 30);
    jbtnSelectUser.setBounds(270, 70, 100, 30);
    jtSelectAllUser.setBounds(20, 110, 780, 300);

    jlAdminManageUser.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 30f));
    jlUserID.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));
    jtfUserID.setFont(FontSingleton.getInstance().bonGodic.deriveFont(22f));
    jbtnSelectUser.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));
    jtSelectAllUser.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));

    jlAdminManageUser.setForeground(Color.WHITE);
    jlUserID.setForeground(Color.WHITE);
    jbtnSelectUser.setForeground(Color.WHITE);
    jbtnSelectUser.setBackground(Color.decode("#47C83E"));

    add(jlAdminManageUser);
    add(jlUserID);
    add(jtfUserID);
    add(jbtnSelectUser);
    add(jtSelectAllUser);

    setSize(840, 480);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public JTextField getJtfUserID() {
    return jtfUserID;
  }

  public JTable getJtSelectAllUser() {
    return jtSelectAllUser;
  }

  public JButton getJbtnSelectUser() {
    return jbtnSelectUser;
  }

}
