package com.javarush.task.task18.task1820;
/* 
Округление чисел
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileR = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileW = new BufferedWriter(new FileWriter(reader.readLine()));

        String str;
        while ((str = fileR.readLine()) !=null) {
            String [] strM = str.split(" "); //создаем массив и каждое прочитанное значении разделяем пробелом
            for (String x : strM) { //проходим по массиву (по каждому элементу)
                int krug = (int)Math.round(Double.parseDouble(x)); //создаем переменную и присваеваем ее в округленном виде
                fileW.write(krug + " "); //записываем в фаил округленные вырожения с добавлением пробелов
            }
        }
        fileR.close();
        fileW.close();
    }
}
