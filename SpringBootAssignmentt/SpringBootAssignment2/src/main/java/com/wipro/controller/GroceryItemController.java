package com.wipro.controller;

import com.wipro.entity.GroceryItem;
import com.wipro.service.GroceryItemService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/grocery-items")
public class GroceryItemController {

    @Autowired
    private GroceryItemService service;

    @GetMapping
    public List<GroceryItem> getAll() {
        return service.getAllItems();
    }

    @GetMapping("/{id}")
    public GroceryItem getById(@PathVariable Long id) {
        return service.getItemById(id);
    }

    @PostMapping
    public GroceryItem create(@Valid @RequestBody GroceryItem item) {
        return service.createItem(item);
    }

    @PutMapping("/{id}")
    public GroceryItem update(@PathVariable Long id, @Valid @RequestBody GroceryItem item) {
        return service.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteItem(id);
    }
}
