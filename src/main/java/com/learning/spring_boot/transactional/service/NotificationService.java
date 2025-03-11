package com.learning.spring_boot.transactional.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService {
    @Transactional(propagation = Propagation.SUPPORTS)
    public void sendNotification(Long accountId, String message) {
        System.out.println("📩 Sending notification: " + message);
    }
}
