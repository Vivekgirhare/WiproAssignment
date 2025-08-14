package com.wipro.service;

import com.wipro.Daofiles.GroceryItemRepository;
import com.wipro.entity.GroceryItem;
import com.wipro.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroceryItemService {

    @Autowired
    private GroceryItemRepository repository;

    public List<GroceryItem> getAllItems() {
        return repository.findAll();
    }

    public GroceryItem getItemById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grocery item not found with id: " + id));
    }

    public GroceryItem createItem(GroceryItem item) {
        return repository.save(item);
    }

    public GroceryItem updateItem(Long id, GroceryItem item) {
        GroceryItem existing = getItemById(id);
        existing.setName(item.getName());
        existing.setQuantity(item.getQuantity());
        existing.setPrice(item.getPrice());
        return repository.save(existing);
    }

    public void deleteItem(Long id) {
        GroceryItem existing = getItemById(id);
        repository.delete(existing);
    }
}
