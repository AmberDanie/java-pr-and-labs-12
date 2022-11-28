package ru.mirea.lab10_11;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        ArrayList<Integer> tst = newArrayList (10, 20);
        for (Integer t : tst)
            System.out.println(t);
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> res = new ArrayList<>();
        for (T elm : elements)
            res.add(elm);
        return res;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> res = new HashSet<>();
        for (T elm : elements)
            res.add(elm);
        return res;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if (keys.size() != values.size())
            throw new IllegalArgumentException();
        HashMap<K, V> res = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            res.put(keys.get(i), values.get(i));
        }
        return res;
    }
}