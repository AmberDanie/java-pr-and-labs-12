package ru.mirea.lab1;

public class factorialClass {
    public long fact(int n) {
        long pr = 1;
        for (int i = 2; i <= n; i++)
            pr *= i;
        return pr;
    }
}
