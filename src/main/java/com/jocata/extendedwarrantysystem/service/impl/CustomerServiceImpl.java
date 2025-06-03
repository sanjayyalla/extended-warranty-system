package com.jocata.extendedwarrantysystem.service.impl;

import com.jocata.extendedwarrantysystem.dao.CustomerDao;
import com.jocata.extendedwarrantysystem.entity.Customer;
import com.jocata.extendedwarrantysystem.form.CustomerRequestForm;
import com.jocata.extendedwarrantysystem.form.CustomerResponseForm;
import com.jocata.extendedwarrantysystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
