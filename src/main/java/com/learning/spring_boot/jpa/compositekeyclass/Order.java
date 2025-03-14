package com.learning.spring_boot.jpa.compositekeyclass;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
// We can also use  @IdClass for Composite Key
public class Order {
    @EmbeddedId
    private OrderId orderId;
    private String productName;
}