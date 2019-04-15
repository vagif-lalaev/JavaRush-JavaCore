package com.javarush.task.task19.task1914;
/* 
Решаем пример
*/
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream pri = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream print = new PrintStream(byteArrayOutputStream);
        System.setOut(print);
        testString.printSomething();
        System.setOut(pri);
        String str = byteArrayOutputStream.toString();
        Pattern pattern = Pattern.compile("(\\d+) ([\\+\\-\\*]) (\\d+) =");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) { //проверка есть ли символы
            int a = Integer.parseInt(matcher.group(1)); //переводим со String в int
            int b = Integer.parseInt(matcher.group(3));
            System.out.print(matcher.group() + " "); //выводим переданное значение с str
            if (matcher.group(2).equals("+")) System.out.println(a + b); //если 2 группа имеет зна + то складываем
            if (matcher.group(2).equals("-")) System.out.println(a - b);//если 2 группа имеет зна + то вычитаем
            if (matcher.group(2).equals("*")) System.out.println(a * b);//если 2 группа имеет зна + то умножаем
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

