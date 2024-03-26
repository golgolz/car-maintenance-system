package kr.co.sist.admin.preventi.management;

import java.sql.Date;

public class PreventiTargetVO {
    private String carId;
    private String ownerId;
    private String ownerTel;
    private String carModel;
    private int driveDistance;
    private String reservationFlag;
    private String maintenanceStatus;
    private Date productionDate;
    private String reservationDate;
    private String[] maintenanceReason;
    private int numParts;

    public PreventiTargetVO(String carId, String ownerId, String ownerTel, String carModel, int driveDistance,
            String reservationFlag, String maintenanceStatus, Date productionDate, String reservationDate,
            String partName) {
        super();
        this.carId = carId;
        this.ownerId = ownerId;
        this.ownerTel = ownerTel;
        this.carModel = carModel;
        this.driveDistance = driveDistance;
        this.reservationFlag = reservationFlag;
        this.maintenanceStatus = maintenanceStatus;
        this.productionDate = productionDate;
        this.reservationDate = reservationDate;
        maintenanceReason = new String[6];
        numParts = 0;
        addPart(partName);
    }

    public String getCarId() {
        return carId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getOwnerTel() {
        return ownerTel;
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

    public String getReservationDate() {
        return reservationDate;
    }

    public String[] getMaintenanceReason() {
        return maintenanceReason;
    }

    public void addPart(String part) {
        maintenanceReason[numParts] = part;
        for (int i = 0; i < numParts; i++) {
            System.out.println(maintenanceReason[i]);
        }
        numParts += 1;
    }

    public String partToString() {
        StringBuilder partStr = new StringBuilder();
        int i = 0;

        while (maintenanceReason[i] != null) {
            partStr.append(maintenanceReason[i]).append(",");
            i += 1;
        }

        partStr.deleteCharAt(partStr.length() - 1);

        return partStr.toString();
    }
}
