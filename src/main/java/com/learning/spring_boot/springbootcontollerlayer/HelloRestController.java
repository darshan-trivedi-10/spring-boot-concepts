package com.learning.spring_boot.springbootcontollerlayer;

import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloRestController {
    @InitBinder
    protected void initBinder(DataBinder dataBinder){
        dataBinder.registerCustomEditor(String.class, "message", new firstMessagePropertyEditor());
    }

    @GetMapping("/say/rest/hello")
    public String sayRestHello(){
        return "Hello";
    }

    @GetMapping("/say/rest/hello-world")
    public String sayRestHelloWorld(){
        return "Hello World";
    }

    @GetMapping("/say/rest/custom")
    public String sayRestCustomReplay(@RequestParam(name = "message") String message){
        return message;
    }

}
