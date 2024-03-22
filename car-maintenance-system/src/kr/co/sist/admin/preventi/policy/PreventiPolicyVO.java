package kr.co.sist.admin.preventi.policy;

public class PreventiPolicyVO {
    private String part;
    private int distancePeriod;
    private int productionPeriod;
    private String content;

    public PreventiPolicyVO(String part, int distancePeriod, int productionPeriod, String content) {
        this.part = part;
        this.distancePeriod = distancePeriod;
        this.productionPeriod = productionPeriod;
        this.content = content;
    }

    public String getPart() {
        return part;
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
