package model;

import model.*;
import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product(1L, "Java Book", "Books", 120.0),
            new Product(2L, "Baby Lotion", "Baby", 80.0),
            new Product(3L, "Soft Toy", "Toys", 200.0),
            new Product(4L, "Kids Book", "Books", 90.0),
            new Product(5L, "Action Figure", "Toys", 400.0)
        );

        List<Customer> customers = Arrays.asList(
            new Customer(1L, "John", 1),
            new Customer(2L, "Tony", 2),
            new Customer(3L, "Charlie", 2)
        );

        List<Order> orders = Arrays.asList(
            new Order(101L, "Delivered", LocalDate.of(2021, 2, 15), LocalDate.of(2021, 2, 20), Arrays.asList(products.get(0), products.get(2)), customers.get(1)),
            new Order(102L, "Pending", LocalDate.of(2021, 3, 10), LocalDate.of(2021, 3, 15), Arrays.asList(products.get(1), products.get(4)), customers.get(2)),
            new Order(103L, "Shipped", LocalDate.of(2021, 1, 5), LocalDate.of(2021, 1, 10), Arrays.asList(products.get(3)), customers.get(0)),
            new Order(104L, "Delivered", LocalDate.of(2021, 2, 25), LocalDate.of(2021, 3, 1), Arrays.asList(products.get(2), products.get(4)), customers.get(1))
        );

        System.out.println("1. Books with price > 100:");
        products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books") && p.getPrice() > 100)
                .forEach(System.out::println);

        System.out.println("\n2. Orders with Baby products:");
        orders.stream()
                .filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby")))
                .forEach(System.out::println);

        System.out.println("\n3. Toys after 10% discount:");
        products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
                .map(p -> {
                    p.setPrice(p.getPrice() * 0.9);
                    return p;
                }).forEach(System.out::println);

        System.out.println("\n4. Products from Tier 2 customers between Feb-Apr 2021:");
        orders.stream()
                .filter(o -> o.getCustomer().getTier() == 2)
                .filter(o -> o.getOrderDate().isAfter(LocalDate.of(2021, 1, 31)) &&
                             o.getOrderDate().isBefore(LocalDate.of(2021, 4, 2)))
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n5. Cheapest Book:");
        products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .sorted(Comparator.comparing(Product::getPrice))
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("\n6. 3 Most recent orders:");
        orders.stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\n7. Total order value in Feb 2021:");
        double total = orders.stream()
                .filter(o -> o.getOrderDate().getMonth() == Month.FEBRUARY)
                .flatMap(o -> o.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("₹" + total);

        System.out.println("\n8. Book category statistics:");
        DoubleSummaryStatistics stats = products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .mapToDouble(Product::getPrice)
                .summaryStatistics();
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: ₹" + stats.getSum());
        System.out.println("Average: ₹" + stats.getAverage());
        System.out.println("Min: ₹" + stats.getMin());
        System.out.println("Max: ₹" + stats.getMax());

        System.out.println("\n9. Most expensive product by category:");
        Map<String, Optional<Product>> mostExpensive = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.maxBy(Comparator.comparing(Product::getPrice))));
        mostExpensive.forEach((category, product) ->
                System.out.println(category + ": " + product.orElse(null)));
    }
}



/*1. Books with price > 100:
Java Book [Books] ₹120.0

2. Orders with Baby products:
Order#102 on 2021-03-10 by Charlie

3. Toys after 10% discount:
Soft Toy [Toys] ₹180.0
Action Figure [Toys] ₹360.0

4. Products from Tier 2 customers between Feb-Apr 2021:
Java Book [Books] ₹120.0
Soft Toy [Toys] ₹180.0
Baby Lotion [Baby] ₹80.0
Action Figure [Toys] ₹360.0

5. Cheapest Book:
Kids Book [Books] ₹90.0

6. 3 Most recent orders:
Order#102 on 2021-03-10 by Charlie
Order#104 on 2021-02-25 by Tony
Order#101 on 2021-02-15 by Tony

7. Total order value in Feb 2021:
₹840.0

8. Book category statistics:
Count: 2
Sum: ₹210.0
Average: ₹105.0
Min: ₹90.0
Max: ₹120.0

9. Most expensive product by category:
Toys: Action Figure [Toys] ₹360.0
Baby: Baby Lotion [Baby] ₹80.0
Books: Java Book [Books] ₹120.0
*/
