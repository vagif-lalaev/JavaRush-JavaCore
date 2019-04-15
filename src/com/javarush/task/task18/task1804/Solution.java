package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/* 
Самые редкие байты
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        int counter = Integer.MAX_VALUE;
        ArrayList<Integer> array = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            array.add(data);
        }
        Collections.sort(array);
        for (int i = 0;  array.size() > i; ) {
            int i2 = array.get(i);
            int min = 1;
            for(int j = i + 1; j < array.size(); j++){
                int j2 = array.get(j);
                if(i2 == j2) min++;
                else break;
            }
            if(min < counter) {
                counter = min;
            }
            i = i + min;
        }
        for(int i = 0; i < array.size(); ){
            int i3 = array.get(i);
            int min2 = 1;
            for(int j = i + 1; j < array.size(); j++){
                int j3 = array.get(j);
                if(i3 == j3) min2++;
                else break;
            }
            if(min2 == counter) {
                System.out.print(i3 + " ");
            }
            i = i + min2;
        }
        fileInputStream.close();
    }
}
