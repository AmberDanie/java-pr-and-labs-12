package ru.mirea.lab2;

public class Head {
    private String hairColor;
    private String eyesColor;
    private boolean mouthIsOpen = false;

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public void setEyesColor(String eyesColor) {
        this.eyesColor = eyesColor;
    }

    public boolean isMouthIsOpen() {
        return mouthIsOpen;
    }

    public void openMouth() {
        if (!mouthIsOpen) {
            mouthIsOpen = true;
            System.out.println("\tHuman opened their mouth");
        }
        else
            System.out.println("\tMouth is already open");
    }
    public void closeMouth() {
        if (mouthIsOpen) {
            mouthIsOpen = false;
            System.out.println("\tHuman closed their mouth");
        }
        else
            System.out.println("\tMouth is already closed");
    }
    public void chew() {
        System.out.println("\tHuman chew something");
    }
}