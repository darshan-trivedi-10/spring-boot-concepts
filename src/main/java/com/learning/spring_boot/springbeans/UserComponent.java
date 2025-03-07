package com.learning.spring_boot.springbeans;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserComponent {
    private String userName;
    private String email;
}
