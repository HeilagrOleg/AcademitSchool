package andreev.range.scr;

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
        if ((from > a.from && a.to < from) || (from < a.from && to < a.from)) {
            return null;
        } else {
            return new Range(Math.max(a.from, from), Math.min(a.to, to));
        }
    }

    public Range[] getAddition(Range a) {
        if ((from > a.from && a.to < from) || (from < a.from && to < a.from)) {
            if (from > a.from) {
                return new Range[]{new Range(a.from, a.to), new Range(from, to)};
            } else {
                return new Range[]{new Range(from, to), new Range(a.from, a.to)};
            }
        } else {
            return new Range[]{new Range((Math.min(a.from, from)), (Math.max(a.to, to)))};
        }
    }

    public Range[] getSubtraction(Range b) {
        if ((from > b.from && b.to < from) || (from < b.from && to < b.from)) {
            return new Range[]{new Range(from, to)};
        } else {
            if (from < b.from) {
                if (to < b.to) {
                    return new Range[]{new Range(from, b.from)};
                } else {
                    return new Range[]{new Range(from, b.from), new Range(b.to, to)};
                }
            } else {
                if (to > b.to) {
                    return new Range[]{new Range(b.to, to)};
                } else {
                    return null;
                }
            }
        }
    }

    public static void print(Range[] array) {
        if (array == null) {
            System.out.println("Промежутка нет");
        } else {
            for (Range e : array) {
                System.out.printf("Промежуток (%.1f - %.1f)%n", e.getFrom(), e.getTo());
            }
        }
    }

    public boolean isInside(double x) {
        return x >= from && x <= to;
    }
}

