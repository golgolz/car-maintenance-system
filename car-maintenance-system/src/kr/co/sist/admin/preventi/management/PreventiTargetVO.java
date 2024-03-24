package kr.co.sist.admin.preventi.management;

import java.sql.Date;

public class PreventiTargetVO {
    private String carId;
    private String ownerId;
    private String carModel;
    private int driveDistance;
    private String reservationFlag;
    // private List<MaintenanceVO> maintenanceHistory;
    private String maintenanceStatus;
    private Date productionDate;
    private Date reservationDate;
    private String maintenanceReason;

    public PreventiTargetVO(String carId, String ownerId, String carModel, int driveDistance, String reservationFlag,
            String maintenanceStatus, Date productionDate, Date reservationDate, String maintenanceReason) {
        super();
        this.carId = carId;
        this.ownerId = ownerId;
        this.carModel = carModel;
        this.driveDistance = driveDistance;
        this.reservationFlag = reservationFlag;
        this.maintenanceStatus = maintenanceStatus;
        this.productionDate = productionDate;
        this.reservationDate = reservationDate;
        this.maintenanceReason = maintenanceReason;
    }

    // public PreventiTargetVO(String carId, String ownerId, String carModel, int driveDistance, boolean reservationFlag,
    // List<MaintenanceVO> maintenanceHistory, Date productionDate, Date reservationDate,
    // String maintenanceReason) {
    // super();
    // this.carId = carId;
    // this.ownerId = ownerId;
    // this.carModel = carModel;
    // this.driveDistance = driveDistance;
    // this.reservationFlag = reservationFlag;
    // this.maintenanceHistory = maintenanceHistory;
    // this.productionDate = productionDate;
    // this.reservationDate = reservationDate;
    // this.maintenanceReason = maintenanceReason;
    // }

    public String getCarId() {
        return carId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getDriveDistance() {
        return driveDistance;
    }

    public String getReservationFlag() {
        return reservationFlag;
    }

    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public String getMaintenanceReason() {
        return maintenanceReason;
    }
}
