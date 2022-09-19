package ru.mirea.lab3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Set 3 names for your beauceron, bulldog and golden retriever dogs");
        Scanner scanner = new Scanner(System.in);
        System.out.print("First name: ");
        String name = scanner.nextLine();
        Beauceron dog1 = new Beauceron(name , "black");
        dog1.bark();
        System.out.print("Second name: ");
        name = scanner.nextLine();
        GoldenRetriever dog2 = new GoldenRetriever(name,"golden");
        dog2.bark();
        System.out.print("Third name: ");
        name = scanner.nextLine();
        Bulldog dog3 = new Bulldog(name, "white");
        dog3.bark();
        System.out.println("Your dogs: ");
        System.out.println(dog1.toString());
        System.out.println(dog2.toString());
        System.out.println(dog3.toString());
    }
}
