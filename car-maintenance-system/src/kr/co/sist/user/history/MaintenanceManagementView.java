package kr.co.sist.user.history;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MaintenanceManagementView extends JFrame {

  private MaintenanceManagementEvent maintenanceManagementEvent;
  private JLabel jlName;
  private JLabel jlCarId;
  private JButton jbtnPreventiHistory;
  private JButton jbtnCommonManagementHistory;

  public MaintenanceManagementView() {
    super("정비 관리");

    maintenanceManagementEvent = new MaintenanceManagementEvent(this);

    jlName = new JLabel("홍길동 님");
    jlCarId = new JLabel("123가 1234");
    jbtnPreventiHistory = new JButton("예방정비 이력");
    jbtnCommonManagementHistory = new JButton("일반 정비 관리");

    setLayout(null);

    jlName.setBounds(400, 200, 100, 30);
    jlCarId.setBounds(390, 220, 100, 30);
    jbtnPreventiHistory.setBounds(300, 260, 120, 30);
    jbtnCommonManagementHistory.setBounds(440, 260, 120, 30);

    add(jlName);
    add(jlCarId);
    add(jbtnPreventiHistory);
    add(jbtnCommonManagementHistory);

    jbtnPreventiHistory.addActionListener(maintenanceManagementEvent);
    jbtnCommonManagementHistory.addActionListener(maintenanceManagementEvent);
    addWindowListener(maintenanceManagementEvent);


    setBounds(200, 320, 840, 480);
    setVisible(true);
    setResizable(false);
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
