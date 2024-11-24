package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Автобус двигается");
    }

    @Override
    public void passengers(int count) {
        System.out.println("В автобусе " + count + " пассажиров");
    }

    @Override
    public int refuel(int fuel) {
        return fuel * 55;
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.move();
        bus.passengers(20);
        System.out.println("Вы заправились на " + bus.refuel(36) + " рублей");
    }
}
