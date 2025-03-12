package com.learning.spring_boot.filter;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
// Spring Boot automatically registers filters marked with @Component.
public class CustomFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Inside Custom Filter: Request Intercepted");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Inside Custom Filter: Response Intercepted");
    }

}
