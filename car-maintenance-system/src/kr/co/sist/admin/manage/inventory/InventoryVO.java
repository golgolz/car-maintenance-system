package kr.co.sist.admin.manage.inventory;

import java.sql.Date;

public class InventoryVO {
  private String partCode;
  private String partName;
  private int partCnt;
  private int partPrice;
  private Date partInputDate;

  // 생성자
  public InventoryVO(String partCode, String partName, int partCnt, int partPrice, Date partInputDate) {
    this.partCode = partCode;
    this.partName = partName;
    this.partCnt = partCnt;
    this.partPrice = partPrice;
    this.partInputDate = partInputDate;
  }

  public InventoryVO(String partCode, String partName, int partCnt, int partPrice) { // 추가용 생성자
    this.partCode = partCode;
    this.partName = partName;
    this.partCnt = partCnt;
    this.partPrice = partPrice;
  }

  public InventoryVO(int partCnt, int partPrice) {
    this.partCnt = partCnt;
    this.partPrice = partPrice;
  }

  public String getPartCode() {
    return partCode;
  }

  public String getPartName() {
    return partName;
  }

  public int getPartCnt() {
    return partCnt;
  }

  public int getPartPrice() {
    return partPrice;
  }

  public Date getPartInputDate() {
    return partInputDate;
  }

  @Override
  public String toString() {
    return "InventoryVO [partCode=" + partCode + ", partName=" + partName + ", partCnt=" + partCnt + ", partPrice="
        + partPrice + ", partInputDate=" + partInputDate + "]";
  }



}
