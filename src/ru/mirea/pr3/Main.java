package ru.mirea.pr3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("x1: ");
        Scanner scanner = new Scanner(System.in);
        int x1 = Integer.parseInt(scanner.nextLine());
        System.out.print("y1: ");
        int y1 = Integer.parseInt(scanner.nextLine());
        System.out.print("x2: ");
        int x2 = Integer.parseInt(scanner.nextLine());
        System.out.print("y2: ");
        int y2 = Integer.parseInt(scanner.nextLine());
        System.out.print("xSpeed: ");
        int xSpeed = Integer.parseInt(scanner.nextLine());
        System.out.print("ySpeed: ");
        int ySpeed = Integer.parseInt(scanner.nextLine());
        MovableRectangle rect = new MovableRectangle(x1, y1, x2, y2, xSpeed, ySpeed);
        System.out.println(rect);
        rect.moveDown();
        rect.moveRight();
        System.out.println(rect);
        for (int i = 0; i < 10; i++)
            rect.moveRight();
        System.out.println(rect);
        System.out.println("Rectangle's square is: " + rect.getSquare());
    }
}