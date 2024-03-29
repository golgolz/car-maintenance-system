package kr.co.sist.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import kr.co.sist.admin.manage.inventory.InventoryView;
import kr.co.sist.admin.manage.reservation.common.CommonReservationView;
import kr.co.sist.admin.manage.reservation.preventi.PreventiReservationView;
import kr.co.sist.admin.manage.reserved_car.ReleasedCarView;
import kr.co.sist.admin.manage.reserved_car.ReservedCarView;
import kr.co.sist.admin.manage.user.AdminManageView;
import kr.co.sist.admin.preventi.management.PreventiManagementView;
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
        if (ae.getSource() == adminView.getJbtnCommonReservation()) {
            new CommonReservationView();
        }
        if (ae.getSource() == adminView.getJbtnReleasedCar()) {
            new ReleasedCarView();
        }
        if (ae.getSource() == adminView.getJbtnPreventiManagement()) {
            new PreventiManagementView();
        }
        if (ae.getSource() == adminView.getJbtnPreventiReservation()) {
            new PreventiReservationView();
        }
        if (ae.getSource() == adminView.getJbtnPartsManage()) {
            new InventoryView();
        }
        if (ae.getSource() == adminView.getJbtnRecallManage()) {
            new AdminRecallView();
        }
        if (ae.getSource() == adminView.getJbtnRegisteredCarManage()) {
            try {
                new AdminRegisteredCarView();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ae.getSource() == adminView.getJbtnUserManage()) {
            new AdminManageView();
        }
        if (ae.getSource() == adminView.getJbtnLogout()) {
            int flag = JOptionPane.showConfirmDialog(adminView, "로그아웃 하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
            switch (flag) {
                case JOptionPane.OK_OPTION:
                    adminView.dispose();
            }
        }
    }

    // @Override
    // public void windowClosing(WindowEvent e) {
    // if (e.getSource() == adminView.getJbtnLogout()) {
    // adminView.dispose();
    // }
    // }

    // public static void main(String[] args) {
    // new AdminView();
    // }

}
