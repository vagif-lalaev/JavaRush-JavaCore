package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        int count = 0; // счетчик
        while (inputStreamReader.ready()) { // усли есть что считать c потока (true)
            char ch = (char)inputStreamReader.read(); // считываем побайтно и приобразуем в символы char
            // если один из переч.символов "abcdefghijklmnopqrstuvwxyz" имеется в переменой "ch" (это методе "indexOf()" делает
            // то сделать их всех прописными, если нет то вернет -1 (согласно методу "indexOf()")
            if ("abcdefghijklmnopqrstuvwxyz".indexOf(Character.toLowerCase(ch)) > -1) {
                count++; // инкримент 1
            }
        }
        System.out.println(count); // вывод счетчика
        inputStreamReader.close(); // закрытия потока;
    }
}
