package com.jocata.extendedwarrantysystem.service.impl;

import com.jocata.extendedwarrantysystem.dao.WarrantyTypeDao;
import com.jocata.extendedwarrantysystem.entity.WarrantyTypes;
import com.jocata.extendedwarrantysystem.enums.WarrantyTypeName;
import com.jocata.extendedwarrantysystem.form.WarrantyTypeRequestForm;
import com.jocata.extendedwarrantysystem.form.WarrantyTypeResponseForm;
import com.jocata.extendedwarrantysystem.service.WarrantyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarrantyTypeServiceImpl implements WarrantyTypeService {

    @Autowired
    private WarrantyTypeDao dao;

    @Override
    public WarrantyTypeResponseForm addWarrantyType(WarrantyTypeRequestForm requestForm) {
        WarrantyTypes entity = new WarrantyTypes();
        entity.setName(WarrantyTypeName.valueOf(requestForm.getName()));
        WarrantyTypes newEntity = dao.addWarrantyType(entity);
        WarrantyTypeResponseForm responseForm = new WarrantyTypeResponseForm();
        responseForm.setWarrantyTypeId(String.valueOf(newEntity.getWarrantyTypeId()));
        responseForm.setName(requestForm.getName());
        return responseForm;
    }

    @Override
    public WarrantyTypeResponseForm getWarrantyType(Integer warrantyTypeID) {
        WarrantyTypes entity = dao.getWarrantyType(warrantyTypeID);
        WarrantyTypeResponseForm responseForm = new WarrantyTypeResponseForm();
        responseForm.setWarrantyTypeId(String.valueOf(entity.getWarrantyTypeId()));
        responseForm.setName(String.valueOf(entity.getName()));
        return responseForm;
    }

    @Override
    public List<WarrantyTypeResponseForm> getAllWarrantyTypes() {
        List<WarrantyTypeResponseForm> responseFormList = new ArrayList<>();
        List<WarrantyTypes> warrantyTypesList = dao.getAllWarrantyTypes();
        for(WarrantyTypes warrantyType : warrantyTypesList){
            WarrantyTypeResponseForm responseForm = new WarrantyTypeResponseForm();
            responseForm.setWarrantyTypeId(String.valueOf(warrantyType.getWarrantyTypeId()));
            responseForm.setName(String.valueOf(warrantyType.getName()));
            responseFormList.add(responseForm);
        }
        return responseFormList;
    }

    @Override
    public WarrantyTypeResponseForm updateWarrantyType(WarrantyTypeRequestForm requestForm) {
        WarrantyTypes entity = new WarrantyTypes();
        entity.setWarrantyTypeId(Integer.valueOf(requestForm.getWarrantyTypeId()));
        entity.setName(WarrantyTypeName.valueOf(requestForm.getName()));

        WarrantyTypes newEntity = dao.updateWarrantyType(entity);
        WarrantyTypeResponseForm responseForm = new WarrantyTypeResponseForm();
        responseForm.setWarrantyTypeId(String.valueOf(newEntity.getWarrantyTypeId()));
        responseForm.setName(String.valueOf(newEntity.getName()));
        return responseForm;
    }

    @Override
    public String deleteWarrantyType(Integer warrantyTypeId) {
        return dao.deleteWarrantyType(warrantyTypeId);
    }


}
