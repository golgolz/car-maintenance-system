package kr.co.sist.user.reserve.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import kr.co.sist.login.LoginDAO;

public class UserCarSelectEvent implements ActionListener {
    private UserCarSelectView userCarSelectView;

    public UserCarSelectEvent(UserCarSelectView userCarSelectView) {
        this.userCarSelectView = userCarSelectView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String carId = userCarSelectView.getCarIdComboBox().getSelectedItem().toString();
        LoginDAO.getInstance().setCarId(carId);
        new CommonReservationView("일반 정비 예약", 1);
    }
}
