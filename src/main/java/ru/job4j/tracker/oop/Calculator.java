package ru.job4j.tracker.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return x - b;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + divide(y) + multiply(y);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Сумма: " + sum(10));
        System.out.println("Разность: " + minus(3));
        System.out.println("Умножение: " + calc.multiply(5));
        System.out.println("Деление: " + calc.divide(10));
        System.out.println("Сумма всех операций: " + calc.sumAllOperation(15));
    }
}