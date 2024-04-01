package kr.co.sist.admin.register.car;

import java.sql.Date;

public class RegisteredCarVO {
    private String carId;
    private String carIdentityNumber;
    private String ownerId;
    private String carModel;
    private Date productionDate;
    private Date registrationDate;
    private int carYear;
    private int driveDistance;
    private String recallFlag;
    private String deleteFlag;

    public RegisteredCarVO(String carId) {
        this.carId = carId;
    }

    public RegisteredCarVO(String carId, String carIdentityNumber, String ownerId, String carModel, Date productionDay,
            Date registrationDay, int carYear, int driveDistance, String recallFlag, String dedeteFlag) {
        this.carId = carId;
        this.carIdentityNumber = carIdentityNumber;
        this.ownerId = ownerId;
        this.carModel = carModel;
        this.productionDate = productionDay;
        this.registrationDate = registrationDay;
        this.carYear = carYear;
        this.driveDistance = driveDistance;
        this.recallFlag = "X";
        this.deleteFlag = "X";
    }



    public RegisteredCarVO(String carId, String carIdentityNumber, String ownerId, String carModel, int carYear,
            int driveDistance) {
        super();
        this.carId = carId;
        this.carIdentityNumber = carIdentityNumber;
        this.ownerId = ownerId;
        this.carModel = carModel;
        this.carYear = carYear;
        this.driveDistance = driveDistance;
    }


    public RegisteredCarVO() {

    }

    public String getCarId() {
        return carId;
    }

    public String getCarIdentityNumber() {
        return carIdentityNumber;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getCarModel() {
        return carModel;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public int getCarYear() {
        return carYear;
    }

    public int getDriveDistance() {
        return driveDistance;
    }

    public String getRecallFlag() {
        return recallFlag;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }


    public void setCarId(String carId) {
        this.carId = carId;
    }



    public void setCarIdentityNumber(String carIdentityNumber) {
        this.carIdentityNumber = carIdentityNumber;
    }



    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }



    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }



    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }



    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }



    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }



    public void setDriveDistance(int driveDistance) {
        this.driveDistance = driveDistance;
    }



    public void setRecallFlag(String recallFlag) {
        this.recallFlag = recallFlag;
    }



    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }



    @Override
    public String toString() {
        return "RegisteredCarVO [carId=" + carId + ", carIdentityNumber=" + carIdentityNumber + ", ownerId=" + ownerId
                + ", carModel=" + carModel + ", productionDay=" + productionDate + ", registrationDay="
                + registrationDate + ", carYear=" + carYear + ", driveDistance=" + driveDistance + ", recallFlag="
                + recallFlag + ", deleteFlag=" + deleteFlag + "]";
    }



}
