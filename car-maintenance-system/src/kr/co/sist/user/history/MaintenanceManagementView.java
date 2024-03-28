package kr.co.sist.user.history;


import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import kr.co.sist.FontSingleton;

public class MaintenanceManagementView extends JFrame {

  private MaintenanceManagementEvent maintenanceManagementEvent;
  private JLabel jlName;
  private JLabel jlCarId;
  private JButton jbtnPreventiHistory;
  private JButton jbtnCommonManagementHistory;
  private PreventiMaintenanceView preventiMaintenanceView;
  private CommonMaintenanceView commonMaintenanceView;

  public MaintenanceManagementView() {
    super("정비 관리");

    // 통일 코드
    this.getContentPane().setBackground(Color.decode("#002347"));


    jlName = new JLabel("홍길동 님");
    jlCarId = new JLabel("123가 1234");
    jbtnPreventiHistory = new JButton("예방정비 이력");
    jbtnCommonManagementHistory = new JButton("일반 정비 관리");

    setLayout(null);

    // 폰트 , 크기, 스타일
    jlName.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
    jlCarId.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
    jbtnPreventiHistory.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.PLAIN, 14f));
    jbtnCommonManagementHistory.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.PLAIN, 14f));

    jlName.setBounds(380, 180, 200, 30);
    jlCarId.setBounds(370, 220, 200, 30);
    jbtnPreventiHistory.setBounds(300, 260, 120, 30);
    jbtnCommonManagementHistory.setBounds(440, 260, 120, 30);

    // 폰트 색상
    jlName.setForeground(Color.WHITE);
    jlCarId.setForeground(Color.WHITE);
    jbtnPreventiHistory.setForeground(Color.WHITE);
    jbtnCommonManagementHistory.setForeground(Color.WHITE);

    jbtnPreventiHistory.setBackground(Color.decode("#5586EB")); // 파란색
    jbtnCommonManagementHistory.setBackground(Color.decode("#5586EB")); // 파란색

    add(jlName);
    add(jlCarId);
    add(jbtnPreventiHistory);
    add(jbtnCommonManagementHistory);

    maintenanceManagementEvent = new MaintenanceManagementEvent(this);

    jbtnPreventiHistory.addActionListener(maintenanceManagementEvent);
    jbtnCommonManagementHistory.addActionListener(maintenanceManagementEvent);



    setBounds(200, 320, 840, 480);
    setVisible(true);
    setResizable(false);
    setLocationRelativeTo(null);
  }

  public void showPreventiMaintenanceView() {
    if (preventiMaintenanceView == null) {
      // 예방 정비 이력 창이 없는 경우에만 생성하여 보이게 함
      preventiMaintenanceView = new PreventiMaintenanceView();
      try {
        preventiMaintenanceView.loadData(); // 데이터 로드 메서드 호출
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } else {
      // 이미 생성된 예방 정비 이력 창이 있는 경우에는 보이도록 설정
      preventiMaintenanceView.setVisible(true);
    }
  }

  public void showCommonMaintenanceView() {
    if (commonMaintenanceView == null) {
      // 예방 정비 이력 창이 없는 경우에만 생성하여 보이게 함
      commonMaintenanceView = new CommonMaintenanceView();
      try {
        commonMaintenanceView.loadData2(); // 데이터 로드 메서드 호출
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } else {
      // 이미 생성된 예방 정비 이력 창이 있는 경우에는 보이도록 설정
      commonMaintenanceView.setVisible(true);
    }
  }

  public void setPreventiMaintenanceView(PreventiMaintenanceView preventiMaintenanceView) {
    this.preventiMaintenanceView = preventiMaintenanceView;
  }

  public PreventiMaintenanceView getPreventiMaintenanceView() {
    return preventiMaintenanceView;
  }

  public MaintenanceManagementEvent getMaintenanceManagementEvent() {
    return maintenanceManagementEvent;
  }

  public JLabel getJlName() {
    return jlName;
  }

  public JLabel getJlCarId() {
    return jlCarId;
  }

  public JButton getJbtnPreventiHistory() {
    return jbtnPreventiHistory;
  }

  public JButton getJbtnCommonManagementHistory() {
    return jbtnCommonManagementHistory;
  }

  public static void main(String[] args) {
    new MaintenanceManagementView();
  }

}
