package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        Thread tr0, tr1 , tr2, tr3, tr4; // перечесляем переменные, которые добовляем в лис (threads);
        threads.add(tr0 = new Tr0_1()); // каждой переменной присваеваем объект;
        threads.add(tr1 = new Tr0_1()); // каждой переменной присваеваем объект;
        threads.add(tr2 = new Tr2()); // каждой переменной присваеваем объект;
        threads.add(tr3 = new Tr3()); // каждой переменной присваеваем объект;
        threads.add(tr4 = new Tr4()); // каждой переменной присваеваем объект;
    }

    public static void main(String[] args) {
        threads.get(0).start(); // стартуем;
        //System.out.println("Запущен: 1 " + threads.get(0).isAlive()); // проверка на запуск нити;
        threads.get(1).start(); // стартуем;
        //System.out.println("Запущен: 2 " + threads.get(1).isAlive()); // проверка на запуск нити;
        threads.get(2).start(); // стартуем;
        // System.out.println("Запущен: 3 " + threads.get(2).isAlive()); // проверка на запуск нити;
        threads.get(3).start(); // стартуем;
        // System.out.println("Запущен: 4 " + threads.get(3).isAlive()); // проверка на запуск нити;
        threads.get(4).start(); // стартуем;
        // System.out.println("Запущен: 5 " + threads.get(4).isAlive()); // проверка на запуск нити;
    }

    public static class Tr0_1 extends Thread { // класс для первой и второй нити;
        @Override
        public void run() { // тело первых двух нитей;
            while (true) { // бесконечный цикл;
                try {
                    threads.get(1).sleep(100); // спим 100 милисикунд;
                } catch (InterruptedException e) { // выводим ошибку;
                    System.out.println("InterruptedException"); // текст ошибки;
                }
            }
        }
    }

    public static class Tr2 extends Thread { // класс для третей нити;
        @Override
        public void run() { // тело третей нити
            while (true) { // бесконечный цикл;
                try {
                    System.out.println("Ура"); // выводим ура;
                    Thread.sleep(500); // спим 500 мс;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Tr3 extends Thread implements Message { // склас для 4 нити;

        @Override
        public void run() { // тело для 4 нити
            while (!this.isInterrupted()) { } // завершить поток пока не вазовут метод interrupt();
            //showWarning();
        }
        @Override
        public void showWarning() { // интерфейс который останавливает поток;
            this.interrupt(); // метод для остановки потока;
        }
    }

    public static class Tr4 extends Thread { // класс для 5 нити;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // считываем с консоли;
        public static boolean stopThread = false; // создаем переменную;
        @Override
        public void run() { // тело для 5 нити;
            int result = 0; // итоговое начальное значение
            while (!stopThread) { // выполняем цикл пока переменная stopThread является false;
                String ch; // инициализация переменной
                try {
                    ch = reader.readLine(); // считываем с консоли;
                    if (ch.equals("N")) { // если вводим "N";
                        stopThread = true; // то останавливаем поток, передав премен. stopThread true;
                        System.out.println(result); // выводим на печать result;
                    }
                    if (!(ch.equals("N"))) { // если не "N";
                        int chislo = Integer.parseInt(ch); // то переменной присваеваем (приобразуя в число)
                        result += chislo; // прибовляем к result вводимых значений
                    }
                } catch (NumberFormatException e) {
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }
        }
    }
}