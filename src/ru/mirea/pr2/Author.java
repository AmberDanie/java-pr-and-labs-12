package ru.mirea.pr2;

public class Author {
    private final String name;
    private String email;
    private final char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void printInfo() {
        System.out.println("\tname: " + this.getName());
        System.out.println("\temail: " + this.getEmail());
        System.out.println("\tgender: " + this.getGender());
    }
}