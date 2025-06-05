package com.jocata.extendedwarrantysystem.dao;

import com.jocata.extendedwarrantysystem.entity.WarrantyPlans;
import com.jocata.extendedwarrantysystem.form.WarrantyPlanResponseForm;

public interface WarrantyPlanDao {
    WarrantyPlans addWarrantyPlan(WarrantyPlans entity);

    WarrantyPlans updateWarrantyPlan(WarrantyPlans entity);
}
