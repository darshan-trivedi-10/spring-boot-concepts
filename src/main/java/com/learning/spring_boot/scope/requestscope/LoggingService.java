package com.learning.spring_boot.scope.requestscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {

    private final RequestContext requestContext;

    @Autowired
    public LoggingService(RequestContext requestContext){
        this.requestContext = requestContext;
    }

    public void log(String message){
        System.out.println("[" + requestContext.getRequestId() + "]" + message);
    }
}
