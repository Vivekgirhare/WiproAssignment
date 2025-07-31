package javaAssignment;

// Drawable interface
interface Drawable {
    void drawingColor();
    void thickness();
}

// Fillable interface
interface Fillable {
    void fillingColor();
    void size();
}

// Line class
class Line implements Drawable, Fillable {
    public void drawingColor() {
        System.out.println("Line Drawing Color: Black");
    }

    public void thickness() {
        System.out.println("Line Thickness: 1px");
    }

    public void fillingColor() {
        System.out.println("Line Fill: Not Applicable");
    }

    public void size() {
        System.out.println("Line Size: 100 units");
    }
}

// Circle class
class Circle implements Drawable, Fillable {
    public void drawingColor() {
        System.out.println("Circle Drawing Color: Red");
    }

    public void thickness() {
        System.out.println("Circle Thickness: 2px");
    }

    public void fillingColor() {
        System.out.println("Circle Fill Color: Blue");
    }

    public void size() {
        System.out.println("Circle Radius: 50 units");
    }
}

// Square class
class Square implements Drawable, Fillable {
    public void drawingColor() {
        System.out.println("Square Drawing Color: Green");
    }

    public void thickness() {
        System.out.println("Square Thickness: 3px");
    }

    public void fillingColor() {
        System.out.println("Square Fill Color: Yellow");
    }

    public void size() {
        System.out.println("Square Side Length: 40 units");
    }
}

// Main class
public class que22 {
    public static void main(String[] args) {
        Line line = new Line();
        Circle circle = new Circle();
        Square square = new Square();

        System.out.println("Line:");
        line.drawingColor();
        line.thickness();
        line.fillingColor();
        line.size();

        System.out.println("\nCircle:");
        circle.drawingColor();
        circle.thickness();
        circle.fillingColor();
        circle.size();

        System.out.println("\nSquare:");
        square.drawingColor();
        square.thickness();
        square.fillingColor();
        square.size();
    }
}
