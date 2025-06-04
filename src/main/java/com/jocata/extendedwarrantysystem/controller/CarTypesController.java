package com.jocata.extendedwarrantysystem.controller;

import com.jocata.extendedwarrantysystem.entity.CarTypes;
import com.jocata.extendedwarrantysystem.form.CarTypeRequestForm;
import com.jocata.extendedwarrantysystem.form.CarTypeResponseForm;
import com.jocata.extendedwarrantysystem.service.CarTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cartypes")
public class CarTypesController {

    @Autowired
    private CarTypesService service;

    @PostMapping("/addCarType")
    public CarTypeResponseForm addCarType(@RequestBody CarTypeRequestForm requestForm) {
        CarTypeResponseForm responseForm = null;
        try {
            System.out.println("I am in controller");
            responseForm = service.addCarType(requestForm);

        } catch (Exception e) {
            return null;
        }
        return responseForm;
    }

    @GetMapping("/getCarType/{carTypeId}")
    public CarTypeResponseForm getCarType(@PathVariable Integer carTypeId){
        CarTypeResponseForm responseForm = null;
        try {
            responseForm = service.getCarType(carTypeId);

        } catch (Exception e) {
            return null;
        }
        return responseForm;
    }

    @PutMapping("/updateCarType")
    public CarTypeResponseForm updateCarType(@RequestBody CarTypeRequestForm requestForm){
        CarTypeResponseForm responseForm = null;
        try{
            System.out.println("I am in controller");
            responseForm = service.updateCarType(requestForm);

        } catch (Exception e) {
            return null;
        }
        return responseForm;
    }

    @DeleteMapping("/deleteCarType/{carTypeId}")
    public String deleteCarType(@PathVariable Integer carTypeId){
        String res = null;
        try {
            res = service.deleteCarType(carTypeId);
        } catch (Exception e) {
            return res;
        }
        return res;
    }

}
