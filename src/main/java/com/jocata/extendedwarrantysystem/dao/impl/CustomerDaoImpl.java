package com.jocata.extendedwarrantysystem.dao.impl;

import com.jocata.extendedwarrantysystem.HibernateUtil.HibernateUtil;
import com.jocata.extendedwarrantysystem.dao.CustomerDao;
import com.jocata.extendedwarrantysystem.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

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
        Customer customer = session.find(Customer.class,custId);
        tx.commit();
        System.out.println("Committed");
        session.close();
        return customer;
    }
}
