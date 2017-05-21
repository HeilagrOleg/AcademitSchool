package andreev.range.main;

import andreev.range.scr.Range;

import java.util.Scanner;

public class TestProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Напишите начало и конец первого промежутка");
        double from = scanner.nextDouble();
        double to = scanner.nextDouble();
        Range firstInterval = new Range(from, to);
        System.out.println("Напишите начало и конец второго промежутка");
        from = scanner.nextDouble();
        to = scanner.nextDouble();
        Range secondInterval = new Range(from, to);

        System.out.printf("Длина первого промежутка = %.1f%nДлина второго промежутка = %.1f%n",
                firstInterval.getLength(), secondInterval.getLength());
        System.out.println("-------");

        double number = 3;
        System.out.printf("Давайте проверим, попадает ли число %.1f в Ваши промежутки:%n", number);
        if (firstInterval.isInside(number) && secondInterval.isInside(number)) {
            System.out.println("Попадает в оба промежутка");
        } else if (firstInterval.isInside(number) || secondInterval.isInside(number)) {
            System.out.println("Попадает в один из промежутков");
        } else {
            System.out.println("Увы...");
        }
        System.out.println("-------");

        if (firstInterval.getIntersection(secondInterval) == null) {
            System.out.println("Промежутки не пересекаются");
        } else {
            Range intersection = firstInterval.getIntersection(secondInterval);
            System.out.printf("Промежуток пересечения (%.1f - %.1f)%n", intersection.getFrom(), intersection.getTo());
        }
        System.out.println("-------");

        System.out.println("При объединении двух промежутков получаем:");
        Range.print(firstInterval.getAddition(secondInterval));
        System.out.println("-------");

        System.out.println("При разности двух промежутков получаем:");
        Range.print(firstInterval.getSubtraction(secondInterval));
        System.out.println("-------");
    }
}
