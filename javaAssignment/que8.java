//8.Modify the above question to allow student to sit if he/she has medical cause. Ask user if he/she has medical cause or not ( 'Y' or 'N' ) and print accordingly.


package javaAssignment;
import java.util.Scanner;

public class que8 {

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
            System.out.print("Do you have a medical cause? (Y/N): ");
            char cause = sc.next().charAt(0);

            if (cause == 'Y' || cause == 'y') {
                System.out.println("Allowed to sit in exam due to medical cause.");
            } else {
                System.out.println("Not allowed to sit in exam.");
            }

	}

}
}
