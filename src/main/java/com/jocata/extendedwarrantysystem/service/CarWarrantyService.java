package com.jocata.extendedwarrantysystem.service;

import com.jocata.extendedwarrantysystem.form.CarWarrantyRequestForm;
import com.jocata.extendedwarrantysystem.form.CarWarrantyResponseForm;

public interface CarWarrantyService {
    CarWarrantyResponseForm createCarWarranty(CarWarrantyRequestForm requestForm);
}
