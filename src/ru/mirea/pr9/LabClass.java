package ru.mirea.pr9;

import java.util.ArrayList;
import java.util.Collections;

public class LabClass {
    public void sortByScore(ArrayList<Student> array, int low, int high) {
        if (array.size() == 0)
            return;//завершить выполнение, если длина массива равна 0
        if (low >= high)
            return;//завершить выполнение если уже нечего делить
        int middle = low + (high - low) / 2;
        float helper = array.get(middle).getStudentScore();
        int i = low, j = high;
        while (i <= j) {
            while (array.get(i).getStudentScore() > helper) {
                i++;
            }
            while (array.get(j).getStudentScore() < helper) {
                j--;
            }
            if (i <= j) {//меняем местами
                Collections.swap(array, i, j);
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            sortByScore(array, low, j);
        if (high > i)
            sortByScore(array, i, high);
    }
    public void sortByName(ArrayList<Student> array, int low, int high) {
        if (array.size() == 0)
            return;//завершить выполнение, если длина массива равна 0
        if (low >= high)
            return;//завершить выполнение если уже нечего делить
        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        String helper = array.get(middle).getStudentLastname();
        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array.get(i).getStudentLastname().compareTo(helper) < 0) {
                i++;
            }
            while (array.get(j).getStudentLastname().compareTo(helper) > 0) {
                j--;
            }
            if (i <= j) {//меняем местами
                Collections.swap(array, i, j);
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            sortByName(array, low, j);
        if (high > i)
            sortByName(array, i, high);
    }
}

