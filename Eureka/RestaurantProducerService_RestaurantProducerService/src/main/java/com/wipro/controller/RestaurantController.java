package com.wipro.controller;

import com.example.entity.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RestaurantController {

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants() {
        return Arrays.asList(
                new Restaurant(1L, "Dominos", "Delhi"),
                new Restaurant(2L, "Burger King", "Noida"),
                new Restaurant(3L, "Starbucks", "Gurgaon")
        );
    }
}
