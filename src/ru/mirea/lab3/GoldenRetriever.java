package ru.mirea.lab3;

public class GoldenRetriever extends Dog {
    public GoldenRetriever(String name, String color) {
        super(name, color);
        super.setColor("golden");
    }

    @Override
    public void bark() {
        System.out.println("\t- woof.");
        System.out.println("Your golden retriever " + super.getName() + " barked");
    }

    @Override
    public String toString() {
        return "\tGolden Retreiver called " + super.getName() + " with golden fur color";
    }
}
