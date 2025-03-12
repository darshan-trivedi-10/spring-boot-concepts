package com.learning.spring_boot.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("LoggingFilter: Request Processing Started");
        chain.doFilter(request, response);
        System.out.println("LoggingFilter: Response Processing Done");
    }

}
