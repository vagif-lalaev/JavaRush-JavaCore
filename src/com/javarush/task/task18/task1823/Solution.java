package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
/* 
Нити и байты
*/
public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str ;
        //вводим путь к файлу пока не напишим "exit" из цикла не выходим
        while (!(str = reader.readLine()).equals("exit")) {
            new ReadThread(str).start(); //создаем и запускаем нить
        }
        for (Map.Entry entry : resultMap.entrySet()) { //проходим по списку Map
            System.out.println(entry.getKey() + " " + entry.getValue()); // отображаем ключ + значение
        }
    }

    public static class ReadThread extends Thread {
        String str;
        public ReadThread(String fileName) throws IOException {
           str = fileName;
            //implement constructor bodybody
        }

        @Override
        public void run() {
            try {
                //открываем поток для чтения файла
                FileInputStream fileInputStream = new FileInputStream(str);
                int [] mb = new int [256];
                int count = 0;
                while (fileInputStream.available() > 0) { //цикл работает пока есть значения в файле
                    int data = fileInputStream.read(); //побайтное чтение из файла
                    mb[data]++; //инкрементируем прочтенный байт
                    for (int i = 0; i < mb.length; i++) { //проходим по массиву
                        if (mb[i] > count) { //если значение в массиве больше count
                            count = mb[i]; //то присваеваем данное значение count
                        }
                    }
                }
                fileInputStream.close();
                for (int i = 0; i < mb.length; i++) { //проходим по массиву
                    if (mb[i] == count) { //если массив значение равно значению count
                        resultMap.put(str, i); //то добовляем названия файла и максимальное число повторений символа в этом файле
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
