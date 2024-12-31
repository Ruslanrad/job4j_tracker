package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(
                10,
                -3,
                2,
                0,
                5,
                -6
        );
        List<Integer> positive = numbers.stream().filter(value -> value > 0).toList();
        positive.forEach(System.out::println);
    }
}