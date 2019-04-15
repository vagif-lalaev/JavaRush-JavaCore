package com.javarush.task.task15.task1504;

import java.util.LinkedList;
import java.util.List;
/* 
ООП - книги
*/
public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ", " + getBook().getTitle() + " is a detective";
            String markTwainOutput = getBook().getTitle() + " book was written by " + author;

            String output = "output";

            if (this instanceof AgathaChristieBook) {
                return agathaChristieOutput;
            }
            if (this instanceof MarkTwainBook) { // или (author.equals("Mark Twain"))
                return markTwainOutput;
            }
            //Add your code here
            return output;
        }

        public String toString() {
            return getOutputByBookType();
        }
    }

    public static class MarkTwainBook extends Book {
        String title = "Tom Sawyer";
        public MarkTwainBook(String title) {
            super("Mark Twain");
            this.title = title;
        }

        @Override
        public MarkTwainBook getBook() {
            return MarkTwainBook.this;
        }

        @Override
        public String getTitle() {
            return title;
        }
    }

    public static class AgathaChristieBook extends Book {
        String title = "Hercule Poirot";
        public AgathaChristieBook(String title) {
            super("Agatha Christie");
            this.title = title;
        }

        @Override
        public AgathaChristieBook getBook() {
            return AgathaChristieBook.this;
        }

        @Override
        public String getTitle() {
            return title;
        }
    }
}
