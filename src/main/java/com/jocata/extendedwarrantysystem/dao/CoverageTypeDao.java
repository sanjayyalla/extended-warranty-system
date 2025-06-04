package com.jocata.extendedwarrantysystem.dao;

import com.jocata.extendedwarrantysystem.entity.CoverageTypes;

import java.util.List;

public interface CoverageTypeDao {
    CoverageTypes addCoverageType(CoverageTypes entity);

    CoverageTypes getCoverageType(Integer coverageTypeId);

    CoverageTypes updateCoverageType(CoverageTypes entity);

    String deleteCoverageType(Integer coverageTypeId);

    List<CoverageTypes> getAllCoverageTypes();
}
