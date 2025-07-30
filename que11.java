//11. Create a class called Calculator which has 4 different methods add, diff, mul and div which 
//accepts two numbers as parameters. Create an object to access these methods and invoke 
//these methods with two numbers and display the result in the corresponding methods. 


// Package declaration
package javaAssignment;

// Question 11
class Calculator {
    public void add(int a, int b) {
        System.out.println("Addition: " + (a + b));
    }

    public void diff(int a, int b) {
        System.out.println("Difference: " + (a - b));
    }

    public void mul(int a, int b) {
        System.out.println("Multiplication: " + (a * b));
    }

    public void div(int a, int b) {
        if (b != 0)
            System.out.println("Division: " + (a / b));
        else
            System.out.println("Division by zero is not allowed.");
    }
}

public class que11 {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.add(10, 5);
        c.diff(10, 5);
        c.mul(10, 5);
        c.div(10, 5);
    }
}


