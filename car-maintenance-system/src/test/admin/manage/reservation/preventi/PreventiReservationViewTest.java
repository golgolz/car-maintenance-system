package test.admin.manage.reservation.preventi;

import org.junit.jupiter.api.Test;
import kr.co.sist.admin.manage.reservation.preventi.PreventiReservationView;

class PreventiReservationViewTest {
    @Test
    void test() {
        PreventiReservationView preventiReservationView = new PreventiReservationView();
        preventiReservationView.setVisible(true);

        while (preventiReservationView.isVisible()) {

        }
    }
}
