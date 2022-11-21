package ru.mirea.lab9;

public class ThrowsDemo {
    public void printMessage(String key) {
        try {
            String message = getDetails(key);
            System.out.println(message);
        }
        catch (NullPointerException e) {
            System.out.println("\tCatch: null exception");
        }
    }
    public String getDetails(String key) {
        if(key == null)
            throw new NullPointerException("null key in getDetails");
        return "Data for " + key;
    }
}