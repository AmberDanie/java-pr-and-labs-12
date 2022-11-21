package ru.mirea.pr11_12;

public class Main {
    public static void main(String[] args) {
        /*1 задание*/
        Person prs = new Person("Горбачев", "Даниил", "Александрович");
        Person prs_another = new Person("Брежнев");
        System.out.println(prs.getFullName());
        System.out.println(prs_another.getFullName());
        /*2 задание*/
        System.out.println(Phone.format_number("89626257032"));
        System.out.println(Phone.format_number("+79903425312"));
    }
}