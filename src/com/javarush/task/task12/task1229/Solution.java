package com.javarush.task.task12.task1229;
/* 
Родитель класса CTO
*/
public class Solution {

    public static void main(String[] args) {
        CTO cto = new CTO();
        System.out.println(cto);
    }

    public static interface Businessman {
        public void workHard();
    }

    public static class CTO extends CTO1 implements Businessman { // наследовал от придуманного класса СТО1

    }
    // напиши код тут
    public static class CTO1 { // написал класс и переопределил метод интерфеса
        public void workHard(){
        }
    }
}
