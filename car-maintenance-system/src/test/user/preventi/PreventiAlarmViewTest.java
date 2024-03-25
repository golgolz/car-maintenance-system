package test.user.preventi;

import org.junit.jupiter.api.Test;
import kr.co.sist.user.preventi.PreventiAlarmView;

class PreventiAlarmViewTest {
    @Test
    void test() {
        PreventiAlarmView preventiAlarmView = new PreventiAlarmView();
        preventiAlarmView.setVisible(true);

        while (preventiAlarmView.isVisible()) {

        }
    }
}
