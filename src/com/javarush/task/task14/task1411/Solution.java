package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/* 
User, Loser, Coder and Proger
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key=null;
        while (true){
            key = reader.readLine();
            if (key.equals("user")) {   // если вводим "user" то
                person = new Person.User(); // присваеваем переменно person объект Person и под класс User, и т.д.
            } else if (key.equals("loser")) {
                person = new Person.Loser();
            } else if (key.equals("coder")) {
                person = new Person.Coder();
            } else if (key.equals("proger")){
                person = new Person.Proger();
            } else break;

            doWork(person); //вызываем метод doWork
            //тут цикл по чтению ключей, пункт 1
            //создаем объект, пункт 2
        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User){ // если переменная person содержится в интерфейсе Person и подклассе User, то
            ((Person.User) person).live();  // присваеваем переменной person метод интерфейса, Person класса User метод live().
//            Person.User pp = (Person.User) person;    ] можно вызвать метод
//            pp.live();                                ] и таким варантом
        }
        if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        }
        if (person instanceof Person.Coder) {
            ((Person.Coder) person).coding();
        }
        if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
        // пункт 3
    }
}
