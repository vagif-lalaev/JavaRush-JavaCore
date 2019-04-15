package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;
/* 
Сортировка байт
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // ввод с консоли
        FileInputStream fileInputStream = new FileInputStream(reader.readLine()); // чтение файла
        TreeSet<Integer> arr1 = new TreeSet<>(); // создание множество TreeSet (сортирует + нет повторений)
        while (fileInputStream.available() > 0) { // если есть байты данные в файле
            arr1.add(fileInputStream.read()); // добавление в множество прочтенные байты
        }
        for (Integer x : arr1) { // цикл перебора и присвоение значен переменной x
            System.out.print(x + " ");
        }
        fileInputStream.close(); // закрытеие потока
    }
}
