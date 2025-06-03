package com.jocata.extendedwarrantysystem.dao.impl;

import com.jocata.extendedwarrantysystem.HibernateUtil.HibernateUtil;
import com.jocata.extendedwarrantysystem.dao.CarModelDao;
import com.jocata.extendedwarrantysystem.entity.CarModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class CarModelDaoImpl implements CarModelDao {
    @Override
    public CarModel addCarModel(CarModel model) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(model);
        tx.commit();
        session.close();
        return model;
    }
}
