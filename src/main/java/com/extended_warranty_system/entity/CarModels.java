package com.extended_warranty_system.entity;

import com.extended_warranty_system.enums.EngineType;
import com.extended_warranty_system.enums.FuelType;
import com.extended_warranty_system.enums.TransmissionType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "carmodels")
public class CarModels {
    private Integer modelId;
    private String make;
    private String modelName;
    private Integer year;
    private BigDecimal basePrice;
    private EngineType engineType;
    private TransmissionType transmission;
    private FuelType fuelType;
    private Integer seatingCapacity;
    private Integer warrantyDurationMonths;
    private Integer warrantyKmLimit;
    private Timestamp createdAt;

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public Integer getWarrantyDurationMonths() {
        return warrantyDurationMonths;
    }

    public void setWarrantyDurationMonths(Integer warrantyDurationMonths) {
        this.warrantyDurationMonths = warrantyDurationMonths;
    }

    public Integer getWarrantyKmLimit() {
        return warrantyKmLimit;
    }

    public void setWarrantyKmLimit(Integer warrantyKmLimit) {
        this.warrantyKmLimit = warrantyKmLimit;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
