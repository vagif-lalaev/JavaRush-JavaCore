package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/* 
Максимальный байт
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        //Принимаем имя файла с консоли
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // при запросе пути к файлу C:\Users\Вагиф\YandexDisk\JAVA\Проэкты от JavaRush\Проэкты от JavaRush (полностью рабочая)\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1801\file
        String str = bufferedReader.readLine(); //создаем строку куда положим имя файла
        long y = 0; // эта переменная нужна для определения какой байт больше
        FileInputStream fileInputStream = new FileInputStream(str); //создаем объект потока в конструкторе объекта кладем имя файла
        while (fileInputStream.available() > 0) { // пока еще байты остались делаем то то
            long x = fileInputStream.read(); // считываем байты и кладем в переменную
            if (x > y) { //тут если байт больше созданной нами переменной
                y = x; //то этой переменной присваиваем байт
            }
        }
        fileInputStream.close(); //закрываем поток
        System.out.println(y); //выводим самый большой байт с потока
    }
}
