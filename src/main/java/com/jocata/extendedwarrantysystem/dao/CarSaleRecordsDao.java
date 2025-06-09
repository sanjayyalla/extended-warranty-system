package com.jocata.extendedwarrantysystem.dao;

import com.jocata.extendedwarrantysystem.entity.CarSaleRecords;

public interface CarSaleRecordsDao {
    CarSaleRecords createCarSale(CarSaleRecords entity);

    CarSaleRecords getCarSaleRecordById(Integer carSaleRecordId);
}
