package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Petya@yandex.ru", "Kolobkov Petya Petrovich");
        for (String key : map.keySet()) {
            System.out.println(map.get(key) + " - " + key);
        }
        System.out.println("-------------------------");
        map.put("Kuzya@yandex.ru", "Petrovuch Kuzya");
        for (String key : map.keySet()) {
            System.out.println(map.get(key) + " - " + key);
        }
        System.out.println("-------------------------");
        map.put("Kuzya@yandex.ru", "Artem Petrovich");
        for (String key : map.keySet()) {
            System.out.println(map.get(key) + " - " + key);
        }
    }
}
