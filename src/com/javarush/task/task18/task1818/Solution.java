package com.javarush.task.task18.task1818;
/* 
Два в одном
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream file1 = new FileOutputStream(reader.readLine());
        FileInputStream file2 = new FileInputStream(reader.readLine());
        FileInputStream file3 = new FileInputStream(reader.readLine());
        byte[] buf2 = new byte[file2.available()]; //буфиризируем file2
        byte[] buf3 = new byte[file3.available()]; //буфиризируем file3

        int x = file2.read(buf2); //считываем буфер file2
        file1.write(buf2, 0, x); //записываем буфер file2 с начало "0" до длинны "x"
        // file2.read(buf2);  //вместо верхних строк,
        // file1.write(buf2); //можно сделать так

        int y = file3.read(buf3); //считываем буфер file3
        file1.write(buf3, 0, y); //записываем буфер file3 с начало "0" до длинны "y"
        //закрываем потоки
        file1.close();
        file2.close();
        file3.close();
    }
}
