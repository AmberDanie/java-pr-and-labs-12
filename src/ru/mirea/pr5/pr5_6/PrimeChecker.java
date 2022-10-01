package ru.mirea.pr5.pr5_6;

import static java.lang.Math.sqrt;

public class PrimeChecker {
    public boolean isPrime(int n, int divider) {
        if (n % divider == 0)
            return false;
        if (divider > sqrt(n))
            return true;
        else
            return isPrime(n, divider+1);
    }
}
