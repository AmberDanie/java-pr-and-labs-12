package ru.mirea.lab10;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Test {
    /* Написать метод для конвертации массива строк/чисел в список.
     * */
    public static <E> ArrayList<E> ConvertArrayToList(E[] a){
        ArrayList<E> temp = new ArrayList<>();
        Collections.addAll(temp, a);
        return temp;
    }

    /* Написать ф-ю, которая сохранит содержимое каталога в список и выведет первые 5 элементов на экран.
     * */

    public static void FileList(String path){
        File f = new File(path);
        String[] fArray = null;
        if (f.exists()||f.isDirectory()) {
            fArray = f.list(null);
        }
        else {
            System.out.print("Папка не найдена");
        }
        assert fArray != null;
        ArrayList<String> list = new ArrayList<>(Arrays.asList(fArray));

        for (int i = 0; i < 5;i++) {
            System.out.println(list.get(i));
        }
    }
}

/* Написать класс, который умеет хранить в себе массив любых типов данных (int, long etc.).
 *  Реализовать метод, который возвращает любой элемент массива по индексу.
 * */
class Array <E>{
    public Array (E[] t) {
        this.aL = new ArrayList<>();
        Collections.addAll(aL, t);
    }

    public E get(int index) {
        return this.aL.get(index);
    }
    private final ArrayList<E> aL;
}