package com.jocata.extendedwarrantysystem.service;

import com.jocata.extendedwarrantysystem.form.CarModelRequestForm;
import com.jocata.extendedwarrantysystem.form.CarModelResponseForm;

public interface CarModelService {
    CarModelResponseForm addCarModel(CarModelRequestForm form);
}
