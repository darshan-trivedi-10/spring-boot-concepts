package com.learning.spring_boot.scope.prototype;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Component
@Scope("prototype")
public class TransactionIdGenerator {
    private String transactionId = UUID.randomUUID().toString();
}
