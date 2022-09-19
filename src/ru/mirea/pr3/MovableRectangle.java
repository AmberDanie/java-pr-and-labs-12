package ru.mirea.pr3;
import java.lang.Math;

public class MovableRectangle implements Movable {
    private final MovablePoint topLeft;
    private final MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    public int getSquare() {
        return Math.abs(topLeft.getX()- bottomRight.getX())*
                Math.abs(topLeft.getY()- bottomRight.getY());
    }

    @Override
    public String toString() {
        return "This is my rectangle. His coordinates: x = " +
                curX() + "\n\t\t\t\t\t\t\t\t\t   y = " + curY();
    }
    public void moveUp() {
        if (!isSpeedEqual()) {
            System.out.println("speed is not equal... we just can't move =(");
            return;
        }
        topLeft.moveUp();
        bottomRight.moveUp();
    }
    public void moveDown() {
        if (!isSpeedEqual()) {
            System.out.println("speed is not equal... we just can't move =(");
            return;
        }
        topLeft.moveDown();
        bottomRight.moveDown();
    }
    public void moveLeft() {
        if (!isSpeedEqual()) {
            System.out.println("speed is not equal... we just can't move =(");
            return;
        }
        topLeft.moveLeft();
        bottomRight.moveLeft();
    }
    public void moveRight() {
        if (!isSpeedEqual()) {
            System.out.println("speed is not equal... we just can't move =(");
            return;
        }
        topLeft.moveRight();
        bottomRight.moveRight();
    }

    public boolean isSpeedEqual() {
        return (topLeft.getxSpeed() == bottomRight.getxSpeed() &&
                topLeft.getySpeed() == bottomRight.getySpeed());
    }
    public float curX() {
        return (topLeft.getX() + bottomRight.getX()) / 2.0f;
    }
    public float curY() {
        return (topLeft.getY() + bottomRight.getY()) / 2.0f;
    }
}
