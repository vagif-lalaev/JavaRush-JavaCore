package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    Properties ppr = new Properties(); //создаем клас Properties()

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        load(fileInputStream);
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        ppr.putAll(properties); //сохраняем всё в классе Properties()
        ppr.store(outputStream, null);
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        ppr.load(inputStream); //загружаем сохраненное
        for (String key : ppr.stringPropertyNames()) {
            properties.put(key, ppr.getProperty(key));
        }
        inputStream.close();
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) throws Exception {
//        Solution solution = new Solution();
//
//        solution.fillInPropertiesMap();
////        ======================== test=====================
//        for (Map.Entry<String, String> pair : properties.entrySet()){
//            System.out.println(pair.getKey() + "---" + pair.getValue());
//        }
//// ========================= save test =====================
//        try {
//            OutputStream outputStream = new FileOutputStream("C:\\Users\\Вагиф\\YandexDisk\\JAVA\\Проэкты от JavaRush\\Проэкты от JavaRush (полностью рабочая)\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\txt");
//            solution.save(outputStream);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
