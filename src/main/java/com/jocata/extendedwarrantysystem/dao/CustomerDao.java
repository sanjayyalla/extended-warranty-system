package com.jocata.extendedwarrantysystem.dao;

import com.jocata.extendedwarrantysystem.entity.Customer;

public interface CustomerDao {
    Customer createCustomer(Customer customer);
    Customer getCustomerById(int custId);
}
