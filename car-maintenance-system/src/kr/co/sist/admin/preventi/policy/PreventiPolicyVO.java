package kr.co.sist.admin.preventi.policy;

public class PreventiPolicyVO {
    private String partCode;
    private String partName;
    private int distancePeriod;
    private int productionPeriod;
    private String content;

    public PreventiPolicyVO(String partCode, String partName, int distancePeriod, int productionPeriod,
            String content) {
        this.partCode = partCode;
        this.partName = partName;
        this.distancePeriod = distancePeriod;
        this.productionPeriod = productionPeriod;
        this.content = content;
    }

    public String getPartCode() {
        return partCode;
    }

    public String getPartName() {
        return partName;
    }

    public int getDistancePeriod() {
        return distancePeriod;
    }

    public int getProductionPeriod() {
        return productionPeriod;
    }

    public String getContent() {
        return content;
    }
}
