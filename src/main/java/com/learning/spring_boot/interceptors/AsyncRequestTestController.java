package com.learning.spring_boot.interceptors;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interceptor")
public class AsyncRequestTestController {

    @GetMapping("/async/test")
    public String hello(){
        return "doing async method test on interceptor";
    }

}
