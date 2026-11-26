package semester1.practice12.homework;

import java.util.HashSet;

public class Task3GeometryCanvasAndStats {
    public static void printStats(GeometryCanvas canvas) {
        System.out.printf("  Фігур: %d | Площа: %.2f | Периметр: %.2f%n",
                canvas.getShapesCopy().size(), canvas.getTotalArea(), canvas.getTotalPerimeter());
        System.out.println("  Унікальні кольори: " + canvas.getUniqueColors());
    }

    public static void main(String[] args) {
        System.out.println("========== ГЕОМЕТРИЧНЕ ПОЛОТНО: ООП ТА КОЛЕКЦІЇ ==========");
        GeometryCanvas canvas1 = new GeometryCanvas("Головне полотно");
        Shape[] candidates = {
            new Circle("C-1", "Red", 3.0),
            new Circle("C-1", "Blue", 5.0),
            new Rectangle("R-1", "Blue", 4.0, 5.0),
            new Rectangle("R-2", "Green", 2.0, 3.0),
            new RightTriangle("T-1", "Red", 3.0, 4.0),
            new RightTriangle("T-2", "Yellow", 6.0, 8.0)
        };

        System.out.println("Додавання фігур на '" + canvas1.getTitle() + "':");
        for (Shape s : candidates) {
            if (canvas1.addShape(s)) {
                System.out.println("  Додано: " + s);
            } else {
                System.out.println("  Відхилено дублікат ID: " + s.getId());
            }
        }

        System.out.println("\nДО ОЧИЩЕННЯ:");
        printStats(canvas1);
        System.out.println("\nОчищення через Iterator.remove() (площа менша 10.0):");
        int removed = canvas1.removeSmallShapes(10.0);
        System.out.println("  Видалено фігур: " + removed);
        System.out.println("\nПІСЛЯ ОЧИЩЕННЯ:");
        printStats(canvas1);

        HashSet<String> palette2 = new HashSet<>();
        palette2.add("Blue");
        palette2.add("Yellow");
        palette2.add("Purple");
        HashSet<String> palette1 = canvas1.getUniqueColors();

        HashSet<String> common = new HashSet<>(palette1);
        common.retainAll(palette2);
        HashSet<String> onlyFirst = new HashSet<>(palette1);
        onlyFirst.removeAll(palette2);
        HashSet<String> allColors = new HashSet<>(palette1);
        allColors.addAll(palette2);

        System.out.println("\nПалітра другого полотна: " + palette2);
        System.out.println("Спільні кольори: " + common);
        System.out.println("Тільки на полотні 1: " + onlyFirst);
        System.out.println("Усі кольори: " + allColors);
    }
}
