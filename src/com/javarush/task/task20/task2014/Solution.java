package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        try (ObjectOutputStream saved = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Вагиф\\YandexDisk\\JAVA\\Проэкты от JavaRush\\Проэкты от JavaRush (полностью рабочая)\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\txt"));
        ObjectInputStream loaded = new ObjectInputStream(new FileInputStream("C:\\Users\\Вагиф\\YandexDisk\\JAVA\\Проэкты от JavaRush\\Проэкты от JavaRush (полностью рабочая)\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\txt"))) {
            Solution savedObject = new Solution(-13);
            saved.writeObject(savedObject); //записал объект
            System.out.println(savedObject.string); //вывел в консоль
            Solution loadedObject = (Solution) loaded.readObject(); //создал новый объект и записал в него прочитанный объект
            System.out.println(loadedObject.string); //вывел в консоль
            System.out.println(savedObject.string.equals(loadedObject.string)); //проверил совподает ли записанное с прочтенным
        } catch (IOException e) {
            e.getStackTrace();
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
        }
        System.out.println(new Solution(4));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
