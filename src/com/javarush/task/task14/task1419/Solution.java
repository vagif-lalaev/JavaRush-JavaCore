package com.javarush.task.task14.task1419;

import java.util.ArrayList;
import java.util.List;
/* 
Нашествие исключений
*/
public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        } finally {
            exceptions.add(new java.lang.NullPointerException());
            exceptions.add(new java.lang.IndexOutOfBoundsException());
            exceptions.add(new java.lang.ArrayIndexOutOfBoundsException());
            exceptions.add(new java.lang.StringIndexOutOfBoundsException());
            exceptions.add(new java.lang.ArrayStoreException());
            exceptions.add(new java.lang.InterruptedException());
            exceptions.add(new java.lang.IllegalMonitorStateException());
            exceptions.add(new java.lang.IllegalThreadStateException());
            exceptions.add(new java.lang.RuntimeException());
        }
        //напишите тут ваш код
    }
}
