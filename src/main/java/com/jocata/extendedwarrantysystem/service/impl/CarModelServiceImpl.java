package com.jocata.extendedwarrantysystem.service.impl;

import com.jocata.extendedwarrantysystem.dao.CarModelDao;
import com.jocata.extendedwarrantysystem.entity.CarModel;
import com.jocata.extendedwarrantysystem.entity.Customer;
import com.jocata.extendedwarrantysystem.enums.EngineType;
import com.jocata.extendedwarrantysystem.enums.FuelType;
import com.jocata.extendedwarrantysystem.enums.TransmissionType;
import com.jocata.extendedwarrantysystem.form.CarModelRequestForm;
import com.jocata.extendedwarrantysystem.form.CarModelResponseForm;
import com.jocata.extendedwarrantysystem.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

        responseForm.setModelId(String.valueOf(newEntity.getModelId()));
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

    @Override
    public CarModelResponseForm updateCarModel(CarModelRequestForm form) {
        CarModel entity = new CarModel();
        entity.setModelId(Integer.parseInt(form.getModelId()));
        entity.setMake(form.getMake());
        entity.setModelName(form.getModelName());
        entity.setYear(Integer.parseInt(form.getYear()));
        entity.setBasePrice(new BigDecimal(form.getBasePrice()));
        entity.setEngineType(EngineType.valueOf(form.getEngineType()));
        entity.setTransmission(TransmissionType.valueOf(form.getTransmission()));
        entity.setFuelType(FuelType.valueOf(form.getFuelType()));
        entity.setSeatingCapacity(Integer.parseInt(form.getSeatingCapacity()));
        entity.setWarrantyDurationMonths(Integer.parseInt(form.getWarrantyDurationMonths()));
        entity.setWarrantyKmLimit(Integer.parseInt(form.getWarrantyKmLimit()));

        CarModel newEntity = dao.updateCarModel(entity);

        CarModelResponseForm responseForm = new CarModelResponseForm();
        responseForm.setModelId(String.valueOf(newEntity.getModelId()));
        responseForm.setModelName(newEntity.getModelName());
        responseForm.setMake(newEntity.getMake());
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

    @Override
    public CarModelResponseForm getCarModelById(Integer modelId) {
        CarModel newEntity = dao.getCarModelById(modelId);
        CarModelResponseForm responseForm = new CarModelResponseForm();
        responseForm.setModelId(String.valueOf(newEntity.getModelId()));
        responseForm.setModelName(newEntity.getModelName());
        responseForm.setMake(newEntity.getMake());
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

    @Override
    public List<CarModelResponseForm> getAllCarModels() {
        List<CarModelResponseForm> responseForms = new ArrayList<>();
        List<CarModel> entitiesList = dao.getAllCarModels();
        for(CarModel newEntity: entitiesList){
            CarModelResponseForm responseForm = new CarModelResponseForm();
            responseForm.setModelId(String.valueOf(newEntity.getModelId()));
            responseForm.setModelName(newEntity.getModelName());
            responseForm.setMake(newEntity.getMake());
            responseForm.setYear(String.valueOf(newEntity.getYear()));
            responseForm.setBasePrice(String.valueOf(newEntity.getBasePrice()));
            responseForm.setEngineType(String.valueOf(newEntity.getEngineType()));
            responseForm.setTransmission(String.valueOf(newEntity.getTransmission()));
            responseForm.setFuelType(String.valueOf(newEntity.getFuelType()));
            responseForm.setSeatingCapacity(String.valueOf(newEntity.getSeatingCapacity()));
            responseForm.setWarrantyDurationMonths(String.valueOf(newEntity.getWarrantyDurationMonths()));
            responseForm.setWarrantyKmLimit(String.valueOf(newEntity.getWarrantyKmLimit()));
            responseForms.add(responseForm);
        }
        return responseForms;
    }

    @Override
    public String deleteCarModelById(Integer modelId) {
        return dao.deleteCarModelById(modelId);
    }
}
