package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд передвигается по рельсам");
    }

    @Override
    public void useFuel() {
        System.out.println("Поезд заправлять только углём");
    }
}
