package com.wipro.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PropertyDemoController {

    @Value("${app.example.integer-value}")
    private Integer valueInteger;

    @Value("${app.example.decimal-value}")
    private Double valueDouble;

    @Value("${app.example.boolean-value}")
    private Boolean valueBoolean;

    @GetMapping("/api/properties")
    public Map<String, Object> getProperties() {
        return Map.of(
                "integerValue", valueInteger,
                "decimalValue", valueDouble,
                "booleanValue", valueBoolean
        );
    }
}
