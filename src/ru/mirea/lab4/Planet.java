package ru.mirea.lab4;

public class Planet implements Nameable {
    String name;
    @Override
    public String getName() {
        return this.name;
    }

    public Planet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                '}';
    }
}
