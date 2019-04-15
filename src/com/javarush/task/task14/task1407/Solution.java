package com.javarush.task.task14.task1407;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/* 
Player and Dancer
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Person person = null;
        String key;
        while (!(key = reader.readLine()).equals("exit")) {
            if ("player".equals(key)) {
                person = new Player();
            } else if ("dancer".equals(key)) {
                person = new Dancer();
            }
            haveRest(person);
        }
    }

    public static void haveRest(Person person) {
        if (person instanceof Player) { // проверка относится ли person к объекту Player()
            ((Player) person).play(); // вызов метода класса Player()
            // Player pl = (Player)person;   ] можно и так
            // pl.play();                    ] вызвать метод класса Player()
            }
        else if (person instanceof Dancer) { // проверка относится ли person к объекту Dancer()
            ((Dancer)person).dance(); // вызов метода класса Dancer()
            // Dancer dr = (Dancer)person;  ] можно и так
            // dr.dance();                  ] вызвать метод класса Dancer()
        }
        //напишите тут ваш код
    }

    interface Person {
    }

    static class Player implements Person {
        void play() {
            System.out.println("playing");
        }
    }

    static class Dancer implements Person {
        void dance() {
            System.out.println("dancing");
        }
    }
}
