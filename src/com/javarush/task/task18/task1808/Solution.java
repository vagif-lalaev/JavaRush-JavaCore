package com.javarush.task.task18.task1808;
/* 
Разделение файла
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream2 = new FileOutputStream(reader.readLine());
        FileOutputStream fileOutputStream3 = new FileOutputStream(reader.readLine());
        byte [] buf = new byte[file1.available()]; // считываение всего байтов и поместить в массив
        while(file1.available() > 0) {
            int data = file1.read(buf); // считываение всех байтов из массива и остатки
            if (data %2 == 0) { // если четное количество байтов
                fileOutputStream2.write(buf, 0, data / 2 ); // записать первую половино прочтенных байтов в фаил
                fileOutputStream3.write(buf, data / 2, data / 2); // записать вторую оставшуюся половину байтов в фаил
            } else {
                fileOutputStream2.write(buf, 0, data/2+1);
                fileOutputStream3.write(buf, data/2+1, data/2);
            }
        }
        file1.close();
        fileOutputStream2.close();
        fileOutputStream3.close();
    }
}
