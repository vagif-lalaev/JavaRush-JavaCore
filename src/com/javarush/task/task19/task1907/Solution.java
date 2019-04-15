package com.javarush.task.task19.task1907;
/* 
Считаем слово
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        //открываем поток для записи в консоль и для чтения файла, и зкрываем автоматически
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()))) {
            int coint = 0; //счетчик
            String str;
            while (file.ready()) { //если есть что читать с файла
            str = file.readLine(); //считываем построчно
            //патерн регулярных выражений
                Pattern pp = Pattern.compile("\\bworld\\b"); //компилирует данное вырожение, где "\\b" начало и конец слова
                Matcher p2 = pp.matcher(str); //Создает совпадение, которое будет соответствовать входным данным
                while (p2.find()) { //если есть совподение то заходим в цикл
                    coint++; //считаем количество
                }
            }
            System.out.println(coint); //выводим количество совподений
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
