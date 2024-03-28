package kr.co.sist.user.recall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import kr.co.sist.admin.recall.RecallDAO;

public class UserRecallEvent implements ActionListener {
    private UserRecallView userRecallView;

    public UserRecallEvent(UserRecallView userRecallView) {
        this.userRecallView = userRecallView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String carId = userRecallView.getCarIdComboBox().getSelectedItem().toString();
        if (isRecallTarget(carId)) {
            JOptionPane.showMessageDialog(userRecallView, carId + "는 리콜 대상입니다.");
            try {
                new UserRecallDetailDialogView(RecallDAO.getInstance().selectOneRecallInfo(carId), false);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(userRecallView, carId + "는 리콜 대상이 아닙니다.");
        }
    }

    public boolean isRecallTarget(String carId) {
        try {
            if (RecallDAO.getInstance().selectOneRecallTarget(carId) > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
