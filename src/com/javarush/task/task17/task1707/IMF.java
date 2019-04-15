package com.javarush.task.task17.task1707;

public class IMF {

    private static IMF imf;

    public static IMF getFund() {
        synchronized (IMF.class) { // Метод getFund() должен содержать синхронизированный блок.
            // Внутри синхронизированного блока должно быть проинициализировано поле imf.
            if (imf == null) { // это от singletone паттерн, если он уже есть, то не создаем новый объект
                // подробно разные примеры см по ссылкам, аля https://habrahabr.ru/post/27108/
                imf = new IMF(); // инициализация поле imf
            }
        }
        return imf; // Метод getFund() должен всегда возвращать один и тот же объект.
        //add your code here - добавь код тут
    }
    private IMF() {
    }
}
