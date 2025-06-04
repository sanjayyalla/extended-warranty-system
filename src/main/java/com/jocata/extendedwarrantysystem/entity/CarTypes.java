package com.jocata.extendedwarrantysystem.entity;

import com.jocata.extendedwarrantysystem.enums.CarTypeName;
import jakarta.persistence.*;

@Entity
@Table(name = "cartypes")
public class CarTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_type_id")
    private Integer carTypeId;
    @Column(name = "car_type_name")
    @Enumerated(EnumType.STRING)
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
