package com.javarush.task.task15.task1525;

        import java.io.*;
        import java.util.ArrayList;
        import java.util.List;
/*
Файл в статическом блоке
*/
public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Statics.FILE_NAME));
            for (Object r : reader.lines().toArray()) { // метод toArray() возвращает массив всех элементов и записывает в переменную r
                lines.add(r.toString()); // добовляет записанные данные в список
            }
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
