package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;
/* 
Закрепляем адаптер
*/
public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
        this.customer = customer;
        this.contact = contact;
        }

        @Override
        //выводим из списка HashMap, ключ
        public String getCountryCode() {
            String result = null;
            for (Map.Entry<String, String> it : countries.entrySet()) { //пробегаем по всему списку
                if (it.getValue().equals(customer.getCountryName())) { //если в списке значений есть сходство со значением указный в методе customer.getCountryName()
                    result = it.getKey(); //то присваеваем и выводим ключ этого значения
                    break;
                }
            }
            return result;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().split(", ")[1]; //удаляем из переданного метада ", " и выводим второе значение массива
        }

        @Override
        public String getContactLastName() {
            return contact.getName().split(", ")[0]; //удаляем из переданного метада ", " и выводим впервое значение массива
        }

        @Override
        public String getDialString() {
            //добовляем к выводу "callto://+" и заменяем у метода все символы на ""
            return "callto://+" + contact.getPhoneNumber().replaceAll("[\\D]", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA
        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan
        String getContactLastName();    //For example: Ivanov
        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.
        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan
        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}