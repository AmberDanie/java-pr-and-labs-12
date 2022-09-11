package ru.mirea.lab2;

public class Hand {
    private boolean isClenched = false;
    private boolean isRaised = false;
    private final String name;
    Hand(String _name) {
        name = _name;
    }

    public boolean isClenched() {
        return isClenched;
    }

    public boolean isRaised() {
        return isRaised;
    }

    public String getName() {
        return name;
    }

    public void raiseHand() {
        if (!isRaised) {
            isRaised = true;
            System.out.println("\tHuman raised " + name + " hand");
        }
        else
            System.out.println("\tThe hand is already raised");
    }
    public void lowerHand() {
        if (isRaised) {
            isRaised = false;
            System.out.println("\tHuman lowered " + name + " hand");
        }
        else
            System.out.println("\tThe hand is already down");
    }
    public void clenchHand() {
        if (!isClenched) {
            isClenched = true;
            System.out.println("\tHuman clenched " + name + " hand");
        }
        else
            System.out.println("\tThe hand is already clenched");
    }
    public void unclenchHand() {
        if (isClenched) {
            isClenched = false;
            System.out.println("\tHuman unclenched " + name + " hand");
        }
        else
            System.out.println("\tThe hand is already unclenched");
    }
    public void wave() {
        if (!isClenched && isRaised)
            System.out.println("\tHuman waved " + name + " hand");
        else
            System.out.println("\tHuman did something wrong");
    }
    public void moveForward() {
        System.out.println("\tHuman moved " + name + " hand forward");
    }
    public void moveBack() {
        System.out.println("\tHuman moved " + name + " hand back");
    }
}
