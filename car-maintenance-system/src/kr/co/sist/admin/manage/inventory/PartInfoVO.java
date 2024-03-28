package kr.co.sist.admin.manage.inventory;

public class PartInfoVO {

  private String partCode;
  private String partName;

  public PartInfoVO(String partCode, String partName) {
    this.partCode = partCode;
    this.partName = partName;
  }

  public String getPartCode() {
    return partCode;
  }

  public void setPartCode(String partCode) {
    this.partCode = partCode;
  }

  public String getPartName() {
    return partName;
  }

  public void setPartName(String partName) {
    this.partName = partName;
  }
}
