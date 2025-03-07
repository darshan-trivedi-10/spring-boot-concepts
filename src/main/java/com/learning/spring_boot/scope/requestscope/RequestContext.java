package com.learning.spring_boot.scope.requestscope;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
//@RequestScope // we can also use this instead of @Scope
@Getter
public class RequestContext {
    private final String requestId;

    public RequestContext(){
        requestId = UUID.randomUUID().toString();
    }
}
