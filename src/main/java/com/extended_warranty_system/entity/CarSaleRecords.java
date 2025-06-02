package com.extended_warranty_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "carsalerecords")
public class CarSaleRecords {
   private Integer carSaleId;
   private Integer customerId;
   private Integer modelId;
   private Integer carTypeId;
   private Date purchaseDate;

    public Integer getCarSaleId() {
        return carSaleId;
    }

    public void setCarSaleId(Integer carSaleId) {
        this.carSaleId = carSaleId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(Integer carTypeId) {
        this.carTypeId = carTypeId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
