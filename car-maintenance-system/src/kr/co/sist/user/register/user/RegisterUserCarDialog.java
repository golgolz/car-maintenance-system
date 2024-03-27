package kr.co.sist.user.register.user;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RegisterUserCarDialog extends JDialog {// oven 69
  private JLabel jlResisterCar;// 차량 등록
  private JLabel jlCarID;// 차량 번호
  private JTextField jtfCarID;
  private JLabel jlCarModel;// 모델
  private JTextField jtfCarModel;
  private JLabel jlDriveDistance;// 주행거리
  private JTextField jtfDriveDistance;
  private JLabel jlProductionDate;// 제조일
  private JTextField jtfProductionDate;
  private JButton jbtnCarAdd;// 차량 추가버튼
  private JTable jtSelectAllCar;// 차량등록 테이블

  public RegisterUserCarDialog() {
    super();
    setLayout(null);
    this.getContentPane().setBackground(Color.decode("#002347"));


  }

}
