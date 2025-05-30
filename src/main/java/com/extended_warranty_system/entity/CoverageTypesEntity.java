package com.extended_warranty_system.entity;

public class CoverageTypesEntity {
    private int coverageTypeId;
    private String name;

    public int getCoverageTypeId() {
        return coverageTypeId;
    }

    public void setCoverageTypeId(int coverageTypeId) {
        this.coverageTypeId = coverageTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
