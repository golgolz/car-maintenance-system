package kr.co.sist.user.monthly;

import java.sql.Date;

public class MonthlyCarMaintenanceVO {

  private String ownerName;
  private Date maintenanceDate;
  private String partName;
  private int partPrice;
  private int partCnt;


  public MonthlyCarMaintenanceVO(String ownerName, Date maintenanceDate, String partName, int partPrice, int partCnt) {
    super();
    this.ownerName = ownerName;
    this.maintenanceDate = maintenanceDate;
    this.partName = partName;
    this.partPrice = partPrice;
    this.partCnt = partCnt;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public Date getMaintenanceDate() {
    return maintenanceDate;
  }

  public String getPartName() {
    return partName;
  }

  public int getPartPrice() {
    return partPrice;
  }

  public int getPartCnt() {
    return partCnt;
  }

  @Override
  public String toString() {
    return "MonthlyCarMaintenanceVO [ownerName=" + ownerName + ", maintenanceDate=" + maintenanceDate + ", partName="
        + partName + ", partPrice=" + partPrice + ", partCnt=" + partCnt + "]";
  }



}
