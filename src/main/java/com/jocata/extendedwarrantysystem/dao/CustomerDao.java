package com.jocata.extendedwarrantysystem.dao;

import com.jocata.extendedwarrantysystem.entity.Customer;

import java.util.List;

public interface CustomerDao {
    Customer createCustomer(Customer customer);

    Customer getCustomerById(int custId);

    Customer updateCustomer(Customer customer);

    String deleteCustomer(int custId);

    List<Customer> getAllCustomers();
}
