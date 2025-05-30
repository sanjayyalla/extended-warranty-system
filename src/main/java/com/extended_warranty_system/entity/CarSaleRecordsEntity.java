package com.extended_warranty_system.entity;

import java.sql.Date;

public class CarSaleRecordsEntity {
   private int carSaleId;
   private int customerId;
   private int modelId;
   private int carTypeId;
   private Date purchaseDate;

    public int getCarSaleId() {
        return carSaleId;
    }

    public void setCarSaleId(int carSaleId) {
        this.carSaleId = carSaleId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(int carTypeId) {
        this.carTypeId = carTypeId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
