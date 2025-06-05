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
        entity.setSurchargePercent(new BigDecimal(requestForm.getSurchagePercent()));

        WarrantyPlans newEntity = warrantyPlanDao.addWarrantyPlan(entity);

        WarrantyPlanResponseForm responseForm = new WarrantyPlanResponseForm();
        responseForm.setPlanId(String.valueOf(newEntity.getPlanId()));
        responseForm.setName(newEntity.getName());
        responseForm.setDurationMonths(String.valueOf(newEntity.getDurationMonths()));
        responseForm.setKmLimit(String.valueOf(newEntity.getKmLimit()));
        responseForm.setWarrantyTypeName(String.valueOf(warrantyTypeEntity.getName()));
        responseForm.setCoverageTypeName(String.valueOf(coverageTypeEntity.getName()));
        responseForm.setBasePrice(String.valueOf(newEntity.getBasePrice()));
        responseForm.setSurchagePercent(String.valueOf(newEntity.getSurchargePercent()));
        return responseForm;
    }
}
