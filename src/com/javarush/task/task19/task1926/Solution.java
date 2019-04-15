package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()))) {
            while (file.ready()) {
                String str = file.readLine();
                char [] arrCh = str.toCharArray();
                for (int i = arrCh.length -1; i >= 0; i--) {
                    System.out.print(arrCh[i]);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
