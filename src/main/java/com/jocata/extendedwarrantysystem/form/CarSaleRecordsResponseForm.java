package com.jocata.extendedwarrantysystem.form;

import java.sql.Date;

public class CarSaleRecordsResponseForm {
    private Integer carSaleId;
    private String customerName;
    private String modelName;
    private String carTypeName;
    private Date purchaseDate;
    private String message;
    public Integer getCarSaleId() {
        return carSaleId;
    }

    public void setCarSaleId(Integer carSaleId) {
        this.carSaleId = carSaleId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCarTypeName() {
        return carTypeName;
    }

    public void setCarTypeName(String carTypeName) {
        this.carTypeName = carTypeName;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
