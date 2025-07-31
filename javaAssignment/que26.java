package javaAssignment;

import java.util.*;

public class que26 {
    public static void main(String[] args) {
        int[] input = {2, 3, 54, 1, 6, 7, 7};

        // Use LinkedHashSet to remove duplicates while maintaining insertion order
        Set<Integer> uniqueSet = new LinkedHashSet<>();
        for (int num : input) {
            uniqueSet.add(num);
        }

        int sumEven = 0;
        for (int num : uniqueSet) {
            if (num % 2 == 0) {
                sumEven += num;
            }
        }

        System.out.println("Sum of even numbers after removing duplicates: " + sumEven);
    }
}
