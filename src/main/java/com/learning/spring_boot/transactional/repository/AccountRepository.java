package com.learning.spring_boot.transactional.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {
    public void debit(Long accountId, Double amount) {
    }

    public void credit(Long accountId, Double amount) {
    }
}
