package com.learning.spring_boot.dynamicallyInitializedbeans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("onlinePaymentOrder")
public class OnlinePaymentOrder implements Order{
    @Override
    public void createOrder() {
        System.out.println("Online Payment Order Created");
    }
}
