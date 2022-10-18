package ru.mirea.lab7;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
public class Main {
    public static void main(String[] args) {
        ArrayList<String> myArray=new ArrayList<>();
        Queue <String> q = new ArrayDeque<>();
        q.add("dogs");
        q.add("cats");
        myArray.add("parrots");
        myArray.add("snakes");
        myArray.add(1,"rabbits");
        myArray.addAll(3,q);
        System.out.print("My array: ");
        for (String item : myArray) {
            System.out.print(item + " ");
        }
        System.out.println();
        if (!myArray.isEmpty())
            System.out.println("Array is not empty");
        System.out.println(myArray.contains("rabbits"));
        System.out.println(myArray.containsAll(q));
        q.add("rabbits");
        System.out.println(myArray.containsAll(q));
        System.out.println(myArray.get(3));
        myArray.add("rabbits");
        System.out.println(myArray.indexOf("rabbits"));
        System.out.println(myArray.lastIndexOf("rabbits"));
        System.out.print("Array before clean: ");
        for (String value : myArray)
            System.out.print(value + " ");
        myArray.clear();
        System.out.println();
        System.out.print("Array after  clean: ");
        for (String s : myArray) { System.out.print(s + " "); }
    }
}
