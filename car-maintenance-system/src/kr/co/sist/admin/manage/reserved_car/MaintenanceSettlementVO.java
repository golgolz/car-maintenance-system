package kr.co.sist.admin.manage.reserved_car;

import java.sql.Date;

public class MaintenanceSettlementVO {
    private String carId;
    private String partCode;
    private int partCnt;
    private Date carMaintenanceDate;
    private String maintenanceClassification;
    private String maintenanceReason;

    public MaintenanceSettlementVO() {}

    public MaintenanceSettlementVO(String carId, String partCode, int partCnt, Date carMaintenanceDate,
            String maintenanceClassification, String maintenanceReason) {
        super();
        this.carId = carId;
        this.partCode = partCode;
        this.partCnt = partCnt;
        this.carMaintenanceDate = carMaintenanceDate;
        this.maintenanceClassification = maintenanceClassification;
        this.maintenanceReason = maintenanceReason;
    }

    public String getCarId() {
        return carId;
    }

    public String getPartCode() {
        return partCode;
    }

    public int getPartCnt() {
        return partCnt;
    }

    public Date getCarMaintenanceDate() {
        return carMaintenanceDate;
    }

    public String getMaintenanceClassification() {
        return maintenanceClassification;
    }

    public String getMaintenanceReason() {
        return maintenanceReason;
    }

    @Override
    public String toString() {
        return "MaintenanceSettlementVO [carId=" + carId + ", partCode=" + partCode + ", partCnt=" + partCnt
                + ", carMaintenanceDate=" + carMaintenanceDate + ", maintenanceClassification="
                + maintenanceClassification + ", maintenanceReason=" + maintenanceReason + "]";
    }


}
