package semester1.practice11.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Task4ArrayListVsLinkedListPerformance {
    public static void fillList(List<Integer> numbers, int count) {
        for (int i = 0; i < count; i++) {
            numbers.add(i);
        }
    }

    public static double measureInsertAtBeginning(List<Integer> numbers, int count) {
        long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            numbers.add(0, -i);
        }
        long end = System.nanoTime();
        return (end - start) / 1000000.0;
    }

    public static double measureInsertInMiddle(List<Integer> numbers, int count) {
        long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            numbers.add(numbers.size() / 2, -i);
        }
        long end = System.nanoTime();
        return (end - start) / 1000000.0;
    }

    public static void main(String[] args) {
        System.out.println("========== ПОРІВНЯННЯ ARRAYLIST І LINKEDLIST ==========");
        int initialCount = 20000;
        int insertCount = 20000;

        List<Integer> arrayAtStart = new ArrayList<>();
        List<Integer> linkedAtStart = new LinkedList<>();
        fillList(arrayAtStart, initialCount);
        fillList(linkedAtStart, initialCount);

        System.out.println("\n[1. ВСТАВКА НА ПОЧАТОК]:");
        System.out.println("  Початкова кількість: " + initialCount
                + " | Кількість вставок: " + insertCount);
        double arrayStartMs = measureInsertAtBeginning(arrayAtStart, insertCount);
        double linkedStartMs = measureInsertAtBeginning(linkedAtStart, insertCount);
        System.out.println(String.format("  ArrayList: %.3f мс", arrayStartMs));
        System.out.println(String.format("  LinkedList: %.3f мс", linkedStartMs));
        System.out.println("  Списки після вставки однакові: " + arrayAtStart.equals(linkedAtStart));

        List<Integer> arrayAtMiddle = new ArrayList<>();
        List<Integer> linkedAtMiddle = new LinkedList<>();
        fillList(arrayAtMiddle, initialCount);
        fillList(linkedAtMiddle, initialCount);

        System.out.println("\n[2. ВСТАВКА В СЕРЕДИНУ]:");
        double arrayMiddleMs = measureInsertInMiddle(arrayAtMiddle, insertCount);
        double linkedMiddleMs = measureInsertInMiddle(linkedAtMiddle, insertCount);
        System.out.println(String.format("  ArrayList: %.3f мс", arrayMiddleMs));
        System.out.println(String.format("  LinkedList: %.3f мс", linkedMiddleMs));
        System.out.println("  Списки після вставки однакові: " + arrayAtMiddle.equals(linkedAtMiddle));
        System.out.println("  Примітка: фактичний час залежить від комп'ютера та запуску.");

        System.out.println("\n[3. СОРТУВАННЯ]:");
        List<Integer> numbers = new ArrayList<>();
        numbers.add(45);
        numbers.add(12);
        numbers.add(89);
        numbers.add(3);
        numbers.add(22);
        numbers.add(67);
        System.out.println("  До сортування: " + numbers);
        Collections.sort(numbers);
        System.out.println("  Після сортування: " + numbers);

        System.out.println("\n[4. SUBLIST]:");
        List<Integer> sub = numbers.subList(1, 4);
        System.out.println("  Початковий список: " + numbers);
        System.out.println("  subList(1, 4): " + sub);
        sub.set(0, 999);
        System.out.println("  Після sub.set(0, 999): " + numbers);
    }
}
