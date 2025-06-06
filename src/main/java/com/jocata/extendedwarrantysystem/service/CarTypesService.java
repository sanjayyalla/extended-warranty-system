package com.jocata.extendedwarrantysystem.service;

import com.jocata.extendedwarrantysystem.entity.CarTypes;
import com.jocata.extendedwarrantysystem.form.CarTypeRequestForm;
import com.jocata.extendedwarrantysystem.form.CarTypeResponseForm;

import java.util.List;

public interface CarTypesService {
    CarTypeResponseForm addCarType(CarTypeRequestForm requestForm);

    CarTypeResponseForm getCarType(Integer carTypeId);

    CarTypeResponseForm updateCarType(CarTypeRequestForm requestForm);

    String deleteCarType(Integer carTypeId);

    List<CarTypeResponseForm> getAllCarTypes();
}
