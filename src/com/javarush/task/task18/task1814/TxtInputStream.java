package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.IOException;
/* 
UnsupportedFileName
*/
public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        // .endsWith(".txt"), метод проверяет, оканчивается ли на окончания ".txt", если да то возвращает true
        if (!fileName.endsWith(".txt")) { // если false то;
            super.close(); // закрываем поток
            throw new UnsupportedFileNameException(); // пробрасываем новое исключение
        }
    }
    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
    }
}

