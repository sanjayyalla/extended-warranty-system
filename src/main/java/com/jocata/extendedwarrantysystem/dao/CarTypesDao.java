package com.jocata.extendedwarrantysystem.dao;

import com.jocata.extendedwarrantysystem.entity.CarTypes;

public interface CarTypesDao {
    CarTypes addCarType(CarTypes entity);

    CarTypes getCarType(Integer carTypeId);

    CarTypes updateCarType(CarTypes entity);

    String deleteCarType(Integer carTypeId);
}
