package com.javarush.task.task15.task1526;

/* 
Дебаг, дебаг, и еще раз дебаг
*/

public class Solution {
    public static void main(String[] args) {
        new B(6);
    }

    public static class A {
        private int f1 = 7;

        public A(int f1) {
            this.f1 = f1;
            initialize();
        }

        private void initialize() { // меняем модификатор так чтобы его нельзя было переопределять,
            System.out.println(f1);
        }
    }

    public static class B extends A {
        protected int f1 = 3;

        public B(int f1) {
            super(f1);
            this.f1 += f1;
            initialize();
        }

        protected void initialize() { // тогда этот метод не будет работать, и потому f1 = 6.
            System.out.println(f1);
        }
    }
}