package com.jocata.extendedwarrantysystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "carwarranties")
public class CarWarranties {
    @Column(name = "car_warranty_id")
    private Integer carWarrantyId;
    @Column(name = "car_sale_id")
    private Integer carSaleId;
    @Column(name = "plan_id")
    private Integer planId;
    @Column(name = "bw_start_date")
    private Date bwStartDate;
    @Column(name = "bw_end_date")
    private Date bwEndDate;
    @Column(name = "bw_km_start")
    private Integer bwKmStart;
    @Column(name = "bw_km_end")
    private Integer bwKmEnd;
    @Column(name = "exw_start_date")
    private Date exwStartDate;
    @Column(name = "exw_end_date")
    private Date exwEndDate;
    @Column(name = "exw_km_start")
    private Integer exwKmStart;
    @Column(name = "exw_km_end")
    private Integer exwKmEnd;
    @Column(name = "price_paid")
    private BigDecimal pricePaid;
    @Column(name = "purchased_during_basic")
    private Boolean purchasedDuringBasic;
    @Column(name = "exw_purchase_date")
    private Date exwPurchaseDate;
    @Column(name = "is_active")
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
