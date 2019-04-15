package com.javarush.task.task14.task1414;
/* 
MovieFactory
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //ввести с консоли несколько ключей (строк), пункт 7
        while (true){
            String read = reader.readLine();
            if (!(read.equals("soapOpera") || read.equals("cartoon") || read.equals("thriller"))) {
                MovieFactory.getMovie(read);
                break;
            }
            Movie movie;
            if (read.equals("soapOpera")) {
                movie = MovieFactory.getMovie("soapOpera");
                System.out.println(movie.getClass().getSimpleName());
            }
            if (read.equals("cartoon")) {
                movie = MovieFactory.getMovie("cartoon");
                System.out.println(movie.getClass().getSimpleName());
            }
            if (read.equals("thriller")) {
                movie = MovieFactory.getMovie("thriller");
                System.out.println(movie.getClass().getSimpleName());
            }
        }
        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */
    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            if ("cartoon".equals(key)){
                movie = new Cartoon();
            }
            if ("thriller".equals(key)) {
                movie = new Thriller();
            }

            //напишите тут ваш код, пункты 5,6

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {
    }

    static class Thriller extends Movie {
    }
    //Напишите тут ваши классы, пункт 3
}
