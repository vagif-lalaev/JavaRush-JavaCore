package com.javarush.task.task19.task1908;
/* 
Выделяем числа
*/
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        // открытия потокрв ввода, чтения и записи, автоматическое закрытие включено
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter (reader.readLine()))) {
            while(fileReader.ready()) { //если в вайле есть что читать
                String str = fileReader.readLine(); //считываем построчно
                Pattern pattern = Pattern.compile("\\b\\d+\\b"); //считать все числа, которые начинаются на число и заканчиваются
                Matcher matcher = pattern.matcher(str); //передаем прочтенную строку, для анализа
                while (matcher.find()) { //если совпало требуемое условие к тексту
                    fileWriter.write(matcher.group() + " "); //то записать вывод в файл
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}