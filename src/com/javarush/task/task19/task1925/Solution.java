package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
                BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            StringBuffer strB = new StringBuffer();
            while (reader.ready()) {
                String [] str = reader.readLine().split(" ");
                for (String x : str) {
                    if (x.length() > 6) {
                        strB.append(x + ",");
                    }
                }
            }
            writer.write(strB.deleteCharAt(strB.length() -1).toString());

        } catch (IOException e) {
            e.getStackTrace();
        }

    }
}
