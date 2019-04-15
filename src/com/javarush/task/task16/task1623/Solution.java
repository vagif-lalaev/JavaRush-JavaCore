package com.javarush.task.task16.task1623;
/* 
Рекурсивное создание нитей
*/
public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {
        public GenerateThread() {
            super(String.valueOf(++countCreatedThreads)); // передаем intовую переменную и переводим в строку (String)
            start(); // при вызове конструктора, сразу стартуем
        }

        @Override
        public void run() {
            if (Solution.count > countCreatedThreads) {
                super.run();
                System.out.println(new GenerateThread()); // создаем и выводи на экран нить
            }
        }

        @Override
        public String toString() {
            return getName() + " created"; // при вызове создонной нити будет печатотться имя и порядковый номер
        }
    }
}
