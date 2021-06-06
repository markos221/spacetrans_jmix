package com.company.spacetrans.listener;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component(UploadCsvEnabledListener.NAME)
public class UploadCsvEnabledListener {
    public static final String NAME = "UploadCsvEnabledListener";

    @EventListener
    public void onApplicationContextRefreshed(ContextRefreshedEvent event) {

    }
}