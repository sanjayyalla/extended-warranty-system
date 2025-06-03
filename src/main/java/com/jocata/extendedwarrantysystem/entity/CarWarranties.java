package com.jocata.extendedwarrantysystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "carwarranties")
public class CarWarranties {
    private Integer carWarrantyId;
    private Integer carSaleId;
    private Integer planId;
    private Date bwStartDate;
    private Date bwEndDate;
    private Integer bwKmStart;
    private Integer bwKmEnd;
    private Date exwStartDate;
    private Date exwEndDate;
    private Integer exwKmStart;
    private Integer exwKmEnd;
    private BigDecimal pricePaid;
    private Boolean purchasedDuringBasic;
    private Date exwPurchaseDate;
    private Boolean isActive;

    public Integer getCarWarrantyId() {
        return carWarrantyId;
    }

    public void setCarWarrantyId(Integer carWarrantyId) {
        this.carWarrantyId = carWarrantyId;
    }

    public Integer getCarSaleId() {
        return carSaleId;
    }

    public void setCarSaleId(Integer carSaleId) {
        this.carSaleId = carSaleId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Date getBwStartDate() {
        return bwStartDate;
    }

    public void setBwStartDate(Date bwStartDate) {
        this.bwStartDate = bwStartDate;
    }

    public Date getBwEndDate() {
        return bwEndDate;
    }

    public void setBwEndDate(Date bwEndDate) {
        this.bwEndDate = bwEndDate;
    }

    public Integer getBwKmStart() {
        return bwKmStart;
    }

    public void setBwKmStart(Integer bwKmStart) {
        this.bwKmStart = bwKmStart;
    }

    public Integer getBwKmEnd() {
        return bwKmEnd;
    }

    public void setBwKmEnd(Integer bwKmEnd) {
        this.bwKmEnd = bwKmEnd;
    }

    public Date getExwStartDate() {
        return exwStartDate;
    }

    public void setExwStartDate(Date exwStartDate) {
        this.exwStartDate = exwStartDate;
    }

    public Date getExwEndDate() {
        return exwEndDate;
    }

    public void setExwEndDate(Date exwEndDate) {
        this.exwEndDate = exwEndDate;
    }

    public Integer getExwKmStart() {
        return exwKmStart;
    }

    public void setExwKmStart(Integer exwKmStart) {
        this.exwKmStart = exwKmStart;
    }

    public Integer getExwKmEnd() {
        return exwKmEnd;
    }

    public void setExwKmEnd(Integer exwKmEnd) {
        this.exwKmEnd = exwKmEnd;
    }

    public BigDecimal getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(BigDecimal pricePaid) {
        this.pricePaid = pricePaid;
    }

    public Boolean isPurchasedDuringBasic() {
        return purchasedDuringBasic;
    }

    public void setPurchasedDuringBasic(Boolean purchasedDuringBasic) {
        this.purchasedDuringBasic = purchasedDuringBasic;
    }

    public Date getExwPurchaseDate() {
        return exwPurchaseDate;
    }

    public void setExwPurchaseDate(Date exwPurchaseDate) {
        this.exwPurchaseDate = exwPurchaseDate;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
