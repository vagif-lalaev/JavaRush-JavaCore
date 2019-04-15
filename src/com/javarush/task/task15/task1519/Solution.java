package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/* 
Разные методы для разных типов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) { // бесконечный цикл
            String str = reader.readLine(); // вводим текст
            try {
                if(str.equals("exit")) { // если вводим "exit"
                break; // то завершаем цикл
                } else if (str.contains(".")) { // если вводим число с точкой
                    print((Double.valueOf(str))); // то относим к методу Double
                } else if (Integer.valueOf(str) > 0 && Integer.valueOf(str) < 128) { // если введенное значение > 0 и < 128
                    print((Short.valueOf(str))); // то запускаем метод Short
                } else if (Integer.valueOf(str) <= 0 || Integer.valueOf(str) >= 128) { // если введенное значение <= 0 и >= 128
                    print((Integer.valueOf(str))); // то запускаем метод Integer
                }
            } catch (NumberFormatException e) { // если вводим текст то выдаем ошибку
             print(String.valueOf(str)); // ошибку решаем запуском и отношением к методу String.
            }
        }
        //напиште тут ваш код
        // на перевод с строки в число, лучше использовать Integer.parseInt(str) чем Integer.valueOf(str).
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}

