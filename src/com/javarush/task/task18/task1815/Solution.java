package com.javarush.task.task18.task1815;

import java.util.List;
/* 
Таблица
*/
// Измени класс TableInterfaceWrapper так, чтобы он стал Wrapper-ом для ATableInterface
public class Solution {
    public class TableInterfaceWrapper implements ATableInterface { // реализовывать интерфейс ATableInterface
       // инициализировать в конструкторе поле типа ATableInterface
        ATableInterface aTableInterface; // поле
        TableInterfaceWrapper(ATableInterface aTableInterface) { // конструктор
            this.aTableInterface = aTableInterface;
        }
        //вывод в консоль количество элементов в новом листе перед обновлением модели
        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            aTableInterface.setModel(rows);
        }
        // возвращает текст в верхнем регистре
        @Override
        public String getHeaderText() {
            return aTableInterface.getHeaderText().toUpperCase();
        }
        // устанавливает текст для заголовка без изменений
        @Override
        public void setHeaderText(String newHeaderText) {
            aTableInterface.setHeaderText(newHeaderText);
        }
    }

    public interface ATableInterface {
        void setModel(List rows);
        String getHeaderText();
        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}