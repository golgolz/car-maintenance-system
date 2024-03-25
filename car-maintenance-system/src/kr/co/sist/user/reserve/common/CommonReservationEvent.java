package kr.co.sist.user.reserve.common;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CommonReservationEvent extends WindowAdapter {

  private CommonReservationView commonReservationView;

  public CommonReservationEvent(CommonReservationView commonReservationView) {
    this.commonReservationView = commonReservationView;
  }

  @Override
  public void windowClosing(WindowEvent e) {
    commonReservationView.dispose();
  }

}
