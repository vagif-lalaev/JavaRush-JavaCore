package com.javarush.task.task19.task1910;
/*
Пунктуация
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()))) {
            while (file.ready()) {
                String str = file.readLine();
                String x =str.replaceAll("\\p{Punct}", "");
                writer.write(x);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
