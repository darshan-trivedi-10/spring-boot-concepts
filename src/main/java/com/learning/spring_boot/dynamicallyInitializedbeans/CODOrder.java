package com.learning.spring_boot.dynamicallyInitializedbeans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("CODOrder")
public class CODOrder implements Order{
    @Override
    public void createOrder() {
        System.out.println("COD Order Created");
    }
}
