package com.jocata.extendedwarrantysystem.form;

public class WarrantyPlanRequestForm {
    private String planId;
    private String name;
    private String durationMonths;
    private String kmLimit;
    private String warrantyTypeId;
    private String coverageTypeId;
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

    public String getWarrantyTypeId() {
        return warrantyTypeId;
    }

    public void setWarrantyTypeId(String warrantyTypeId) {
        this.warrantyTypeId = warrantyTypeId;
    }

    public String getCoverageTypeId() {
        return coverageTypeId;
    }

    public void setCoverageTypeId(String coverageTypeId) {
        this.coverageTypeId = coverageTypeId;
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
