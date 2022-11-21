package ru.mirea.pr11_12;

public class Person {
    String surname = "";
    String name = "";
    String patronymic = "";

    public Person(String surname, String name, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public Person(String surname)    {
        this.surname = surname;
    }

    StringBuffer getFullName() {
        StringBuffer fullName = new StringBuffer(surname);
        if (!name.equals(""))
            fullName.append(" ").append(name.charAt(0)).append(".");
        if (!patronymic.equals(""))
            fullName.append(" ").append(patronymic.charAt(0)).append(".");
        return fullName;
    }
}
