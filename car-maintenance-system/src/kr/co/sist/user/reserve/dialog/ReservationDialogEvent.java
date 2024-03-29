package kr.co.sist.user.reserve.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import kr.co.sist.admin.manage.reserved_car.ReservedCarDAO;
import kr.co.sist.admin.manage.reserved_car.ReservedCarVO;
import kr.co.sist.admin.register.car.RegisteredCarVO;
import kr.co.sist.user.reserve.common.ReservationManagementVO;
import kr.co.sist.user.reserve.common.SelectDay;
import kr.co.sist.user.reserve.dao.ReservationManagementDAO;

public class ReservationDialogEvent implements ActionListener {

    private ReservationDialogView rdv;
    private ReservationCalendarDialogView rcdv;
    private ReservationCalendarDialogEvent rcde;
    private String selectTime;
    private String reserveDate;
    private boolean checkFlag, deleteFlag;

    public ReservationDialogEvent(ReservationDialogView rdv) {
        this.rdv = rdv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == rdv.getJrbAM() || e.getSource() == rdv.getJrbPM()) {
            selectTime = e.getActionCommand();
        }

        if (e.getSource() == rdv.getJbtnConfirm()) { // 예약 요청 버튼
            if (rdv.getViewNum() == rdv.COMMON) { // 일반 정비 신청
                try {
                    // 항목이 비어있거나 선택하지 않은 경우
                    if (rdv.getBg().getSelection() == null || rdv.getJtaReservationReason().getText().isEmpty()
                            || SelectDay.jtfDate.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(rdv, "선택 항목을 확인해주세요.");
                        return;
                    } // end if
                    checkFlag = checkDateDuplication(reserveDate + " " + selectTime);
                    if (checkFlag == true) {
                        JOptionPane.showMessageDialog(rdv, "신청하신 예약 일자는 이미 마감 되었습니다. 다른 날짜 혹은 시간을 선택해주세요.");
                    }
                    if (checkFlag == false) {
                        insertCommonReservation();
                        JOptionPane.showMessageDialog(rdv, "일반 정비 예약이 신청 되었습니다.");
                    } // end if
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } // end catch
                rdv.getJtaReservationReason().setText("");
                SelectDay.jtfDate.setText("");
                rdv.getBg().clearSelection();
            } // end if

            if (rdv.getViewNum() == rdv.PREVENTI) { // 예방 정비 신청
                // 항목이 비어있거나 선택하지 않은 경우
                if (rdv.getBg().getSelection() == null || SelectDay.jtfDate.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rdv, "선택 항목을 확인해주세요.");
                    return;
                } // end if
                try {
                    checkFlag = checkDateDuplication(reserveDate + " " + selectTime);
                    if (checkFlag == true) {
                        JOptionPane.showMessageDialog(rdv, "신청하신 예약 일자는 이미 마감 되었습니다. 다른 날짜 혹은 시간을 선택해주세요.");
                    }
                    if (checkFlag == false) {
                        insertReservation();
                        JOptionPane.showMessageDialog(rdv, "예방 정비 예약이 신청 되었습니다.");
                    } // end if
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } // end catch
                SelectDay.jtfDate.setText("");
                rdv.getBg().clearSelection();
            } // end if

