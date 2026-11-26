package semester1.practice12.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class GeometryCanvas {
    private String title;
    private ArrayList<Shape> shapes = new ArrayList<>();
    private HashSet<String> usedIds = new HashSet<>();

    public GeometryCanvas(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean addShape(Shape s) {
        if (s == null || !usedIds.add(s.getId())) {
            return false;
        }
        shapes.add(s);
        return true;
    }

    public int removeSmallShapes(double minArea) {
        Iterator<Shape> it = shapes.iterator();
        int removed = 0;
        while (it.hasNext()) {
            Shape s = it.next();
            if (s.getArea() < minArea) {
                System.out.printf("  Видалено: %s (площа %.2f)%n", s.getId(), s.getArea());
                it.remove();
                usedIds.remove(s.getId());
                removed++;
            }
        }
        return removed;
    }

    public double getTotalArea() {
        double total = 0;
        for (Shape s : shapes) {
            total += s.getArea();
        }
        return total;
    }

    public double getTotalPerimeter() {
        double total = 0;
        for (Shape s : shapes) {
            total += s.getPerimeter();
        }
        return total;
    }

    public HashSet<String> getUniqueColors() {
        HashSet<String> colors = new HashSet<>();
        for (Shape s : shapes) {
            colors.add(s.getColor());
        }
        return colors;
    }

    public ArrayList<Shape> getShapesCopy() {
        return new ArrayList<>(shapes);
    }
}
