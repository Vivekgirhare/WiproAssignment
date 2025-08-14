package com.wipro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Food name must not be blank")
    private String name;

    @NotNull(message = "Food price must not be null")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    // Constructors, Getters, Setters

    public Food() {}

    public Food(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

	public void setRestaurant(Restaurant restaurant2) {
		// TODO Auto-generated method stub
		
	}

    // Getters and setters...
}
