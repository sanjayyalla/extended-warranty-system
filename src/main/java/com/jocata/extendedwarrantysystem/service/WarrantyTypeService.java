package com.jocata.extendedwarrantysystem.service;

import com.jocata.extendedwarrantysystem.form.WarrantyTypeRequestForm;
import com.jocata.extendedwarrantysystem.form.WarrantyTypeResponseForm;

import java.util.List;

public interface WarrantyTypeService {
    WarrantyTypeResponseForm addWarrantyType(WarrantyTypeRequestForm requestForm);

    WarrantyTypeResponseForm getWarrantyType(Integer warrantyTypeID);

    WarrantyTypeResponseForm updateWarrantyType(WarrantyTypeRequestForm requestForm);

    String deleteWarrantyType(Integer warrantyTypeId);

    List<WarrantyTypeResponseForm> getAllWarrantyTypes();
}
