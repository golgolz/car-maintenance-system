package kr.co.sist.user.history;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class PreventiMaintenanceEvent implements ActionListener {
  private MaintenanceManagementView maintenanceManagementView;

  public PreventiMaintenanceEvent(MaintenanceManagementView maintenanceManagementView) {
    this.maintenanceManagementView = maintenanceManagementView;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // DAO를 사용하여 데이터 가져오기
    PreventiMaintenanceDAO preventiMaintenanceDAO = PreventiMaintenanceDAO.getInstance();
    try {
      List<PreventiMaintenanceVO> preventiMaintenanceList = preventiMaintenanceDAO.getAllPreventiMaintenance();
      // 가져온 데이터를 PreventiMaintenanceView의 테이블에 추가
      for (PreventiMaintenanceVO maintenanceVO : preventiMaintenanceList) {
        maintenanceManagementView.getPreventiMaintenanceView().addRowToTable(maintenanceVO);
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      // 예외 처리 (예: 메시지 출력)
    }
    // PreventiMaintenanceView 화면을 표시
    maintenanceManagementView.getPreventiMaintenanceView().setVisible(true);
  }
}
