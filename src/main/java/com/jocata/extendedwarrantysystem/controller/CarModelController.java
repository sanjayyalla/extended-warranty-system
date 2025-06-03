package com.jocata.extendedwarrantysystem.controller;

import com.jocata.extendedwarrantysystem.form.CarModelRequestForm;
import com.jocata.extendedwarrantysystem.form.CarModelResponseForm;
import com.jocata.extendedwarrantysystem.form.CustomerRequestForm;
import com.jocata.extendedwarrantysystem.form.CustomerResponseForm;
import com.jocata.extendedwarrantysystem.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carmodel")
public class CarModelController {

    @Autowired
    private CarModelService service;

    @PostMapping("/addCarModel")
    public CarModelResponseForm addCarModel(@RequestBody CarModelRequestForm requestForm) {
        CarModelResponseForm responseForm = null;
        try {
            responseForm = service.addCarModel(requestForm);
            if (responseForm != null) {
                return responseForm;
            }
        } catch (Exception e) {
            return null;
        }
        return responseForm;
    }

    @PutMapping("/updateCarModel")
    public CarModelResponseForm updateCustomer(@RequestBody CarModelRequestForm form) {
        CarModelResponseForm responseForm = null;
        try {
            System.out.println("I am in controller");
            responseForm = service.updateCarModel(form);
            if (responseForm != null) {
                return responseForm;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return responseForm;
    }

    @GetMapping("/getCarModelById/{modelId}")
    public CarModelResponseForm getCarModelById(@PathVariable Integer modelId) {
        CarModelResponseForm responseForm = null;
        try {
            System.out.println("I am in controller");
            responseForm = service.getCarModelById(modelId);
            if (responseForm != null) {
                return responseForm;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return responseForm;
    }

    @GetMapping("/getAllCarModels")
    public List<CarModelResponseForm> getAllCarModels() {
        List<CarModelResponseForm> responseForms = null;

        try {
            System.out.println("I am in controller");
            responseForms = service.getAllCarModels();
            if (responseForms != null) {
                return responseForms;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return responseForms;
    }

    @DeleteMapping("/deleteCarModel/{modelId}")
    public String deleteCarModelById(@PathVariable Integer modelId){
        String response = null;

        try {
            response = service.deleteCarModelById(modelId);
            if (response != null) {
                return response;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return response;
    }
}
