package kr.co.sist.user.reserve.common;

import org.junit.jupiter.api.Test;
import kr.co.sist.user.reserve.dialog.ReservationDialogView;

public class CommonReservationTest {
    // @Test
    // void testCommon() {
    // CommonReservationView crv = new CommonReservationView("일반 정비 예약", ReservationDialogView.COMMON);
    // crv.setVisible(true);
    //
    // while (crv.isVisible()) {
    // } // end while
    // }// testCommon


    @Test
    void testPreventi() {
        CommonReservationView crv = new CommonReservationView("예방 정비 예약", ReservationDialogView.PREVENTI, "부품 이름");
        crv.setVisible(true);

        while (crv.isVisible()) {
        } // end while
    }// testCommon

    // @Test
    // void testRecall() {
    // CommonReservationView crv = new CommonReservationView("리콜 예약", ReservationDialogView.RECALL);
    // crv.setVisible(true);
    //
    // while (crv.isVisible()) {
    // } // end while
    // }// testCommon

}


