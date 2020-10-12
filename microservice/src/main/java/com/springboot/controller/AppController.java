package com.springboot.controller;

import com.springboot.service.AppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {

    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/dynamic")
    public String getDynamicConfig()  {
        return appService.getName();
    }

    @GetMapping("/ping")
    public String doPing()  {
        return "-------------- Hello World !!! --------------";
    }
}