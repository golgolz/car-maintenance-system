package kr.co.sist.admin.preventi.management;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import kr.co.sist.admin.preventi.policy.PreventiPolicyDialog;

public class PreventiManagementEvent implements ActionListener {
    private PreventiManagementView preventiManagementView;

    public PreventiManagementEvent(PreventiManagementView preventiManagementView) {
        this.preventiManagementView = preventiManagementView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "보기":
                System.out.println("보기버튼 눌림");
                break;
            case "예방 정비 지침 확인":
                new PreventiPolicyDialog();
                break;
            default:
        }
    }
}
