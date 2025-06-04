package com.jocata.extendedwarrantysystem.dao.impl;

import com.jocata.extendedwarrantysystem.HibernateUtil.HibernateUtil;
import com.jocata.extendedwarrantysystem.dao.CarTypesDao;
import com.jocata.extendedwarrantysystem.entity.CarTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class CarTypesDaoImpl implements CarTypesDao {
    @Override
    public CarTypes addCarType(CarTypes entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entity);
        System.out.println("I am here");
        tx.commit();
        session.close();
        return entity;
    }

    @Override
    public CarTypes getCarType(Integer carTypeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CarTypes entity = session.find(CarTypes.class,carTypeId);
        tx.commit();
        session.close();
        return entity;
    }

    @Override
    public CarTypes updateCarType(CarTypes entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CarTypes existing = session.find(CarTypes.class,entity.getCarTypeId());
        if(entity.getCarTypeName()!=null){
            existing.setCarTypeName(entity.getCarTypeName());
        }
        tx.commit();
        session.close();
        return existing;
    }

    @Override
    public String deleteCarType(Integer carTypeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CarTypes existing = session.find(CarTypes.class,carTypeId);
        System.out.println(existing);
        if(existing==null){
            return "Not found";
        }
        session.remove(existing);
        tx.commit();
        session.close();
        return "Deleted successfully";
    }
}
