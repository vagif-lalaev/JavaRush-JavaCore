package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* 
???? ????????
*/
public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws ParseException {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
        SimpleDateFormat si = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH); //для верного отображение даты
        while(reader.ready()) { //если с файла есть что читать
            String read = reader.readLine(); //считываем построчно
            Pattern p1 = Pattern.compile("([\\D]+)\\D+(\\d+ \\d+ \\d+)"); //записываем регулярку которая делится на две группы (имя и дату)
            Matcher m1 = p1.matcher(read); //регулярку применяем на прочтенный текст
            if (m1.find()) //проверка есть ли что считать по регулярке
            PEOPLE.add(new Person(m1.group(1), si.parse(m1.group(2)))); //добовляем в лист нового объекта с данными по группам, группа 1 - имя , группа 2 - дата + применяем формат
        } } catch (IOException e) {
            e.getStackTrace();
        }
        for (Person x : PEOPLE) { //проходим по листу
            System.out.println(x); //отображаем добавленные объекты
        }
    }
}
