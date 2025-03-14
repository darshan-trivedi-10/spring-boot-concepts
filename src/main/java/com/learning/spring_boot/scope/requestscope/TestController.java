package com.learning.spring_boot.scope.requestscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    private TestContext testContext;

    @Autowired
    public TestController(TestContext testContext){
        this.testContext = testContext;
    }

    @GetMapping("/test/hashcode")
    public void print(){
        System.out.println("DBT :: " + this.hashCode() + " :: " + testContext.hashCode());
        System.out.println(testContext.getRequestId());
    }
}