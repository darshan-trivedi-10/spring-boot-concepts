package com.learning.spring_boot.transactional.service;

import com.learning.spring_boot.transactional.entity.Customer;
import com.learning.spring_boot.transactional.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void createUser(String name, double amount){
        Customer customer = new Customer(null, name, amount);
        customerRepository.save(customer);
    }

    @Transactional
    public void createUserWithException(String name, double amount){
        Customer customer = new Customer(null, name, amount);
        customerRepository.save(customer);

        if (amount < 0) {
            throw new RuntimeException("Balance cannot be negative");
        }
    }

    @Transactional
    public void createUserWithPropagation(String name, double amount) {
        Customer customer = new Customer(null, name, amount);
        customerRepository.save(customer);
        updateUserBalance(1L, 500.0);
    }

    @Transactional
    public void updateUserBalance(Long userId, double newAmount) {
        Customer customer = customerRepository.findById(userId).orElseThrow();
        customer.setAmount(newAmount);
        customerRepository.save(customer);
    }
}
