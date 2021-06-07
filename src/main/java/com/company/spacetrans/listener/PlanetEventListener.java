package com.company.spacetrans.listener;

import com.company.spacetrans.entity.Planet;
import io.jmix.core.DataManager;
import io.jmix.core.event.EntityChangedEvent;
import io.jmix.core.event.EntitySavingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component(PlanetEventListener.NAME)
public class PlanetEventListener {
    public static final String NAME = "PlanetEventListener";

    @Autowired
    private DataManager dataManager;

    @EventListener
    public void onPlanetSaving(EntitySavingEvent<Planet> event){

    }

    @EventListener
    public void onPlanetChangedBeforeCommit(EntityChangedEvent<Planet> event) {
        ///dataManager.remove(event.getEntity());
    }

    @TransactionalEventListener
    public void onPlanetChangedAfterCommit(EntityChangedEvent<Planet> event) {

    }
}