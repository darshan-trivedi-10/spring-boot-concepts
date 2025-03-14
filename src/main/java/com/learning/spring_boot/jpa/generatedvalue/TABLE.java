package com.learning.spring_boot.jpa.generatedvalue;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@TableGenerator(name = "user_table_gen", table = "id_generator", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "user_id", allocationSize = 1)
@Data
public class TABLE {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_table_gen")
    private Long id;
    private String name;
}