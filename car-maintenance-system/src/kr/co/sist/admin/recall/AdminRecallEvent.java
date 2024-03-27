package kr.co.sist.admin.recall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminRecallEvent implements ActionListener {
    private AdminRecallView adminRecallView;

    public AdminRecallEvent(AdminRecallView adminRecallView) {
        this.adminRecallView = adminRecallView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "검색":
                try {
                    showSearchResult();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
        }
    }

    public void showSearchResult() throws SQLException {
        String carId = adminRecallView.getJtfCarId().getText();
        String ownerId = adminRecallView.getJtfOwnerId().getText();
        List<RecallTargetVO> recallTargets = RecallDAO.getInstance().selectRecallTargets(carId, ownerId);

        DefaultTableModel recallTargetModel = adminRecallView.getRecallInfoModel();

        if (recallTargets.size() == 0) {
            recallTargets = RecallDAO.getInstance().selectAllRecallTargets();
            JOptionPane.showMessageDialog(adminRecallView, "검색 결과가 없습니다.\n전체 목록을 출력합니다.");
        }

        recallTargetModel.setRowCount(0);
        Object[] recallTargetData = new Object[7];

        for (RecallTargetVO target : recallTargets) {
            recallTargetData[0] = target.getOwnerName();
            recallTargetData[1] = target.getOwnerId();
            recallTargetData[2] = target.getOwnerTel();
            recallTargetData[3] = target.getCarId();
            recallTargetData[4] = target.getCarModel();
            recallTargetData[5] = "";
            recallTargetData[6] = target.getRecallStatus();
            recallTargetModel.addRow(recallTargetData);
        }
        JOptionPane.showMessageDialog(adminRecallView, "검색을 완료했습니다.");

        adminRecallView.getJtfCarId().setText("");
        adminRecallView.getJtfOwnerId().setText("");
    }
}
