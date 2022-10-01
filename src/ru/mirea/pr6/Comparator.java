package ru.mirea.pr6;

import java.util.ArrayList;

public interface Comparator {
    public void printList(ArrayList<String> array);
    public void quickSort(ArrayList<String> array, int low, int high);
}
