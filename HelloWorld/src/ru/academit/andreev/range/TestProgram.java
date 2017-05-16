package ru.academit.andreev.range;

public class TestProgram {
    public static void main(String[] args) {
        System.out.println("Напишите начало и конец первого промежутка");
        Range firstInterval = new Range();
        System.out.println("Напишите начало и конец второго промежутка");
        Range secondInterval = new Range();

        System.out.printf("Длина первого промежутка = %.1f%nДлина второго промежутка = %.1f%n",
                firstInterval.getLength(), secondInterval.getLength());

        double number = 3;
        System.out.printf("Давайте проверим, попадает ли число %.1f в Ваши промежутки:%n", number);
        if (firstInterval.isInside(number) && secondInterval.isInside(number)) {
            System.out.println("Попадает в оба промежутка");
        } else if (firstInterval.isInside(number) || secondInterval.isInside(number)) {
            System.out.println("Попадает в один из промежутков");
        } else {
            System.out.println("Увы...");
        }

        double[] array = Range.getIntersection(firstInterval, secondInterval);
        if (Range.getIntersection(firstInterval, secondInterval) == null) {
            System.out.println("Промежутки не пересекаются");
        } else {
            System.out.print("Промежуток пересечения ( ");
            for (double e : array) {
                System.out.print(e + " ");
            }
            System.out.println(")");
        }

        array = Range.getAddition(firstInterval, secondInterval);
        System.out.print("При объединении двух промежутков получаем ");
        if (Range.getAddition(firstInterval, secondInterval) == null) {
            System.out.printf("два промежутка (%.1f %.1f) и (%.1f %.1f)", firstInterval.getFrom(), firstInterval.getTo(),
                    secondInterval.getFrom(), secondInterval.getTo());
        } else {
            System.out.printf("один промежуток ( ");
            for (double e : array) {
                System.out.print(e + " ");
            }
            System.out.println(")");
        }

        array = Range.getSubtraction(firstInterval, secondInterval);
        System.out.print("При разности двух промежутков получаем один промежуток ( ");
        for (int i = 0; i < array.length; i++) {
            if (i == 2) {
                System.out.print(" ) и второй промежуток ( ");
            }
            System.out.print(array[i] + " ");
        }
        System.out.print(")");
    }
}
