//1.Write a program to add 8 to the number 2345 and then divide it by 3. Now, the modulus of the quotient is taken with 5 and then multiply the resultant value by 5. Display the final result.

package javaAssignment;

public class que1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 2345;

        int step1 = num + 8;       // Add 8
        int step2 = step1 / 3;     // Divide by 3
        int step3 = step2 % 5;     // Modulus with 5
        int result = step3 * 5;    // Multiply by 5

        System.out.println("Final Result: " + result);

	}

}
