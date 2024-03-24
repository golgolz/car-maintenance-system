package kr.co.sist.admin.preventi.management;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
                System.out.println("보기");
                break;
            case "검색":
                showSearchResult();
                break;
            case "예방 정비 지침 확인":
                new PreventiPolicyDialog();
                break;
            default:
        }
    }

    public Object[][] showAllPreventi() {
        List<PreventiTargetVO> preventiTargets = PreventiTargetDAO.getInstance().selectAllPreventi();
        Object[][] preventiTargetModel = new Object[preventiTargets.size()][10];
        int cnt = 0;
        for (PreventiTargetVO target : preventiTargets) {
            preventiTargetModel[cnt][0] = target.getCarId();
            preventiTargetModel[cnt][1] = target.getOwnerId();
            preventiTargetModel[cnt][2] = target.getCarModel();
            preventiTargetModel[cnt][3] = target.getDriveDistance();
            preventiTargetModel[cnt][4] = target.getReservationFlag();
            preventiTargetModel[cnt][5] = "";
            preventiTargetModel[cnt][6] = target.getMaintenanceStatus();
            preventiTargetModel[cnt][7] = target.getProductionDate();
            preventiTargetModel[cnt][8] = target.getReservationDate();
            preventiTargetModel[cnt][9] = target.getMaintenanceReason();
        }

        return preventiTargetModel;
    }

    public void showSearchResult() {
        String carId = preventiManagementView.getJtfCarId().getText();
        String ownerId = preventiManagementView.getJtfOwnerId().getText();
        List<PreventiTargetVO> preventiTargets = PreventiTargetDAO.getInstance().selectPreventis(carId, ownerId);

        DefaultTableModel preventiTargetModel = preventiManagementView.getPreventiTargets();


        if (preventiTargets.size() == 0) {
            preventiTargets = PreventiTargetDAO.getInstance().selectAllPreventi();
            JOptionPane.showMessageDialog(preventiManagementView, "검색 결과가 없습니다.\n전체 목록을 출력합니다.");
        } else {
            preventiTargetModel.setRowCount(0);
            Object[] preventiTargetData = new Object[10];

            for (PreventiTargetVO target : preventiTargets) {
                preventiTargetData[0] = target.getCarId();
                preventiTargetData[1] = target.getOwnerId();
                preventiTargetData[2] = target.getCarModel();
                preventiTargetData[3] = target.getDriveDistance();
                preventiTargetData[4] = target.getReservationFlag();
                preventiTargetData[5] = "";
                preventiTargetData[6] = target.getMaintenanceStatus();
                preventiTargetData[7] = target.getProductionDate();
                preventiTargetData[8] = target.getReservationDate();
                preventiTargetData[9] = target.getMaintenanceReason();
                preventiTargetModel.addRow(preventiTargetData);
            }
            JOptionPane.showMessageDialog(preventiManagementView, "검색을 완료했습니다.");
        }
    }
}
