package com.learning.spring_boot.servlet;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@Configurable
public class ServletConfig {
//    @Bean
//    public ServletRegistrationBean<DemoServlet1> demoServlet(){
//        return new ServletRegistrationBean<>(new DemoServlet1(), "/health-check/*");
//    }
}
