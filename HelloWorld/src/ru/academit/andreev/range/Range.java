package ru.academit.andreev.range;

import java.util.Scanner;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public Range() {
        Scanner scanner = new Scanner(System.in);
        this.from = scanner.nextDouble();
        this.to = scanner.nextDouble();
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }


    public double getLength() {
        return to - from;
    }

    public static double[] getIntersection(Range a, Range b) {
        if (b.from > a.from) {
            if (a.to >= b.from) {
                double[] array = {b.from, a.to};
                return array;
            } else {
                return null;
            }
        } else {
            if (b.to >= a.from) {
                double[] array = {a.from, b.to};
                return array;
            } else {
                return null;
            }
        }
    }

    public static double[] getAddition(Range a, Range b) {
        if (b.from > a.from) {
            if (a.to >= b.from) {
                if (a.to >= b.to) {
                    double[] array = {a.from, a.to};
                    return array;
                } else {
                    double[] array = {a.from, b.to};
                    return array;
                }
            } else {
                return null;
            }
        } else {
            if (a.to >= b.from) {
                if (b.to >= a.to) {
                    double[] array = {b.from, b.to};
                    return array;
                } else {
                    double[] array = {b.from, a.to};
                    return array;
                }
            } else {
                return null;
            }
        }
    }

    public static double[] getSubtraction(Range a, Range b) {
        if (b.from > a.from) {
            if (a.to >= b.from) {
                if (a.to <= b.to) {
                    double[] array = {a.from, b.from};
                    return array;
                } else {
                    double[] array = {a.from, b.from, b.to, a.to};
                    return array;
                }
            } else {
                double[] array = {a.from, a.to};
                return array;
            }
        } else {
            if (b.to >= a.from) {
                if (b.to >= a.to) {
                    double[] array = {b.from, a.from, a.to, b.to};
                    return array;
                } else {
                    double[] array = {b.from, a.from};
                    return array;
                }
            } else {
                double[] array = {b.from, b.to};
                return array;
            }
        }
    }

    public boolean isInside(double x) {
        return x >= from && x <= to;
    }
}

