package com.javarush.task.task13.task1319;

import java.io.*;
/* 
Писатель в файл с консоли
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // вводим в консоль
        BufferedWriter bw = new BufferedWriter(new FileWriter(reader.readLine())); // записываем в консоль имя файла

        // чтение построчно
        while (true) { // бесконеный цыкл, пока не произойдет условие
            String text = reader.readLine();
            if (text.equals("exit")) { // если вводим "exit" то
                bw.write(text + "\r\n"); // записываем "exit" в буффер
                break; // и приекращаем работу
            }
            bw.write(text + "\r\n"); // записываем в буффер
        }
        bw.close(); // закрываем запись в буффер
    }
}
