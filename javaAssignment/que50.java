package javaAssignment;

import java.util.*;
import java.util.stream.Collectors;

public class que50 {

    // Employee class defined as static inner class for simplicity
    static class Employee {
        private final int id;
        private final String name;
        private final String department;
        private final double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return String.format("Employee{id=%d, name='%s', dept='%s', salary=%.2f}", id, name, department, salary);
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(101, "Ravi", "HR", 50000),
            new Employee(102, "Priya", "IT", 60000),
            new Employee(103, "Arun", "HR", 55000),
            new Employee(104, "Kavya", "IT", 70000),
            new Employee(105, "Divya", "Sales", 45000)
        );

        // Q1. Print all employee names using Stream
        System.out.println("Q1: Employee names:");
        employees.stream()
                 .map(Employee::getName)
                 .forEach(System.out::println);

        // Q2. Filter and print employees with salary > 55000
        System.out.println("\nQ2: Employees with salary > 55000:");
        employees.stream()
                 .filter(e -> e.getSalary() > 55000)
                 .forEach(System.out::println);

        // Q3. Count the number of employees in "HR" department
        long hrCount = employees.stream()
                                .filter(e -> "HR".equalsIgnoreCase(e.getDepartment()))
                                .count();
        System.out.println("\nQ3: Number of employees in HR: " + hrCount);

        // Q4. Sort employees by salary in descending order
        System.out.println("\nQ4: Employees sorted by salary (desc):");
        employees.stream()
                 .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                 .forEach(System.out::println);

        // Q5. Find the highest paid employee (use max)
        Optional<Employee> highestPaid = employees.stream()
                                                  .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("\nQ5: Highest paid employee:");
        highestPaid.ifPresent(System.out::println);

        // Q6. Find the average salary of all employees
        double avgSalary = employees.stream()
                                    .mapToDouble(Employee::getSalary)
                                    .average()
                                    .orElse(0);
        System.out.println("\nQ6: Average salary: " + avgSalary);

        // Q7. Collect all names into a List
        List<String> namesList = employees.stream()
                                          .map(Employee::getName)
                                          .collect(Collectors.toList());
        System.out.println("\nQ7: All employee names as list: " + namesList);

        // Q8. Group employees by department (use Collectors.groupingBy)
        Map<String, List<Employee>> groupByDept = employees.stream()
                                                           .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("\nQ8: Employees grouped by department:");
        groupByDept.forEach((dept, emps) -> {
            System.out.println(dept + ": " + emps);
        });

        // Q9. Calculate total salary per department
        Map<String, Double> totalSalaryPerDept = employees.stream()
                                                          .collect(Collectors.groupingBy(
                                                              Employee::getDepartment,
                                                              Collectors.summingDouble(Employee::getSalary)));
        System.out.println("\nQ9: Total salary per department:");
        totalSalaryPerDept.forEach((dept, totalSal) -> {
            System.out.println(dept + ": " + totalSal);
        });

        // Q10. Find names of employees in IT department sorted by salary
        System.out.println("\nQ10: IT department employee names sorted by salary:");
        employees.stream()
                 .filter(e -> "IT".equalsIgnoreCase(e.getDepartment()))
                 .sorted(Comparator.comparingDouble(Employee::getSalary))
                 .map(Employee::getName)
                 .forEach(System.out::println);

        // Q11. Check if any employee earns less than 40000
        boolean anyLessThan40000 = employees.stream()
                                            .anyMatch(e -> e.getSalary() < 40000);
        System.out.println("\nQ11: Any employee earns less than 40000? " + anyLessThan40000);

        // Q12. Get a comma-separated string of all employee names
        String commaSeparatedNames = employees.stream()
                                             .map(Employee::getName)
                                             .collect(Collectors.joining(", "));
        System.out.println("\nQ12: Comma-separated employee names:");
        System.out.println(commaSeparatedNames);

        // Q13. Get a list of top 2 highest earning employees
        System.out.println("\nQ13: Top 2 highest earning employees:");
        List<Employee> top2 = employees.stream()
                                      .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                      .limit(2)
                                      .collect(Collectors.toList());
        top2.forEach(System.out::println);

        // Q14. Skip first 2 employees and print the rest
        System.out.println("\nQ14: Employees after skipping first 2:");
        employees.stream()
                 .skip(2)
                 .forEach(System.out::println);

        // Q15. Limit to first 3 employees and print their names
        System.out.println("\nQ15: First 3 employees' names:");
        employees.stream()
                 .limit(3)
                 .map(Employee::getName)
                 .forEach(System.out::println);

        // Q16. Get employee with minimum salary in HR department
        Optional<Employee> minHrSalaryEmp = employees.stream()
                                                    .filter(e -> "HR".equalsIgnoreCase(e.getDepartment()))
                                                    .min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("\nQ16: Employee with minimum salary in HR:");
        minHrSalaryEmp.ifPresent(System.out::println);

        // Q17. Partition employees into two groups: salary > 55000 and <= 55000
        Map<Boolean, List<Employee>> partitioned = employees.stream()
                                                           .collect(Collectors.partitioningBy(e -> e.getSalary() > 55000));
        System.out.println("\nQ17: Employees partitioned by salary > 55000:");
        System.out.println("Salary > 55000: " + partitioned.get(true));
        System.out.println("Salary <= 55000: " + partitioned.get(false));

        // Q18. Create a Map<Department, AverageSalary>
        Map<String, Double> avgSalaryPerDept = employees.stream()
                                                       .collect(Collectors.groupingBy(
                                                           Employee::getDepartment,
                                                           Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("\nQ18: Average salary per department:");
        avgSalaryPerDept.forEach((dept, avgSal) -> System.out.println(dept + ": " + avgSal));

        // Q19. Sort employees by name and then by salary
        System.out.println("\nQ19: Employees sorted by name then salary:");
        employees.stream()
                 .sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary))
                 .forEach(System.out::println);

        // Q20. Convert List<Employee> into Map<Id, Name>
        Map<Integer, String> idNameMap = employees.stream()
                                                 .collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println("\nQ20: Map of Employee ID to Name:");
        idNameMap.forEach((id, name) -> System.out.println(id + " -> " + name));

        // 🔹 Challenge 1: Get employees whose name starts with “D” and ends with “a”
        System.out.println("\nChallenge 1: Employees whose names start with 'D' and end with 'a':");
        employees.stream()
                 .filter(e -> e.getName().startsWith("D") && e.getName().endsWith("a"))
                 .forEach(System.out::println);

        // 🔹 Challenge 2: List departments with more than 1 employee
        System.out.println("\nChallenge 2: Departments with more than 1 employee:");
        groupByDept.entrySet().stream()
                   .filter(entry -> entry.getValue().size() > 1)
                   .map(Map.Entry::getKey)
                   .forEach(System.out::println);

        // 🔹 Challenge 3: Find the second highest salary using streams
        System.out.println("\nChallenge 3: Second highest salary:");
        employees.stream()
                 .map(Employee::getSalary)
                 .distinct()
                 .sorted(Comparator.reverseOrder())
                 .skip(1)
                 .findFirst()
                 .ifPresentOrElse(
                     salary -> System.out.println("Second highest salary: " + salary),
                     () -> System.out.println("No second highest salary found")
                 );
    }
}

