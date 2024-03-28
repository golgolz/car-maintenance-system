package kr.co.sist.user.reserve.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import kr.co.sist.user.reserve.common.SelectDay;

public class ReservationCalendarDialogEvent implements ActionListener {

    private ReservationCalendarDialogView rcdv;
    private JButton dayButton;

    public ReservationCalendarDialogEvent(ReservationCalendarDialogView rcdv, JButton dayButton) {
        this.rcdv = rcdv;
        this.dayButton = dayButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuilder msg = new StringBuilder();
        msg.append(rcdv.getSelectYear()).append("년 ").append(rcdv.getSelectMonth()).append("월 ")
                .append(dayButton.getText()).append("일을 선택 하시겠습니까?");
        if (e.getSource() == dayButton) {
            int result = JOptionPane.showConfirmDialog(rcdv, msg, "날짜 선택", JOptionPane.YES_NO_OPTION);
            if (result == 0) { // 예를 눌렀을 때
                SelectDay.selectDay = dayButton.getText();
                SelectDay.jtfDate.setText(
                        rcdv.getSelectYear() + "년 " + rcdv.getSelectMonth() + "월 " + SelectDay.selectDay + "일");
            } // end if
        }

    }

    public ReservationCalendarDialogView getRcdv() {
        return rcdv;
    }

    public JButton getDayButton() {
        return dayButton;
    }


}
