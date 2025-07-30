package javaAssignment;

// Custom exception for invalid employee code
class InvalidEmployeeCodeException extends Exception {
    public InvalidEmployeeCodeException(String message) {
        super(message);
    }
}

class Employee {
    private String employeeID;
    private String name;

    public Employee(String employeeID, String name) {
        this.employeeID = employeeID;
        this.name = name;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    // Validate the employee code and throw exception if invalid
    public static void validateEmployeeCode(String code) throws InvalidEmployeeCodeException {
        if (code == null) {
            throw new InvalidEmployeeCodeException("Employee code cannot be null");
        }

        String[] parts = code.split("-");
        if (parts.length != 3) {
            throw new InvalidEmployeeCodeException("Employee code must have 3 parts separated by hyphens");
        }

        if (!parts[0].matches("\\d{2}")) {
            throw new InvalidEmployeeCodeException("Year part must be exactly 2 digits");
        }

        if (!parts[1].matches("[FS]")) {
            throw new InvalidEmployeeCodeException("Designation must be 'F' or 'S'");
        }

        if (!parts[2].matches("\\d{3}")) {
            throw new InvalidEmployeeCodeException("Number part must be exactly 3 digits");
        }
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + name);
    }
}

public class que35 {
    public static void main(String[] args) {
        // Example inputs (could be replaced with Scanner for user input)
        String id1 = "81-F-112";
        String name1 = "Alice Johnson";

        String id2 = "79-S254X";
        String name2 = "Bob Smith";

        try {
            Employee.validateEmployeeCode(id1);
            Employee emp1 = new Employee(id1, name1);
            System.out.println("Employee created successfully.");
            emp1.displayDetails();
        } catch (InvalidEmployeeCodeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();

        try {
            Employee.validateEmployeeCode(id2);
            Employee emp2 = new Employee(id2, name2);
            System.out.println("Employee created successfully.");
            emp2.displayDetails();
        } catch (InvalidEmployeeCodeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

