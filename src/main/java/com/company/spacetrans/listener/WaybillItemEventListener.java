package com.company.spacetrans.listener;


import com.company.spacetrans.entity.WaybillItem;
import io.jmix.core.DataManager;
import io.jmix.core.event.EntityChangedEvent;
import io.jmix.core.event.EntitySavingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

@Component(WaybillItemEventListener.NAME)
public class WaybillItemEventListener {
    public static final String NAME = "WaybillItemEventListener";

    @Autowired
    DataManager dataManager;

    @Autowired
    EntityManager entityManager;

    @EventListener
    public void onWaybillItemSaving(EntitySavingEvent<WaybillItem> event) {

    }

    @EventListener
    public void onWaybillItemChangedBeforeCommit(EntityChangedEvent<WaybillItem> event) {

    }

    @TransactionalEventListener
    public void onWaybillItemChangedAfterCommit(EntityChangedEvent<WaybillItem> event) {
        WaybillItem waybillItem = dataManager.load(event.getEntityId()).one();
        Double sumDimesions = Double.valueOf(100 * 100 * 100);
        Double weight = waybillItem.getWeight();
        BigDecimal sum = new BigDecimal(sumDimesions/(5 * weight));
        waybillItem.setCharge(sum);
        entityManager.persist(waybillItem);
    }
}