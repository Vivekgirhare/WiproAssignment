package javaAssignment;
import java.util.Scanner;

public class que24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] speeds = new int[5];
        int sum = 0;

        // Input speeds
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter speed of biker " + (i + 1) + ": ");
            speeds[i] = sc.nextInt();
            sum += speeds[i];
        }

        double average = sum / 5.0;
        System.out.println("\nAverage speed: " + average);
        System.out.println("Qualifying bikers (speed > average):");

        for (int i = 0; i < 5; i++) {
            if (speeds[i] > average) {
                System.out.println("Biker " + (i + 1) + ": " + speeds[i] + " km/h");
            }
        }
    }
}
