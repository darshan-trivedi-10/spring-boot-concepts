package com.learning.spring_boot.aspectorientedprogramming;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public void processPayment(String userName, double amount){
        System.out.println("Processing Payment for " + userName + "amount is " + amount);
    }

    public void refundPayment(String userName, double amount){
        System.out.println("Refunding to " + userName + "amount is " + amount);
    }

    public void simulateError(String username) {
        System.out.println("Simulating an error for user: " + username);
        throw new RuntimeException("Simulated exception!");
    }
}
