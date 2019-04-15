package com.javarush.task.task19.task1927;
/* 
Контекстная реклама
*/
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream sy = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(sy);
        //деление по переход на строку ниже System.lineSeparator() - (так более универсально) тоже самое что и "\\n"
        String [] result = byteArrayOutputStream.toString().split(System.lineSeparator()); //делим строку "\\n" и заполняем массив
        for (int i = 0; i < result.length; i++) { //проходим по массиву
            System.out.println(result[i]); //выводим
            if (i % 2 != 0) { //если строка третья,
                System.out.println("JavaRush - курсы Java онлайн"); //то выводим рекламу
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
