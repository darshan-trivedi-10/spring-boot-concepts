package com.learning.spring_boot.dynamicallyInitializedbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class User {

    @Autowired
    @Qualifier("onlinePaymentOrder")
    private Order order;

    @PostMapping
    public ResponseEntity<String> createOrder(){
        order.createOrder();
        return ResponseEntity.ok("Order Created");
    }

}
