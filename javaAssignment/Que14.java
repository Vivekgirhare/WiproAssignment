package javaAssignment;

class Shape {
    // Square area
    double area(double side) {
        return side * side;
    }

    // Rectangle area
    double area(double length, double breadth) {
        return length * breadth;
    }

    // Square perimeter
    double perimeter(double side) {
        return 4 * side;
    }

    // Rectangle perimeter
    double perimeter(double length, double breadth) {
        return 2 * (length + breadth);
    }
}

public class Que14 {
    public static void main(String[] args) {
        Shape shape = new Shape();

        double side = 5;
        double length = 10, breadth = 6;

        System.out.println("Square area: " + shape.area(side));
        System.out.println("Rectangle area: " + shape.area(length, breadth));
        System.out.println("Square perimeter: " + shape.perimeter(side));
        System.out.println("Rectangle perimeter: " + shape.perimeter(length, breadth));
    }
}
