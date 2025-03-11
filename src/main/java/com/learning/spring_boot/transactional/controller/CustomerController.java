package com.learning.spring_boot.transactional.controller;

import com.learning.spring_boot.transactional.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactional")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/create")
    public String createUser(@RequestParam String name, @RequestParam double balance) {
        customerService.createUser(name, balance);
        return "User created successfully";
    }

    @GetMapping("/create-with-exception")
    public String createUserWithException(@RequestParam String name, @RequestParam double balance) {
        try {
            customerService.createUserWithException(name, balance);
        } catch (Exception e) {
            return "Transaction Rolled Back: " + e.getMessage();
        }
        return "User created successfully";
    }


}
