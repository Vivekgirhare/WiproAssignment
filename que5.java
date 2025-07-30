//5.A company decided to give bonus of 10% to employee if his/her year of service is more than 6 years.
//Ask user for their salary and year of service and print the net bonus amount.

package javaAssignment;
import java.util.Scanner;

public class que5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter your years of service: ");
        int years = sc.nextInt();

        if (years > 6) {
            double bonus = salary * 0.10;
            System.out.println("You get a bonus of: " + bonus);
        } else {
            System.out.println("No bonus, service must be more than 6 years.");

	}

	}
}
