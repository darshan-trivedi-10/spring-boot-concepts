package com.learning.spring_boot.jpa;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "People")
@Data
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;
}
