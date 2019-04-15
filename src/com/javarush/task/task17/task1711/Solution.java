package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* 
CRUD 2
*/
public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        /*
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
         */
       // -----------------------------------------------------------
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
// перебор аргументов переданных в args, как читал в комментах это все нужно для базы данных
        switch (args[0]) { // выврл первого оргумента
            case "-c": // если первый аргумент -с
                synchronized(allPeople) { // произвести синхранизацию (тут не надо, но если многопоточность то нужно)
                    for (int i = 1; i < args.length; i = i + 3) { // перебираем каждое 4 имя
                        if (args[i] == null) { // если имени нет
                            break; // то выходим из цикла
                        } else if (args[i + 1].equals("м")) { // иначе если аргумент с индексом 2 является "м"
                            allPeople.add(Person.createMale(args[i], format1.parse(args[i + 2]))); // то добовляем объект мужского рода
                        } else { // иначе
                            allPeople.add(Person.createFemale(args[i], format1.parse(args[i + 2]))); // добовляем объект женского рода
                        }
                        System.out.println(allPeople.size()-1); // вывод id человека (-1 потому что id ведет отсчет с 0)
                    }
                    break; // выход с ключа
                }
            case "-u": // если первый аргумент -u
                synchronized(allPeople) {
                    for (int i = 1; i < args.length; i = i + 4) { // перебираем каждое 5 id
                        if (args[i] == null) { // если id нет
                            break; // то выходим из цикла
                        } else if (args[i + 2].equals("м")) { // иначе если аргумент с индексом 3 является "м"
                            allPeople.set(Integer.parseInt(args[i]), Person.createMale(args[i + 1], format1.parse(args[i + 3]))); // то изменяем(обновляем) объект мужского рода
                        } else // иначе
                            allPeople.set(Integer.parseInt(args[i]), Person.createFemale(args[i + 1], format1.parse(args[i + 3]))); // изменяем(обновляем) объект женского рода
                    }
                    break;
                }
            case "-d": // если первый аргумент -d
                synchronized(allPeople) {
                    for (int i = 1; i < args.length; i++) { // перебираем каждое id
                        if (args[i] == null) { // если id нет
                            break; // то выходим из цикла
                        } else {
                            // производит логическое удаление человека с id, заменяет все его данные на null
                            allPeople.get(Integer.parseInt(args[i])).setName(null);
                            allPeople.get(Integer.parseInt(args[i])).setSex(null);
                            allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                        }
                    }
                    break;
                }
            case "-i":
                synchronized(allPeople) {
                    for (int i = 1; i < args.length; i++) { // перебираем аргументы
                        Person person = allPeople.get(Integer.parseInt(args[i])); // присваеваем объекту person id (числовое)
                        if (args[i] == null) {
                            break;
                        } else if (person.getSex().equals(Sex.MALE)) { // иначе если объект мужского рода
                            System.out.println(person.getName() + " м " + format2.format(person.getBirthDate())); // выводим данные в полном формате для муж.
                        } else System.out.println(person.getName() + " ж " + format2.format(person.getBirthDate())); // выводим данные в полном формате для жен.
                    }
                }
                break;
                // ------------------------------
        }
        //start here - начни тут
    }
}
