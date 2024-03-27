package kr.co.sist.user.reserve.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import kr.co.sist.admin.register.car.RegisteredCarVO;
import kr.co.sist.user.reserve.common.ReservationManagementVO;
import kr.co.sist.user.reserve.dao.ReservationManagementDAO;

public class ReservationDialogEvent implements ActionListener {

  private ReservationDialogView rdv;
  private ReservationCalendarDialogView rcdv;
  private ReservationCalendarDialogEvent rcde;
  private String selectTime;

  public ReservationDialogEvent(ReservationDialogView rdv) {
    this.rdv = rdv;
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == rdv.getJrbAM() || e.getSource() == rdv.getJrbPM()) {
      selectTime = e.getActionCommand();
    }

    if (e.getSource() == rdv.getJbtnConfirm()) { // 예약 요청 버튼
      if (rdv.getViewNum() == rdv.COMMON) {
        insertCommonReservation();
        JOptionPane.showMessageDialog(rdv, "일반 정비 예약이 신청 되었습니다.");
        rdv.getJtaReservationReason().setText("");
      } // end if
      if (rdv.getViewNum() == rdv.PREVENTI) {
        JOptionPane.showMessageDialog(rdv, "예방 정비 예약이 신청 되었습니다.");
      } // end if
      if (rdv.getViewNum() == rdv.RECALL) {
        JOptionPane.showMessageDialog(rdv,
            "리콜 정비 부품 재고 상태에 따라\n해당 예약일보다 일정이 늦어질 수 있습니다.\n추후 센터에서 예약 여부 문자가 발송될 예정입니다.");
      } // end if
    } // end if
    if (e.getSource() == rdv.getJbtnCancel()) { // 취소 버튼
      JOptionPane.showMessageDialog(rdv, "취소 되었습니다.");
    } // end if
  }// actionPerformed


  public void insertCommonReservation() {
    rcdv = new ReservationCalendarDialogView();
    ReservationManagementDAO rmDAO = ReservationManagementDAO.getInstance();
    rcde = new ReservationCalendarDialogEvent(rcdv, rcdv.getDayButton());
    ReservationManagementVO rmVO = new ReservationManagementVO();
    RegisteredCarVO rVO = rmVO.getRegisteredCarVO();

    // String ownerId = rVO.getOwnerId();
    String ownerId = "jmh";
    // String tel = null;
    String tel = "01040178212";
    // String carId = rVO.getCarId();
    String carId = "369십1523";
    // String carModel = rVO.getCarModel();
    String carModel = "K7";
    String reserveTime = selectTime;
    String reserveReason = rdv.getJtaReservationReason().getText(); // 사유
    String reserveDate = rcdv.getSelectYear() + "-" + rcdv.getSelectMonth() + "-" + rcde.getDayButton().getText(); // 날짜
    // CommDate.day
    String maintenanceClassification = null; // 정비 분류
    if (rdv.getViewNum() == rdv.COMMON) {
      maintenanceClassification = "일반";
    }
    if (rdv.getViewNum() == rdv.PREVENTI) {
      maintenanceClassification = "정기";
    }
    if (rdv.getViewNum() == rdv.RECALL) {
      maintenanceClassification = "리콜";
    }


    rmVO = new ReservationManagementVO(ownerId, tel, carId, carModel, reserveReason, reserveDate, reserveTime,
        maintenanceClassification);



    try {
      rmDAO.insertReservationManagement(rmVO);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }// insertCommonReservation

  public void searchReservationByOwnerId() { // 성강님 view 구현 필요
    ReservationManagementDAO rmDAO = ReservationManagementDAO.getInstance();
  }// searchReservationByOwnerId

  public ReservationDialogView getRdv() {
    return rdv;
  }

  public String getSelectTime() {
    return selectTime;
  }

  public ReservationCalendarDialogView getRcdv() {
    return rcdv;
  }

  public ReservationCalendarDialogEvent getRcde() {
    return rcde;
  }

}
