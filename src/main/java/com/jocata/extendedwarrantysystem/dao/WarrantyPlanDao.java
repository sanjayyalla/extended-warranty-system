package com.jocata.extendedwarrantysystem.dao;

import com.jocata.extendedwarrantysystem.entity.WarrantyPlans;
import com.jocata.extendedwarrantysystem.form.WarrantyPlanResponseForm;

import java.util.List;

public interface WarrantyPlanDao {
    WarrantyPlans addWarrantyPlan(WarrantyPlans entity);

    WarrantyPlans updateWarrantyPlan(WarrantyPlans entity);

    WarrantyPlans getWarrantyPlanById(Integer warrantyPlanId);

    String deleteWarrantyPlanById(Integer warrantyPlanId);

    List<WarrantyPlans> getAllWarrantyPlans();
}
