package com.jocata.extendedwarrantysystem.entity;

import com.jocata.extendedwarrantysystem.enums.EngineType;
import com.jocata.extendedwarrantysystem.enums.FuelType;
import com.jocata.extendedwarrantysystem.enums.TransmissionType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "carmodels")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Integer modelId;
    @Column(name = "make")
    private String make;
    @Column(name = "model_name")
    private String modelName;
    @Column(name = "year")
    private Integer year;
    @Column(name = "base_price")
    private BigDecimal basePrice;
    @Column(name = "engine_type")
    @Enumerated(EnumType.STRING)
    private EngineType engineType;
    @Column(name = "transmission")
    @Enumerated(EnumType.STRING)
    private TransmissionType transmission;
    @Column(name = "fuel_type")
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    @Column(name = "seating_capacity")
    private Integer seatingCapacity;
    @Column(name = "warranty_duration_months")
    private Integer warrantyDurationMonths;
    @Column(name = "warranty_km_limit")
    private Integer warrantyKmLimit;
    @Column(name = "created_at")
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
