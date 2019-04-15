package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("C:\\Users\\Вагиф\\YandexDisk\\JAVA\\Проэкты от JavaRush\\Проэкты от JavaRush (полностью рабочая)\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            // эти объекты нужны для проверки
//            User us = new User();
//            us.setFirstName("Pavel");
//            us.setLastName("Ivanov");
//            us.setBirthDate(new Date());
//            us.setMale(true);
//            us.setCountry(User.Country.RUSSIA);
//            javaRush.users.add(us);

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            //тут проверяем, является ли записанный и прочитанный объект одинаковым
            String control = (javaRush.equals(loadedObject) ? "yes" : "no");
            System.out.println("control: " + control);

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream)); //откр.поток для записи
            if (users.size() > 0) { //проверка на пустату списка
                for (int i = 0; i < users.size(); i++) { //проходим по циклу для записи в файл
                    bufferedWriter.write(users.get(i).getFirstName() + "\n"); //записываем имя
                    bufferedWriter.write(users.get(i).getLastName() + "\n"); //записываем фамилию
//                    SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);   // формат в который  будет переводить строку
//                    String str = sdf.format(users.get(i).getBirthDate());
                    bufferedWriter.write(new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH).format(users.get(i).getBirthDate()) + "\n"); //записываем дату в нужном нам формате
                    bufferedWriter.write(users.get(i).isMale() + "\n"); //записываем пол
                    bufferedWriter.write(users.get(i).getCountry() + "\n"); //записываем страну
                }
            }
            bufferedWriter.flush(); //сохроняем
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream)); //откр.поток для чтения
            while (bufferedReader.ready()) { //если есть что читать то
                User user = new User(); //создаем объект
                user.setFirstName(bufferedReader.readLine()); //читаем имя
                user.setLastName(bufferedReader.readLine()); //читаем фамилию
//                SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
//                Date date = sdf.format(str0);
//                user.setBirthDate(date);
                //считываем дату в нужном нам формате
                String str0 = bufferedReader.readLine();
                user.setBirthDate(new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH).parse(str0));
                user.setMale(Boolean.parseBoolean(bufferedReader.readLine())); //считываем пол
                String str = bufferedReader.readLine(); //считываем строку для страны
                //проверяем, объект какой страны является
                if (str.equals("UKRAINE")) user.setCountry(User.Country.UKRAINE);
                if (str.equals("RUSSIA")) user.setCountry(User.Country.RUSSIA);
                if (str.equals("OTHER")) user.setCountry(User.Country.OTHER);
                //передаем все прочитанные данные объекту "users"
                this.users.add(user);
            }
            // для проверки
//            for (User x : users) {
//                System.out.println(x.getFirstName());
//                System.out.println(x.getLastName());
//                System.out.println(x.getBirthDate());
//                System.out.println(x.isMale());
//                System.out.println(x.getCountry());
//            }
//            implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            JavaRush javaRush = (JavaRush) o;
            return users != null ? users.equals(javaRush.users) : javaRush.users == null;
        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
