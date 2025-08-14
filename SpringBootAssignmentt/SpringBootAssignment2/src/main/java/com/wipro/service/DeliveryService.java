package com.wipro.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeliveryService {

    @Value("${external.delivery.api.url}")
    private String deliveryApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    @CircuitBreaker(name = "deliveryService", fallbackMethod = "fallbackDeliveryStatus")
    public String getDeliveryStatus() {
        // Calling the external API
        return restTemplate.getForObject(deliveryApiUrl, String.class);
    }

    // Fallback method
    public String fallbackDeliveryStatus(Throwable throwable) {
        return "Delivery status currently unavailable, please try again later! (Fallback triggered)";
    }
}
