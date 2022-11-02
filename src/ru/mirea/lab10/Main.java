package ru.mirea.lab10;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        // int[] k = {1,2,3,4,5,6,7} ;
        Integer[] i = {1,2,3,4,5,6,7} ;
        String[] s = {"abc","def","c","d","e"};

        ArrayList<Integer> aL1 = Test.ConvertArrayToList(i);
        for (Object o : aL1) {
            System.out.print(o + " ");
        }

        ArrayList<String> aL2 = Test.ConvertArrayToList(s);
        for (Object o : aL2) {
            System.out.print(o + "|");
        }
        Array<Integer> iA2 = new Array<>(i);
        System.out.println("\n" + iA2.get(2));

        Test.FileList("C:\\Users\\Setup\\IdeaProjects\\JABA");
    }
}