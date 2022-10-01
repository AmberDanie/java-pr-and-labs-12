package ru.mirea.pr6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> studentsList = new ArrayList<String>();
        SortingStudentsByGPA students = new SortingStudentsByGPA();
        File myFile = new File("src/ru/mirea/pr6/studentListBeforeSorting");
        Scanner myReader = new Scanner(myFile);
        while (myReader.hasNextLine())
            studentsList.add(myReader.nextLine());
        myReader.close();
        System.out.print("List before sorting: ");
        students.printList(studentsList);
        students.quickSort(studentsList, 0, studentsList.size() - 1);
        System.out.print("List after sorting: ");
        students.printList(studentsList);
    }
}