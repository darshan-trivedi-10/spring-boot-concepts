package com.learning.spring_boot.jpa.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public void insertDevices() {
        List<Device> devices = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            devices.add(new Device("Device " + i, "Sensor"));
        }

        long start = System.currentTimeMillis();
        deviceRepository.saveAll(devices);
        long end = System.currentTimeMillis();

        System.out.println("Time taken: " + (end - start) + " ms");
    }



}
