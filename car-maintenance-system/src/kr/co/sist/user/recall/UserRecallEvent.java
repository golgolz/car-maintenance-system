package kr.co.sist.user.recall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            new UserRecallDetailDialogView(RecallDAO.getInstance().selectOneRecallInfo(carId));
        } else {
            JOptionPane.showMessageDialog(userRecallView, carId + "는 리콜 대상이 아닙니다.");
        }
    }

    public String[] createUserCarInfo() {
        return new String[] {"135칠7911", "222나3456"};
    }

    public boolean isRecallTarget(String carId) {
        if (carId.equals("135칠7911")) {
            return true;
        }
        return false;
    }
}
