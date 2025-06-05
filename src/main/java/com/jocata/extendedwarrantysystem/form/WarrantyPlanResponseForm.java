package com.jocata.extendedwarrantysystem.form;

public class WarrantyPlanResponseForm {
    private String planId;
    private String name;
    private String durationMonths;
    private String kmLimit;
    private String warrantyTypeName;
    private String coverageTypeName;
    private String basePrice;
    private String surchagePercent;

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(String durationMonths) {
        this.durationMonths = durationMonths;
    }

    public String getKmLimit() {
        return kmLimit;
    }

    public void setKmLimit(String kmLimit) {
        this.kmLimit = kmLimit;
    }

    public String getWarrantyTypeName() {
        return warrantyTypeName;
    }

    public void setWarrantyTypeName(String warrantyTypeName) {
        this.warrantyTypeName = warrantyTypeName;
    }

    public String getCoverageTypeName() {
        return coverageTypeName;
    }

    public void setCoverageTypeName(String coverageTypeName) {
        this.coverageTypeName = coverageTypeName;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public String getSurchagePercent() {
        return surchagePercent;
    }

    public void setSurchagePercent(String surchagePercent) {
        this.surchagePercent = surchagePercent;
    }
}
