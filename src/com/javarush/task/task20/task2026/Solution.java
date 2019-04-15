package com.javarush.task.task20.task2026;
/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
//        int count1 = getRectangleCount(a1);
//        System.out.println(count1);
    }

    public static int getRectangleCount(byte[][] a) {
        int coint = 0; //счетчик
        for (int i = 0; i < a.length; i++) { //проходим по строкам
            for (int j = 0; j < a.length; j++) { //проходим по столбцам
                if (a[i][j] == 1 ){ //если найдена 1
                    coint++; //добавляем +1 к счетчику
                    for (int k = i; k < a.length; k++) { //проходим дополнительно по строкам передавая значение строки
                        if (a[k][j] == 0 ) { //если в строке найден 0
                            break; //то выходим из цикла
                        } for (int l = j; l < a.length; l++) { //иначе проходим циклом по столбцам передавая значения столбца
                            if (a[k][l] == 1 ) { //если в столбце находим 1
                                a[k][l] = 0; //то присваиваем ей 0
                            } else break; //иначе выходим из цикла
                        }
                    }
                }
            }
        }
        return coint; //возврат общего кол.посчитонного
    }
}
