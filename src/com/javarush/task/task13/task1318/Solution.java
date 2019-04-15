package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;
/* 
Чтение файла
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileS = File.separator; // позволяет разделитель ставить свой "/" , так как на windows свой, macBook или Linuks, благоторя separator, разделитель становится универсальным.

        InputStream readFile = new FileInputStream("C:" + fileS + "Users" + fileS + "Вагиф" + fileS + "YandexDisk" + fileS + "JAVA" + fileS + "Для проверки переноса настройки на intellij IDEA" + fileS + "Проэкты от JavaRush (полностью рабочая (не хватает всех задачь по 8 ур.)" + fileS + "JavaRushTasks" + fileS + "2.JavaCore" + fileS +reader.readLine());
        while (readFile.available() > 0){
            System.out.print((char) readFile.read());
        }
        readFile.close();
        reader.close();
        // напишите тут ваш код
        // вписать имя файла в консоль "Читаем имя файла.txt"
    }
}