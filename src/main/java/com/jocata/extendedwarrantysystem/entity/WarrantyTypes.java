package com.jocata.extendedwarrantysystem.entity;

import com.jocata.extendedwarrantysystem.enums.WarrantyTypeName;
import jakarta.persistence.*;

@Entity
@Table(name = "warrantytypes")
public class WarrantyTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warranty_type_id")
    private Integer warrantyTypeId;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
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
