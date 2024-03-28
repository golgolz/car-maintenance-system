package kr.co.sist.user.history;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;

public class MaintenanceManagementEvent extends WindowAdapter implements ActionListener {

  private MaintenanceManagementView maintenanceManagementView;
  private PreventiMaintenanceView preventiMaintenanceView;
  private CommonMaintenanceView commonMaintenanceView;

  public MaintenanceManagementEvent(MaintenanceManagementView maintenanceManagementView) {
    this.maintenanceManagementView = maintenanceManagementView;
  }

  public MaintenanceManagementEvent(MaintenanceManagementView maintenanceManagementView,
      PreventiMaintenanceView preventiMaintenanceView) {
    this.maintenanceManagementView = maintenanceManagementView;
    this.preventiMaintenanceView = preventiMaintenanceView; // 전달받은 PreventiMaintenanceView 객체 저장
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == maintenanceManagementView.getJbtnPreventiHistory()) {
      // 버튼 클릭 시 예방정비이력창을 호출
      maintenanceManagementView.showPreventiMaintenanceView();
    } else if (ae.getSource() == maintenanceManagementView.getJbtnCommonManagementHistory()) {
      maintenanceManagementView.showCommonMaintenanceView();
    }
  }


  // PreventiMaintenanceView를 열고 데이터 조회하는 메소드
  private void openPreventiMaintenanceView() throws SQLException {
    if (preventiMaintenanceView == null) {
      preventiMaintenanceView = new PreventiMaintenanceView();
    }
    preventiMaintenanceView.loadData(); // 데이터 로드
    preventiMaintenanceView.setVisible(true); // 보이도록 설정
  }

  public void setPreventiMaintenanceView(PreventiMaintenanceView preventiMaintenanceView) {
    this.preventiMaintenanceView = preventiMaintenanceView;
  }

}
