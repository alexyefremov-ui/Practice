package semester1.practice12.homework;

import java.util.ArrayList;
import java.util.HashSet;

public class Task1UniquePointsAndSets {
    public static void main(String[] args) {
        System.out.println("========== ГЕОДЕЗИЧНИЙ РАДАР: HASHSET ТА ITERATOR ==========");

        ArrayList<Point2D> sensorA = new ArrayList<>();
        sensorA.add(new Point2D(0, 0));
        sensorA.add(new Point2D(3, 4));
        sensorA.add(new Point2D(1, 2));
        sensorA.add(new Point2D(3, 4));
        sensorA.add(new Point2D(6, 8));
        sensorA.add(new Point2D(5, 0));
        sensorA.add(new Point2D(1, 2));

        ArrayList<Point2D> sensorB = new ArrayList<>();
        sensorB.add(new Point2D(3, 4));
        sensorB.add(new Point2D(5, 0));
        sensorB.add(new Point2D(2, 2));
        sensorB.add(new Point2D(8, 6));
        sensorB.add(new Point2D(2, 2));
        sensorB.add(new Point2D(0, 10));

        HashSet<Point2D> setA = new HashSet<>(sensorA);
        HashSet<Point2D> setB = new HashSet<>(sensorB);
        System.out.println("Сенсор A: записів " + sensorA.size() + ", унікальних " + setA.size() + ": " + setA);
        System.out.println("Сенсор B: записів " + sensorB.size() + ", унікальних " + setB.size() + ": " + setB);

        HashSet<Point2D> allPoints = PointSetUtils.union(setA, setB);
        HashSet<Point2D> common = PointSetUtils.intersection(setA, setB);
        HashSet<Point2D> onlyA = PointSetUtils.difference(setA, setB);
        System.out.println("\nОб'єднання A U B [" + allPoints.size() + "]: " + allPoints);
        System.out.println("Перетин A та B [" + common.size() + "]: " + common);
        System.out.println("Різниця A \\ B [" + onlyA.size() + "]: " + onlyA);

        int removed = PointSetUtils.removeFarPoints(allPoints, 7.0);
        System.out.println("\nФільтрація радіусом 7.0 через Iterator.remove():");
        System.out.println("Видалено: " + removed + " | Залишилось: " + allPoints.size() + ": " + allPoints);
        System.out.println("Оригінальні множини не змінені: A=" + setA.size() + ", B=" + setB.size());
    }
}
