package kr.co.sist.user.recall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRecallDetailDialogEvent implements ActionListener {
    private UserRecallDetailDialogView userRecallDetailDialogView;

    public UserRecallDetailDialogEvent(UserRecallDetailDialogView userRecallDetailDialogView) {
        this.userRecallDetailDialogView = userRecallDetailDialogView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "예약하기":
                // [TODO] 예약 다이얼로그 객체화 추가
                break;
            case "확인":
                userRecallDetailDialogView.dispose();
                break;
        }
    }
}
