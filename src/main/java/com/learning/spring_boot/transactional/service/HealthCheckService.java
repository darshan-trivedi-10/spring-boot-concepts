package com.learning.spring_boot.transactional.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HealthCheckService {
    @Transactional(propagation = Propagation.NEVER)
    public void checkSystemHealth() {
        System.out.println("💻 Performing system health check...");
    }
}
