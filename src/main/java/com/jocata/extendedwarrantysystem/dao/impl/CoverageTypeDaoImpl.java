package com.jocata.extendedwarrantysystem.dao.impl;

import com.jocata.extendedwarrantysystem.HibernateUtil.HibernateUtil;
import com.jocata.extendedwarrantysystem.dao.CoverageTypeDao;
import com.jocata.extendedwarrantysystem.entity.CoverageTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoverageTypeDaoImpl implements CoverageTypeDao {
    @Override
    public CoverageTypes addCoverageType(CoverageTypes entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entity);
        tx.commit();
        session.close();
        return entity;
    }

    @Override
    public CoverageTypes getCoverageType(Integer coverageTypeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CoverageTypes entity = session.find(CoverageTypes.class, coverageTypeId);
        tx.commit();
        session.close();
        return entity;
    }

    @Override
    public CoverageTypes updateCoverageType(CoverageTypes entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CoverageTypes existing = session.find(CoverageTypes.class,entity.getCoverageTypeId());
        if(entity.getName()!=null){
            existing.setName(entity.getName());
        }
        tx.commit();
        return existing;
    }

    @Override
    public String deleteCoverageType(Integer coverageTypeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CoverageTypes existing = session.find(CoverageTypes.class,coverageTypeId);
        if(existing!=null){
            session.remove(existing);
            tx.commit();
            return "Deleted successfully";
        }
        return "Not found";
    }

    @Override
    public List<CoverageTypes> getAllCoverageTypes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<CoverageTypes> coverageTypesList = session.createQuery("FROM CoverageTypes", CoverageTypes.class).list();
        tx.commit();
        session.close();
        return coverageTypesList;
    }
}
