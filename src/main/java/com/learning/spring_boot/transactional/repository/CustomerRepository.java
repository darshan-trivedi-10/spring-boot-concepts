package com.learning.spring_boot.transactional.repository;

import com.learning.spring_boot.transactional.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
