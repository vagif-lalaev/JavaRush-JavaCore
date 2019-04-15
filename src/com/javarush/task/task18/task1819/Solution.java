package com.javarush.task.task18.task1819;
/* 
Объединение файлов
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream file1 = new FileInputStream(file); //открываем поток для чтение первого файла
        FileInputStream file2 = new FileInputStream(reader.readLine()); //открываем поток для чтение второго файла

        byte [] buf1 = new byte[file1.available()]; //создаем массив и записываем туда данные 1 файла
        file1.read(buf1); //читаем данные первого массива
        file1.close(); //закрываем поток для первого файла

        byte [] buf2 = new byte[file2.available()]; //создаем массив и записываем туда данные 2 файла
        file2.read(buf2); //читаем данные второго массива
        file2.close(); //закрываем поток для второго файла

        FileOutputStream file1Zap = new FileOutputStream(file); //открываем поток для записи в первый файл
        file1Zap.write(buf2); //записываем второй массив данных
        file1Zap.write(buf1); //записываем первый массив данных
        file1Zap.close(); //закрываем поток для записи
    }
}
