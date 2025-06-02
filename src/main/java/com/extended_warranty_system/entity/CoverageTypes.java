package com.extended_warranty_system.entity;

import com.extended_warranty_system.enums.CoverageTypeName;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "coveragetypes")
public class CoverageTypes {
    private Integer coverageTypeId;
    private CoverageTypeName name;

    public Integer getCoverageTypeId() {
        return coverageTypeId;
    }

    public void setCoverageTypeId(Integer coverageTypeId) {
        this.coverageTypeId = coverageTypeId;
    }

    public CoverageTypeName getName() {
        return name;
    }

    public void setName(CoverageTypeName name) {
        this.name = name;
    }
}
