package ru.mirea.pr1;

import java.lang.Math;

public class Ball {
    private double radius; // размер мяча
    private String name; // имя мяча
    private String color; // цвет мяча
    public Ball(String _name, double _radius, String _color) {
        this.name = _name;
        this.radius = _radius;
        this.color = _color;
    }
    public Ball(double _radius, String _color) {
        this.radius = _radius;
        this.color = _color;
        this.name = "defaultBall";
    }
    public Ball(double _radius) {
        this.radius = _radius;
        this.color = "red";
        this.name = "defaultBall";
    }
    public Ball() {
        this.color = "red";
        this.name = "defaultBall";
        this.radius = 10.0;
    }
    // Getters
    public String getName() {
        return name;
    }
    public String getColor() { return color; }
    public double getRadius() {
        return radius;
    }
    public double getDiameter() { return 2*radius;}
    // Setters
    public void setRadius(double radius) { this.radius = radius; }
    public void setName(String name) { this.name = name; }
    public void setColor(String color) { this.color = color; }
    // Method for displaying ball's information
    public void printInfo() {
        System.out.println("\tname: " + this.getName());
        System.out.println("\tradius: " + this.getRadius());
        System.out.println("\tcolor: " + this.getColor());
    }

    public String toString() {
        return ("\tИмя: " + this.getName() + "\tРадиус: " + this.getRadius() +"\tЦвет: " + this.getColor());
    }
    // Method for throwing ball
    public void throwIt() {
        System.out.println("You throwed the ball named " + this.getName());
    }
}
