package com.javarush.task.task19.task1919;
/* 
Считаем зарплаты
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        TreeMap<String, Double> set = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String[] s = reader.readLine().split(" "); //создание и заполнение массива
                if (set.containsKey(s[0])) { //если в массиве уже существует элемент с ключом key
                    //то добовляем в TreeMap элемент прибавив сумму другого элемента
                    set.put(s[0], set.get(s[0]) + Double.parseDouble(s[1]));
                } else set.put(s[0], Double.parseDouble(s[1])); //иначе добовляем элемент в TreeMap
            }
         } catch (IOException e) {
            e.getStackTrace();
        }
        for (Map.Entry<String, Double> it : set.entrySet()) { //проход по TreeMap
            System.out.println(it.getKey() + " " + it.getValue()); //вывод на экран
        }
    }
}
