package ru.mirea.lab3;

public class Beauceron extends Dog {
    public Beauceron(String name, String color) {
        super(name, color);
    }

    public void bark() {
        System.out.println("\t- Woof!");
        System.out.println("Your beauceron " + super.getName() + " barked");
    }

    @Override
    public String toString() {
        return "\tBeauceron called " + super.getName() +
                " with " + super.getColor() + " fur color";
    }
}