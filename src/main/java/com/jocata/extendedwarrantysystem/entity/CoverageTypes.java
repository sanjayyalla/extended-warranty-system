package com.jocata.extendedwarrantysystem.entity;

import com.jocata.extendedwarrantysystem.enums.CoverageTypeName;
import jakarta.persistence.*;

@Entity
@Table(name = "coveragetypes")
public class CoverageTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coverage_type_id")
    private Integer coverageTypeId;
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
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
