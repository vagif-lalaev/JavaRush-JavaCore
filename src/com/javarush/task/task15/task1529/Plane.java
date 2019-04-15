package com.javarush.task.task15.task1529;

public class Plane implements Flyable {

    int planPass;
    Plane(int planPass) {
        this.planPass = planPass;
    }

    @Override
    public void fly() {
    }
}
