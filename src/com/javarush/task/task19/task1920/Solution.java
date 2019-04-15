package com.javarush.task.task19.task1920;
/* 
Самый богатый
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        TreeMap<String, Double> tree = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
        while (reader.ready()) {
            String s = reader.readLine();
            String [] str = s.split(" ");
            if (tree.containsKey(str[0])) {
                tree.put(str[0], tree.get(str[0]) + Double.parseDouble(str[1]));
            } else tree.put(str[0], Double.parseDouble(str[1]));
        } } catch (IOException e) {
            e.getStackTrace();
        }
        //этот код в замен ниже закаментированного
        for (Map.Entry<String, Double> it : tree.entrySet()) {
        if (it.getValue().equals(Collections.max(tree.values())))
            System.out.println(it.getKey());
        }
// закоментированное снизу мое первоначальное решение (работает)

//        double count = Double.MIN_VALUE;
//        for (Map.Entry<String, Double> it : tree.entrySet()) { //проход по TreeMap
//                if (it.getValue() > count) {
//                    count = it.getValue();
//                }
//        }
//        for (Map.Entry<String, Double> it2 : tree.entrySet()) {
//            if (it2.getValue() == count) {
//                System.out.println(it2.getKey());
//            }
//        }
    }
}
