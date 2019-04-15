package com.javarush.task.task13.task1326;
/* 
Сортировка четных чисел из файла
*/
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // чтение с консоли (это для ввода имени файла (который заранее был создан с цифрами "text"))
        ArrayList<Integer> list = new ArrayList<Integer>(); // создаем и инициализируем аррай лист
        try {
            String file = reader.readLine(); // запрос на пусть к файлу "text".
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            // Files.lines(Paths.get("C:\\Users\\Вагиф\\YandexDisk\\JAVA\\Проэкты от JavaRush\\Проэкты от JavaRush (полностью рабочая)\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task13\\task1326\\" + reader.readLine())).forEach(System.out::println); (данный код заменяет все вышенаписанный текст, кроме аррай листа, еще тут он выводит его на консоль)
            while (fileReader.ready()) { //.ready() будет возвращать false до тех пор пока пользователь не введёт какие-то данные и не нажмёт enter ↵, другими словами цикл запиститься если метод выдает true (т.е. присутствуют поток данных)
                int i = Integer.parseInt(fileReader.readLine());
                if (i % 2 == 0) // если четное число,
                    list.add(i); // то добовляем его в список Array
            }
            fileReader.close(); // закрываем поток
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(list); // метод позволяет сортировать числа по возрастанию
        for (Integer i : list) { // цикл для передачи последовательно всех данных из масива "list" в переменную "i"
            System.out.println(i); // отображение переданных данных из переменной "i".
            // в запросе нужно прописать путь до файла C:\\Users\\Вагиф\\YandexDisk\\JAVA\\Проэкты от JavaRush\\Проэкты от JavaRush (полностью рабочая)\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task13\\task1326\\text
        }
    }
}