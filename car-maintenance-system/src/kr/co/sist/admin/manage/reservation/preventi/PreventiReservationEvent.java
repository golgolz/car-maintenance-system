package kr.co.sist.admin.manage.reservation.preventi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreventiReservationEvent implements ActionListener {
    private PreventiReservationView preventiReservationView;

    public PreventiReservationEvent(PreventiReservationView preventiReservationView) {
        this.preventiReservationView = preventiReservationView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("검색 버튼 눌림");
        // selectPreReservationByOwnerId->
    }
}
