package com.example.assignment;

public class Loginvalidator{

    public static boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username or password cannot be null");
        }
        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Username or password cannot be empty");
        }
        return username.equals("admin") && password.equals("password123");
    }
}