package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус передвигается по скоростным трассам");
    }

    @Override
    public void useFuel() {
        System.out.println("Автобус заправлять только бензином");
    }
}
