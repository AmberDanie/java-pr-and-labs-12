package ru.mirea.lab10_11;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    // Задание 1
    public static <E> ArrayList<E> arrayToList(E[] arr){
        if(arr == null)
            throw new IllegalArgumentException("Null array!");
        ArrayList<E> l = new ArrayList<>(arr.length);
        for (E element : arr) {
            l.add(element);
        }
        return l;
    }

    // Задание 3
    public static <E> E get(E[] arr, int index){
        if (index < 0 || index >= arr.length)
            throw new IndexOutOfBoundsException("Array size = "+ arr.length+", index = "+index);
        return arr[index];
    }

    // Задание 4
    public static ArrayList<File> readDir(String path){
        File f = new File(path);

        if (!f.exists() || !f.isDirectory())
            throw new IllegalArgumentException("Not correct path!");

        ArrayList<File> lf = new ArrayList<File>();

        Collections.addAll(lf, f.listFiles());
        try {
            for (int i = 0; i < 5; i++)
                System.out.println(lf.get(i).getName());
        } catch (Exception e) {
            System.out.println("Files in the directory is less than 5!");
        }
        return lf;
    }



    // Задание 5
    public static <E> HashSet<E> arrayToHashSet(E[] arr){
        if(arr == null)
            throw new IllegalArgumentException("Null array!");
        HashSet<E> s = new HashSet<>(arr.length);
        for (E element : arr) {
            s.add(element);
        }
        return s;
    }

    public static <K, V> HashMap<K, V> arrayToHashMap(K[] arr, V[] vArr){
        if(arr == null || vArr == null)
            throw new IllegalArgumentException("Null array!");
        if(vArr.length < arr.length)
            throw new IllegalArgumentException("Массив значений меньше массива ключей!");
        HashMap<K, V> m = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            m.put(arr[i], vArr[i]);
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println("Задание 1");
        String[] a = new String[]{"Hello", "world", "!"};
        ArrayList<String> l = arrayToList(a);
        System.out.println(l);
        System.out.println();

        System.out.println("\n\nЗадание 2");
        UnicClass<Integer> ints = new UnicClass<>(8);
        for(int i = 0; i<20;i++)
            ints.add(i);
        System.out.println(ints);
        for(int i = 5; i < 13; i++)
            ints.remove(i);
        System.out.println(ints);
        System.out.println(ints.get(5));
        System.out.println();

        UnicClass<String> strs = new UnicClass<>();
        System.out.println(strs);
        for (int i = 0; i < 10; i++) {
            strs.add("String number " + (i+1));
        }
        System.out.println(strs);
        System.out.println();

        UnicClass<String> strs2 = new UnicClass<>(strs);
        System.out.println(strs2);
        strs2.remove(5);
        System.out.println(strs2);
        System.out.println(strs2.get(5));
        System.out.println(strs.get(5));
        strs2.addAll(strs2.getCount(), strs.subList(4, 8));
        System.out.println(strs2);
        strs2.sort(String::compareTo);
        System.out.println(strs2);
        System.out.println();

        System.out.println("\n\nЗадание 3");
        System.out.println(get(a, 0));
        System.out.println(get(a, 2));
        System.out.println();

        System.out.println("\n\nЗадание 4");
        ArrayList<File> lf = readDir(Paths.get("").toAbsolutePath().toString());
        System.out.println();
        System.out.println(lf);
        System.out.println();

        System.out.println("\n\nЗадание 5");
        HashSet<String> hs = arrayToHashSet(a);
        System.out.println(hs);

        HashMap<String, String> m = arrayToHashMap(a, new String[]{"H", "w", "!"});
        System.out.println(m);
    }
}