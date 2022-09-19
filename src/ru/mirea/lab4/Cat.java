package ru.mirea.lab4;

public class Cat implements Nameable {
    String name;
    @Override
    public String getName() {
        return this.name;
    }

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
