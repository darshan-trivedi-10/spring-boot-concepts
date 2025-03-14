package com.learning.spring_boot.jpa.compositekeyclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
}
