package javaAssignment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class que31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // InputMismatchException demo
        try {
            System.out.print("Enter an integer: ");
            int number = sc.nextInt(); // throws exception if input is not an int
            System.out.println("You entered: " + number);
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException: You must enter an integer!");
        }

        // StringIndexOutOfBoundsException demo
        try {
            String str = "Java";
            System.out.println("Character at index 5: " + str.charAt(5)); // invalid index
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException: Invalid string index accessed!");
        }

        System.out.println("Program continues after exception handling...");
    }
}
