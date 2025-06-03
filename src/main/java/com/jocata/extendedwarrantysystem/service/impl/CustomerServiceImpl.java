package com.jocata.extendedwarrantysystem.service.impl;

import com.jocata.extendedwarrantysystem.dao.CustomerDao;
import com.jocata.extendedwarrantysystem.entity.Customer;
import com.jocata.extendedwarrantysystem.form.CustomerRequestForm;
import com.jocata.extendedwarrantysystem.form.CustomerResponseForm;
import com.jocata.extendedwarrantysystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao dao;

    @Override
    public CustomerResponseForm createCustomer(CustomerRequestForm form) {
        Customer customer = new Customer();
        customer.setName(form.getName());
        customer.setEmail(form.getEmail());
        customer.setPhone(form.getPhone());
        customer.setAddress(form.getAddress());
        Customer res = dao.createCustomer(customer);
        CustomerResponseForm responseForm = new CustomerResponseForm();
        responseForm.setCustomerId(res.getCustomerId() != null ? String.valueOf(res.getCustomerId()) : null);
        responseForm.setName(res.getName());
        responseForm.setEmail(res.getEmail());
        responseForm.setPhone(res.getPhone());
        responseForm.setAddress(res.getAddress());

        return responseForm;
    }

    @Override
    public CustomerResponseForm getCustomerById(Integer custId) {
        Customer res = dao.getCustomerById(custId);
        CustomerResponseForm responseForm = new CustomerResponseForm();
        responseForm.setCustomerId(res.getCustomerId() != null ? String.valueOf(res.getCustomerId()) : null);
        responseForm.setName(res.getName());
        responseForm.setEmail(res.getEmail());
        responseForm.setPhone(res.getPhone());
        responseForm.setAddress(res.getAddress());

        return responseForm;
    }

    @Override
    public List<CustomerResponseForm> getAllCustomers() {
        List<Customer> customersList = dao.getAllCustomers();
        List<CustomerResponseForm> responseForms = new ArrayList<>();
        for(Customer c : customersList){
            CustomerResponseForm responseForm = new CustomerResponseForm();
            responseForm.setCustomerId(String.valueOf(c.getCustomerId()));
            responseForm.setName(String.valueOf(c.getName()));
            responseForm.setEmail(String.valueOf(c.getEmail()));
            responseForm.setAddress(c.getAddress());
            responseForm.setPhone(c.getPhone());
            responseForms.add(responseForm);
        }
        return responseForms;
    }

    @Override
    public CustomerResponseForm updateCustomer(CustomerRequestForm form) {
        Customer entity = new Customer();
        entity.setCustomerId(Integer.valueOf(form.getCustomerId()));
        entity.setName(form.getName());
        entity.setEmail(form.getEmail());
        entity.setPhone(form.getPhone());
        entity.setAddress(form.getAddress());
        Customer res = dao.updateCustomer(entity);
        CustomerResponseForm responseForm = new CustomerResponseForm();
        responseForm.setCustomerId(res.getCustomerId() != null ? String.valueOf(res.getCustomerId()) : null);
        responseForm.setName(res.getName());
        responseForm.setEmail(res.getEmail());
        responseForm.setPhone(res.getPhone());
        responseForm.setAddress(res.getAddress());
        return responseForm;
    }

    @Override
    public String deleteCustomer(int custId) {
        String res = dao.deleteCustomer(custId);
        return res;
    }


}
