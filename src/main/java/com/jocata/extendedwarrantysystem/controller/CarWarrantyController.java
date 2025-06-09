package com.jocata.extendedwarrantysystem.controller;

import com.jocata.extendedwarrantysystem.form.CarWarrantyRequestForm;
import com.jocata.extendedwarrantysystem.form.CarWarrantyResponseForm;
import com.jocata.extendedwarrantysystem.service.CarWarrantyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carWarranty")
public class CarWarrantyController {

    private CarWarrantyService service;

    @PostMapping("/createCarWarranty")
    public CarWarrantyResponseForm createCarWarranty(@RequestBody CarWarrantyRequestForm requestForm) {
        CarWarrantyResponseForm responseForm = null;
        try {
            if (requestForm.getCarSaleId() != null && !requestForm.getCarSaleId().isEmpty() &&
                    requestForm.getPlanId() != null && !requestForm.getPlanId().isEmpty()) {
                responseForm = service.createCarWarranty(requestForm);
                return responseForm;
            }
            return null;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
