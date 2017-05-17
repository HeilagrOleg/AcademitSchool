package range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
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

    public Range getIntersection(Range a) {
        if (from > a.from) {
            if (a.to >= from) {
                if (to <= a.to) {
                    return new Range(from, to);
                } else {
                    return new Range(from, a.to);
                }
            } else {
                return null;
            }
        } else {
            if (to >= a.from) {
                if (a.to <= to) {
                    return new Range(a.from, a.to);
                } else {
                    return new Range(a.from, to);
                }
            } else {
                return null;
            }
        }
    }

    public Range[] getAddition(Range a) {
        if (from > a.from) {
            if (a.to >= from) {
                if (a.to >= to) {
                    return new Range[]{new Range(a.from, a.to)};
                } else {
                    return new Range[]{new Range(a.from, to)};
                }
            } else {
                return new Range[]{new Range(a.from, a.to), new Range(from, to)};
            }
        } else {
            if (to >= a.from) {
                if (to >= a.to) {
                    return new Range[]{new Range(from, to)};
                } else {
                    return new Range[]{new Range(from, a.to)};
                }
            } else {
                return new Range[]{new Range(from, to), new Range(a.from, a.to)};
            }
        }
    }

    public Range[] getSubtraction(Range b) {
        if (b.from > from) {
            if (to >= b.from) {
                if (to <= b.to) {
                    return new Range[]{new Range(from, b.from)};
                } else {
                    return new Range[]{new Range(from, b.from), new Range(b.to, to)};
                }
            } else {

                return new Range[]{new Range(from, to)};
            }
        } else {
            if (b.to >= from) {
                if (b.to >= to) {
                    return new Range[]{new Range(b.from, from), new Range(to, b.to)};
                } else {
                    return new Range[]{new Range(b.from, from)};
                }
            } else {
                return new Range[]{new Range(b.from, b.to)};
            }
        }
    }

    public static void print(Range[] array) {
        for (Range e : array) {
            System.out.printf("Промежуток (%.1f - %.1f)%n", e.getFrom(), e.getTo());
        }
    }

    public boolean isInside(double x) {
        return x >= from && x <= to;
    }
}

