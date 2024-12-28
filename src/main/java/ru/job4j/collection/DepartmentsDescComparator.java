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
        int count = Math.min(left.length(), right.length());
        for (int i = 0; i < count; i++) {
            int compareChar = Character.compare(left.charAt(i), right.charAt(i));
            if (compareChar != 0) {
                return compareChar;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}