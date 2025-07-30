
package javaAssignment;

// Base Vehicle class
public class Vehicle {
    protected String color;
    protected int wheels;
    protected String model;

    public Vehicle(String color, int wheels, String model) {
        this.color = color;
        this.wheels = wheels;
        this.model = model;
    }

    public void start() {
        System.out.println("Vehicle " + model + " started.");
    }

    public void stop() {
        System.out.println("Vehicle " + model + " stopped.");
    }
}

// Subclass Truck
class Truck extends Vehicle {
    public Truck(String color, int wheels, String model) {
        super(color, wheels, model);
    }

    public void load() {
        System.out.println("Truck " + model + " loading cargo...");
    }
}

// Subclass Bus
class Bus extends Vehicle {
    public Bus(String color, int wheels, String model) {
        super(color, wheels, model);
    }

    public void carryPassengers() {
        System.out.println("Bus " + model + " carrying passengers...");
    }
}

// Subclass Car
class Car extends Vehicle {
    public Car(String color, int wheels, String model) {
        super(color, wheels, model);
    }

    public void openSunroof() {
        System.out.println("Car " + model + " opening sunroof...");
    }
}

// Road class to test vehicles
class Road {
    public void testVehicles() {
        Truck truck = new Truck("Red", 6, "Volvo");
        Bus bus = new Bus("Blue", 4, "Mercedes");
        Car car = new Car("Black", 4, "Toyota");

        truck.start();
        truck.load();
        truck.stop();

        bus.start();
        bus.carryPassengers();
        bus.stop();

        car.start();
        car.openSunroof();
        car.stop();
    }
}

// Main class Que17
public class Que17 {
    public static void main(String[] args) {
        Road road = new Road();
        road.testVehicles();
    }
}
