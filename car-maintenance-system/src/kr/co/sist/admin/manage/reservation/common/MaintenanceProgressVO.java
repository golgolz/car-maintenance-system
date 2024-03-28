package kr.co.sist.admin.manage.reservation.common;

public class MaintenanceProgressVO {
  private String partCode; // 부품 코드
  private String partName; // 부품 이름
  private int partPrice; // 부품 가격
  private int partCount; // 부품 카운트
  private String maintenanceClassification;// 정비 분류

  public MaintenanceProgressVO(String partCode, String partName, int partPrice, int partCount,
      String maintenanceClassification) {
    super();
    this.partCode = partCode;
    this.partName = partName;
    this.partPrice = partPrice;
    this.partCount = partCount;
    this.maintenanceClassification = maintenanceClassification;
  }

  public String getPartCode() {
    return partCode;
  }

  public String getPartName() {
    return partName;
  }

  public int getPartPrice() {
    return partPrice;
  }

  public int getPartCount() {
    return partCount;
  }

  public String getMaintenanceClassification() {
    return maintenanceClassification;
  }

  @Override
  public String toString() {
    return "MaintenanceProgressViewVO [partCode=" + partCode + ", partName=" + partName + ", partPrice=" + partPrice
        + ", partCount=" + partCount + ", maintenanceClassification=" + maintenanceClassification + "]";
  }



}
