package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.List;
/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;
        //требуется пустой конструктор
        public Person () {
        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            children = (List<Person>)in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("Владимир","Ульянов", 47);
        Person father = new Person("Илья","Ульянов",86);
        Person mother = new Person("Мария","Ульянова",82);
        person.setFather(father); //установлеваем отца
        person.setMother(mother); //устан. мать
        ByteArrayOutputStream bos = new ByteArrayOutputStream(); //создаем BayteArray
        ObjectOutputStream oos = new ObjectOutputStream(bos); //поток для записи
        oos.writeObject(person); //сирилизуем объект
        byte [] buffer = bos.toByteArray(); //создаем массив и заполняем его дан. сирилизацией
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buffer)); //поток для чтения
        Person leninRestored = (Person) ois.readObject(); //десириализуем
        System.out.println(leninRestored.firstName + " " + leninRestored.lastName + " " + leninRestored.age);
        System.out.println(leninRestored.father.firstName + " " + leninRestored.father.lastName + " " + leninRestored.father.age);
        System.out.println(leninRestored.mother.firstName + " " + leninRestored.mother.lastName + " " + leninRestored.mother.age);
    }
}
