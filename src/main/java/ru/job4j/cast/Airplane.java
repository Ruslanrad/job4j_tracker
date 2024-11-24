package ru.job4j.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолёт передвигается по воздуху");
    }

    @Override
    public void useFuel() {
        System.out.println("Самолёт заправлять только соляркой");
    }
}
