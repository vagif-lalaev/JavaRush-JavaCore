package com.javarush.task.task18.task1824;
/* 
Файлы и исключения
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) { //вечный цикл
            String str = bufferedReader.readLine(); //ситаем с консоли
            //тут не закрываем поток явно, так как открытый поток помещенное в try(сюда), автоматически его закрывает.
            try (FileInputStream file = new FileInputStream(str)) { //открыт на чтение
            } catch (FileNotFoundException e) { //вывод исключения если нет файла
                System.out.println(str); //вывод имени файла
                break; //при исключении делаем выход из цикла
            }
        }
    }
}
