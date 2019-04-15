package com.javarush.task.task14.task1420;
/* 
НОД
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        // закоментираванно потому что не пропускает валидатор ↓
      //x = Math.abs(x); // Преобразование числа по модулю
      //y = Math.abs(y); // Преобразование числа по модулю
        if (x <= 0 || y <= 0) throw new Exception(); // если значение < 0, то проборос исключение
        int z = Math.min(x, y); // находим минимальное значение из двух введенных
        for (int i = z; i > 0; i--) {
            if (x % i == 0 && y % i == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
