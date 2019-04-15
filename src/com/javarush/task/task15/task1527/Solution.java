package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
/* 
Парсер реквестов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        URL url = new URL(reader.readLine()); // принимает на вход ссылку (URL);
   //   URL url = new URL("http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo"); // для проверки
        String[] str = url.getQuery().split("&"); // разделить на массив, если встречается символ "&"
        for (String x : str) { // цикл для перебора уже отсортировнного массива
            if (x.contains("=")) { // если в массиве встречается "="
                int in2 = x.indexOf("="); // какой индекс по счету явлется знака "="
                String sub2 = x.substring(0, in2); // считать элемент с массива с индексам 0 до значаения индекса "in2"
                System.out.print(sub2 + " "); // отобразить элемент "sub2", + добавить пробел
            } else if (!x.contains("=")) { // если невстречается элемент со знаком "=";
                System.out.print(x + " "); // то отобразить как есть + пробел.
            }
        }
        System.out.println(); // переход на страку вниз
        for (String y : str) { // цикл для перебора уже отсортировнного массива
            int in = y.indexOf("="); // какой индекс по счету явлется знака "="
            String chislo = y.substring(in + 1); // считать элемент с массива с индексам "in" + 1
            try { // блок поиска ошибки если не число
                if (y.contains("obj")) { // если присутствует параметр "obj"
                    double chInt = Double.parseDouble(chislo); // переводим значение в double
                    alert(chInt); // то передать его значение в нужный метод alert для double;
                    break; // остановка процесса
                }
            } catch (NumberFormatException e) { // если не число то запускаем другой метод
                alert(chislo); // запуск метода alert для String.
            }
        }
    }
    public static void alert(double value) {
        System.out.println("double " + value);
    }
    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
