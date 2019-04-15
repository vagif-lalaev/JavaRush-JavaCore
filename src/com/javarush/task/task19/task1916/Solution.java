package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/* 
Отслеживаем изменения
*/
public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileReader reader1 = new FileReader(reader.readLine());
             FileReader reader2 = new FileReader(reader.readLine())) {
            String[] arr1 = solution.arrFromFileReader(reader1);
            String[] arr2 = solution.arrFromFileReader(reader2);
            int k = 0;
            int stepI;
            for (int i = 0; i < arr1.length; i += stepI) {
                if (k > arr2.length - 1) {
                    lines.add(new LineItem(Type.REMOVED, arr1[i]));
                    break;
                }
                int nextK = k + 1;
                int nextI = i + 1;
                if (!arr1[i].trim().equals(arr2[k].trim())) {
                    // смотрим, добавлен новый или удалён старый
                    // если arr2[k] - последний, то удалён
                    // если не последний, а последний arr1[i], то добавлен
                    // если оба не последних, сравниваем дальше
                    if (nextK > arr2.length - 1) {
                        lines.add(new LineItem(Type.REMOVED, arr1[i]));
                        lines.add(new LineItem(Type.SAME, arr1[nextI]));
                        break;
                    } else if (nextI > arr1.length - 1) {
                        lines.add(new LineItem(Type.ADDED, arr2[k]));
                        lines.add(new LineItem(Type.SAME, arr2[nextK]));
                        break;
                    } else {
                        // если не совпадают arr1[i] и arr2[k]
                        if (!arr1[i].trim().equals(arr2[nextK].trim())) {
                            // удалён arr1[i]
                            lines.add(new LineItem(Type.REMOVED, arr1[i]));
                            stepI = 1;
                        } else {
                            lines.add(new LineItem(Type.ADDED, arr2[k]));
                            k++;
                            stepI = 0;
                        }
                    }
                } else {
                    lines.add(new LineItem(Type.SAME, arr1[i]));
                    stepI = 1;
                    k++;
                }
            }
            if (k < arr2.length) {
                lines.add(new LineItem(Type.ADDED, arr2[k]));
            }

            for (LineItem x : lines) {
                System.out.println(x.type.toString() + " " + x.line);
            }
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }

    public String[] arrFromFileReader(FileReader reader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        int current;
        while (reader.ready()) {
            current = reader.read();
            stringBuffer.append((char) current);
        }
        String test = stringBuffer.toString();
        return test.split("\n");
    }
}

/* // еще один вариант решения (типа оптимизация) (не мое)
for (int i = 0, j = 0; ; ) {
            String s1 = i < strings.size() ? strings.get(i) : "";
            String s2 = j < strings2.size() ? strings2.get(j) : "";

            if (s1.length() == 0 && s2.length() == 0)
                break;

            if (s1.equals(s2)) {
                lines.add(new LineItem(Type.SAME, s1));
                i++;
                j++;
            } else if ((i + 1) < strings.size() && s2.equals(strings.get(i + 1))) {
                lines.add(new LineItem(Type.REMOVED, s1));
                i++;
            } else {
                lines.add(new LineItem(Type.ADDED, s2));
                j++;
            }
        }
 */