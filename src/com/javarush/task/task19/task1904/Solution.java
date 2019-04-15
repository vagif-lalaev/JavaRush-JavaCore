package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws ParseException {
//        для проверки
//        String name = "Иванов Иван Иванович 13 09 1993";
//        PersonScannerAdapter adapter = new PersonScannerAdapter(new Scanner(name));
//        System.out.println(adapter.read());
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() {
            String str = fileScanner.nextLine(); //считываем строку
            String[] strM = str.split(" "); //заполняем массив считынными словами, которые деляться по пробелам
            String data = strM[3] + " " + strM[4] + " " + strM[5]; //считываем и добовляем пробелы к прочтенным массивам, делая строку
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy"); //форматируем дату
            try {
                Date d = format.parse(data); //парсим дату учитывая стандарт формата
                return new Person(strM[1], strM[2], strM[0], d); //создаем бъект Person и передаем в него данные согласно конструктору
            } catch (ParseException e) {
                return null;
            }
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
