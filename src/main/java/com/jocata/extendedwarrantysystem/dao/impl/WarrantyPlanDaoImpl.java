package com.jocata.extendedwarrantysystem.dao.impl;

import com.jocata.extendedwarrantysystem.HibernateUtil.HibernateUtil;
import com.jocata.extendedwarrantysystem.dao.WarrantyPlanDao;
import com.jocata.extendedwarrantysystem.entity.WarrantyPlans;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class WarrantyPlanDaoImpl implements WarrantyPlanDao {
    @Override
    public WarrantyPlans addWarrantyPlan(WarrantyPlans entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entity);
        tx.commit();
        System.out.println(entity);
        session.close();
        return entity;
    }

    @Override
    public WarrantyPlans updateWarrantyPlan(WarrantyPlans entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        WarrantyPlans existing = session.find(WarrantyPlans.class,entity.getPlanId());
        if (existing == null) {
            tx.commit();
            session.close();
            return null;
        }
        if(entity.getName()!=null && !entity.getName().isEmpty()){
            existing.setName(entity.getName());
        }
        if(entity.getDurationMonths()!=null && entity.getDurationMonths()!=0){
            existing.setDurationMonths(entity.getDurationMonths());
        }
        if(entity.getKmLimit()!=null && entity.getKmLimit()!=0){
            existing.setKmLimit(entity.getKmLimit());
        }
        if(entity.getWarrantyType()!=null){
            existing.setWarrantyType(entity.getWarrantyType());
        }
        if(entity.getCoverageType()!=null){
            existing.setCoverageType(entity.getCoverageType());
        }
        if(entity.getBasePrice()!=null){
            existing.setBasePrice(entity.getBasePrice());
        }
        if(entity.getSurchargePercent()!=null){
            existing.setSurchargePercent(entity.getSurchargePercent());
        }
        tx.commit();
        session.close();
        return existing;
    }
}
