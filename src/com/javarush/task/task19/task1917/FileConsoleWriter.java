package com.javarush.task.task19.task1917;
/* 
Свой FileWriter
*/
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    //пишем пять конструкторов которые инициализируют fileWriter
    //5 конструкторов пишим по FileWriter согласно API
    public FileConsoleWriter (File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }
    public FileConsoleWriter (File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }
    public FileConsoleWriter (FileDescriptor fileDescriptor) throws  IOException {
        this.fileWriter = new FileWriter(fileDescriptor);
    }
    public FileConsoleWriter(String name) throws IOException {
        this.fileWriter = new FileWriter(name);
    }
    public  FileConsoleWriter (String name, boolean append) throws IOException {
        this.fileWriter = new FileWriter(name, append);
    }

    //должен содержать пять методов
    //При записи данных в файл, должен дублировать эти данные на консоль
    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        for (int i = off; i < off + len; i++) {
            System.out.print(cbuf[i]); }
    }
    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }
    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }
    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off, off + len));
    }
    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        for (char x : cbuf) {
            System.out.print(x); }
    }
    public void close() throws IOException {
        fileWriter.close(); }
    public static void main(String[] args) {
    }
}
