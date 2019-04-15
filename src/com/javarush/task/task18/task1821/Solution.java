package com.javarush.task.task18.task1821;
/* 
Встречаемость символов
*/
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]); //передаем аргумент в параметр main
        ArrayList<Character> ch = new ArrayList<>(); //создаем и инициализируем ArrayList
        while (reader.ready()) { //если есть что читать
            ch.add((char) reader.read()); //то считываем и заносим в список
        }
        reader.close(); //закрываем поток чтения

        Map<Character, Integer> freqList = new TreeMap<Character, Integer>(); //создаем и инициализируем TreeMap
        for(char key : ch) { //цикл forich для прохода по ArrayListу
            if(freqList.containsKey(key)) { //если существует элемент в массиве с ключем "key"
                freqList.put(key, freqList.get(key) + 1); //то заносим в список "TreeMap" значение "key"(char) и значение соответствующему ключу(int)
            } else
                freqList.put(key, 1); //иначе заполняется "key" с значением "1"
        }

        for (Map.Entry entry : freqList.entrySet()){ //циклом проходим по коллекции Map
            System.out.println(entry.getKey() + " " + entry.getValue()); //отображаем ключь(char) и значение(int)
        }
    }
}
