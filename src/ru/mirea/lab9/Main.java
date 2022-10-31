package ru.mirea.lab9;

public class Main {
    public static void main(String[] args) {
        ThrowsDemo td = new ThrowsDemo();
        td.printMessage("data1");
        td.printMessage(null);
        td.printMessage("data2");
    }
}
