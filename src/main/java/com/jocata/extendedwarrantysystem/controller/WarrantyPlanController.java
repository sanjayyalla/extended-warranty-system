package com.jocata.extendedwarrantysystem.controller;

import com.jocata.extendedwarrantysystem.form.WarrantyPlanRequestForm;
import com.jocata.extendedwarrantysystem.form.WarrantyPlanResponseForm;
import com.jocata.extendedwarrantysystem.service.WarrantyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warrantyplans")
public class WarrantyPlanController {

    @Autowired
    private WarrantyPlanService service;

    @PostMapping("/addWarrantyPlan")
    public WarrantyPlanResponseForm addWarrantyPlan(@RequestBody WarrantyPlanRequestForm requestForm) {
        WarrantyPlanResponseForm responseForm = null;
        try {
            responseForm = service.addWarrantyPlan(requestForm);
            if (responseForm != null) {
                return responseForm;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/updateWarrantyPlan")
    public WarrantyPlanResponseForm updateWarrantyPlan(@RequestBody WarrantyPlanRequestForm requestForm) {
        WarrantyPlanResponseForm responseForm = null;
        try {
            responseForm = service.updateWarrantyPlan(requestForm);
            if (responseForm != null) {
                return responseForm;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getWarrantyPlanById/{warrantyPlanId}")
    public WarrantyPlanResponseForm getWarrantyPlanById(@PathVariable Integer warrantyPlanId) {
        WarrantyPlanResponseForm responseForm = null;
        try {
            responseForm = service.getWarrantyPlanById(warrantyPlanId);
            if (responseForm != null) {
                return responseForm;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getAllWarrantyPlans")
    public List<WarrantyPlanResponseForm> getAllWarrantyPlans(){
        List<WarrantyPlanResponseForm> warrantyPlanResponseFormList = null;
        try{
            warrantyPlanResponseFormList = service.getAllWarrantyPlans();
            if(!warrantyPlanResponseFormList.isEmpty()){
                return warrantyPlanResponseFormList;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/deleteWarrantyPlanById/{warrantyPlanId}")
    public String deleteWarrantyPlanById(@PathVariable Integer warrantyPlanId){
        String response = null;
        try{
            response = service.deleteWarrantyPlanById(warrantyPlanId);
            if(response!=null && !response.isEmpty()){
                return response;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
