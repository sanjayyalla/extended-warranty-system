package com.jocata.extendedwarrantysystem.service;

import com.jocata.extendedwarrantysystem.form.CarSaleRecordsRequestForm;
import com.jocata.extendedwarrantysystem.form.CarSaleRecordsResponseForm;

public interface CarSaleRecordsService {
    CarSaleRecordsResponseForm createCarSale(CarSaleRecordsRequestForm requestForm);

    CarSaleRecordsResponseForm getCarSaleRecordById(Integer carSaleRecordId);
}
