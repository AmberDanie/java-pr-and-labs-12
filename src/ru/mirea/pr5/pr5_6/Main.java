package ru.mirea.pr5.pr5_6;

// 5.6. Проверка числа на простоту

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PrimeChecker pCheck = new PrimeChecker();
        System.out.print("N: ");
        int N;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        if (pCheck.isPrime(N, 2)) {
            System.out.println("YES");
        }
        else
            System.out.println("NO");
    }
}
