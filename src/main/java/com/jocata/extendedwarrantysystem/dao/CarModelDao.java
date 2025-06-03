package com.jocata.extendedwarrantysystem.dao;

import com.jocata.extendedwarrantysystem.entity.CarModel;
import com.jocata.extendedwarrantysystem.form.CarModelResponseForm;

import java.util.List;

public interface CarModelDao {
    CarModel addCarModel(CarModel model);

    CarModel updateCarModel(CarModel entity);

    CarModel getCarModelById(Integer modelId);

    List<CarModel> getAllCarModels();

    String deleteCarModelById(Integer modelId);
}
