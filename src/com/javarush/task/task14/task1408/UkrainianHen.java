package com.javarush.task.task14.task1408;

import static com.javarush.task.task14.task1408.Country.UKRAINE;

public class UkrainianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 50;
    }

    @Override
    String getDescription(){
        return super.getDescription() + " Моя страна - " + UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}