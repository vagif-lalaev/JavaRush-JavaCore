package com.javarush.task.task18.task1806;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* 
Исправить ошибки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("c:/data.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("c:/result.txt");

        byte[] buffer = new byte[inputStream.available()]; //для буффера создаем один максимальный кусок прочтения за раз, это расзмер полученного блока байтов
        if (inputStream.available() > 0) { // если размер получ.байтов больше 0
            //читаем весь файл одним куском
            int count = inputStream.read(buffer); // передаем в переменую count прочтенный блок buffer
            outputStream.write(buffer, 0, count); // записываем в фаил блок байтов и остатки count
        }
        inputStream.close(); // закрываем поток
        outputStream.close(); // закрываем поток
    }
}
