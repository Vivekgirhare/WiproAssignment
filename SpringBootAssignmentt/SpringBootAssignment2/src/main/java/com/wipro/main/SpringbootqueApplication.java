package com.wipro.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootqueApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootqueApplication.class, args);
    }
}

//
//#GET all posts: GET http://localhost:8080/api/posts
//#
//#GET post by ID: GET http://localhost:8080/api/posts/1
//#
//#CREATE post: POST http://localhost:8080/api/posts (JSON body)
//#
//#UPDATE post: PUT http://localhost:8080/api/posts/1 (JSON body)
//#
//#DELETE post: DELETE http://localhost:8080/api/posts/1