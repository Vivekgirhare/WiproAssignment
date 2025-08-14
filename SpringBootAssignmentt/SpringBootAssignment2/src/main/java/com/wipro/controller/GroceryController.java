package com.wipro.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grocery")
public class GroceryController {

    @GetMapping("/public")
    public String publicMessage() {
        return "Welcome to the Grocery Store! (Public Access)";
    }

    @GetMapping("/items")
    public List<String> getItems() {
        return List.of("Apples", "Bananas", "Carrots", "Dates");
    }

    @GetMapping("/orders")
    public List<String> getOrders() {
        return List.of("Order#1: Apples x5", "Order#2: Bananas x3");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/report")
    public String adminReport() {
        return "📊 Grocery Store Sales Report (ADMIN Access Only)";
    }
}
