package ru.mirea.lab8;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {

    private BufferedReader fileReader;

    MyFileReader(){}

    public void read(String path){
        try{
            fileReader=new BufferedReader(new FileReader(path));
            String line = fileReader.readLine();
            while (line!=null){
                System.out.println(line);
                line=fileReader.readLine();
            }
        }
        catch (IOException ex){};
    }
}
