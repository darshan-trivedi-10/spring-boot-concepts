package com.learning.spring_boot.jpa.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/batch-insert/test")
    public String test(){
        deviceService.insertDevices();
        return "Done. Check Logs";
    }



}
