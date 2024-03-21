package kr.co.sist.admin.preventi.policy;

public class PreventiPolicyVO {
    private String part;
    private int distancePeriod;
    private int manufacturePeriod;
    private String content;

    public PreventiPolicyVO(String part, int distancePeriod, int manufacturePeriod, String content) {
        this.part = part;
        this.distancePeriod = distancePeriod;
        this.manufacturePeriod = manufacturePeriod;
        this.content = content;
    }

    public String getPart() {
        return part;
    }

    public int getDistancePeriod() {
        return distancePeriod;
    }

    public int getManufacturePeriod() {
        return manufacturePeriod;
    }

    public String getContent() {
        return content;
    }
}