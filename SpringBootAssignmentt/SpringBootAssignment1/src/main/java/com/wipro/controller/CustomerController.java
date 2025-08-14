package com.wipro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbootprograms.Customer;

import jakarta.validation.Valid;

@Controller
//@RequestMapping("/wiproassignments")
public class CustomerController {

	 @GetMapping("/custform")
	    public String showForm(Model model) {
	        model.addAttribute("customer", new Customer());
	        return "customerForm";
	    }

	    @PostMapping("/save")
	    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer,
	                               BindingResult result) {
	        if (result.hasErrors()) {
	            return "customerForm";
	        }
	        return "customersuccess"; 
	    }
}