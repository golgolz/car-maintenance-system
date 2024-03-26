package kr.co.sist.user.reserve.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ReservationCalendarDialogEvent implements ActionListener {

  private ReservationCalendarDialogView rcdv;
  private JButton dayButton;

  public ReservationCalendarDialogEvent(ReservationCalendarDialogView rcdv, JButton dayButton) {
    this.rcdv = rcdv;
    this.dayButton = dayButton;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // 클릭된 버튼의 텍스트(날짜)를 가져와서 출력
    // if (e.getSource() == dayButton) {
    // System.out.print(rcdv.getJlMonth().getText() + " ");
    // System.out.println(dayButton.getText() + "일 ");
    // }
  }

  public ReservationCalendarDialogView getRcdv() {
    return rcdv;
  }

  public JButton getDayButton() {
    return dayButton;
  }

}
