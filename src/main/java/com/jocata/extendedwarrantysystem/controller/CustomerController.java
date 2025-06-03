package com.jocata.extendedwarrantysystem.controller;

import com.jocata.extendedwarrantysystem.form.CustomerRequestForm;
import com.jocata.extendedwarrantysystem.form.CustomerResponseForm;
import com.jocata.extendedwarrantysystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/createCustomer")
    public CustomerResponseForm createCustomer(@RequestBody CustomerRequestForm form) {
        CustomerResponseForm responseForm = null;
//        System.out.println("inside it");
        try {
            responseForm = service.createCustomer(form);
            if (responseForm != null) {
                return responseForm;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return responseForm;
    }

    @GetMapping("/getCustomerbyId/{custId}")
    public CustomerResponseForm getCustomer(@PathVariable Integer custId){
        CustomerResponseForm responseForm = null;
        try {
            responseForm = service.getCustomerById(custId);
            if(responseForm!=null){
                return responseForm;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return responseForm;
    }
}
