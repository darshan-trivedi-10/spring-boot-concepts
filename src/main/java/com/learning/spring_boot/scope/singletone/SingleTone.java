package com.learning.spring_boot.scope.singletone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/single-tone")
public class SingleTone {

    @GetMapping("/")
    public String singleToneReplay(){
        return "I'm Single Tone";
    }

}
