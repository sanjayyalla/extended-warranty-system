package com.jocata.extendedwarrantysystem.service.impl;

import com.jocata.extendedwarrantysystem.dao.CoverageTypeDao;
import com.jocata.extendedwarrantysystem.dao.WarrantyPlanDao;
import com.jocata.extendedwarrantysystem.dao.WarrantyTypeDao;
import com.jocata.extendedwarrantysystem.entity.CoverageTypes;
import com.jocata.extendedwarrantysystem.entity.WarrantyPlans;
import com.jocata.extendedwarrantysystem.entity.WarrantyTypes;
import com.jocata.extendedwarrantysystem.form.WarrantyPlanRequestForm;
import com.jocata.extendedwarrantysystem.form.WarrantyPlanResponseForm;
import com.jocata.extendedwarrantysystem.service.WarrantyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class WarrantyPlanServiceImpl implements WarrantyPlanService {
    @Autowired
    private WarrantyPlanDao warrantyPlanDao;
    @Autowired
    private WarrantyTypeDao warrantyTypeDao;
    @Autowired
    private CoverageTypeDao coverageTypeDao;

    @Override
    public WarrantyPlanResponseForm addWarrantyPlan(WarrantyPlanRequestForm requestForm) {
        WarrantyPlans entity = new WarrantyPlans();
        entity.setName(requestForm.getName());
        entity.setDurationMonths(Integer.valueOf(requestForm.getDurationMonths()));
        entity.setKmLimit(Integer.valueOf(requestForm.getKmLimit()));

        WarrantyTypes warrantyTypeEntity = warrantyTypeDao.getWarrantyType(Integer.parseInt(requestForm.getWarrantyTypeId()));
        entity.setWarrantyType(warrantyTypeEntity);

        CoverageTypes coverageTypeEntity = coverageTypeDao.getCoverageType(Integer.parseInt(requestForm.getCoverageTypeId()));
        entity.setCoverageType(coverageTypeEntity);

        entity.setBasePrice(new BigDecimal(requestForm.getBasePrice()));
        entity.setSurchargePercent(new BigDecimal(requestForm.getSurchargePercent()));

        WarrantyPlans newEntity = warrantyPlanDao.addWarrantyPlan(entity);

        WarrantyPlanResponseForm responseForm = new WarrantyPlanResponseForm();
        responseForm.setPlanId(String.valueOf(newEntity.getPlanId()));
        responseForm.setName(newEntity.getName());
        responseForm.setDurationMonths(String.valueOf(newEntity.getDurationMonths()));
        responseForm.setKmLimit(String.valueOf(newEntity.getKmLimit()));
        responseForm.setWarrantyTypeName(String.valueOf(newEntity.getWarrantyType().getName()));
        responseForm.setCoverageTypeName(String.valueOf(newEntity.getCoverageType().getName()));
        responseForm.setBasePrice(String.valueOf(newEntity.getBasePrice()));
        responseForm.setSurchagePercent(String.valueOf(newEntity.getSurchargePercent()));
        return responseForm;
    }

    @Override
    public WarrantyPlanResponseForm updateWarrantyPlan(WarrantyPlanRequestForm requestForm) {
        WarrantyPlans entity = new WarrantyPlans();
        entity.setPlanId(Integer.valueOf(requestForm.getPlanId()));
        entity.setName(requestForm.getName());
        try {
            entity.setDurationMonths(Integer.valueOf(requestForm.getDurationMonths()));
        } catch (NumberFormatException e) {
            entity.setDurationMonths(0);
        }

        try {
            entity.setKmLimit(Integer.valueOf(requestForm.getKmLimit()));
        } catch (NumberFormatException e) {
            entity.setKmLimit(0);
        }

        if (requestForm.getWarrantyTypeId() != null && !requestForm.getWarrantyTypeId().isEmpty()) {
            WarrantyTypes warrantyTypeEntity = warrantyTypeDao.getWarrantyType(Integer.parseInt(requestForm.getWarrantyTypeId()));
            entity.setWarrantyType(warrantyTypeEntity);
        }

        if (requestForm.getCoverageTypeId() != null && !requestForm.getCoverageTypeId().isEmpty()) {
            CoverageTypes coverageTypeEntity = coverageTypeDao.getCoverageType(Integer.parseInt(requestForm.getCoverageTypeId()));
            entity.setCoverageType(coverageTypeEntity);
        }

        try {
            entity.setBasePrice(new BigDecimal(requestForm.getBasePrice()));
        } catch (Exception e) {
            entity.setBasePrice(null);
        }

        try {
            entity.setSurchargePercent(new BigDecimal(requestForm.getSurchargePercent()));
        } catch (Exception e) {
            entity.setSurchargePercent(null);
        }

        WarrantyPlans newEntity = warrantyPlanDao.updateWarrantyPlan(entity);

        WarrantyPlanResponseForm responseForm = new WarrantyPlanResponseForm();
        responseForm.setPlanId(String.valueOf(newEntity.getPlanId()));
        responseForm.setName(newEntity.getName());
        responseForm.setDurationMonths(String.valueOf(newEntity.getDurationMonths()));
        responseForm.setKmLimit(String.valueOf(newEntity.getKmLimit()));
        responseForm.setWarrantyTypeName(String.valueOf(newEntity.getWarrantyType().getName()));
        responseForm.setCoverageTypeName(String.valueOf(newEntity.getCoverageType().getName()));
        responseForm.setBasePrice(String.valueOf(newEntity.getBasePrice()));
        responseForm.setSurchagePercent(String.valueOf(newEntity.getSurchargePercent()));

        return responseForm;

    }

    @Override
    public WarrantyPlanResponseForm getWarrantyPlanById(Integer warrantyPlanId) {
        WarrantyPlans entity = warrantyPlanDao.getWarrantyPlanById(warrantyPlanId);
        WarrantyPlanResponseForm responseForm = new WarrantyPlanResponseForm();
        responseForm.setPlanId(String.valueOf(entity.getPlanId()));
        responseForm.setName(entity.getName());
        responseForm.setDurationMonths(String.valueOf(entity.getDurationMonths()));
        responseForm.setKmLimit(String.valueOf(entity.getKmLimit()));
        responseForm.setWarrantyTypeName(String.valueOf(entity.getWarrantyType().getName()));
        responseForm.setCoverageTypeName(String.valueOf(entity.getCoverageType().getName()));
        responseForm.setBasePrice(String.valueOf(entity.getBasePrice()));
        responseForm.setSurchagePercent(String.valueOf(entity.getSurchargePercent()));
        return responseForm;
    }

    @Override
    public List<WarrantyPlanResponseForm> getAllWarrantyPlans() {
        List<WarrantyPlans> warrantyPlansList = warrantyPlanDao.getAllWarrantyPlans();
        List<WarrantyPlanResponseForm> warrantyPlanResponseFormList = new ArrayList<>();
        for(WarrantyPlans warrantyPlan:warrantyPlansList){
            WarrantyPlanResponseForm responseForm = new WarrantyPlanResponseForm();
            responseForm.setPlanId(String.valueOf(warrantyPlan.getPlanId()));
            responseForm.setName(warrantyPlan.getName());
            responseForm.setDurationMonths(String.valueOf(warrantyPlan.getDurationMonths()));
            responseForm.setKmLimit(String.valueOf(warrantyPlan.getKmLimit()));
            responseForm.setWarrantyTypeName(String.valueOf(warrantyPlan.getWarrantyType().getName()));
            responseForm.setCoverageTypeName(String.valueOf(warrantyPlan.getCoverageType().getName()));
            responseForm.setBasePrice(String.valueOf(warrantyPlan.getBasePrice()));
            responseForm.setSurchagePercent(String.valueOf(warrantyPlan.getSurchargePercent()));
            warrantyPlanResponseFormList.add(responseForm);
        }
        return warrantyPlanResponseFormList;
    }

    @Override
    public String deleteWarrantyPlanById(Integer warrantyPlanId) {
        return warrantyPlanDao.deleteWarrantyPlanById(warrantyPlanId);
    }


}
