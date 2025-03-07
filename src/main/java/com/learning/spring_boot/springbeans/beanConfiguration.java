package com.learning.spring_boot.springbeans;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class beanConfiguration {

    @Bean
    public UserBean createUserBean(){
        return new UserBean("d.t", "dt@dt.com");
    }

}
