package com.learning.spring_boot.transactional.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionLogService {
//    @Autowired
//    private TransactionLogRepository logRepository;

    @Transactional(propagation = Propagation.NESTED)
    public void logTransaction(Long fromAccount, Long toAccount, Double amount) {
        System.out.println("📝 Logging transaction...");
//        logRepository.save(new TransactionLog(fromAccount, toAccount, amount));
        // Simulate failure
        if (amount > 7000) {
            throw new RuntimeException("❌ Logging failed, but main transaction can continue.");
        }
    }
}
