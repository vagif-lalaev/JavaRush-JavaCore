package com.javarush.task.task19.task1906;
/* 
Четные символы
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        //благодря конструкции try() можно не закрывать поток, он закроется автоматически с 7 java пошло
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader readerFile = new FileReader(reader.readLine());
        FileWriter writer = new FileWriter(reader.readLine())) {
        while (readerFile.read() !=-1) { //первый элемент читает тут
//            readerFile.skip(1); можно и так (если изменить цикл while(reader.ready()))
            char ch = (char) readerFile.read(); //читает каждый второй елемент
            writer.write(ch); //записывает в файл каждый второй прочтенный элемент
        } } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
