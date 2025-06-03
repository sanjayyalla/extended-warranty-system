package com.jocata.extendedwarrantysystem.dao.impl;

import com.jocata.extendedwarrantysystem.HibernateUtil.HibernateUtil;
import com.jocata.extendedwarrantysystem.dao.CarModelDao;
import com.jocata.extendedwarrantysystem.entity.CarModel;
import com.jocata.extendedwarrantysystem.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public CarModel updateCarModel(CarModel entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CarModel returned = session.find(CarModel.class, entity.getModelId());
        if (returned == null) {
            tx.commit();
            session.close();
            return null;
        }

        if(entity.getModelName()!=null && !entity.getModelName().isEmpty()){
            returned.setModelName(entity.getModelName());
        }
        if (entity.getMake() != null && !entity.getMake().isEmpty()) {
            returned.setMake(entity.getMake());
        }
        if (entity.getYear() != null) {
            returned.setYear(entity.getYear());
        }
        if (entity.getBasePrice() != null) {
            returned.setBasePrice(entity.getBasePrice());
        }
        if (entity.getEngineType() != null) {
            returned.setEngineType(entity.getEngineType());
        }
        if (entity.getTransmission() != null) {
            returned.setTransmission(entity.getTransmission());
        }
        if (entity.getFuelType() != null) {
            returned.setFuelType(entity.getFuelType());
        }
        if (entity.getSeatingCapacity() != null) {
            returned.setSeatingCapacity(entity.getSeatingCapacity());
        }
        if (entity.getWarrantyDurationMonths() != null) {
            returned.setWarrantyDurationMonths(entity.getWarrantyDurationMonths());
        }
        if (entity.getWarrantyKmLimit() != null) {
            returned.setWarrantyKmLimit(entity.getWarrantyKmLimit());
        }
        tx.commit();
        session.close();
        return returned;
    }

    @Override
    public CarModel getCarModelById(Integer modelId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CarModel carModel = session.find(CarModel.class, modelId);
        tx.commit();
        session.close();
        return carModel;
    }

    @Override
    public List<CarModel> getAllCarModels() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<CarModel> carModels =session.createQuery("FROM CarModel", CarModel.class).list();
        tx.commit();
        return carModels;
    }

    @Override
    public String deleteCarModelById(Integer modelId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CarModel existing = session.find(CarModel.class,modelId);
        session.remove(existing);
        tx.commit();
        return "Car model deleted successfully";
    }
}
