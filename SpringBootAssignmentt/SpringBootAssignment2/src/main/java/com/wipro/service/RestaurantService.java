package com.wipro.service;

import com.wipro.Daofiles.RestaurantRepository;
import com.wipro.Daofiles.FoodRepository;
import com.wipro.entity.Restaurant;
import com.wipro.entity.Food;
import com.wipro.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private FoodRepository foodRepository;

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id " + id));
    }

    public void deleteRestaurant(Long id) {
        Restaurant restaurant = getRestaurantById(id);
        restaurantRepository.delete(restaurant);
    }

    public Food addFoodToRestaurant(Long restaurantId, Food food) {
        Restaurant restaurant = getRestaurantById(restaurantId);
        food.setRestaurant(restaurant);
        return foodRepository.save(food);
    }

    public void deleteFood(Long foodId) {
        Food food = foodRepository.findById(foodId)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with id " + foodId));
        foodRepository.delete(food);
    }

    public List<Food> getFoodsByRestaurant(Long restaurantId) {
        Restaurant restaurant = getRestaurantById(restaurantId);
        return restaurant.getFoods();
    }
}
