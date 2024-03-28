package kr.co.sist.user.monthly;

import java.sql.Date;

public class MonthlyCarMaintenanceVO {

  private String ownerName;
  private Date maintenanceDate;
  private String maintenanceDate2;
  private String partName;
  private int partPrice;
  private int partCnt;
  private int totalPrice;


  public MonthlyCarMaintenanceVO(String string, Date date, String partName, int partPrice, int partCnt) {
    super();
    this.ownerName = ownerName;
    this.maintenanceDate = maintenanceDate;
    this.partName = partName;
    this.partPrice = partPrice;
    this.partCnt = partCnt;
  }

  public MonthlyCarMaintenanceVO(String string, Date date) {
    this.ownerName = ownerName;
    this.maintenanceDate = maintenanceDate;
  }

  public MonthlyCarMaintenanceVO(String ownerName, String maintenanceDate2) {
    this.ownerName = ownerName;
    this.maintenanceDate2 = maintenanceDate2;
  }

  public MonthlyCarMaintenanceVO(String partName, int partPrice, int partCnt, int totalPrice) {
    this.partName = partName;
    this.partPrice = partPrice;
    this.partCnt = partCnt;
    this.totalPrice = totalPrice;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public Date getMaintenanceDate() {
    return maintenanceDate;
  }

  public String getMaintenanceDate2() {
    return maintenanceDate2;
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
    return "MonthlyCarMaintenanceVO [ownerName=" + ownerName + ", maintenanceDate=" + maintenanceDate
        + ", maintenanceDate2=" + maintenanceDate2 + ", partName=" + partName + ", partPrice=" + partPrice
        + ", partCnt=" + partCnt + ", totalPrice=" + totalPrice + "]";
  }



}
