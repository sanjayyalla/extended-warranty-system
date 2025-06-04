package com.jocata.extendedwarrantysystem.service.impl;

import com.jocata.extendedwarrantysystem.dao.CarTypesDao;
import com.jocata.extendedwarrantysystem.entity.CarTypes;
import com.jocata.extendedwarrantysystem.enums.CarTypeName;
import com.jocata.extendedwarrantysystem.form.CarModelRequestForm;
import com.jocata.extendedwarrantysystem.form.CarModelResponseForm;
import com.jocata.extendedwarrantysystem.form.CarTypeRequestForm;
import com.jocata.extendedwarrantysystem.form.CarTypeResponseForm;
import com.jocata.extendedwarrantysystem.service.CarTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarTypesServiceImpl implements CarTypesService {
    @Autowired
    private CarTypesDao dao;

    @Override
    public CarTypeResponseForm addCarType(CarTypeRequestForm requestForm) {
        CarTypes entity = new CarTypes();

        entity.setCarTypeName(CarTypeName.valueOf(requestForm.getCarTypeName()));
        System.out.println("I am in service");

        CarTypes newEntity = dao.addCarType(entity);
        CarTypeResponseForm responseForm = new CarTypeResponseForm();
        responseForm.setCarTypeId(String.valueOf(newEntity.getCarTypeId()));
        responseForm.setCarTypeName(String.valueOf(newEntity.getCarTypeName()));
        return responseForm;
    }

    @Override
    public CarTypeResponseForm getCarType(Integer carTypeId) {
        CarTypes entity = dao.getCarType(carTypeId);
        CarTypeResponseForm responseForm = new CarTypeResponseForm();
        responseForm.setCarTypeId(String.valueOf(entity.getCarTypeId()));
        responseForm.setCarTypeName(String.valueOf(entity.getCarTypeName()));
        return responseForm;
    }

    @Override
    public CarTypeResponseForm updateCarType(CarTypeRequestForm requestForm) {
        CarTypes entity = new CarTypes();
        entity.setCarTypeId(Integer.valueOf(requestForm.getCarTypeId()));
        entity.setCarTypeName(CarTypeName.valueOf(requestForm.getCarTypeName()));
        System.out.println("I am in service");
        CarTypes newEntity = dao.updateCarType(entity);
        CarTypeResponseForm responseForm = new CarTypeResponseForm();
        responseForm.setCarTypeId(String.valueOf(newEntity.getCarTypeId()));
        responseForm.setCarTypeName(String.valueOf(newEntity.getCarTypeName()));
        return responseForm;

    }

    @Override
    public String deleteCarType(Integer carTypeId) {
        if (carTypeId != null) {
            return dao.deleteCarType(carTypeId);
        }
        return null;
    }
}
