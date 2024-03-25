package kr.co.sist.admin.recall;

import java.sql.Date;

public class RecallInfoVO {
    private String partName;
    private String carModel;
    // private Date recallDate;
    private String imgFile;

    public RecallInfoVO(String partName, String carModel, String imgFile) {
        this.partName = partName;
        this.carModel = carModel;
        // this.recallDate = recallDate;
        this.imgFile = imgFile;
    }

    public RecallInfoVO(String partName, String carModel, Date recallDate, String imgFile) {
        this.partName = partName;
        this.carModel = carModel;
        // this.recallDate = recallDate;
        this.imgFile = imgFile;
    }

    public String getPartName() {
        return partName;
    }

    public String getCarModel() {
        return carModel;
    }

    // public Date getRecallDate() {
    // return recallDate;
    // }

    public String getImgFile() {
        return imgFile;
    }
}
