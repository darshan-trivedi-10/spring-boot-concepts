package com.learning.spring_boot.springbootcontollerlayer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/say/hello")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/say/hello-world")
    @ResponseBody
    public String sayHelloWorld(){
        return "Hello World";
    }

}
