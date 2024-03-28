package kr.co.sist.user.recall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import kr.co.sist.user.reserve.common.CommonReservationView;
import kr.co.sist.user.reserve.dialog.ReservationDialogView;

public class UserRecallDetailDialogEvent implements ActionListener {
    private UserRecallDetailDialogView userRecallDetailDialogView;

    public UserRecallDetailDialogEvent(UserRecallDetailDialogView userRecallDetailDialogView) {
        this.userRecallDetailDialogView = userRecallDetailDialogView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "예약하기":
                new CommonReservationView("리콜 예약", ReservationDialogView.RECALL,
                        userRecallDetailDialogView.getCurrentRecallInfo().getPartName());
                break;
            case "확인":
                userRecallDetailDialogView.dispose();
                break;
        }
    }
}
