package com.jocata.extendedwarrantysystem.service.impl;

import com.jocata.extendedwarrantysystem.dao.CarModelDao;
import com.jocata.extendedwarrantysystem.dao.CarSaleRecordsDao;
import com.jocata.extendedwarrantysystem.dao.CarTypesDao;
import com.jocata.extendedwarrantysystem.dao.CustomerDao;
import com.jocata.extendedwarrantysystem.entity.CarModel;
import com.jocata.extendedwarrantysystem.entity.CarSaleRecords;
import com.jocata.extendedwarrantysystem.form.CarSaleRecordsRequestForm;
import com.jocata.extendedwarrantysystem.form.CarSaleRecordsResponseForm;
import com.jocata.extendedwarrantysystem.service.CarSaleRecordsService;
import com.jocata.extendedwarrantysystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class CarSaleRecordsServiceImpl implements CarSaleRecordsService {

    @Autowired
    private CarSaleRecordsDao carSaleRecordsDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private CarTypesDao carTypesDao;
    @Autowired
    private CarModelDao carModelDao;

    @Override
    public CarSaleRecordsResponseForm createCarSale(CarSaleRecordsRequestForm requestForm) {
        CarSaleRecords entity = new CarSaleRecords();
        entity.setCustomerId(customerDao.getCustomerById(requestForm.getCustomerId()));
        if (entity.getCustomerId() == null) {
            CarSaleRecordsResponseForm responseForm = new CarSaleRecordsResponseForm();
            responseForm.setMessage("Customer not found with the provided ID");
            return responseForm;
        }
        entity.setModelId(carModelDao.getCarModelById(requestForm.getModelId()));
        entity.setCarTypeId(carTypesDao.getCarType(requestForm.getCarTypeId()));
        entity.setPurchaseDate(Date.valueOf(LocalDate.now()));
        CarSaleRecords newEntity = carSaleRecordsDao.createCarSale(entity);
        CarSaleRecordsResponseForm responseForm = new CarSaleRecordsResponseForm();
        responseForm.setCarSaleId(newEntity.getCarSaleId());
        responseForm.setCustomerName(newEntity.getCustomerId().getName());
        responseForm.setModelName(newEntity.getModelId().getModelName());
        responseForm.setCarTypeName(newEntity.getCarTypeId().getCarTypeName().name());
        responseForm.setPurchaseDate(newEntity.getPurchaseDate());
        responseForm.setMessage("Success");
        return responseForm;
    }

    @Override
    public CarSaleRecordsResponseForm getCarSaleRecordById(Integer carSaleRecordId) {
        CarSaleRecords entity = carSaleRecordsDao.getCarSaleRecordById(carSaleRecordId);
        CarSaleRecordsResponseForm responseForm = new CarSaleRecordsResponseForm();
        if(entity!=null){
            responseForm.setCarSaleId(entity.getCarSaleId());
            responseForm.setCustomerName(entity.getCustomerId().getName());
            responseForm.setModelName(entity.getModelId().getModelName());
            responseForm.setCarTypeName(entity.getCarTypeId().getCarTypeName().name());
            responseForm.setPurchaseDate(entity.getPurchaseDate());
            responseForm.setMessage("Success");
            return responseForm;
        }
        responseForm.setMessage("No data found");
        return responseForm;
    }
}
