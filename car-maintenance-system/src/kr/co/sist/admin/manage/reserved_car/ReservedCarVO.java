package kr.co.sist.admin.manage.reserved_car;

import java.util.Date;

public class ReservedCarVO {

    private String carId, ownerId, carModel;
    private Date reservedDate, releasedDate;
    private int carYear, driveDistance;
    private String maintenanceStatus, deleteFlag;

    public ReservedCarVO() {}

    public ReservedCarVO(String carId, String ownerId, String carModel, Date reservedDate, Date releasedDate,
            int carYear, int driveDistance, String maintenanceStatus) {
        super();
        this.carId = carId;
        this.ownerId = ownerId;
        this.carModel = carModel;
        this.reservedDate = reservedDate;
        this.releasedDate = releasedDate;
        this.carYear = carYear;
        this.driveDistance = driveDistance;
        this.maintenanceStatus = maintenanceStatus;
    }

    public ReservedCarVO(String carId, String ownerId, String carModel, Date reservedDate, Date releasedDate,
            int carYear, int driveDistance, String maintenanceStatus, String deleteFlag) {
        super();
        this.carId = carId;
        this.ownerId = ownerId;
        this.carModel = carModel;
        this.reservedDate = reservedDate;
        this.releasedDate = releasedDate;
        this.carYear = carYear;
        this.driveDistance = driveDistance;
        this.maintenanceStatus = maintenanceStatus;
        this.deleteFlag = deleteFlag;
    }

    public String getCarId() {
        return carId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getCarModel() {
        return carModel;
    }

    public Date getReservedDate() {
        return reservedDate;
    }

    public Date getReleasedDate() {
        return releasedDate;
    }

    public int getCarYear() {
        return carYear;
    }

    public int getDriveDistance() {
        return driveDistance;
    }

    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    @Override
    public String toString() {
        return "ReservedCarVO [carId=" + carId + ", ownerId=" + ownerId + ", carModel=" + carModel + ", reservedDate="
                + reservedDate + ", releasedDate=" + releasedDate + ", carYear=" + carYear + ", driveDistance="
                + driveDistance + ", maintenanceStatus=" + maintenanceStatus + ", deleteFlag=" + deleteFlag + "]";
    }


}
