package com.jocata.extendedwarrantysystem.controller;

import com.jocata.extendedwarrantysystem.form.CoverageTypeRequestForm;
import com.jocata.extendedwarrantysystem.form.CoverageTypeResponseForm;
import com.jocata.extendedwarrantysystem.service.CoverageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coveragetype")
public class CoverageTypeController {

    @Autowired
    private CoverageTypeService service;
    @PostMapping("/addCoverageType")
    public CoverageTypeResponseForm addCoverageType(@RequestBody CoverageTypeRequestForm requestForm) {
        CoverageTypeResponseForm responseForm = null;
        try {
            responseForm = service.addCoverageType(requestForm);
            if(responseForm!=null){
                return responseForm;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/getCoverageType/{coverageTypeId}")
    public CoverageTypeResponseForm getCoverageType(@PathVariable Integer coverageTypeId){
        CoverageTypeResponseForm responseForm = null;
        try{
            responseForm = service.getCoverageType(coverageTypeId);
            if(responseForm!=null){
                return responseForm;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/getAllCoverageTypes")
    public List<CoverageTypeResponseForm> getAllCoverageTypes(){
        List<CoverageTypeResponseForm> responseForms = null;
        try{
            responseForms = service.getAllCoverageTypes();
            if(!responseForms.isEmpty()){
                return responseForms;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @PutMapping("/updateCoverageType")
    public CoverageTypeResponseForm updateCoverageType(@RequestBody CoverageTypeRequestForm requestForm){
        CoverageTypeResponseForm responseForm = null;
        try{
            System.out.println("I am here ");
            responseForm = service.updateCoverageType(requestForm);
            if(responseForm!=null){
                return responseForm;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @DeleteMapping("/deleteCoverageType/{coverageTypeId}")
    public String deleteCoverageType(@PathVariable Integer coverageTypeId){
        String res = null;
        try{
            res = service.deleteCoverageType(coverageTypeId);
            if(res!=null&&!res.isEmpty()){
                return res;
            }
            return "Error";
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }
        return "Error";
    }
}
