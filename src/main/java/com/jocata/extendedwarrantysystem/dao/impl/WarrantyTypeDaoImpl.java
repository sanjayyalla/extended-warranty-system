package com.jocata.extendedwarrantysystem.dao.impl;

import com.jocata.extendedwarrantysystem.HibernateUtil.HibernateUtil;
import com.jocata.extendedwarrantysystem.dao.WarrantyTypeDao;
import com.jocata.extendedwarrantysystem.entity.WarrantyTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WarrantyTypeDaoImpl implements WarrantyTypeDao {

    @Override
    public WarrantyTypes addWarrantyType(WarrantyTypes entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entity);
        tx.commit();
        session.close();
        return entity;
    }

    @Override
    public WarrantyTypes getWarrantyType(Integer warrantyTypeID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        WarrantyTypes entity = session.find(WarrantyTypes.class, warrantyTypeID);
        tx.commit();
        session.close();
        return entity;
    }

    @Override
    public List<WarrantyTypes> getAllWarrantyTypes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<WarrantyTypes> warrantyTypes = session.createQuery("FROM WarrantyTypes", WarrantyTypes.class).list();
        tx.commit();
        session.close();
        return warrantyTypes;
    }

    @Override
    public WarrantyTypes updateWarrantyType(WarrantyTypes entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        WarrantyTypes existing = session.find(WarrantyTypes.class, entity.getWarrantyTypeId());
        if (entity.getName() != null) {
            existing.setName(entity.getName());
        }
        tx.commit();
        session.close();
        return existing;
    }

    @Override
    public String deleteWarrantyType(Integer warrantyTypeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        WarrantyTypes existing = session.find(WarrantyTypes.class, warrantyTypeId);
        if (existing != null) {
            session.remove(existing);
            tx.commit();
            return "Deletion successful";
        }
        return "Not found";
    }

}
