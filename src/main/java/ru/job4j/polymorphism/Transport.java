package ru.job4j.polymorphism;

public interface Transport {
    int refuel(int fuel);

    void move();

    void passengers(int count);
}
