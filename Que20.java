package javaAssignment;

abstract class Vehicle {
    public abstract void startEngine();
    public abstract void stopEngine();
}

class Carr extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Car engine started.");
    }
    @Override
    public void stopEngine() {
        System.out.println("Car engine stopped.");
    }
}

class Motorcycle extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Motorcycle engine started.");
    }
    @Override
    public void stopEngine() {
        System.out.println("Motorcycle engine stopped.");
    }
}

public class Que20 {
    public static void main(String[] args) {
        Vehicle carr = new Carr();
        Vehicle motorcycle = new Motorcycle();

        carr.startEngine();
        carr.stopEngine();

        motorcycle.startEngine();
        motorcycle.stopEngine();
    }
}
