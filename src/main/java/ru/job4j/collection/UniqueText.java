package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String textToHash: text) {
            check.add(textToHash);
        }
        for (String textChec: origin) {
            if (!check.contains(textChec)) {
                result = false;
                break;
            }
        }
        return result;
    }
}