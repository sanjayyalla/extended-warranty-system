package com.jocata.extendedwarrantysystem.controller;

import com.jocata.extendedwarrantysystem.form.CarSaleRecordsRequestForm;
import com.jocata.extendedwarrantysystem.form.CarSaleRecordsResponseForm;
import com.jocata.extendedwarrantysystem.service.CarSaleRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carSaleRecords")
public class CarSaleRecordsController {

    @Autowired
    private CarSaleRecordsService service;

    @PostMapping("/createCarSale")
    public CarSaleRecordsResponseForm createCarSale(@RequestBody CarSaleRecordsRequestForm requestForm) {
        CarSaleRecordsResponseForm responseForm = new CarSaleRecordsResponseForm();
        try {
            if (requestForm.getCustomerId() != null && requestForm.getCarTypeId() != null && requestForm.getModelId() != null) {
                responseForm = service.createCarSale(requestForm);
                return responseForm;
            } else {
                responseForm.setMessage("Fill the fields correctly");
                return responseForm;
            }
        } catch (Exception e) {
            responseForm.setMessage(e.getMessage());
            return responseForm;
        }
    }

    @GetMapping("/getCarSaleRecordById/{carSaleRecordId}")
    public CarSaleRecordsResponseForm getCarSaleRecordById(@PathVariable Integer carSaleRecordId) {
        CarSaleRecordsResponseForm responseForm = null;
        try {
            if (carSaleRecordId != null && carSaleRecordId != 0) {
                responseForm = service.getCarSaleRecordById(carSaleRecordId);
                if (responseForm != null) {
                    return responseForm;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
