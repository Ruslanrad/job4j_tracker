package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder bilder = new StringBuilder();
        for (int i = evenElements.size() / 2; i > 0; i--) {
            bilder.append(evenElements.pollFirst());
            evenElements.pollFirst();
        }
        return bilder.toString();
    }

    private String getDescendingElements() {
        StringBuilder bilder = new StringBuilder();
        for (int i = descendingElements.size(); i > 0; i--) {
            bilder.append(descendingElements.pollLast());
        }
        return bilder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}