package com.jocata.extendedwarrantysystem.dao;

import com.jocata.extendedwarrantysystem.entity.WarrantyTypes;

import java.util.List;

public interface WarrantyTypeDao {
    WarrantyTypes addWarrantyType(WarrantyTypes entity);

    WarrantyTypes getWarrantyType(Integer warrantyTypeID);

    WarrantyTypes updateWarrantyType(WarrantyTypes entity);

    String deleteWarrantyType(Integer warrantyTypeId);

    List<WarrantyTypes> getAllWarrantyTypes();
}
