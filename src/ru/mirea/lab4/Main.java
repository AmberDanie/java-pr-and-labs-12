package ru.mirea.lab4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cat's name: ");
        String catName = scanner.nextLine();
        Cat cat = new Cat(catName);
        System.out.print("Car's name: ");
        String carName = scanner.nextLine();
        Car car = new Car(carName);
        System.out.print("Planet's name: ");
        String planetName = scanner.nextLine();
        Planet planet = new Planet(planetName);
        System.out.print(cat.toString() + "\n" + car.toString() + "\n" + planet.toString());
        System.out.println(cat.getName());
    }
}
