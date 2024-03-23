package kr.co.sist.user.reserve.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ReservationDialogEvent implements ActionListener {

  private ReservationDialogView rdv;

  public ReservationDialogEvent(ReservationDialogView rdv) {
    this.rdv = rdv;
  }

  @Override
  public void actionPerformed(ActionEvent ae) {

    if (ae.getSource() == rdv.getJbtnConfirm()) { // 예약 요청 버튼
      if (rdv.getViewNum() == rdv.COMMON) {
        JOptionPane.showMessageDialog(rdv, "일반 정비 예약이 신청 되었습니다.");
        rdv.getJtaReservationReason().setText("");
      } // end if
      if (rdv.getViewNum() == rdv.PREVENTI) {
        JOptionPane.showMessageDialog(rdv, "예방 정비 예약이 신청 되었습니다.");
      } // end if
      if (rdv.getViewNum() == rdv.RECALL) {
        JOptionPane.showMessageDialog(rdv, "리콜 예약이 신청 되었습니다.");
      } // end if
    } // end if
    if (ae.getSource() == rdv.getJbtnCancel()) { // 취소 버튼
      JOptionPane.showMessageDialog(rdv, "취소 되었습니다.");
    } // end if
  }


}
