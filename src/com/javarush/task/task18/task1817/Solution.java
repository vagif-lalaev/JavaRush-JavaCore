package com.javarush.task.task18.task1817;
/* 
Пробелы
*/
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        // считываем байты с args[] в который был передан фаил (его путь) txt.txt
        InputStreamReader inputStream = new InputStreamReader(new FileInputStream(args[0]));
        int countPr = 0; // счетчик пробелов
        int countVs = 0; // счетчик общий
        while (inputStream.ready()) { // если есть что читать
            countVs++; // подсчет всех проходов (т.е. всех символов)
            char ch = (char) inputStream.read(); // считываем байты и периводим к char
            if (" ".indexOf(ch) > -1) { // если есть хоть один пробел " "
                countPr++; // то считываем их количество
            }
        }
        inputStream.close(); // закрываем поток
        float sum = (float) countPr / countVs * 100; // посдчет отношения (согласо заданию)
        DecimalFormat f = new DecimalFormat("0.00"); // окргуляет до двух десятых
        System.out.println(f.format(sum));  // вывод с округлением
        //System.out.println(String.format("%.2f", sum)); // заменяет последние 2 строчки (округляет до последних 2 десятых)
    }
}
