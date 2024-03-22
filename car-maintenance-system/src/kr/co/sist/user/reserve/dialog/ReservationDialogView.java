package kr.co.sist.user.reserve.dialog;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import kr.co.sist.user.reserve.common.CommonReservationView;

@SuppressWarnings("serial")
public class ReservationDialogView extends JPanel {

  public static final int COMMON = 1; // 일반
  public static final int PREVENTI = 2; // 예방
  public static final int RECALL = 3; // 리콜

  private int viewNum;

  private JLabel jlReservationDate;
  private JLabel jlAM;
  private JLabel jlPM;
  private JLabel jlReservationReason;
  private JTextArea jtaReservationReason;
  private JRadioButton jrbAM;
  private JRadioButton jrbPM;
  private JButton jbtnConfirm;
  private JButton jbtnCancel;

  private CommonReservationView crv;

  public ReservationDialogView(int viewNum, CommonReservationView crv) {

    this.crv = crv;
    this.viewNum = viewNum;

    ReservationDialogEvent rde = new ReservationDialogEvent(this);

    if (viewNum == COMMON) { // 일반 정비 예약
      addCommonView();
    } // end if
    if (viewNum == PREVENTI) { // 예방 정비 예약
      addPreventiView();
    } // end if
    if (viewNum == RECALL) { // 리콜 예약
      addRecallView();
    } // end if


    // 이벤트 추가
    jbtnConfirm.addActionListener(rde);
    jbtnCancel.addActionListener(rde);

    setVisible(true);

  }

