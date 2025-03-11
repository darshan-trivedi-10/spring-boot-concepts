package com.learning.spring_boot.transactional.service;

import com.learning.spring_boot.transactional.repository.AccountRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankingService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionLogService transactionLogService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private HealthCheckService healthCheckService;

    // ✅ MAIN TRANSACTION (Uses REQUIRED by default)
    @Transactional
    public void transferMoney(Long fromAccount, Long toAccount, Double amount) {
        try {
            System.out.println("🏦 Starting money transfer...");

            // Step 1: Debit money (REQUIRED)
            debitAccount(fromAccount, amount);

            // Step 2: Credit money (REQUIRES_NEW - Independent Transaction)
            creditAccount(toAccount, amount);

            // Step 3: Log Transaction (NESTED - Can rollback separately)
            transactionLogService.logTransaction(fromAccount, toAccount, amount);

            // Step 4: Send SMS Notification (SUPPORTS - Will join if transaction exists)
            notificationService.sendNotification(toAccount, "Money received!");

            // Step 5: Fetch exchange rate (NOT_SUPPORTED - Should run outside of a transaction)
            exchangeRateService.fetchExchangeRate();

            // Step 6: Validate transaction (MANDATORY - Should throw error if not in a transaction)
            validationService.validateTransaction(amount);

            // Step 7: Check System Health (NEVER - Should throw error if a transaction exists)
            healthCheckService.checkSystemHealth();

            System.out.println("✅ Money transfer completed successfully!");

        } catch (Exception e) {
            System.out.println("❌ Transaction failed: " + e.getMessage());
            throw e;
        }
    }

    // 🔹 REQUIRED (Joins existing transaction, or creates new one if none exists)
    @Transactional(propagation = Propagation.REQUIRED)
    public void debitAccount(Long accountId, Double amount) {
        System.out.println("💰 Debiting amount: " + amount);
        accountRepository.debit(accountId, amount);
    }

    // 🔹 REQUIRES_NEW (Starts a completely new transaction)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void creditAccount(Long accountId, Double amount) {
        System.out.println("💵 Crediting amount: " + amount);
        accountRepository.credit(accountId, amount);
        // Simulate failure
        if (amount > 5000) {
            throw new RuntimeException("❌ Credit transaction failed!");
        }
    }
}
