package com.jocata.extendedwarrantysystem.dao.impl;

import com.jocata.extendedwarrantysystem.HibernateUtil.HibernateUtil;
import com.jocata.extendedwarrantysystem.dao.CustomerDao;
import com.jocata.extendedwarrantysystem.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public Customer createCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(customer);
        tx.commit();
        System.out.println("Committed");
        session.close();
        return customer;
    }

    @Override
    public Customer getCustomerById(int custId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Customer customer = session.find(Customer.class, custId);
        tx.commit();
        System.out.println("Committed");
        session.close();
        return customer;
    }
    @Override
    public Customer updateCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Cust id : " + customer.getCustomerId());
        Customer returned = session.find(Customer.class, customer.getCustomerId());
        System.out.println(returned);
        if (returned == null) {
            tx.commit();
            session.close();
            return null;
        }

        if (customer.getName() != null && !customer.getName().isEmpty()) {
            returned.setName(customer.getName());
        }
        if (customer.getEmail() != null && !customer.getEmail().isEmpty()) {
            returned.setEmail(customer.getEmail());
        }
        if (customer.getPhone() != null && !customer.getPhone().isEmpty()) {
            returned.setPhone(customer.getPhone());
        }
        if (customer.getAddress() != null && !customer.getAddress().isEmpty()) {
            returned.setAddress(customer.getAddress());
        }
        //session.merge(returned);
        tx.commit();
        session.close();
        return returned;
    }

    @Override
    public String deleteCustomer(int custId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Customer customer = session.find(Customer.class,custId);
        if(customer!=null){
            session.remove(customer);
        }
        tx.commit();
        return "Customer deleted successfully";
    }

    @Override
    public List<Customer> getAllCustomers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Customer> customers =session.createQuery("FROM Customer",Customer.class).list();
        tx.commit();
        return customers;
    }
}
