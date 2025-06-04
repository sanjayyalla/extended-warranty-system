package com.jocata.extendedwarrantysystem.service;

import com.jocata.extendedwarrantysystem.form.CoverageTypeRequestForm;
import com.jocata.extendedwarrantysystem.form.CoverageTypeResponseForm;

import java.util.List;

public interface CoverageTypeService {
    CoverageTypeResponseForm addCoverageType(CoverageTypeRequestForm requestForm);

    CoverageTypeResponseForm getCoverageType(Integer coverageTypeId);

    CoverageTypeResponseForm updateCoverageType(CoverageTypeRequestForm requestForm);

    String deleteCoverageType(Integer coverageTypeId);

    List<CoverageTypeResponseForm> getAllCoverageTypes();
}
