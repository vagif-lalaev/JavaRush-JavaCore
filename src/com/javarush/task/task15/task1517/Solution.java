package com.javarush.task.task15.task1517;

/* 
Статики и исключения
*/

public class Solution  {
    public static int A = 0;

    static { if(1<10)
            throw new RuntimeException();
        //throw an exception here - выбросьте эксепшн тут
    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}
