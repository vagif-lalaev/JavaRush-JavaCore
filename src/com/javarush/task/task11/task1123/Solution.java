package com.javarush.task.task11.task1123;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Maximum is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] array) {
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }

       // Отличное решение, но не мое.
       // Arrays.sort(array);
       // return new Pair<Integer, Integer>(array[0], array[array.length-1]);

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int z : array){
            if (min > z) {
                min = z;
            }
            if (max < z) {
                max = z;
            }
        }
        return new Pair<>(min,max);
        //Напишите тут ваше решение
    }

    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
