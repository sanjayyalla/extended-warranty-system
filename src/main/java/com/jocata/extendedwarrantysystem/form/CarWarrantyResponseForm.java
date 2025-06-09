package com.jocata.extendedwarrantysystem.form;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.sql.Date;

public class CarWarrantyResponseForm {
    private String carWarrantyId;
    private String carSaleId;
    private String customerName;
    private String planId;
    private String bwStartDate;
    private String bwEndDate;
    private String bwKmStart;
    private String bwKmEnd;
    private String exwStartDate;
    private String exwEndDate;
    private String exwKmStart;
    private String exwKmEnd;
    private String pricePaid;
    private String purchasedDuringBasic;
    private String exwPurchaseDate;
    private String isActive;

    public String getCarWarrantyId() {
        return carWarrantyId;
    }

    public void setCarWarrantyId(String carWarrantyId) {
        this.carWarrantyId = carWarrantyId;
    }

    public String getCarSaleId() {
        return carSaleId;
    }

    public void setCarSaleId(String carSaleId) {
        this.carSaleId = carSaleId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getBwStartDate() {
        return bwStartDate;
    }

    public void setBwStartDate(String bwStartDate) {
        this.bwStartDate = bwStartDate;
    }

    public String getBwEndDate() {
        return bwEndDate;
    }

    public void setBwEndDate(String bwEndDate) {
        this.bwEndDate = bwEndDate;
    }

    public String getBwKmStart() {
        return bwKmStart;
    }

    public void setBwKmStart(String bwKmStart) {
        this.bwKmStart = bwKmStart;
    }

    public String getBwKmEnd() {
        return bwKmEnd;
    }

    public void setBwKmEnd(String bwKmEnd) {
        this.bwKmEnd = bwKmEnd;
    }

    public String getExwStartDate() {
        return exwStartDate;
    }

    public void setExwStartDate(String exwStartDate) {
        this.exwStartDate = exwStartDate;
    }

    public String getExwEndDate() {
        return exwEndDate;
    }

    public void setExwEndDate(String exwEndDate) {
        this.exwEndDate = exwEndDate;
    }

    public String getExwKmStart() {
        return exwKmStart;
    }

    public void setExwKmStart(String exwKmStart) {
        this.exwKmStart = exwKmStart;
    }

    public String getExwKmEnd() {
        return exwKmEnd;
    }

    public void setExwKmEnd(String exwKmEnd) {
        this.exwKmEnd = exwKmEnd;
    }

    public String getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(String pricePaid) {
        this.pricePaid = pricePaid;
    }

    public String getPurchasedDuringBasic() {
        return purchasedDuringBasic;
    }

    public void setPurchasedDuringBasic(String purchasedDuringBasic) {
        this.purchasedDuringBasic = purchasedDuringBasic;
    }

    public String getExwPurchaseDate() {
        return exwPurchaseDate;
    }

    public void setExwPurchaseDate(String exwPurchaseDate) {
        this.exwPurchaseDate = exwPurchaseDate;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
}
