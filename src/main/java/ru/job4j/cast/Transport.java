package ru.job4j.cast;

public class Transport {
    public static void main(String[] args) {
        Airplane airplane = new Airplane();
        Train train = new Train();
        Bus bus = new Bus();
        Vehicle[] vehicles = new Vehicle[]{airplane, train, bus};
        for (Vehicle objects : vehicles) {
            objects.move();
            objects.useFuel();
        }
    }
}
