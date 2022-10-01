package ru.mirea.pr6;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;

public class SortingStudentsByGPA implements Comparator {
    public void printList(ArrayList<String> array) {
        System.out.print("[");
        for (int i = 0; i < array.size(); ++i) {
            System.out.print(array.get(i));
            if (i != array.size() - 1)
                System.out.print(" ");
            if (i % 5 == 0 && i != 0) {
                System.out.println("");
                System.out.print("\t\t\t\t\t  ");
            }
            if (i == array.size() - 1)
                System.out.println("]");
        }
    }
    @Override
    public void quickSort(ArrayList<String> array, int low, int high) {
        if (array.size() == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        float opora = Float.parseFloat(array.get(middle).substring(array.get(middle).indexOf(" ") + 1));

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (Float.parseFloat(array.get(i).substring(array.get(i).indexOf(" ")+1)) > opora) {
                i++;
            }

            while (Float.parseFloat(array.get(j).substring(array.get(j).indexOf(" ") + 1)) < opora) {
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
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}