            if (rdv.getViewNum() == rdv.RECALL) {
                // 항목이 비어있거나 선택하지 않은 경우
                if (rdv.getBg().getSelection() == null || SelectDay.jtfDate.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rdv, "선택 항목을 확인해주세요.");
                    return;
                } // end if
                try {
                    checkFlag = checkDateDuplication(reserveDate + " " + selectTime);
                    if (checkFlag == true) {
                        JOptionPane.showMessageDialog(rdv, "신청하신 예약 일자는 이미 마감 되었습니다. 다른 날짜 혹은 시간을 선택해주세요.");
                    }
                    if (checkFlag == false) {
                        insertReservation();
                        JOptionPane.showMessageDialog(rdv,
                                "리콜 정비 부품 재고 상태에 따라\n해당 예약일보다 일정이 늦어질 수 있습니다.\n추후 센터에서 예약 여부 문자가 발송될 예정입니다.");
                    } // end if
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } // end catch
                SelectDay.jtfDate.setText("");
                rdv.getBg().clearSelection();
            } // end if
        } // end if

        if (e.getSource() == rdv.getJbtnCancel()) { // 취소 버튼
            rdv.getCrv().dispose();
            JOptionPane.showMessageDialog(rdv, "취소 되었습니다.");
        } // end if
    }// actionPerformed



    public void insertCommonReservation() throws SQLException {
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
        reserveDate = rcdv.getSelectYear() + "-" + rcdv.getSelectMonth() + "-" + SelectDay.selectDay; // 날짜
        // CommDate.day
        String maintenanceClassification = "일반"; // 정비 분류

        rmVO = new ReservationManagementVO(ownerId, tel, carId, carModel, reserveReason, reserveDate, reserveTime,
                maintenanceClassification);

        boolean duplicationFlag = checkDateDuplication(reserveDate + " " + selectTime);
        try {
            if (duplicationFlag == false) { // 중복되지 않을 경우 실행
                rmDAO.insertReservationManagement(rmVO);
            } else { // 중복될 경우
                checkFlag = duplicationFlag;
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }// insertCommonReservation


    public void insertReservation() throws SQLException {
        rcdv = new ReservationCalendarDialogView();
        ReservationManagementDAO rmDAO = ReservationManagementDAO.getInstance();
        rcde = new ReservationCalendarDialogEvent(rcdv, rcdv.getDayButton());
        ReservationManagementVO rmVO = null;
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
        String reserveReason = rdv.getCrv().getParts(); // 어떤 부품에 대한 예방인지 부품의 정보를 받아와야 한다.
        reserveDate = rcdv.getSelectYear() + "-" + rcdv.getSelectMonth() + "-" + SelectDay.selectDay; // 날짜
        // CommDate.day
        String maintenanceClassification = null; // 정비 분류
        if (rdv.getViewNum() == rdv.PREVENTI) {
            maintenanceClassification = "정기";
        }
        if (rdv.getViewNum() == rdv.RECALL) {
            maintenanceClassification = "리콜";
        }

        rmVO = new ReservationManagementVO(ownerId, tel, carId, carModel, reserveReason, reserveDate, reserveTime,
                maintenanceClassification);

        try {
            boolean duplicationFlag = checkDateDuplication(reserveDate + " " + selectTime);
            if (duplicationFlag == false) { // 중복되지 않을 경우 실행
                rmDAO.insertReservationManagement(rmVO);
            } else { // 중복될 경우
                checkFlag = duplicationFlag;
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }// insertReservation


    public void addReservedCar() throws SQLException {
        ReservedCarDAO rcDAO = ReservedCarDAO.getInstance();
        ReservedCarVO rcVO = null;

        String carId = "사용자 차량번호";
        String ownerId = "사용자 ID";
        String carModel = "사용자 차량 모델";
        Date reservedDate = new Date();
        Date releasedDate = new Date();
        int carYear = 2024;
        int driveDistance = 3333;
        String maintenanceStatus = "x";

        rcVO = new ReservedCarVO(carId, ownerId, carModel, reservedDate, releasedDate, carYear, driveDistance,
                maintenanceStatus);

        boolean duplicationFlag = rcDAO.checkCarIdDuplication(carId);

        if (duplicationFlag == true) {
            // 삭제하는 method 실행
        }

        if (duplicationFlag == false) {
            rcDAO.insertReservedCar(rcVO);
        }

    }// addReservedCar


    /**
     * 예약일자 중복 체크 method
     * 
     * @param selectDay
     * @return
     * @throws SQLException
     */
    public boolean checkDateDuplication(String date) throws SQLException {
        ReservationManagementDAO rmDAO = ReservationManagementDAO.getInstance();
        boolean duplicationFlag = false;

        String checkDate = date;

        duplicationFlag = rmDAO.checkDateDuplication(checkDate);

        return duplicationFlag;
    }



    public void searchReservationByOwnerId() { // view 구현 필요
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

    public boolean isCheckFlag() {
        return checkFlag;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }


}
