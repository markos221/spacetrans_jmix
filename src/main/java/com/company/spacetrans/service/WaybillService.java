package com.company.spacetrans.service;

import com.company.spacetrans.entity.WaybillItem;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface WaybillService {
    String NAME = "WaybillService";

    BigDecimal sumCharge(WaybillItem waybillItem);
}
