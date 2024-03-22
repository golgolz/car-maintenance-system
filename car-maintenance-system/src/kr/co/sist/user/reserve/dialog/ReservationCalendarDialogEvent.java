package kr.co.sist.user.reserve.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationCalendarDialogEvent implements ActionListener {

  private ReservationCalendarDialogView rcdv;
  private String day;

  public ReservationCalendarDialogEvent(ReservationCalendarDialogView rcdv) {
    this.rcdv = rcdv;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // 클릭된 버튼의 텍스트(날짜)를 가져와서 출력
    System.out.println("1");
  }



}
