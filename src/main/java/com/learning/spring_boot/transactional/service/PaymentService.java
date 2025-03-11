package com.learning.spring_boot.transactional.service;

import com.learning.spring_boot.transactional.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

@Service(value = "paymentServiceV2")
public class PaymentService {
    private final TransactionTemplate transactionTemplate;
    private final AccountRepository accountRepository;

    public PaymentService(TransactionTemplate transactionTemplate, AccountRepository accountRepository){
        this.transactionTemplate = transactionTemplate;
        this.accountRepository = accountRepository;
    }

    public void processPayment(Long fromAccountId, Long toAccountId, Double amount) {
        transactionTemplate.execute(status -> {
            try {
                // some db operations
                System.out.println("Hello");
            } catch (Exception e) {
                status.setRollbackOnly(); // Manually triggering rollback
            }
            return null;
        });
    }



}
