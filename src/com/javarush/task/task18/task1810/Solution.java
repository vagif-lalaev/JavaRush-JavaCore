package com.javarush.task.task18.task1810;
/* 
DownloadException
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true){ // бесконечный цикл
            FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine()); //запрос ссылки
            if (fileInputStream.available() < 1000) { //если количество байтов меньше 1000
                fileInputStream.close(); // то закрыть поток чтение файла
                throw new DownloadException(); // вызвать исключение
            }
        }
    }
    public static class DownloadException extends Exception {

    }
}
