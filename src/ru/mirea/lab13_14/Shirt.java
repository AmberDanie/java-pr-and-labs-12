package ru.mirea.lab13_14;

public class Shirt {
    private String article;
    private String title;
    private String color;
    private String size;

    public Shirt(String params) {
        String[] par = params.split(",");
        article = par[0];
        title = par[1];
        color = par[2];
        size = par[3];
    }

    public void printInfo() {
        System.out.println(article + "\n\t" + title + "\n\t" + color + "\n\t" + size);
    }
}