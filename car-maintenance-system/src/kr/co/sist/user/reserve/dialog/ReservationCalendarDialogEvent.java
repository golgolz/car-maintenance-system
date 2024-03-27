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
    public void actionPerformed(ActionEvent e) {}


    public ReservationCalendarDialogView getRcdv() {
        return rcdv;
    }

    public JButton getDayButton() {
        return dayButton;
    }


}
