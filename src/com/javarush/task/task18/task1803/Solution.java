package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/* 
Самые частые байты
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        // напишим трайник из Stream.
        // фаил находдится тут
        // C:\Users\Вагиф\YandexDisk\JAVA\Проэкты от JavaRush\Проэкты от JavaRush (полностью рабочая)\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1801\file
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        long count = 0; // создаем для сравнения и добовления в него значения
        long[] arr = new long[255]; // создаем массив и добавляем максимальное возможное число хронящее в byte
        while (fileInputStream.available() > 0) { // читаем все байты наход. в файле
            int data = fileInputStream.read(); // прочтенные байты присваеваем в data
            arr[data]++; // инкрементируем индикс  массива
            for (int i = 0; i < arr.length; i++) { // проходим по всему массиву
                if (arr[i] > count) { // если массив с индексом i больше count
                    count = arr[i]; // то присваеваем значение моссива к count
                }
            }
        }
        for (int i = 0; i < arr.length; i++) { // еще раз проходим по всему массиву
            if (arr[i] == count) { // если массив равен count
                System.out.print(i + " "); // то выводим индекс прохода
            }
        }
        fileInputStream.close(); // закрываем поток
    }
}
