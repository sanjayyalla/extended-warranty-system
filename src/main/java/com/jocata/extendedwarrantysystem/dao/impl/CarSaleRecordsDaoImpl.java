package com.jocata.extendedwarrantysystem.dao.impl;

import com.jocata.extendedwarrantysystem.HibernateUtil.HibernateUtil;
import com.jocata.extendedwarrantysystem.dao.CarSaleRecordsDao;
import com.jocata.extendedwarrantysystem.entity.CarSaleRecords;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class CarSaleRecordsDaoImpl implements CarSaleRecordsDao {
    @Override
    public CarSaleRecords createCarSale(CarSaleRecords entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entity);
        tx.commit();
        session.close();
        return entity;
    }

    @Override
    public CarSaleRecords getCarSaleRecordById(Integer carSaleRecordId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CarSaleRecords carSaleRecord = session.find(CarSaleRecords.class,carSaleRecordId);
        tx.commit();
        session.close();
        return carSaleRecord;
    }
}
