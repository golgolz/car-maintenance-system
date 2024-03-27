package kr.co.sist.user.register.user;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import kr.co.sist.FontSingleton;

@SuppressWarnings("serial")
public class RegisterUserCarDialog extends JDialog {// oven 69

  private RegisterUserCarEvent registerUserCarEvent;

  private JLabel jlRegisterCar;// 차량 등록
  private JLabel jlCarID;// 차량 번호
  private JTextField jtfCarID;
  private JLabel jlCarModel;// 모델
  private JTextField jtfCarModel;
  private JLabel jlDriveDistance;// 주행거리
  private JTextField jtfDriveDistance;
  private JLabel jlProductionDate;// 제조일
  private JTextField jtfProductionDate;
  private JButton jbtnCarAdd;// 차량 추가버튼
  private JButton jbtnCancel;// 차량 추가버튼


  public RegisterUserCarDialog() {
    super();
    setLayout(null);
    this.getContentPane().setBackground(Color.decode("#FFFFFF"));

    registerUserCarEvent = new RegisterUserCarEvent(this);

    jlRegisterCar = new JLabel("차량 등록");
    jlCarID = new JLabel("차량번호");
    jtfCarID = new JTextField();
    jlCarModel = new JLabel("모델");
    jtfCarModel = new JTextField();
    jlDriveDistance = new JLabel("주행거리");
    jtfDriveDistance = new JTextField();
    jlProductionDate = new JLabel("제조일자");
    jtfProductionDate = new JTextField();
    jbtnCarAdd = new JButton("등록");
    jbtnCancel = new JButton("취소");

    jlRegisterCar.setBounds(30, 0, 100, 100);
    jlCarID.setBounds(30, 50, 100, 100);
    jtfCarID.setBounds(30, 115, 200, 25);
    jlCarModel.setBounds(30, 100, 100, 100);
    jtfCarModel.setBounds(30, 160, 200, 25);
    jlDriveDistance.setBounds(30, 150, 100, 100);
    jtfDriveDistance.setBounds(30, 210, 200, 25);
    jlProductionDate.setBounds(30, 200, 100, 100);
    jtfProductionDate.setBounds(30, 260, 200, 25);
    jbtnCarAdd.setBounds(50, 330, 80, 25);
    jbtnCancel.setBounds(150, 330, 80, 25);

    jlRegisterCar.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 20f));
    jlCarID.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
    jtfCarID.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
    jlCarModel.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
    jtfCarModel.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
    jlDriveDistance.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
    jtfDriveDistance.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
    jlProductionDate.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
    jtfProductionDate.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
    jbtnCarAdd.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));
    jbtnCancel.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));

    jbtnCarAdd.setForeground(Color.WHITE);
    jbtnCarAdd.setBackground(Color.decode("#5586EB"));
    jbtnCancel.setForeground(Color.WHITE);
    jbtnCancel.setBackground(Color.decode("#5D5D5D"));

    add(jlRegisterCar);
    add(jlCarID);
    add(jtfCarID);
    add(jlCarModel);
    add(jtfCarModel);
    add(jlDriveDistance);
    add(jtfDriveDistance);
    add(jlProductionDate);
    add(jtfProductionDate);
    add(jbtnCarAdd);
    add(jbtnCancel);

    jbtnCarAdd.addActionListener(registerUserCarEvent);
    jbtnCancel.addActionListener(registerUserCarEvent);

    setSize(300, 450);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

  }


  public JTextField getJtfCarID() {
    return jtfCarID;
  }


  public JTextField getJtfCarModel() {
    return jtfCarModel;
  }


  public JTextField getJtfDriveDistance() {
    return jtfDriveDistance;
  }


  public JTextField getJtfProductionDate() {
    return jtfProductionDate;
  }


  public JButton getJbtnCarAdd() {
    return jbtnCarAdd;
  }


  public JButton getJbtnCancel() {
    return jbtnCancel;
  }



}
