package kr.co.sist.admin.manage.reserved_car;

public class ReleasedCarVO {

    private String carId;
    private int carYear;
    private int driveDistance;
    private String reservedDate;
    private String releasedDate;
    private String ownerId;

    public ReleasedCarVO(String carId, int carYear, int driveDistance, String reservedDate, String releasedDate,
            String ownerId) {
        super();
        this.carId = carId;
        this.carYear = carYear;
        this.driveDistance = driveDistance;
        this.reservedDate = reservedDate;
        this.releasedDate = releasedDate;
        this.ownerId = ownerId;
    }

    public String getCarId() {
        return carId;
    }

    public int getCarYear() {
        return carYear;
    }

    public int getDriveDistance() {
        return driveDistance;
    }

    public String getReservedDate() {
        return reservedDate;
    }

    public String getReleasedDate() {
        return releasedDate;
    }

    public String getOwnerId() {
        return ownerId;
    }

    @Override
    public String toString() {
        return "ReleasedCarVO [carId=" + carId + ", carYear=" + carYear + ", driveDistance=" + driveDistance
                + ", reservedDate=" + reservedDate + ", releasedDate=" + releasedDate + ", ownerId=" + ownerId + "]";
    }



}
