package com.springboot.service;

import com.springboot.config.AppConfig;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    private final AppConfig appConfig;

    public AppService(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public String getValue() {
        return appConfig.getValue();
    }
}