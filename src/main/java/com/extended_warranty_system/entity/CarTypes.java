package com.extended_warranty_system.entity;

import com.extended_warranty_system.enums.CarTypeName;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cartypes")
public class CarTypes {
    private Integer carTypeId;
    private CarTypeName carTypeName;

    public Integer getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(Integer carTypeId) {
        this.carTypeId = carTypeId;
    }

    public CarTypeName getCarTypeName() {
        return carTypeName;
    }

    public void setCarTypeName(CarTypeName carTypeName) {
        this.carTypeName = carTypeName;
    }
}
