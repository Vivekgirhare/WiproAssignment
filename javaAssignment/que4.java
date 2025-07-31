//4.Take name, roll number and field of interest from user and print in the format below :
//Hey, my name is xyz and my roll number is xyz. My field of interest are xyz.

package javaAssignment;
import java.util.Scanner;

public class que4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your roll number: ");
        int roll = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter your field of interest: ");
        String interest = sc.nextLine();

        System.out.println("Hey, my name is " + name + " and my roll number is " + roll + ". My field of interest are " + interest + ".");

	}

}
