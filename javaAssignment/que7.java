//7.A student will not be allowed to sit in exam if his/her attendence is less than 70%.
//Take following input from user
//Number of classes held
//Number of classes attended.
//And print
//percentage of class attended
//Is student is allowed to sit in exam or not.


package javaAssignment;
import java.util.Scanner;

public class que7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number of classes held: ");
	        int held = sc.nextInt();

	        System.out.print("Enter number of classes attended: ");
	        int attended = sc.nextInt();

	        double percentage = (attended * 100.0) / held;

	        System.out.println("Attendance Percentage: " + percentage + "%");

	        if (percentage >= 70) {
	            System.out.println("Allowed to sit in exam.");
	        } else {
	            System.out.println("Not allowed to sit in exam.");
	        }

	}

}
