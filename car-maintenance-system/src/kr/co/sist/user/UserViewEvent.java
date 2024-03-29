package kr.co.sist.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import javax.swing.JOptionPane;
import kr.co.sist.admin.manage.reservation.common.CommonReservationView;
import kr.co.sist.user.history.MaintenanceManagementView;
import kr.co.sist.user.manage.user.UserManageView;
import kr.co.sist.user.monthly.MonthlyCarMaintenanceView;
import kr.co.sist.user.preventi.PreventiAlarmView;
import kr.co.sist.user.recall.UserRecallView;
import kr.co.sist.user.register.car.UserRegisteredCarView;

public class UserViewEvent extends WindowAdapter implements ActionListener {

    private UserView userView;

    public UserViewEvent(UserView userView) {
        this.userView = userView;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == userView.getJbtnMaintenance()) {
            new MaintenanceManagementView();
        }
        if (ae.getSource() == userView.getJbtnReservation()) {
            new CommonReservationView();
        }
        if (ae.getSource() == userView.getJbtnResisteredCar()) {
            new UserRegisteredCarView();
        }
        if (ae.getSource() == userView.getJbtnPreventi()) {
            new PreventiAlarmView();
        }
        if (ae.getSource() == userView.getJbtnUpdateUserInfo()) {
            new UserManageView();
        }
        if (ae.getSource() == userView.getJbtnMonthlyCarMaintenance()) {
            new MonthlyCarMaintenanceView();
        }
        if (ae.getSource() == userView.getJbtnUserRecallManage()) {
            new UserRecallView();
        }
        if (ae.getSource() == userView.getJbtnLogout()) {
            int flag = JOptionPane.showConfirmDialog(userView, "로그아웃 하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
            switch (flag) {
                case JOptionPane.OK_OPTION:
                    userView.dispose();
            }
        }
    }

    // public static void main(String[] args) {
    // new UserView();
    // }

}
