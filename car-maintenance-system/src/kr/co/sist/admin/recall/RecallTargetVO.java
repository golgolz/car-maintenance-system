package kr.co.sist.admin.recall;

public class RecallTargetVO {
    private String ownerName;
    private String ownerId;
    private String ownerTel;
    private String carId;
    private String carModel;
    private String recallStatus;

    public RecallTargetVO(String ownerName, String ownerId, String ownerTel, String carId, String carModel,
            String recallStatus) {
        this.ownerName = ownerName;
        this.ownerId = ownerId;
        this.ownerTel = ownerTel;
        this.carId = carId;
        this.carModel = carModel;
        this.recallStatus = recallStatus;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getOwnerTel() {
        return ownerTel;
    }

    public String getCarId() {
        return carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getRecallStatus() {
        return recallStatus;
    }
}
