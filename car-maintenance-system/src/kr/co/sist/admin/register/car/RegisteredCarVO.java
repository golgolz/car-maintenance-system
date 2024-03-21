package kr.co.sist.admin.register.car;

import java.sql.Date;

public class RegisteredCarVO {
    private String carId;
    private String carIdentityNumber;
    private String ownerId;
    private String carModel;
    private Date productionDay;
    private Date registrationDay;
    private int carYear;
    private int driveDistance;
    private boolean recallFlag;

    public RegisteredCarVO(String carId, String carIdentityNumber, String ownerId, String carModel, Date productionDay,
            Date registrationDay, int carYear, int driveDistance, boolean recallFlag) {
        this.carId = carId;
        this.carIdentityNumber = carIdentityNumber;
        this.ownerId = ownerId;
        this.carModel = carModel;
        this.productionDay = productionDay;
        this.registrationDay = registrationDay;
        this.carYear = carYear;
        this.driveDistance = driveDistance;
        this.recallFlag = recallFlag;
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

    public Date getProductionDay() {
        return productionDay;
    }

    public Date getRegistrationDay() {
        return registrationDay;
    }

    public int getCarYear() {
        return carYear;
    }

    public int getDriveDistance() {
        return driveDistance;
    }

    public boolean isRecallFlag() {
        return recallFlag;
    }

    @Override
    public String toString() {
        return "RegisteredCarVO [carId=" + carId + ", carIdentityNumber=" + carIdentityNumber + ", ownerId=" + ownerId
                + ", carModel=" + carModel + ", productionDay=" + productionDay + ", registrationDay=" + registrationDay
                + ", carYear=" + carYear + ", driveDistance=" + driveDistance + ", recallFlag=" + recallFlag + "]";
    }


}
