package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftArr = left.split("/", 0);
        String[] rightArr = right.split("/", 0);
        int compareOnePart = rightArr[0].compareTo(leftArr[0]);
        if (compareOnePart != 0) {
            return compareOnePart;
        }
        return left.compareTo(right);
    }
}