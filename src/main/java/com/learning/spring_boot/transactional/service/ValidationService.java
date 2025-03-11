package com.learning.spring_boot.transactional.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ValidationService {
    @Transactional(propagation = Propagation.MANDATORY)
    public void validateTransaction(Double amount) {
        System.out.println("🔍 Validating transaction...");
    }
}
