package com.learning.spring_boot.scope.prototype;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private ObjectProvider<TransactionIdGenerator> transactionIdProvider;

    @GetMapping("/new")
    public String getNewTransaction() {
        return "Transaction ID: " + transactionIdProvider.getObject().getTransactionId();
    }
}
