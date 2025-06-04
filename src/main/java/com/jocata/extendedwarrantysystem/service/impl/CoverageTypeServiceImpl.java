package com.jocata.extendedwarrantysystem.service.impl;

import com.jocata.extendedwarrantysystem.dao.CoverageTypeDao;
import com.jocata.extendedwarrantysystem.entity.CoverageTypes;
import com.jocata.extendedwarrantysystem.enums.CoverageTypeName;
import com.jocata.extendedwarrantysystem.form.CoverageTypeRequestForm;
import com.jocata.extendedwarrantysystem.form.CoverageTypeResponseForm;
import com.jocata.extendedwarrantysystem.service.CoverageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoverageTypeServiceImpl implements CoverageTypeService {
    @Autowired
    private CoverageTypeDao dao;

    @Override
    public CoverageTypeResponseForm addCoverageType(CoverageTypeRequestForm requestForm) {
        CoverageTypes entity = new CoverageTypes();
        entity.setName(CoverageTypeName.valueOf(requestForm.getName()));
        CoverageTypes newEntity = dao.addCoverageType(entity);
        CoverageTypeResponseForm responseForm = new CoverageTypeResponseForm();
        responseForm.setCoverageTypeId(String.valueOf(newEntity.getCoverageTypeId()));
        responseForm.setName(String.valueOf(newEntity.getName()));
        return responseForm;
    }

    @Override
    public CoverageTypeResponseForm getCoverageType(Integer coverageTypeId) {
        CoverageTypes entity = dao.getCoverageType(coverageTypeId);
        CoverageTypeResponseForm responseForm = new CoverageTypeResponseForm();
        responseForm.setCoverageTypeId(String.valueOf(entity.getCoverageTypeId()));
        responseForm.setName(String.valueOf(entity.getName()));
        return responseForm;
    }

    @Override
    public List<CoverageTypeResponseForm> getAllCoverageTypes() {
        List<CoverageTypes> coverageTypesList = dao.getAllCoverageTypes();
        List<CoverageTypeResponseForm> coverageTypeResponseFormList = new ArrayList<>();
        for(CoverageTypes coverageTypes:coverageTypesList){
            CoverageTypeResponseForm responseForm = new CoverageTypeResponseForm();
            responseForm.setCoverageTypeId(String.valueOf(coverageTypes.getCoverageTypeId()));
            responseForm.setName(String.valueOf(coverageTypes.getName()));
            coverageTypeResponseFormList.add(responseForm);
        }
        return coverageTypeResponseFormList;
    }

    @Override
    public CoverageTypeResponseForm updateCoverageType(CoverageTypeRequestForm requestForm) {
        CoverageTypes entity = new CoverageTypes();
        entity.setCoverageTypeId(Integer.valueOf(requestForm.getCoverageTypeId()));
        entity.setName(CoverageTypeName.valueOf(requestForm.getName()));

        CoverageTypes newEntity = dao.updateCoverageType(entity);
        CoverageTypeResponseForm responseForm = new CoverageTypeResponseForm();
        responseForm.setCoverageTypeId(String.valueOf(newEntity.getCoverageTypeId()));
        responseForm.setName(String.valueOf(newEntity.getName()));
        return responseForm;
    }

    @Override
    public String deleteCoverageType(Integer coverageTypeId) {
        if (coverageTypeId != null && coverageTypeId != 0) {
            return dao.deleteCoverageType(coverageTypeId);
        }
        return "Provide Coverage Id correctly";
    }

}
