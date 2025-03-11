package com.learning.spring_boot.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Autowired
    private LoggingInterceptor loggingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(loggingInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/test", "/css/**", "/js/**", "/images/**", "/webjars/**", "/favicon.ico");
    }
}
