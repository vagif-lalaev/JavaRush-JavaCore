package com.javarush.task.task17.task1714;
/* 
Comparable
*/
public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach b = new Beach("Пляж 1", 2, 7);
        Beach a = new Beach("Пляж 2", 7, 7);
        System.out.println (b.getName() + ": " + b.compareTo(a)); // имя объекта + результат сравнения одно с другим
        System.out.println(a.getName() + ": " + a.compareTo(b)); // имя объекта + результат сравнения одно с другим
    }

    @Override
    public synchronized int compareTo(Beach o) { // метод для сравнения
        // сравниваем начальный объект с переданным в него "o" ↓
        return (getQuality() - o.getQuality()) - (int)(getDistance() - o.getDistance());
    }
}
