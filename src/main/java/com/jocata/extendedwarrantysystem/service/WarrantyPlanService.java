package com.jocata.extendedwarrantysystem.service;

import com.jocata.extendedwarrantysystem.form.WarrantyPlanRequestForm;
import com.jocata.extendedwarrantysystem.form.WarrantyPlanResponseForm;

import java.util.List;

public interface WarrantyPlanService {
    WarrantyPlanResponseForm addWarrantyPlan(WarrantyPlanRequestForm requestForm);

    WarrantyPlanResponseForm updateWarrantyPlan(WarrantyPlanRequestForm requestForm);

    WarrantyPlanResponseForm getWarrantyPlanById(Integer warrantyPlanId);

    String deleteWarrantyPlanById(Integer warrantyPlanId);

    List<WarrantyPlanResponseForm> getAllWarrantyPlans();
}
