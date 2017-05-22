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
        if (to < a.from || a.to < from) {
            return null;
        } else {
            return new Range(Math.max(a.from, from), Math.min(a.to, to));
        }
    }

    public Range[] getAddition(Range a) {
        if (to < a.from || a.to < from) {
            return new Range[]{new Range(Math.min(from, a.from), Math.min(to, a.to)),
                    new Range(Math.max(from, a.from), Math.max(to, a.to))};
        } else {
            return new Range[]{new Range((Math.min(a.from, from)), (Math.max(a.to, to)))};
        }
    }

    public Range[] getSubtraction(Range b) {
        if (to < b.from || b.to < from) {
            return new Range[]{new Range(from, to)};
        }
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
                return new Range[]{};
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

