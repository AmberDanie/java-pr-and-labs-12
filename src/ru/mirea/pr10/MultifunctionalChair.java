package ru.mirea.pr10;

public class MultifunctionalChair implements Chair  {
    public void cook() {
        System.out.println("WOW! You chair just cooked breakfast for you");
    }
    public void jump() {
        System.out.println("WOOOOOOOOW! Your chair jumped?! How is it possible?");
    }
    public void calculate(int a, int b) {
        System.out.println("OMG. Your chair just found, that " + a + " + " + b + " equals " + a+b);
    }
}
