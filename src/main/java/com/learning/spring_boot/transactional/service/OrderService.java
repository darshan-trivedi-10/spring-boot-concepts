package com.learning.spring_boot.transactional.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

@Service
public class OrderService {
    private final PlatformTransactionManager transactionManager;

    public OrderService(PlatformTransactionManager transactionManager){
        this.transactionManager = transactionManager;
    }

    public void PlaceOrder(){
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionAttribute());
        try {
            // db operations
            transactionManager.commit(status); // Manually commit transaction
        } catch (Exception e) {
            transactionManager.rollback(status); // Manually rollback transaction
        }
    }



}
