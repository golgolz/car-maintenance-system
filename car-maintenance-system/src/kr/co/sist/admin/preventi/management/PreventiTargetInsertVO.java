package kr.co.sist.admin.preventi.management;

import java.sql.Date;

public class PreventiTargetInsertVO {
    private String carId;
    private Date productionDate;
    private String partCode;

    public PreventiTargetInsertVO(String carId, Date productionDate, String partCode) {
        this.carId = carId;
        this.productionDate = productionDate;
        this.partCode = partCode;
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
}
