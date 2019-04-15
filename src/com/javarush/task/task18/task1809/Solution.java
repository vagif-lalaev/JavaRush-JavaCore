package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
/* 
Реверс файла
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
        ArrayList<Byte> all = new ArrayList<>(); // создаем и инициализ. переменную ArrayList
        while (fileInputStream.available() > 0) { // вход в цикл если есть хоть один байт
            all.add((byte) fileInputStream.read()); // считываем и добовляем побайтно
        }
            for (int i = all.size()-1; i >= 0; i--) { // запускаем обратный цикл
            fileOutputStream.write(all.get(i)); // записываем значения обратных байтов
            }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
