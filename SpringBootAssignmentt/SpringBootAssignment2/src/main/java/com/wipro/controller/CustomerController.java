package com.wipro.controller;

import com.wipro.model.Customer;
//import javax.validation.Valid;

import jakarta.validation.Valid;
//import jakarta.validation.constraints.NotBlank;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {
    @GetMapping("/form")
    public String showForm(Customer customer) {
        return "form";
    }

    @PostMapping("/form")
    public String submitForm(@Valid Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "form";
        }
        model.addAttribute("customer", customer);
        return "success";
    }
}
