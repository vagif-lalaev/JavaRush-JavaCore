package com.javarush.task.task14.task1408;

import static com.javarush.task.task14.task1408.Country.BELARUS;

public class BelarusianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 150;
    }

    @Override
    String getDescription(){
        return super.getDescription() + " Моя страна - " + BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
