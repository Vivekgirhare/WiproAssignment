package com.wipro.feignclient;


import com.wipro.entity.Restaurant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "restaurant-producer")
public interface RestaurantProducerClient {
    @GetMapping("/restaurants")
    List<Restaurant> getAllRestaurants();
}
