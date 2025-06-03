package com.jocata.extendedwarrantysystem.service;

import com.jocata.extendedwarrantysystem.form.CarModelRequestForm;
import com.jocata.extendedwarrantysystem.form.CarModelResponseForm;

import java.util.List;

public interface CarModelService {
    CarModelResponseForm addCarModel(CarModelRequestForm form);

    CarModelResponseForm updateCarModel(CarModelRequestForm form);

    CarModelResponseForm getCarModelById(Integer modelId);

    List<CarModelResponseForm> getAllCarModels();

    String deleteCarModelById(Integer modelId);
}
