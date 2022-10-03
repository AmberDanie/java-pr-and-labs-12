package ru.mirea.lab1;

// ВАРИАНТ 5. Создать метод, вычисляющий* факториал числа с помощью
// цикла, проверить работу метода.

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        factorialClass obj = new factorialClass();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("n: ");
            int n = Integer.parseInt(scanner.nextLine());
            System.out.println(n + "! = " + obj.fact(n));
        }
    }
}
