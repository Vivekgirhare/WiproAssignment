package javaAssignment;

public class que34 {
    // Employee attributes
    private String employeeID;  // format: year-designation-number, eg. "81-F-112"
    private String name;
    private int yearOfBirth;

    public que34(String employeeID, String name, int yearOfBirth) {
        this.employeeID = employeeID;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    // getters
    public String getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    // validate employeeID format
    public boolean isValidEmployeeCode() {
        // employeeID should be in format "yy-X-nnn"
        // where yy are two digits for year,
        // X is single letter 'F' or 'S',
        // nnn is three digits number
        
        if (employeeID == null) return false;

        String[] parts = employeeID.split("-");
        if(parts.length != 3) return false;

        // Check year part: exactly 2 digits
        if(!parts[0].matches("\\d{2}")) return false;

        // Check designation: 'F' or 'S'
        if(!parts[1].matches("[FS]")) return false;

        // Check number part: 3 digits
        if(!parts[2].matches("\\d{3}")) return false;

        return true;
    }

    // Display Employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + name);
        System.out.println("Year of Birth: " + yearOfBirth);
    }

    // test main method
    public static void main(String[] args) {
        que34 emp1 = new que34("81-F-112", "John Doe", 1981);
        if(emp1.isValidEmployeeCode()) {
            emp1.displayDetails();
            System.out.println("Employee code is valid.");
        } else {
            System.out.println("Employee code is invalid.");
        }

        que34 emp2 = new que34("79-S254", "Jane Smith", 1979);
        if(emp2.isValidEmployeeCode()) {
            emp2.displayDetails();
            System.out.println("Employee code is valid.");
        } else {
            System.out.println("Employee code is invalid.");
        }
    }
}
