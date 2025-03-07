package com.learning.spring_boot.scope.requestscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logging")
public class LoggingTestController {

    private final LoggingService loggingService;

    @Autowired
    public LoggingTestController(LoggingService loggingService){
        this.loggingService = loggingService;
    }


    @GetMapping("/test")
    public String test(){
        loggingService.log("Processing Request ...");
        return "Request Logged with ID";
    }
}
