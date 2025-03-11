package com.learning.spring_boot.transactional.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExchangeRateService {
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void fetchExchangeRate() {
        System.out.println("🌍 Fetching exchange rate (no transaction involved)...");
    }
}
