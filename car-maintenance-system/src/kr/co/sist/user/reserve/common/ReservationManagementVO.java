package kr.co.sist.user.reserve.common;

import java.sql.Date;
import kr.co.sist.admin.register.car.RegisteredCarVO;

public class ReservationManagementVO {

    private RegisteredCarVO registeredCarVO;
    private String ownerId, name, tel, carId, carModel, reservationDate, reserveTime, reserveReason,
            maintenanceClassification;
    private int driveDistance;
    private Date productDate, reserveDate;

    public ReservationManagementVO() {}

    // 예약 차량 리스트 추가
    public ReservationManagementVO(String ownerId, String tel, String carId, String carModel, String reserveReason,
            String reservationDate, String reserveTime, String maintenanceClassification) {
        super();
        this.ownerId = ownerId;
        this.tel = tel;
        this.carId = carId;
        this.carModel = carModel;
        this.reserveTime = reserveTime;
        this.reserveReason = reserveReason;
        this.reservationDate = reservationDate;
        this.maintenanceClassification = maintenanceClassification;
    }

    // 일반 정비 예약 차량 조회
    public ReservationManagementVO(String carId, String tel, String name, String ownerId, String carModel,
            int driveDistance, String maintenanceClassification, Date productDate, String reservationDate,
            String reserveReason) {
        super();
        this.carId = carId;
        this.tel = tel;
        this.name = name;
        this.ownerId = ownerId;
        this.carModel = carModel;
        this.driveDistance = driveDistance;
        this.maintenanceClassification = maintenanceClassification;
        this.productDate = productDate;
        this.reservationDate = reservationDate;
        this.reserveReason = reserveReason;
    }


    public RegisteredCarVO getRegisteredCarVO() {
        return registeredCarVO;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getTel() {
        return tel;
    }

    public String getCarId() {
        return carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getReserveTime() {
        return reserveTime;
    }

    public String getReserveReason() {
        return reserveReason;
    }

    public String getName() {
        return name;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public int getDriveDistance() {
        return driveDistance;
    }

    public Date getProductDate() {
        return productDate;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public String getMaintenanceClassification() {
        return maintenanceClassification;
    }

    @Override
    public String toString() {
        return "ReservationManagementVO [registeredCarVO=" + registeredCarVO + ", ownerId=" + ownerId + ", name=" + name
                + ", tel=" + tel + ", carId=" + carId + ", carModel=" + carModel + ", reservationDate="
                + reservationDate + ", reserveTime=" + reserveTime + ", reserveReason=" + reserveReason
                + ", maintenanceClassification=" + maintenanceClassification + ", driveDistance=" + driveDistance
                + ", productDate=" + productDate + ", reserveDate=" + reserveDate + "]";
    }


}
