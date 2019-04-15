package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
        printMatrix(5.2F,33,(String)"77.1F");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
        printMatrix(1,2,3);
    }
    public static void printMatrix(int m, int n, int d) {
        int r= m + n + d;
        System.out.println(r);
    }
    public static void printMatrix(int a, Integer b, String v) {
        System.out.println("4 констркутор");
    }
    public static void printMatrix(String a, Integer b, String v) {
        System.out.println("5 констркутор");
    }
    public static void printMatrix(double a, int b, float v) {
        System.out.println("6 констркутор");
    }
    public static void printMatrix(float a, float b, float v) {
        System.out.println("7 констркутор");
    }
    public static void printMatrix(Object a, Integer b, String v) {
        System.out.println("8 констркутор");
    }
    public static void printMatrix(Integer a, Integer b, String v) {
        System.out.println("9 констркутор");
    }
    public static void printMatrix(Object a, Object b, Object v) {
        System.out.println("10 констркутор");
    }
}
