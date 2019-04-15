package com.javarush.task.task19.task1923;
/* 
Слова с цифрами
*/
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(args[1]))) {
            String str;
            //читаем строки и записываем в переменную str пока не нул
            while ((str = file1.readLine()) != null) {
                Pattern p = Pattern.compile("\\S*\\d+\\S*"); //ищем все слова согласно этой регулярки
                Matcher m = p.matcher(str); //передаем текст в котором нужно искать
                while (m.find()) file2.write(m.group() + " "); //проходим циклом по тексту в поисках необходимых слов
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
