package com.javarush.task.task18.task1826;
/* 
Шифровка
*/
import java.io.*;

public class Solution {
//    public static void main(String[] args) throws IOException {
//        FileInputStream input = new FileInputStream(args[1]); //поток для чтение
//        FileOutputStream output = new FileOutputStream(args[2]); //поток для записи
//        if (args[0].equals("-e")) { //если в аргумент передать "-e"
//            while (input.available() > 0) { //если есть байты в файле
//                int read = input.read() + 3; //читайем каждый байт отдельно и добовляем 3
//                output.write(read); //записываем прочтенные и добавленные байты в фаил
//            }
//            input.close();//закрываем поток
//            output.close();//закрываем поток
//        } else if (args[0].equals("-d")) { //если в аргумент передать "-d"
//            while (input.available() > 0) {
//                int read = input.read() - 3; //читайем каждый байт отдельно и вычитаем 3
//                output.write(read);
//            }
//            input.close();
//            output.close();
//        }
//    }
    public static void main(String[] args) throws IOException {
    FileInputStream input = new FileInputStream(args[1]);
    FileOutputStream output = new FileOutputStream(args[2]);
    String arg = args[0];
    switch (arg) {
        case "-e": cipher(input, output, +3); break;
        case "-d": cipher(input, output, -3); break;
    }
}

    public static void cipher(FileInputStream input, FileOutputStream output, int shifr) throws IOException {
        while (input.available() > 0) {
            int read = input.read() + shifr;
            output.write(read);
        }
        input.close();
        output.close();
    }
}