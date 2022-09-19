package ru.mirea.lab3;

public class Bulldog extends Dog {
    public Bulldog(String name, String color) {
        super(name, color);
    }

    @Override
    public void bark() {
        System.out.println("\t- Woof! woof!");
        System.out.println("Your bulldog " + super.getName() + " barked");
    }

    @Override
    public String toString() {
        return "\tBulldog called " + super.getName() +
                " with " + super.getColor() + " fur color";
    }
}
