package com.jocata.extendedwarrantysystem.controller;
import com.jocata.extendedwarrantysystem.form.CarModelRequestForm;
import com.jocata.extendedwarrantysystem.form.CarModelResponseForm;
import com.jocata.extendedwarrantysystem.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carmodel")
public class CarModelController {

    @Autowired
    private CarModelService service;
    @PostMapping("/addCarModel")
    public CarModelResponseForm addCarModel(@RequestBody CarModelRequestForm requestForm){
        CarModelResponseForm responseForm=null;
        try{
            responseForm = service.addCarModel(requestForm);
            if (responseForm != null) {
                return responseForm;
            }
        } catch (Exception e) {
            return null;
        }
        return responseForm;
    }
}
