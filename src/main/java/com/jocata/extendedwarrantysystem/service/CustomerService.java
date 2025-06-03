package com.jocata.extendedwarrantysystem.service;

import com.jocata.extendedwarrantysystem.form.CustomerRequestForm;
import com.jocata.extendedwarrantysystem.form.CustomerResponseForm;

public interface CustomerService {
    public CustomerResponseForm createCustomer(CustomerRequestForm form);
    public CustomerResponseForm getCustomerById(Integer custId);
}
