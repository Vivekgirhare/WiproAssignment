package com.wipro.controller;

import com.wipro.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public User createUser(@RequestBody User user) {
        // For demonstration, simply return the user object back.
        // In a real application, you might save this to the database.
        return user;
    }
}
