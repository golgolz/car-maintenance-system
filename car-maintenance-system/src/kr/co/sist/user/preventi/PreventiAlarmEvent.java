package kr.co.sist.user.preventi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreventiAlarmEvent implements ActionListener {
    private PreventiAlarmView preventiAlarmView;

    public PreventiAlarmEvent(PreventiAlarmView preventiAlarmView) {
        this.preventiAlarmView = preventiAlarmView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "예약하기":
                System.out.println("예약 버튼 눌림");
                // [TODO] 예약 다이얼로그에 예방 정비 예약에 대한 플래그 넣어서 생성자 호출
                break;
            case "취소":
                System.out.println("취소 버튼 눌림");
                preventiAlarmView.dispose();
                break;
        }
    }
}
