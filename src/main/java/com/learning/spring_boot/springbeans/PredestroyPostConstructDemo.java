package com.learning.spring_boot.springbeans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PredestroyPostConstructDemo {


    public PredestroyPostConstructDemo() {
        System.out.println("1. Constructor: Object is being created");
    }

    @PostConstruct
    public void init() {
        System.out.println("2. @PostConstruct: Initialization logic after bean creation");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("3. @PreDestroy: Cleanup logic before bean is destroyed");
    }
}
