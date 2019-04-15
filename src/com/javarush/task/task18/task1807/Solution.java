package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        // C:\Users\Vagif\YandexDisk\JAVA\Проэкты от JavaRush\Проэкты от JavaRush (полностью рабочая)\JavaRushTasks\2.JavaCore\src\com\javarush\task\txt
        int count = 0; // счетчик
        while(fileInputStream.available() > 0) { // если есть хоть какое-то количество байтов то
            // тут ниже сравниваем, есть ли в прочитанных байтах код "44",
            // (44 - это байт код из таблицы ASCII что вызывает символ ',')
            // так же в замен "44" можно использовать "','" или "(byte)','"
            if (fileInputStream.read() == 44) { //если да то
                count++; // читаем сколько раз
            }
        }
        System.out.println(count); // выводим счетчик
        fileInputStream.close(); // закрываем поток
    }
}
