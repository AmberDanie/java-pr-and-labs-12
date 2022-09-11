package ru.mirea.pr1;

import ru.mirea.pr1.Ball;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        System.out.print("Create your ball. Input ball's name: ");
        // Object scanner
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        // Name's emptiness check
        if (name.isEmpty()) {
            System.out.println("Name can't be empty");
            return;
        }
        System.out.print("Input radius of the ball: ");
        double radius = Double.parseDouble(scanner.nextLine());
        // Radius' positive value check
        if (radius <= 0) {
            System.out.println("Radius have to be positive number");
            return;
        }
        System.out.print("Input color of the ball: ");
        String color = scanner.nextLine();
        // Color's emptiness check
        if (color.isEmpty()) {
            System.out.println("Color can't be empty");
            return;
        }
        // Next we create 2 objects of Ball class
        System.out.println("The first ball, created by default:");
        Ball defaultBall = new Ball(); // Ball object created by default constructor
        defaultBall.printInfo();
        System.out.println("The second ball, created with the given arguments: ");
        Ball secondBall = new Ball(name, radius, color);
        secondBall.printInfo();
        secondBall.throwIt();
        System.out.println("Diameter of the created ball: " + secondBall.getDiameter());
        defaultBall.throwIt();
    }
}