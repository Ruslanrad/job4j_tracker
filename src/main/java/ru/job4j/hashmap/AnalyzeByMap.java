package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double count = 0;
        double sumScore = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject: pupil.subjects()) {
                sumScore += subject.score();
                count++;
            }
        }
        return sumScore / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        double count;
        double sumScore;
        double averageScore;
        for (Pupil pupil : pupils) {
            count = 0;
            sumScore = 0;
            for (Subject subject: pupil.subjects()) {
                sumScore += subject.score();
                count++;
            }
            averageScore = sumScore / count;
            labels.add(new Label(pupil.name(), averageScore));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject: pupil.subjects()) {
                counts.put(subject.name(), counts.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            labels.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        double sumScore;
        for (Pupil pupil : pupils) {
            sumScore = 0;
            for (Subject subject: pupil.subjects()) {
                sumScore += subject.score();
            }
            labels.add(new Label(pupil.name(), sumScore));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject: pupil.subjects()) {
                counts.put(subject.name(), counts.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            labels.add(new Label(entry.getKey(), entry.getValue()));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}