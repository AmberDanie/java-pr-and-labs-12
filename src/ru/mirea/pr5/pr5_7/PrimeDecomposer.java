package ru.mirea.pr5.pr5_7;

public class PrimeDecomposer {
    public void PrimeDecompose(int N, int divider) {
        if (N < divider)
            return;
        while (N % divider == 0) {
            System.out.print(divider + " ");
            N /= divider;
        }
        PrimeDecompose(N, divider+1);
    }
}
