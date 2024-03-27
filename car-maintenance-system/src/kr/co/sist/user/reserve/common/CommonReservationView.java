package kr.co.sist.user.reserve.common;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import kr.co.sist.user.reserve.dialog.ReservationDialogView;


public class CommonReservationView extends JFrame {

  private JLabel jlReservationManagement;


  public CommonReservationView(String label, int viewNum) {
    super(label);

    try {
      UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    } // end catch

    SwingUtilities.updateComponentTreeUI(this);


    jlReservationManagement = new JLabel(label);
    // jlReservationManagement.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 27f));
    ReservationDialogView rdv = new ReservationDialogView(viewNum, this); // 1은 일반 정비 예약


    Font font = new Font("맑은 고딕", Font.BOLD, 24);
    jlReservationManagement.setFont(font);
    jlReservationManagement.setForeground(Color.WHITE);

    setLayout(null);
    jlReservationManagement.setBounds(320, 50, 400, 60);
    rdv.setBounds(100, 100, 600, 320);
    rdv.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1)));


    add(jlReservationManagement); // 라벨 배치
    add(rdv); // rdv를 CommonReservationView에 추가

    // 프레임의 배경색 설정
    Color backgroundColor = new Color(14, 50, 74);
    getContentPane().setBackground(backgroundColor);


    // 이벤트 추가
    CommonReservationEvent commonReservationEvent = new CommonReservationEvent(this);
    addWindowListener(commonReservationEvent);

    setBounds(500, 300, 840, 480);
    setResizable(false);
    setVisible(true);
  }// CommonReservationView



  public static void main(String[] args) {
    new CommonReservationView("일반 정비 예약", ReservationDialogView.COMMON);
    // new CommonReservationView("예방 정비 예약",ReservationDialogView.PREVENTI);
    // new CommonReservationView("리콜 예약",ReservationDialogView.RECALL);

  }


}
