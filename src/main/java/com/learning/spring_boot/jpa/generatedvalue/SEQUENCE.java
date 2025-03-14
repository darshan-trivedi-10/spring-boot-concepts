package com.learning.spring_boot.jpa.generatedvalue;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
@Data
public class SEQUENCE {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;
    private String name;
}
