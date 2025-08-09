package com.wipro.controller;


import com.example.entity.Restaurant;
import com.wipro.feignclient.RestaurantProducerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class RestaurantConsumerController {
    @Autowired
    private RestaurantProducerClient producerClient;

    @GetMapping("/consumer/restaurants")
    public List<Restaurant> getRestaurants() {
        return producerClient.getAllRestaurants();
    }
}