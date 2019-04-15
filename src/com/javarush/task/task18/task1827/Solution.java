package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    // оба варианта рабочие , нужно разобратся

//    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader fileReader;
//        BufferedWriter writer;
//        if (args[0].equals("-c")) {
//            fileReader = new BufferedReader(new FileReader(reader.readLine()));
//            int id;
//            int maxiId = 0;
//            while (fileReader.ready()) {
//                id = Integer.parseInt(fileReader.readLine().substring(0, 8).trim());
//                if (id > maxiId) {
//                    maxiId = id;
//                }
//            }
//            fileReader.close();
//            writer = new BufferedWriter(new FileWriter(reader.readLine(), true));
//            writer.newLine();
//            writer.write(String.format("\n%8d%30.30s%8.8s%4.4s", maxiId+1, args[1], args[2], args[3]));
//            writer.close();
//        }
public static void main(String[] args) throws Exception {
    if (args.length != 0 && args[0].equals("-c")) // проверка на наличие аргументов и первого аргумента
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        ArrayList<Integer> list = new ArrayList<>();
        while (fileReader.ready()) { //запись интерегера преобразованного из первых восьми символов каждой строки
            list.add(Integer.parseInt(fileReader.readLine().substring(0, 8).trim()));
        }

        int maxID = Collections.max(list); //выбираю максимальный ID
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true)); //поток записи с ДОзаписью
        writer.write(String.format("\n%-8s%-30s%-8s%-4s", ++maxID, args[1], args[2], args[3])); // новая строка и для каждого параметра нужное количество символов
        fileReader.close();
        writer.close();
    }
    else return;

    }
}
