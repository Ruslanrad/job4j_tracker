package ru.job4j.function;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionCalculator {
    public List<Double> diapason(int start, int end, Function<Double, Double> function) {
        return IntStream.rangeClosed(start, end)
                .mapToObj(Double::valueOf)
                .map(function)
                .collect(Collectors.toList());
    }
}