package javaAssignment;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class que29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Register Number: ");
            String regNo = sc.nextLine();

            if (regNo.length() != 9)
                throw new IllegalArgumentException("Register Number must be exactly 9 characters");

            System.out.print("Enter Mobile Number: ");
            String mobNo = sc.nextLine();

            if (mobNo.length() != 10)
                throw new IllegalArgumentException("Mobile Number must be exactly 10 characters");

            if (!mobNo.matches("\\d+"))
                throw new IllegalArgumentException("Mobile Number must contain only digits"); // Just use IllegalArgumentException

            if (!regNo.matches("[a-zA-Z0-9]+"))
                throw new NoSuchElementException("Register Number must contain only digits and alphabets");

            System.out.println("valid");
        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println("invalid: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}



