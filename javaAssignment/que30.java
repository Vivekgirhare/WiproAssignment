package javaAssignment;

import java.util.Scanner;

@FunctionalInterface
interface MinCalculator {
    float minimum3(float a, float b, float c);
}

public class que30 {
    public static float findMin(float a, float b, float c) {
        return Math.min(Math.min(a, b), c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        float num1 = sc.nextFloat();

        System.out.print("Enter second number: ");
        float num2 = sc.nextFloat();

        System.out.print("Enter third number: ");
        float num3 = sc.nextFloat();

        // Using method reference
        MinCalculator calc = que30::findMin;

        float min = calc.minimum3(num1, num2, num3);
        System.out.println("Smallest value is: " + min);
    }
}

