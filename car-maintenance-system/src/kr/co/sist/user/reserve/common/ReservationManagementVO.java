package kr.co.sist.user.reserve.common;

import kr.co.sist.admin.register.car.RegisteredCarVO;

public class ReservationManagementVO {

  private RegisteredCarVO registeredCarVO;
  private String ownerId, tel, carId, carModel, reserveDate, reserveTime, reserveReason, maintenanceClassification;

  public ReservationManagementVO() {}


  public ReservationManagementVO(RegisteredCarVO registeredCarVO, String ownerId, String tel, String carId,
      String carModel, String reserveReason, String reserveDate, String reserveTime, String maintenanceClassification) {
    super();
    this.registeredCarVO = registeredCarVO;
    this.ownerId = ownerId;
    this.tel = tel;
    this.carId = carId;
    this.carModel = carModel;
    this.reserveTime = reserveTime;
    this.reserveReason = reserveReason;
    this.reserveDate = reserveDate;
    this.maintenanceClassification = maintenanceClassification;
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

  public String getReserveDate() {
    return reserveDate;
  }


  public String getMaintenanceClassification() {
    return maintenanceClassification;
  }


  @Override
  public String toString() {
    return "ReservationManagementVO [registeredCarVO=" + registeredCarVO + ", ownerId=" + ownerId + ", tel=" + tel
        + ", carId=" + carId + ", carModel=" + carModel + ", reserveTime=" + reserveTime + ", reserveReason="
        + reserveReason + ", reserveDate=" + reserveDate + ", maintenanceClassification=" + maintenanceClassification
        + "]";
  }



}
