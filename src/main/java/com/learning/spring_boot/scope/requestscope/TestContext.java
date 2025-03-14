package com.learning.spring_boot.scope.requestscope;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.lang.reflect.Proxy;
import java.util.UUID;

@Component
@RequestScope
@Getter
public class TestContext {
    private final String requestId;

    public TestContext(){
        requestId = UUID.randomUUID().toString();
    }
}

