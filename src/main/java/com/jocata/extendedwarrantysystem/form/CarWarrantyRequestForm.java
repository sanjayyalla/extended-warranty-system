package com.jocata.extendedwarrantysystem.form;

public class CarWarrantyRequestForm {
    private String carWarrantyId;
    private String carSaleId;
    private String planId;
    private String exwKm;

    public String getExwKm() {
        return exwKm;
    }

    public void setExwKm(String exwKm) {
        this.exwKm = exwKm;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getCarSaleId() {
        return carSaleId;
    }

    public void setCarSaleId(String carSaleId) {
        this.carSaleId = carSaleId;
    }

    public String getCarWarrantyId() {
        return carWarrantyId;
    }

    public void setCarWarrantyId(String carWarrantyId) {
        this.carWarrantyId = carWarrantyId;
    }
}
