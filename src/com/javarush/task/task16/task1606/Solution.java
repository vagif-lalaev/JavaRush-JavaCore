package com.javarush.task.task16.task1606;

import java.util.ArrayList;
import java.util.List;

/* 
join: в нужное время в нужном месте
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
//запустилаcь 1 нить (обьект main)
        PrintListThread firstThread = new PrintListThread("firstThread"); //создали первый обьект
        PrintListThread secondThread = new PrintListThread("secondThread"); //создали второй обьект
        firstThread.start(); //запустилась 2 нить (1 оьект firstThread )
        firstThread.join(); //остановилась 1 нить, (что бы дождаться полного выполнения, результатов 2 нити)
//снова продолжилась выполняться 1 нить
        secondThread.start(); //запустилась 3 нить (2 обьект secondThread )
    }

    public static void printList(List<String> list, String threadName) {
        for (String item : list) {
            System.out.println(String.format("%s : %s", threadName, item));
        }
    }

    public static List<String> getList(int n) {
        List<String> result = new ArrayList<String>();
        if (n < 1) return result;

        for (int i = 0; i < n; i++) {
            result.add(String.format("String %d", (i + 1)));
        }
        return result;
    }

    public static class PrintListThread extends Thread {
        public PrintListThread(String name) {
            super(name);
        }

        public void run() {
            printList(getList(20), getName());
        }
    }
}
