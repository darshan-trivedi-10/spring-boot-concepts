package com.learning.spring_boot.jpa.test;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;

    public Device(String name, String type) {
        this.name = name;
        this.type = type;
    }


}
