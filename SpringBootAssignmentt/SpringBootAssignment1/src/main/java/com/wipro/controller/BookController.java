package com.wipro.controller;

import com.wipro.model.Book;
import com.wipro.model.BookList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class BookController {

    @GetMapping(value = "/bookXYZ", produces = MediaType.APPLICATION_XML_VALUE)
    public BookList getBooks() {
        Book b1 = new Book(101, "Java Tutorials", "Vivek");
        Book b2 = new Book(102, "Spring Tutorials", "Ajay");
        Book b3 = new Book(103, "Angular Tutorials", "Girhare");
        return new BookList(Arrays.asList(b1, b2, b3));
    }
}
