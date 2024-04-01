package kr.co.sist.admin.manage.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import kr.co.sist.user.register.user.UserInfoVO;
import kr.co.sist.user.register.user.UserManageDAO;

public class AdminMangeEvent extends WindowAdapter implements ActionListener {

    private AdminManageView adminManageView;

    public AdminMangeEvent(AdminManageView adminManageView) {
        this.adminManageView = adminManageView;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == adminManageView.getJbtnSelectUser()) {
            UserManageDAO userManageDAO = UserManageDAO.getInstance();
            UserInfoVO uiVO = null;
            try {
                uiVO = userManageDAO.selectOneUser(adminManageView.getJtfUserID().getText());
                Object[] objectRow = {uiVO.getId(), uiVO.getName(), uiVO.getAddr(), uiVO.getTel(),
                        uiVO.getRegisteredCar().get(0).getCarId()};
                adminManageView.getDtm().setRowCount(0);
                adminManageView.getDtm().addRow(objectRow);
                // for (int i = 0; i < 5; i++) {
                // System.out.println(objectRow[i]);
                // }
                System.out.println(uiVO.getRegisteredCar().get(0).getCarId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
