package com.extended_warranty_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "warrantyplans")
public class WarrantyPlans {
    private Integer planId;
    private String name;
    private Integer durationMonths;
    private Integer kmLimit;
    private Integer warrantyTypeId;
    private Integer coverageTypeId;
    private BigDecimal basePrice;
    private BigDecimal surchargePercent;

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(Integer durationMonths) {
        this.durationMonths = durationMonths;
    }

    public Integer getKmLimit() {
        return kmLimit;
    }

    public void setKmLimit(Integer kmLimit) {
        this.kmLimit = kmLimit;
    }

    public Integer getWarrantyTypeId() {
        return warrantyTypeId;
    }

    public void setWarrantyTypeId(Integer warrantyTypeId) {
        this.warrantyTypeId = warrantyTypeId;
    }

    public Integer getCoverageTypeId() {
        return coverageTypeId;
    }

    public void setCoverageTypeId(Integer coverageTypeId) {
        this.coverageTypeId = coverageTypeId;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getSurchargePercent() {
        return surchargePercent;
    }

    public void setSurchargePercent(BigDecimal surchargePercent) {
        this.surchargePercent = surchargePercent;
    }
}
