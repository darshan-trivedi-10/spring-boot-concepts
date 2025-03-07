package com.learning.spring_boot.scope.sessionscope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
// We can also use @SessionScope
public class ShoppingCart {
    private final List<String> items = new ArrayList<>();

    public void addItem(String item){
        items.add(item);
    }

    public List<String> getItems(){
        return items;
    }

    public void clearCart(){
        items.clear();
    }
}
