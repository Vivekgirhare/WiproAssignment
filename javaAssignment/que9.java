
//9.A shopkeeper sells three products whose retail prices are as follows: 
//Product 1 - 22.50
//              Product 2 - 44.50 
//              Product 3 - 9.98
//Write an application that reads a series of pairs of numbers as follows:
// a) Product number 
// b) Quantity sold
//
//                The application should use a switch statement to determine the retail price for each product. It 
//should calculate and display the total retail value of all products sold. 


package javaAssignment;

import java.util.Scanner;

public class que9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        char choice;

        do {
            System.out.print("Enter product number (1, 2, or 3): ");
            int product = sc.nextInt();

            System.out.print("Enter quantity sold: ");
            int quantity = sc.nextInt();

            switch (product) {
                case 1:
                    total += 22.50 * quantity;
                    break;
                case 2:
                    total += 44.50 * quantity;
                    break;
                case 3:
                    total += 9.98 * quantity;
                    break;
                default:
                    System.out.println("Invalid product number.");
            }

            System.out.print("Do you want to add more products? (Y/N): ");
            choice = sc.next().charAt(0);
        } while (choice == 'Y' || choice == 'y');

        System.out.println("Total retail value: ₹" + total);
    }
}
