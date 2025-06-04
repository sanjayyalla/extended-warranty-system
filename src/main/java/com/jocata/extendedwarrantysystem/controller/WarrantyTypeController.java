package com.jocata.extendedwarrantysystem.controller;

import com.jocata.extendedwarrantysystem.form.WarrantyTypeRequestForm;
import com.jocata.extendedwarrantysystem.form.WarrantyTypeResponseForm;
import com.jocata.extendedwarrantysystem.service.WarrantyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/warrantytype")
public class WarrantyTypeController {

    @Autowired
    private WarrantyTypeService service;

    @PostMapping("/addWarrantyType")
    public WarrantyTypeResponseForm addWarrantyType(@RequestBody WarrantyTypeRequestForm requestForm){
        WarrantyTypeResponseForm responseForm = null;
        try{
            responseForm = service.addWarrantyType(requestForm);
            if(responseForm!=null){
                return responseForm;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/getWarrantyType/{warrantyTypeID}")
    public WarrantyTypeResponseForm getWarrantyType(@PathVariable Integer warrantyTypeID){
        WarrantyTypeResponseForm responseForm = null;
        try{
            responseForm = service.getWarrantyType(warrantyTypeID);
            if(responseForm!=null){
                return responseForm;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/getAllWarrantyTypes")
    public List<WarrantyTypeResponseForm> getAllWarrantyTypes(){
        List<WarrantyTypeResponseForm> responseFormsList = null;
        try{
            responseFormsList = service.getAllWarrantyTypes();
            if(!responseFormsList.isEmpty()){
                return responseFormsList;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>();

    }
    @PutMapping("/updateWarrantyType")
    public WarrantyTypeResponseForm updateWarrantyType(@RequestBody WarrantyTypeRequestForm requestForm){
        WarrantyTypeResponseForm responseForm = null;
        try{
            responseForm = service.updateWarrantyType(requestForm);
            if(responseForm!=null){
                return responseForm;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @DeleteMapping("/deleteWarrantyType/{warrantyTypeId}")
    public String deleteWarrantyType(@PathVariable Integer warrantyTypeId){
        String res = null;
        try{
            res = service.deleteWarrantyType(warrantyTypeId);
            if(res!=null && !res.isEmpty()){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
