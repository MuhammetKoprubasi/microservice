package com.microservice.limitsservice.controller;

import com.microservice.limitsservice.configuration.ApplicationConfiguration;
import com.microservice.limitsservice.configuration.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationController {

    @Autowired
    ApplicationConfiguration applicationConfiguration;

    @GetMapping("/limits")
    public LimitConfiguration getLimitsFromConfiguration(){
        return new LimitConfiguration(applicationConfiguration.getMaximum(),applicationConfiguration.getMinimum());
    }

    @GetMapping("/limits-fault-tolerance")
    @HystrixCommand(fallbackMethod = "fallbackMethodForHystrix")
    public LimitConfiguration tryToGetLimitsFromConfiguration(){
        throw new RuntimeException("Exception for testing Hystrix");
    }

    public LimitConfiguration fallbackMethodForHystrix(){
        return new LimitConfiguration(999,9);
    }
}
