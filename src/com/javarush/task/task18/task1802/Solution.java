package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int coint = Integer.MAX_VALUE;
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (data < coint) {
                coint = data;
            }
        }
        fileInputStream.close();
        System.out.println(coint);
    }
}
