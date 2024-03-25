package kr.co.sist.admin.manage.reservation.common;

import java.sql.Date;

public class CommonReservationVO {
    private String carId;
    private String ownerName;
    private String ownerId;
    private String carMoodel;
    private int driveDistance;
    private int maintenanceState;
    private Date productionDate;
    private Date reservationDate;
    private String reservationReason;

    public CommonReservationVO(String carId, String ownerName, String ownerId, String carMoodel, int driveDistance,
            int maintenanceState, Date productionDate, Date reservationDate, String reservationReason) {
        super();
        this.carId = carId;
        this.ownerName = ownerName;
        this.ownerId = ownerId;
        this.carMoodel = carMoodel;
        this.driveDistance = driveDistance;
        this.maintenanceState = maintenanceState;
        this.productionDate = productionDate;
        this.reservationDate = reservationDate;
        this.reservationReason = reservationReason;
    }

    public String getCarId() {
        return carId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getCarMoodel() {
        return carMoodel;
    }

    public int getDriveDistance() {
        return driveDistance;
    }

    public int getMaintenanceState() {
        return maintenanceState;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public String getReservationReason() {
        return reservationReason;
    }

    @Override
    public String toString() {
        return "CommonReservationVO [carId=" + carId + ", ownerName=" + ownerName + ", ownerId=" + ownerId
                + ", carMoodel=" + carMoodel + ", driveDistance=" + driveDistance + ", maintenanceState="
                + maintenanceState + ", productionDate=" + productionDate + ", reservationDate=" + reservationDate
                + ", reservationReason=" + reservationReason + "]";
    }



}
