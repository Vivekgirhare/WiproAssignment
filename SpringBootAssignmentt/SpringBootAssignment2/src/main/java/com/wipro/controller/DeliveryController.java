package com.wipro.controller;

import com.wipro.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery-client")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/status")
    public String getDeliveryStatus() {
        return deliveryService.getDeliveryStatus();
    }
}
