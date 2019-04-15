package com.javarush.task.task19.task1922;

import javafx.print.Collation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* 
Ищем нужные строки
*/
public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader file = new BufferedReader(new FileReader(reader.readLine()))) {
            String str;
            while ((str = file.readLine()) != null) {
                int count = 0;
                for (String x : words) {
                    Pattern p = Pattern.compile("\\b" + x + "\\b");
                    Matcher m = p.matcher(str);
                    if (m.find()) count++;
                }
                if (count == 2) System.out.println(str);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
