package kr.co.sist.user.history;

import java.util.Date;

public class PreventiMaintenanceVO {
  private String carId;
  private int carMaintenanceId;
  private String partCode;
  private int partCount;
  private Date carMaintenanceDate;
  private String maintenanceClassification;
  private String maintenanceReason;

  // 생성자
  public PreventiMaintenanceVO(String carId, Date carMaintenanceDate, String maintenanceReason) {
    this.carId = carId;
    this.carMaintenanceDate = carMaintenanceDate;
    this.maintenanceReason = maintenanceReason;
  }



  public String getCarId() {
    return carId;
  }

  public int getCarMaintenanceId() {
    return carMaintenanceId;
  }

  public String getPartCode() {
    return partCode;
  }

  public int getPartCount() {
    return partCount;
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
    return "PreventiMaintenanceVO [carId=" + carId + ", carMaintenanceId=" + carMaintenanceId + ", partCode=" + partCode
        + ", partCount=" + partCount + ", carMaintenanceDate=" + carMaintenanceDate + ", maintenanceClassification="
        + maintenanceClassification + ", maintenanceReason=" + maintenanceReason + "]";
  }



}
