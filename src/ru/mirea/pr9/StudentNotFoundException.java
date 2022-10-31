package ru.mirea.pr9;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
