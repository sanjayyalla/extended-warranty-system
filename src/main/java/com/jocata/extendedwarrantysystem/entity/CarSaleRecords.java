package com.jocata.extendedwarrantysystem.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "carsalerecords")
public class CarSaleRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_sale_id")
    private Integer carSaleId;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customerId;
    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "model_id")
    private CarModel modelId;

    @ManyToOne
    @JoinColumn(name = "car_type_id", referencedColumnName = "car_type_id")
    private CarTypes carTypeId;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    public Integer getCarSaleId() {
        return carSaleId;
    }

    public void setCarSaleId(Integer carSaleId) {
        this.carSaleId = carSaleId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public CarModel getModelId() {
        return modelId;
    }

    public void setModelId(CarModel modelId) {
        this.modelId = modelId;
    }

    public CarTypes getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(CarTypes carTypeId) {
        this.carTypeId = carTypeId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
