package kr.co.sist.user;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import kr.co.sist.FontSingleton;

@SuppressWarnings("serial")
public class UserView extends JFrame {// oven 74
  private UserViewEvent userViewEvent;
  private JLabel jlSelectFunctionMsg;// 원하시는 메뉴를 선택해주세요.
  private JLabel jlUserName;// 사용자명
  private JLabel jlReport;// 알림표시
  private JButton jbtnMaintenance;// 정비관리버튼
  private JButton jbtnReservation;// 일반정비예약버튼
  private JButton jbtnResisteredCar;// 등록차량관리버튼
  private JButton jbtnPreventi;// 예방정비관리버튼
  private JButton jbtnUpdateUserInfo;// 사용자정보관리
  private JButton jbtnMaintenanceSettlement;// 차량별 정비 정산버튼
  private JButton jbtnLogout;// 로그아웃버튼

  public UserView() {
    super("사용자 기능 선택");
    setLayout(null);
    this.getContentPane().setBackground(Color.decode("#002347"));

    userViewEvent = new UserViewEvent(this);

    jlSelectFunctionMsg = new JLabel("원하시는 메뉴를 선택해주세요.");
    jlUserName = new JLabel(getName());
    jlReport = new JLabel("1");
    jbtnMaintenance = new JButton("정비 관리");
    jbtnReservation = new JButton("일반 정비 예약");
    jbtnResisteredCar = new JButton("등록 차량 관리");
    jbtnPreventi = new JButton("예방 정비 관리");
    jbtnUpdateUserInfo = new JButton("사용자 정보 변경");
    jbtnMaintenanceSettlement = new JButton("차량별 정비 정산");
    jbtnLogout = new JButton("로그아웃");

    jlSelectFunctionMsg.setBounds(270, 10, 300, 50);
    jlUserName.setBounds(20, 50, 150, 50);
    jlReport.setBounds(650, 175, 50, 50);
    jbtnMaintenance.setBounds(150, 100, 210, 40);
    jbtnReservation.setBounds(450, 100, 210, 40);
    jbtnResisteredCar.setBounds(150, 200, 210, 40);
    jbtnPreventi.setBounds(450, 200, 210, 40);
    jbtnUpdateUserInfo.setBounds(150, 300, 210, 40);
    jbtnMaintenanceSettlement.setBounds(450, 300, 210, 40);
    jbtnLogout.setBounds(700, 20, 90, 30);

    jlSelectFunctionMsg.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 20f));
    jlUserName.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 15f));
    jlReport.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 20f));
    jbtnMaintenance.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));
    jbtnReservation.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));
    jbtnResisteredCar.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));
    jbtnPreventi.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));
    jbtnUpdateUserInfo.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));
    jbtnMaintenanceSettlement.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 22f));
    jbtnLogout.setFont(FontSingleton.getInstance().bonGodic.deriveFont(14f));

    jlSelectFunctionMsg.setForeground(Color.WHITE);
    jlUserName.setForeground(Color.WHITE);
    jlReport.setForeground(Color.WHITE);
    jbtnMaintenance.setForeground(Color.WHITE);
    jbtnMaintenance.setBackground(Color.decode("#5586EB"));
    jbtnReservation.setForeground(Color.WHITE);
    jbtnReservation.setBackground(Color.decode("#47C83E"));
    jbtnResisteredCar.setForeground(Color.WHITE);
    jbtnResisteredCar.setBackground(Color.decode("#5586EB"));
    jbtnPreventi.setForeground(Color.WHITE);
    jbtnPreventi.setBackground(Color.decode("#47C83E"));
    jbtnUpdateUserInfo.setForeground(Color.WHITE);
    jbtnUpdateUserInfo.setBackground(Color.decode("#5586EB"));
    jbtnMaintenanceSettlement.setForeground(Color.WHITE);
    jbtnMaintenanceSettlement.setBackground(Color.decode("#47C83E"));
    jbtnLogout.setForeground(Color.WHITE);
    jbtnLogout.setBackground(Color.decode("#002347"));

    add(jlSelectFunctionMsg);
    add(jlUserName);
    add(jlReport);
    add(jbtnMaintenance);
    add(jbtnReservation);
    add(jbtnResisteredCar);
    add(jbtnPreventi);
    add(jbtnUpdateUserInfo);
    add(jbtnMaintenanceSettlement);
    add(jbtnLogout);

    jbtnMaintenance.addActionListener(userViewEvent);
    jbtnReservation.addActionListener(userViewEvent);
    jbtnResisteredCar.addActionListener(userViewEvent);
    jbtnPreventi.addActionListener(userViewEvent);
    jbtnUpdateUserInfo.addActionListener(userViewEvent);
    jbtnMaintenanceSettlement.addActionListener(userViewEvent);
    jbtnLogout.addActionListener(userViewEvent);


    setSize(840, 480);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

  }

  public JLabel getJlSelectFunctionMsg() {
    return jlSelectFunctionMsg;
  }

  public JLabel getJlUserName() {
    return jlUserName;
  }

  public JLabel getJlReport() {
    return jlReport;
  }

  public JButton getJbtnMaintenance() {
    return jbtnMaintenance;
  }

  public JButton getJbtnReservation() {
    return jbtnReservation;
  }

  public JButton getJbtnResisteredCar() {
    return jbtnResisteredCar;
  }

  public JButton getJbtnPreventi() {
    return jbtnPreventi;
  }

  public JButton getJbtnUpdateUserInfo() {
    return jbtnUpdateUserInfo;
  }

  public JButton getJbtnMaintenanceSettlement() {
    return jbtnMaintenanceSettlement;
  }

  public JButton getJbtnLogout() {
    return jbtnLogout;
  }



}
