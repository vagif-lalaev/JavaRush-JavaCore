package com.javarush.task.task20.task2021;

import java.io.*;
/* 
Сериализация под запретом
*/
public class Solution implements Serializable {

    public static class SubSolution extends Solution {
        //прописываем два метода и выбрасываем исключения
        private void writeObject(ObjectOutputStream stream) throws NotSerializableException {
            throw new NotSerializableException("Not Serializable");
        }
        private void readObject(ObjectInputStream stream) throws NotSerializableException {
            throw new NotSerializableException("Not Serializable");
        }
    }

    public static void main(String[] args) {
    }
}
