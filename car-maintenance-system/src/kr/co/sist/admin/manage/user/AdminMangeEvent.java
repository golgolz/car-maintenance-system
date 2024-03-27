package kr.co.sist.admin.manage.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class AdminMangeEvent extends WindowAdapter implements ActionListener {

  private AdminManageView adminManageView;

  public AdminMangeEvent(AdminManageView adminManageView) {
    this.adminManageView = adminManageView;
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == adminManageView.getJbtnSelectUser()) {
    }

  }

}
