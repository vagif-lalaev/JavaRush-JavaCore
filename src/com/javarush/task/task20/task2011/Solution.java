package com.javarush.task.task20.task2011;

import java.io.*;
/*
Externalizable для апартаментов
*/
public class Solution {
// реализуем интерфейс Externalizable
    public static class Apartment implements Externalizable {

        private String address;
        private int year;
// переопределяем все его два метода
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address); //записываем объект адрес
            out.writeInt(year); //записсываем римитив int
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address = (String) in.readObject(); //читаем объект String
            year = in.readInt(); //читаем примитив int
        }

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Apartment apt = new Apartment("г.Москва, Кутузовский просп., дом 18", 2017); //создаем объект Apartment
        //указываем путь к файлу куда будет производится запись
        ObjectOutputStream ou = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Вагиф\\YandexDisk\\JAVA\\Проэкты от JavaRush\\Проэкты от JavaRush (полностью рабочая)\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\txt"));
        ou.writeObject(apt); //сириализуем созданный объект apt
        ou.close(); //закрываем поток записи
        //указываем путь к файлу откуда будет производится чтение
        ObjectInputStream oi = new ObjectInputStream(new FileInputStream("C:\\Users\\Вагиф\\YandexDisk\\JAVA\\Проэкты от JavaRush\\Проэкты от JavaRush (полностью рабочая)\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\txt"));
        Apartment reApt = (Apartment) oi.readObject(); //десирализуем объект и явно преводим его тип
        System.out.println(reApt.toString()); //выводим на экран
        oi.close(); //закрываем поток чтения
    }
}
