package ru.job4j.oop;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double semiPerimeter(double a, double b, double c) {
        if (exist(a, b, c)) {
            return (first.distance(second) + first.distance(second) + second.distance(third)) / 2;
        } else {
            return -1;
        }
    }

    public boolean exist(double ab, double ac, double bc) {
        return first.distance(second) + first.distance(third) > second.distance(first)
                && first.distance(second) + second.distance(third) > first.distance(third)
                && first.distance(third) + second.distance(third) > first.distance(second);
    }

    public double area() {
        double result = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        if (this.exist(ab, ac, bc)) {
            double p = semiPerimeter(ab, ac, bc);
            result = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return result;
    }
}