  private void addCommonView() {
    Font font = new Font("맑은 고딕", Font.BOLD, 18);
    // 캘린더
    jlReservationDate = new JLabel();

    jlReservationDate.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1)));

    // 라디오 버튼
    jrbAM = new JRadioButton();
    jrbPM = new JRadioButton();
    ButtonGroup bg = new ButtonGroup();
    bg.add(jrbAM);
    bg.add(jrbPM);

    jlAM = new JLabel("오전");
    jlPM = new JLabel("오후");
    jlAM.setFont(new Font("맑은 고딕", Font.BOLD, 13));
    jlPM.setFont(new Font("맑은 고딕", Font.BOLD, 13));

    // 예약 사유
    jlReservationReason = new JLabel("사후관리 요청 내용");
    jlReservationReason.setFont(font);
    jtaReservationReason = new JTextArea("요청 내용을 입력해주세요");


    // 하단 버튼
    jbtnConfirm = new JButton("예약신청");
    jbtnCancel = new JButton("취소");

    setLayout(null);

    ReservationCalendarDialogView rcdv = new ReservationCalendarDialogView();
    rcdv.setSize(200, 200);
    rcdv.setBorder(new TitledBorder(new LineBorder(Color.BLACK)));
    jlReservationDate.add(rcdv);


    // 컴포넌트 배치
    jlReservationDate.setBounds(10, 20, 230, 220);
    rcdv.setBounds(0, 0, 230, 220);
    jrbAM.setBounds(290, 30, 20, 20);
    jlAM.setBounds(320, 30, 40, 20);
    jrbPM.setBounds(360, 30, 20, 20);
    jlPM.setBounds(390, 30, 40, 20);
    jlReservationReason.setBounds(270, 70, 180, 40);
    jtaReservationReason.setBounds(270, 120, 310, 120);
    jbtnConfirm.setBounds(200, 270, 90, 30);
    jbtnCancel.setBounds(300, 270, 90, 30);


    add(jlReservationDate);
    add(jrbAM);
    add(jlAM);
    add(jrbPM);
    add(jlPM);
    add(jlReservationReason);
    add(jtaReservationReason);
    add(jbtnConfirm);
    add(jbtnCancel);


  }// addCommonView


  private void addPreventiView() {
    Font font = new Font("맑은 고딕", Font.BOLD, 18);
    // 캘린더 라벨
    jlReservationDate = new JLabel();

    jlReservationDate.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1)));

    // 라디오 버튼
    jrbAM = new JRadioButton();
    jrbPM = new JRadioButton();
    ButtonGroup bg = new ButtonGroup();
    bg.add(jrbAM);
    bg.add(jrbPM);

    jlAM = new JLabel("오전");
    jlPM = new JLabel("오후");
    jlAM.setFont(new Font("맑은 고딕", Font.BOLD, 13));
    jlPM.setFont(new Font("맑은 고딕", Font.BOLD, 13));


    // 하단 버튼
    jbtnConfirm = new JButton("예약확정");
    jbtnCancel = new JButton("취소");

    setLayout(null);

    ReservationCalendarDialogView rcdv = new ReservationCalendarDialogView();
    rcdv.setSize(200, 200);
    rcdv.setBorder(new TitledBorder(new LineBorder(Color.BLACK)));
    jlReservationDate.add(rcdv);


    // 컴포넌트 배치
    jlReservationDate.setBounds(10, 20, 230, 220);
    rcdv.setBounds(0, 0, 230, 220);
    jrbAM.setBounds(290, 120, 20, 20);
    jlAM.setBounds(320, 120, 40, 20);
    jrbPM.setBounds(360, 120, 20, 20);
    jlPM.setBounds(390, 120, 40, 20);
    jbtnConfirm.setBounds(200, 270, 90, 30);
    jbtnCancel.setBounds(300, 270, 90, 30);


    add(jlReservationDate);
    add(jrbAM);
    add(jlAM);
    add(jrbPM);
    add(jlPM);
    add(jbtnConfirm);
    add(jbtnCancel);

  }// addPreventiView


  private void addRecallView() {
    Font font = new Font("맑은 고딕", Font.BOLD, 18);
    // 캘린더 라벨
    jlReservationDate = new JLabel();

    jlReservationDate.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1)));

    // 라디오 버튼
    jrbAM = new JRadioButton();
    jrbPM = new JRadioButton();
    ButtonGroup bg = new ButtonGroup();
    bg.add(jrbAM);
    bg.add(jrbPM);

    jlAM = new JLabel("오전");
    jlPM = new JLabel("오후");
    jlAM.setFont(new Font("맑은 고딕", Font.BOLD, 13));
    jlPM.setFont(new Font("맑은 고딕", Font.BOLD, 13));


    // 하단 버튼
    jbtnConfirm = new JButton("예약신청");
    jbtnCancel = new JButton("취소");

    setLayout(null);

    ReservationCalendarDialogView rcdv = new ReservationCalendarDialogView();
    rcdv.setSize(200, 200);
    rcdv.setBorder(new TitledBorder(new LineBorder(Color.BLACK)));
    jlReservationDate.add(rcdv);


    // 컴포넌트 배치
    jlReservationDate.setBounds(10, 20, 230, 220);
    rcdv.setBounds(0, 0, 230, 220);
    jrbAM.setBounds(290, 120, 20, 20);
    jlAM.setBounds(320, 120, 40, 20);
    jrbPM.setBounds(360, 120, 20, 20);
    jlPM.setBounds(390, 120, 40, 20);
    jbtnConfirm.setBounds(200, 270, 90, 30);
    jbtnCancel.setBounds(300, 270, 90, 30);


    add(jlReservationDate);
    add(jrbAM);
    add(jlAM);
    add(jrbPM);
    add(jlPM);
    add(jbtnConfirm);
    add(jbtnCancel);
  }// addRecallView



  public JLabel getJlReservationDate() {
    return jlReservationDate;
  }

  public JLabel getJlReservationReason() {
    return jlReservationReason;
  }

  public JTextArea getJtaReservationReason() {
    return jtaReservationReason;
  }

  public JRadioButton getJrbAM() {
    return jrbAM;
  }

  public JRadioButton getJrbPM() {
    return jrbPM;
  }

  public JButton getJbtnConfirm() {
    return jbtnConfirm;
  }

  public JButton getJbtnCancel() {
    return jbtnCancel;
  }

  public int getViewNum() {
    return viewNum;
  }

}
