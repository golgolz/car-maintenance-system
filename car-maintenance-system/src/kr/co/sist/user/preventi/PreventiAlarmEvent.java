package kr.co.sist.user.preventi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import kr.co.sist.user.reserve.common.CommonReservationView;
import kr.co.sist.user.reserve.dialog.ReservationDialogView;

public class PreventiAlarmEvent implements ActionListener {
    private PreventiAlarmView preventiAlarmView;
    private JTable preventiAlarmTable;

    public PreventiAlarmEvent(PreventiAlarmView preventiAlarmView) {
        this.preventiAlarmView = preventiAlarmView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "예약하기":
                preventiAlarmTable = preventiAlarmView.getPreventiAlarmTable();
                int selectedRow = preventiAlarmTable.getSelectedRow();
                if (selectedRow < 0) {
                    JOptionPane.showMessageDialog(null, "선택된 항목이 없습니다.");
                    return;
                }
                new CommonReservationView("예방 정비 예약", ReservationDialogView.PREVENTI,
                        preventiAlarmTable.getValueAt(selectedRow, 2).toString());
                break;
            case "취소":
                preventiAlarmView.dispose();
                break;
        }
    }
}
