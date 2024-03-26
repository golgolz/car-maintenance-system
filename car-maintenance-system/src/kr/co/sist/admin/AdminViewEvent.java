package kr.co.sist.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import kr.co.sist.admin.manage.inventory.InventoryView;
import kr.co.sist.admin.manage.reserved_car.ReservedCarView;
import kr.co.sist.admin.manage.user.AdminManageView;
import kr.co.sist.admin.recall.AdminRecallView;
import kr.co.sist.admin.register.car.AdminRegisteredCarView;

public class AdminViewEvent extends WindowAdapter implements ActionListener {

  private AdminView adminView;

  public AdminViewEvent(AdminView adminView) {
    this.adminView = adminView;
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == adminView.getJbtnReceivingManage()) {
      new ReservedCarView();
    }
    if (ae.getSource() == adminView.getJbtnReservationManage()) {
      new ReservedCarView();
    }
    if (ae.getSource() == adminView.getJbtnPartsManage()) {
      new InventoryView();
    }
    if (ae.getSource() == adminView.getJbtnRecallManage()) {
      new AdminRecallView();
    }
    if (ae.getSource() == adminView.getJbtnRegisteredCarManage()) {
      new AdminRegisteredCarView();
    }
    if (ae.getSource() == adminView.getJbtnUserManage()) {
      new AdminManageView();
    }
  }

  @Override
  public void windowClosing(WindowEvent e) {
    if (e.getSource() == adminView.getJbtnLogout()) {
      adminView.dispose();
    }
  }

  public static void main(String[] args) {
    new AdminView();
  }

}
