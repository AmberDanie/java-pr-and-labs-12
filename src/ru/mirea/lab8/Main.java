package ru.mirea.lab8;
public class Main {
    public static void main(String[] args) {
        String path="text.txt";
        MyFileReader readerFile = new MyFileReader();
        readerFile.read(path);
    }
}