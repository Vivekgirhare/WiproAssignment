package javaAssignment;

abstract class Person {
    public abstract void eat();
    public abstract void exercise();
}

class Athlete extends Person {
    @Override
    public void eat() {
        System.out.println("Athlete eats healthy meals.");
    }

    @Override
    public void exercise() {
        System.out.println("Athlete exercises intensively.");
    }
}

class LazyPerson extends Person {
    @Override
    public void eat() {
        System.out.println("Lazy person eats junk food.");
    }

    @Override
    public void exercise() {
        System.out.println("Lazy person avoids exercise.");
    }
}

public class Que21 {
    public static void main(String[] args) {
        Person athlete = new Athlete();
        Person lazy = new LazyPerson();

        athlete.eat();
        athlete.exercise();

        lazy.eat();
        lazy.exercise();
    }
}
