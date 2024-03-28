package kr.co.sist.admin.manage.user;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import kr.co.sist.FontSingleton;
import kr.co.sist.user.register.user.UserInfoVO;
import kr.co.sist.user.register.user.UserManageDAO;

@SuppressWarnings("serial")
public class AdminManageView extends JFrame {
  private JLabel jlAdminManageUser;// 고객 정보 관리
  private JLabel jlUserID;// 사용자 ID
  private JTextField jtfUserID;
  private JButton jbtnSelectUser;// 조회버튼
  private DefaultTableModel dtm;// 사용자 테이블 조회
  private JTable jTable;
  private List<UserInfoVO> userList;
  UserManageDAO userManageDAO;
  private AdminMangeEvent adminMangeEvent;



  public AdminManageView() {
    super("고객 정보 관리");
    setLayout(null);
    this.getContentPane().setBackground(Color.decode("#002347"));

    adminMangeEvent = new AdminMangeEvent(this);

    String[] tableColumn = {"사용자 ID", "이름", "주소", "연락처", "최근 등록 차량"};
    dtm = new DefaultTableModel(tableColumn, 0) {
      public boolean isCellEditable(int row, int col) {// 테이블 셀 수정x
        return !(col == 0);
      }
    };

    selectAllUser();

    jTable = new JTable(dtm);
    JScrollPane jsp = new JScrollPane(jTable);

    jlAdminManageUser = new JLabel("고객 정보 관리");
    jlUserID = new JLabel("사용자 ID");
    jtfUserID = new JTextField();
    jbtnSelectUser = new JButton("조회");

    jlAdminManageUser.setBounds(20, 20, 300, 35);
    jlUserID.setBounds(20, 70, 100, 30);
    jtfUserID.setBounds(130, 70, 120, 30);
    jbtnSelectUser.setBounds(270, 70, 100, 30);
    jsp.setBounds(20, 110, 780, 300);

    jlAdminManageUser.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 30f));
    jlUserID.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));
    jtfUserID.setFont(FontSingleton.getInstance().bonGodic.deriveFont(22f));
    jbtnSelectUser.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));

    jlAdminManageUser.setForeground(Color.WHITE);
    jlUserID.setForeground(Color.WHITE);
    jbtnSelectUser.setForeground(Color.WHITE);
    jbtnSelectUser.setBackground(Color.decode("#47C83E"));

    add(jlAdminManageUser);
    add(jlUserID);
    add(jtfUserID);
    add(jbtnSelectUser);

    add(jsp);

    jbtnSelectUser.addActionListener(adminMangeEvent);

    setSize(840, 480);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public void selectAllUser() {
    // 모든 고객 정보를 담는 메서드
    userList = new ArrayList<UserInfoVO>();
    userManageDAO = UserManageDAO.getInstance();
    UserInfoVO uiVO = new UserInfoVO();

    try {
      userList = userManageDAO.selectAllUser();
      for (UserInfoVO uVO : userList) {
        Object[] rowData = {uVO.getId(), uVO.getName(), uVO.getAddr(), uVO.getTel(), uVO.getRegisteredCar()};
        dtm.addRow(rowData);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }



  }

  public JTextField getJtfUserID() {
    return jtfUserID;
  }

  public JButton getJbtnSelectUser() {
    return jbtnSelectUser;
  }

  public DefaultTableModel getDtm() {
    return dtm;
  }
}
