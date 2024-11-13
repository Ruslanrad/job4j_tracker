package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PointTest {
    @Test
    public void point73andMinus31Then10Ponit2() {
        Point p1 = new Point(7, 3);
        Point p2 = new Point(-3, 1);
        double expected = 10.2;
        double output = p1.distance(p2);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    public void point10and13Minus10Then15Point62() {
        Point p1 = new Point(1, 0);
        Point p2 = new Point(13, -10);
        double expected = 15.62;
        double output = p1.distance(p2);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenPointsMinus1Minus1And1And1Then2Dot83Point83() {
        Point p1 = new Point(-1, -1);
        Point p2 = new Point(1, 1);
        double expected = 2.83;
        double output = p1.distance(p2);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }
}
