package com.javarush.task.task18.task1822;
/* 
Поиск данных внутри файла
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()));
        String [] ch; //создаем переменную моссив строк
        String str; //создаем переменну строки
        while((str = bufferedReader.readLine()) != null) { //если фаил переданный не пустой то
            ch = str.split(" "); //присвоить в массив значения разделенные пробелом из значен."str"
            if (ch[0].equals(args[0])){ //если значение по индексу равна значению переданного в args[0]
                break; //то выход из цикла
            }
        }
        bufferedReader.close(); //закрыть поток
        System.out.println(str); //отобразить значение присвоенное в цикле "str"
    }
}
