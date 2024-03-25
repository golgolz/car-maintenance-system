package kr.co.sist.user.history;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class MaintenanceManagementEvent extends WindowAdapter implements ActionListener {

  private MaintenanceManagementView maintenanceManagementView;
  private PreventiMaintenanceView preventiMaintenanceView;
  private CommonMaintenanceView commonMaintenanceView;

  public MaintenanceManagementEvent(MaintenanceManagementView maintenanceManagementView) {
    this.maintenanceManagementView = maintenanceManagementView;
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == maintenanceManagementView.getJbtnPreventiHistory()) {
      new PreventiMaintenanceView();
    }
    if (ae.getSource() == maintenanceManagementView.getJbtnCommonManagementHistory()) {
      new CommonMaintenanceView();
    }

  }

}
