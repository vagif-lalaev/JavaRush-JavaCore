package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("C:\\Users\\Вагиф\\YandexDisk\\JAVA\\Проэкты от JavaRush\\Проэкты от JavaRush (полностью рабочая)\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);

            //производим проверку, есть ли что читать
            String isEqual = (somePerson.equals(ivanov)) ? "is equal" : "is not equal";
            System.out.println(isEqual);

            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
           PrintWriter printWriter = new PrintWriter(outputStream); //использую для записи
                String strName = (name != null) ? "yes" : "no"; //проверка на null
                printWriter.println(strName); //запись проверки в файл
                if ("yes".equals(strName)) { //проверка есть ли запись
                    printWriter.println(name); //запись имени
                    if (assets.size() > 0) { //проверка есть ли что в списке
                        for (int i = 0; i < assets.size(); i++) { //проходим по списку
                            printWriter.println(assets.get(i).getName()); //записываем имя из списка
                            printWriter.println(assets.get(i).getPrice()); //записываем значение из списка
                        }
                    }
                }
                printWriter.flush(); //сохроняем
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            //переводим и читаем записынные данные
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String strName = bufferedReader.readLine(); //считываем проверку
            if ("yes".equals(strName)) { //проверка
                name = bufferedReader.readLine(); //считываем имя
                while (bufferedReader.ready()) { //проверка есть ли что читать
                    String assetN = bufferedReader.readLine(); //считываем имя из списка
                    double db = Double.parseDouble(bufferedReader.readLine()); //считываем значение из списка
                    this.assets.add(new Asset(assetN, db)); //доболвляем прочтенные данные в список
                }
            }
        }
        //implement this method - реализуйте этот метод
    }
}
