package com.jocata.extendedwarrantysystem.service;

import com.jocata.extendedwarrantysystem.form.WarrantyPlanRequestForm;
import com.jocata.extendedwarrantysystem.form.WarrantyPlanResponseForm;

public interface WarrantyPlanService {
    WarrantyPlanResponseForm addWarrantyPlan(WarrantyPlanRequestForm requestForm);
}
