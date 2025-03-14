package com.learning.spring_boot.jpa.compositekeyclass;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.Objects;

@Embeddable
@Data
public class OrderId {
    private Long orderId;
    private Long customerId;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrderId orderId1))
            return false;
        return Objects.equals(getOrderId(), orderId1.getOrderId()) && Objects.equals(getCustomerId(), orderId1.getCustomerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getCustomerId());
    }
}