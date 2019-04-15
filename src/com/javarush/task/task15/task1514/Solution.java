package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(1.0, "will be program" );
        labels.put(1.1, "maybe programmer");
        labels.put(1.2, "i want to be programmer");
        labels.put(1.3, "i programmer");
        labels.put(1.4, "i respect programmer");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
