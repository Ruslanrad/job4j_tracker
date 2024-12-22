package ru.job4j.tracker;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {
    @Override
    public int compare(Item i1, Item i2) {
        return i1.getName().compareToIgnoreCase(i2.getName());
    }
}
