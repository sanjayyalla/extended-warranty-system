package com.jocata.extendedwarrantysystem.controller;

import com.jocata.extendedwarrantysystem.form.CustomerRequestForm;
import com.jocata.extendedwarrantysystem.form.CustomerResponseForm;
import com.jocata.extendedwarrantysystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping("/getAllCustomers")
    public List<CustomerResponseForm> getAllCustomers(){
        List<CustomerResponseForm> responseForms = null;
        try{
            responseForms = service.getAllCustomers();
            if(responseForms!=null){
                return responseForms;
            }
        } catch (Exception e) {
            return null;
        }
        return responseForms;
    }
    @PutMapping("/updateCustomer")
    public CustomerResponseForm updateCustomer(@RequestBody CustomerRequestForm form){
        CustomerResponseForm responseForm = null;
        try {
            System.out.println("I am in controller");
            responseForm = service.updateCustomer(form);
            if(responseForm!=null){
                return responseForm;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return responseForm;
    }

    @DeleteMapping("/deleteCustomer/{custId}")
    public String deleteCustomer(@PathVariable int custId){
        String str = null;
        try{
            str = service.deleteCustomer(custId);
            if(str!=null){
                return str;
            }
        } catch (Exception e) {
            return null;
        }
        return str;
    }
}
