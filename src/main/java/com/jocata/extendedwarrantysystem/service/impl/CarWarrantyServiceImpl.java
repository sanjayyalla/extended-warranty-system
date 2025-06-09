package com.jocata.extendedwarrantysystem.service.impl;

import com.jocata.extendedwarrantysystem.dao.CarModelDao;
import com.jocata.extendedwarrantysystem.dao.CarSaleRecordsDao;
import com.jocata.extendedwarrantysystem.dao.CarWarrantyDao;
import com.jocata.extendedwarrantysystem.dao.WarrantyPlanDao;
import com.jocata.extendedwarrantysystem.entity.CarSaleRecords;
import com.jocata.extendedwarrantysystem.entity.CarWarranties;
import com.jocata.extendedwarrantysystem.entity.WarrantyPlans;
import com.jocata.extendedwarrantysystem.form.CarWarrantyRequestForm;
import com.jocata.extendedwarrantysystem.form.CarWarrantyResponseForm;
import com.jocata.extendedwarrantysystem.service.CarWarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.time.LocalDate;

@Service
public class CarWarrantyServiceImpl implements CarWarrantyService {

    @Autowired
    private CarWarrantyDao carWarrantyDao;
    @Autowired
    private CarSaleRecordsDao carSaleRecordsDao;
    @Autowired
    private CarModelDao carModelDao;
    @Autowired
    private WarrantyPlanDao warrantyPlanDao;

    @Override
    public CarWarrantyResponseForm createCarWarranty(CarWarrantyRequestForm requestForm) {
        CarWarranties entity = new CarWarranties();
        CarSaleRecords carSalesRecord = carSaleRecordsDao.getCarSaleRecordById(Integer.valueOf(requestForm.getCarSaleId()));
        if (carSalesRecord != null) {
            WarrantyPlans warrantyPlans = warrantyPlanDao.getWarrantyPlanById(Integer.valueOf(requestForm.getPlanId()));
            if (warrantyPlans != null) {
                entity.setCarSaleId(carSalesRecord);
                entity.setPlanId(warrantyPlans);
                if (carSalesRecord.getCarTypeId().getCarTypeName().toString().equals("Personal") || carSalesRecord.getCarTypeId().getCarTypeName().toString().equals("Commercial")) {


                    Date startDate = carSalesRecord.getPurchaseDate();
                    LocalDate startLocalDate = startDate.toLocalDate();
                    LocalDate endLocalDate = startLocalDate.plusMonths(warrantyPlans.getDurationMonths());
                    Date endDate = Date.valueOf(endLocalDate);
                    entity.setBwStartDate(startDate);
                    entity.setBwEndDate(endDate);
                    entity.setBwKmStart(0);
                    entity.setBwKmEnd(warrantyPlans.getKmLimit());
                    entity.setActive(true);
                    if (warrantyPlans.getWarrantyType().getName().toString().equals("Extended")) {

                        entity.setExwStartDate(Date.valueOf(endLocalDate.plusDays(1)));
                        entity.setExwEndDate(Date.valueOf(endLocalDate.plusDays(1).plusMonths(warrantyPlans.getDurationMonths())));
                        entity.setExwKmStart(warrantyPlans.getKmLimit());
                        entity.setExwKmEnd(entity.getExwKmStart() + warrantyPlans.getKmLimit());
                        entity.setPricePaid(warrantyPlans.getBasePrice().add(warrantyPlans.getBasePrice().multiply(warrantyPlans.getSurchargePercent()).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP)));
                        if (entity.getExwPurchaseDate().toLocalDate().isBefore(entity.getBwEndDate().toLocalDate())) {
                            entity.setPurchasedDuringBasic(true);
                        } else {
                            entity.setPurchasedDuringBasic(false);
                        }
                        entity.setExwPurchaseDate(Date.valueOf(LocalDate.now()));
                    }
                } else if (carSalesRecord.getCarTypeId().getCarTypeName().toString().equals("UsedPersonal") || carSalesRecord.getCarTypeId().getCarTypeName().toString().equals("UsedCommercial")) {
                    //ext start = ext purchase date
                    //EX END = ext start + duration months , plan id
                    //exkmst = from req from ex km start
                    //exend = exkm st + kmlimit
                    //base price = baseprice+ surcharge + 2% for personal
                    //                                  +5% for com
                    Date startDate = carSalesRecord.getPurchaseDate();
                    LocalDate startLocalDate = startDate.toLocalDate();
                    Date endDate = Date.valueOf(startLocalDate.plusMonths(warrantyPlans.getDurationMonths()));
                    entity.setExwStartDate(Date.valueOf(startLocalDate));
                    entity.setExwEndDate(endDate);
                    entity.setExwKmStart(Integer.valueOf(requestForm.getExwKm()));
                    entity.setExwKmEnd(Integer.valueOf(requestForm.getExwKm()) + warrantyPlans.getKmLimit());
                    if (carSalesRecord.getCarTypeId().getCarTypeName().toString().equals("UsedPersonal")) {
                        BigDecimal basePrice = warrantyPlans.getBasePrice();
                        BigDecimal surchargeAmount = basePrice.multiply(warrantyPlans.getSurchargePercent().divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP));
                        BigDecimal personalExtra = basePrice.multiply(new BigDecimal("0.02"));
                        entity.setPricePaid(basePrice.add(surchargeAmount).add(personalExtra));
                    } else if (carSalesRecord.getCarTypeId().getCarTypeName().toString().equals("UsedCommercial")) {
                        BigDecimal basePrice = warrantyPlans.getBasePrice();
                        BigDecimal surchargeAmount = basePrice.multiply(warrantyPlans.getSurchargePercent().divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP));
                        BigDecimal commercialExtra = basePrice.multiply(new BigDecimal("0.05"));
                        entity.setPricePaid(basePrice.add(surchargeAmount).add(commercialExtra));
                    }

                }
            }
        }
    }
}
