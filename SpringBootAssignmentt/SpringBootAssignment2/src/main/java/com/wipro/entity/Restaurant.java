package com.wipro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Restaurant name must not be blank")
    private String name;

    @NotBlank(message = "Restaurant location must not be blank")
    private String location;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Food> foods = new ArrayList<>();

    // Constructors, Getters, Setters

    public Restaurant() {}

    public Restaurant(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    // Getters and setters...

    public void addFood(Food food) {
        foods.add(food);
        food.setRestaurant(this);
    }

    public void removeFood(Food food) {
        foods.remove(food);
        food.setRestaurant(null);
    }
    // toString (optional)

	public List<Food> getFoods() {
		// TODO Auto-generated method stub
		return null;
	}
}
