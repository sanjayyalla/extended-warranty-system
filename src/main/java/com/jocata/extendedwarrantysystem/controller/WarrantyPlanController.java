package com.jocata.extendedwarrantysystem.controller;

import com.jocata.extendedwarrantysystem.form.WarrantyPlanRequestForm;
import com.jocata.extendedwarrantysystem.form.WarrantyPlanResponseForm;
import com.jocata.extendedwarrantysystem.service.WarrantyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/warrantyplans")
public class WarrantyPlanController {

    @Autowired
    private WarrantyPlanService service;

    @PostMapping("/addWarrantyPlan")
    public WarrantyPlanResponseForm addWarrantyPlan(@RequestBody WarrantyPlanRequestForm requestForm){
        WarrantyPlanResponseForm responseForm = null;
        try{
            responseForm = service.addWarrantyPlan(requestForm);
            if(responseForm!=null){
                return responseForm;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
