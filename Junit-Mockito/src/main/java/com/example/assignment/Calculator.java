package com.example.assignment;

public class Calculator {

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zerooo");
        }
        return a / b;
    }
}
