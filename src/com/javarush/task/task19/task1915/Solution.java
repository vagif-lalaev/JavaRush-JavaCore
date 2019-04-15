package com.javarush.task.task19.task1915;
/* 
Дублируем текст
*/
import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //решели сам однако наоборот было бы быстрей и удобней, т.е. в начале FileOutputStream а потом ByteArrayOutputStream используя метод writeTo
        PrintStream pr = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream print = new PrintStream(byteArrayOutputStream);
        System.setOut(print);
        testString.printSomething();
        try(BufferedReader nameFile = new BufferedReader (new InputStreamReader(System.in));
            BufferedOutputStream reader = new BufferedOutputStream (new FileOutputStream(nameFile.readLine()))) {
//            reader.write(byteArrayOutputStream.toString().getBytes()); //это удобней, закрывает 5 строчек снизу
//            reader.write(byteArrayOutputStream.toByteArray()); //или сделать так, что еще проще
            String str = byteArrayOutputStream.toString(); //присваеваю строке byteArrayOutputStream
            char[] ch = str.toCharArray(); //перевод с строки в char
            for (char x : ch) { //прохожу по массиву char
                reader.write(x);//записываю каждый элемент в массиве
            }
        } catch (IOException e) {
            e.getStackTrace();
        }

        System.setOut(pr); //возвращаю как было
        System.out.println(byteArrayOutputStream.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

