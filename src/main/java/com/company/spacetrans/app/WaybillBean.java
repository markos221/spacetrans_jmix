package com.company.spacetrans.app;

import com.company.spacetrans.entity.WaybillItem;
import com.company.spacetrans.service.WaybillService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component(WaybillService.NAME)
public class WaybillBean implements WaybillService{
    public static final String NAME = "WaybillBean";

    @Override
    public BigDecimal sumCharge(WaybillItem waybillItem) {
        return null;
    }
}