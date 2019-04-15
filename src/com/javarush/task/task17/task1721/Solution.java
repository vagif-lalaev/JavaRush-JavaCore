package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/* 
Транзакционность
*/
public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // для ввода данных в консоль

        File file = new File(reader.readLine()); // считываение первого файла (путь которых указываем с консоли)
        File file2 = new File(reader.readLine()); // считываение второго файла (путь которых указываем с консоли)

        BufferedReader readFile1 = new BufferedReader(new FileReader(file));
        BufferedReader readFile2 = new BufferedReader(new FileReader(file2));

        String f1;
        String f2;

        while ((f1 = readFile1.readLine()) != null) { // если фаил не пустой то
            allLines.add(f1); // добовляем данные в список
        }

        while ((f2 = readFile2.readLine()) != null) { // если фаил не пустой то
            forRemoveLines.add(f2); // добовляем данные в список
        }
        reader.close(); // закрываем поток

        try {
            new Solution().joinData(); // запускаем метод joinData()
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) { // если allLines содержит данные forRemoveLines
            allLines.removeAll(forRemoveLines); // то очистить из allLines все елементы содержашиеся в forRemoveLines
        } else {
            allLines.clear(); // очистить полностью список allLines
            throw new CorruptedDataException(); // сгенерировать исключение CorruptedDataException()
        }
    }
}
// тут список который нужно прописать в консоль
// C:\Users\Вагиф\YandexDisk\JAVA\Проэкты от JavaRush\Проэкты от JavaRush (полностью рабочая)\JavaRushTasks\2.JavaCore\src\com\javarush\task\task17\task1721\file
// C:\Users\Вагиф\YandexDisk\JAVA\Проэкты от JavaRush\Проэкты от JavaRush (полностью рабочая)\JavaRushTasks\2.JavaCore\src\com\javarush\task\task17\task1721\file2