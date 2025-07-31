package javaAssignment;

enum Currency {
    USD, EUR, GBP, INR, AUD, CAD
}

public class que27 {
    public static void main(String[] args) {
        for (Currency c : Currency.values()) {
            System.out.println(c);
            switch(c) {
                case USD:
                    System.out.println("United States Dollar");
                    break;
                case EUR:
                    System.out.println("Euro");
                    break;
                case GBP:
                    System.out.println("British Pound");
                    break;
                case INR:
                    System.out.println("Indian Rupee");
                    break;
                case AUD:
                    System.out.println("Australian Dollar");
                    break;
                case CAD:
                    System.out.println("Canadian Dollar");
                    break;
                default:
                    System.out.println("Unknown currency");
            }
        }
    }
}

