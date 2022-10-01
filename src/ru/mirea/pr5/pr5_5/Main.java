package ru.mirea.pr5.pr5_5;

// 5.5. Сумма цифр числа
//Дано натуральное число N. Вычислите сумму его цифр.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("N: ");
        int N;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        System.out.print("Sum of N's digits: ");
        Number number = new Number();
        System.out.print(number.countSumOfDigits(N));
    }
}
