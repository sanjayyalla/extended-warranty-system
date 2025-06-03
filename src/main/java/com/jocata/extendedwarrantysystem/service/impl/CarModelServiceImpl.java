package com.jocata.extendedwarrantysystem.service.impl;

import com.jocata.extendedwarrantysystem.dao.CarModelDao;
import com.jocata.extendedwarrantysystem.entity.CarModel;
import com.jocata.extendedwarrantysystem.enums.EngineType;
import com.jocata.extendedwarrantysystem.enums.FuelType;
import com.jocata.extendedwarrantysystem.enums.TransmissionType;
import com.jocata.extendedwarrantysystem.form.CarModelRequestForm;
import com.jocata.extendedwarrantysystem.form.CarModelResponseForm;
import com.jocata.extendedwarrantysystem.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CarModelServiceImpl implements CarModelService {
    @Autowired
    private CarModelDao dao;

    @Override
    public CarModelResponseForm addCarModel(CarModelRequestForm form) {
        CarModel carModel = new CarModel();
        carModel.setMake(form.getMake());
        carModel.setModelName(form.getModelName());
        carModel.setYear(Integer.valueOf(form.getYear()));
        carModel.setBasePrice(new BigDecimal(form.getBasePrice()));
        carModel.setEngineType(EngineType.valueOf(form.getEngineType()));
        carModel.setTransmission(TransmissionType.valueOf(form.getTransmission()));
        carModel.setFuelType(FuelType.valueOf(form.getFuelType()));
        carModel.setSeatingCapacity(Integer.valueOf(form.getSeatingCapacity()));
        carModel.setWarrantyDurationMonths(Integer.valueOf(form.getWarrantyDurationMonths()));
        carModel.setWarrantyKmLimit(Integer.valueOf(form.getWarrantyKmLimit()));
        CarModel newEntity = dao.addCarModel(carModel);
        CarModelResponseForm responseForm = new CarModelResponseForm();

        responseForm.setMake(newEntity.getMake());
        responseForm.setModelName(newEntity.getModelName());
        responseForm.setYear(String.valueOf(newEntity.getYear()));
        responseForm.setBasePrice(String.valueOf(newEntity.getBasePrice()));
        responseForm.setEngineType(String.valueOf(newEntity.getEngineType()));
        responseForm.setTransmission(String.valueOf(newEntity.getTransmission()));
        responseForm.setFuelType(String.valueOf(newEntity.getFuelType()));
        responseForm.setSeatingCapacity(String.valueOf(newEntity.getSeatingCapacity()));
        responseForm.setWarrantyDurationMonths(String.valueOf(newEntity.getWarrantyDurationMonths()));
        responseForm.setWarrantyKmLimit(String.valueOf(newEntity.getWarrantyKmLimit()));
        return responseForm;
    }
}
