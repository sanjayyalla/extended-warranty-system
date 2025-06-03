package com.jocata.extendedwarrantysystem.entity;

import com.jocata.extendedwarrantysystem.enums.WarrantyTypeName;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "warrantytypes")
public class WarrantyTypes {
    private Integer warrantyTypeId;
    private WarrantyTypeName name;

    public Integer getWarrantyTypeId() {
        return warrantyTypeId;
    }

    public void setWarrantyTypeId(Integer warrantyTypeId) {
        this.warrantyTypeId = warrantyTypeId;
    }

    public WarrantyTypeName getName() {
        return name;
    }

    public void setName(WarrantyTypeName name) {
        this.name = name;
    }
}
