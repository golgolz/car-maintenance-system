package kr.co.sist.admin.preventi.management;

import java.sql.Date;

public class PreventiTargetInsertVO {
    private String carId;
    private Date productionDate;
    private String partCode;
    private int driveDistance;

    public PreventiTargetInsertVO(String carId, Date productionDate, String partCode, int driveDistance) {
        this.carId = carId;
        this.productionDate = productionDate;
        this.partCode = partCode;
        this.driveDistance = driveDistance;
    }

    public String getCarId() {
        return carId;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public String getPartCode() {
        return partCode;
    }

    public int getDriveDistance() {
        return driveDistance;
    }
}
