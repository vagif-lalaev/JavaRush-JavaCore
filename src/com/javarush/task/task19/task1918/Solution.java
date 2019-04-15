package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args)throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()))) {
            while (fileReader.ready()) {
                stringBuilder.append(fileReader.readLine());
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        String data = stringBuilder.toString();

        String startTag = "<" + args[0]; //определяем начало поиска
        String endTag = "</" + args[0] + ">"; //определяем конец поиска
        int start;
        int end;
        int tempStart = 0;
        while(tempStart != -1) {
            start = data.indexOf(startTag, tempStart); //присваеваем индекс начало поиска
            if(start == -1 ){
                return;
            }
            end = data.indexOf(endTag, start); //присваеваем индекс концы поиска

            tempStart = data.indexOf(startTag, start + 1); //присваеваем индекс который требуется считать
            if(tempStart < end && tempStart!= -1){ //если индекс который нужен для вывода меньше индекса конца поиска и при этом не -1
                end = data.indexOf(endTag, end + 1); //то присваеваем индекс концу поиска значение определяющую конец строки
            }
            //выводим значение от начало до конца требуемого тега
            System.out.println(data.substring(start, end + endTag.length()));
        }
    }
}