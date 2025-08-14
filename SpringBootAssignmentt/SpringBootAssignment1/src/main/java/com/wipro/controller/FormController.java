package com.wipro.controller;

import com.wipro.model.Student;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @GetMapping("/")
    public String showForm(Student student) {
        return "enrollmentForm";
    }

    @PostMapping("/")
    public String submitForm(@Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "enrollmentForm";
        }
        model.addAttribute("student", student);
        return "success";
    }
}
