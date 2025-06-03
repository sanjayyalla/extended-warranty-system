package com.jocata.extendedwarrantysystem.service;

import com.jocata.extendedwarrantysystem.form.CustomerRequestForm;
import com.jocata.extendedwarrantysystem.form.CustomerResponseForm;

import java.util.List;

public interface CustomerService {
    CustomerResponseForm createCustomer(CustomerRequestForm form);

    CustomerResponseForm getCustomerById(Integer custId);

    CustomerResponseForm updateCustomer(CustomerRequestForm form);

    String deleteCustomer(int custId);

    List<CustomerResponseForm> getAllCustomers();
}
