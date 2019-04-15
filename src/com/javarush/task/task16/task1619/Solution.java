package com.javarush.task.task16.task1619;
/* 
А без interrupt слабо?
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start();
        Thread.sleep(3000);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() { //Тут обращаемся в публичному стат свойству класса
        TestThread.isChenil = true; // Меняем флажок свойство на true чтобы цикл прекратился
    }

    public static class TestThread implements Runnable {
       public static boolean isChenil = false; //Создал флажок запуска цикла и сделал его публичным
        public void run() {
            while (!isChenil) { //Тут цикл выполняется пока флажок false
                try {
                    System.out.println("he-he");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
