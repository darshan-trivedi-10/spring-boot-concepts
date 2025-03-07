package com.learning.spring_boot.springbeans;

import org.springframework.stereotype.Component;

//@Component // This will throw an bean creation error
public class UserBean {
    private String userName;
    private String email;

    public UserBean(String userName, String email){
        this.userName = userName;
        this.email = email;
    }

}
