package ru.mirea.lab2;

public class Leg {
    private boolean isUp = false;
    private final String name;
    Leg(String _name) {
        name = _name;
    }
    public void raiseLeg() {
        if (!isUp) {
            isUp = true;
            System.out.println("\tHuman raised " + name + " leg");
        }
        else
            System.out.println("\tThe leg is already up");
    }
    public void lowerLeg() {
        if (isUp) {
            isUp = false;
            System.out.println("\tHuman lowered " + name + " leg");
        }
        else
            System.out.println("\tThe leg is already down");
    }
    public void moveForward() {
        System.out.println("\tHuman moved " + name + " leg forward");
    }
}
