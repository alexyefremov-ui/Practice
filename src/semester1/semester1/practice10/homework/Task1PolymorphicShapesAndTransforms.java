package semester1.semester1.practice10.homework;

public class Task1PolymorphicShapesAndTransforms {
    public static double calculateTotalArea(AbstractShape2D[] shapes) {
        double total = 0;
        for (int i = 0; i < shapes.length; i++) {
            total = total + shapes[i].getArea();
        }
        return total;
    }

    public static void transformScene(AbstractShape2D[] shapes, double scaleFactor, double rotateDeg) {
        for (int i = 0; i < shapes.length; i++) {
            AbstractShape2D shape = shapes[i];
            boolean changed = false;
            if (shape instanceof Scalable2D scalable) {
                scalable.scale(scaleFactor);
                changed = true;
            }
            if (shape instanceof Rotatable2D rotatable) {
                rotatable.rotate(rotateDeg);
                changed = true;
            }
            if (!changed) {
                System.out.println("  [Info] '" + shape.getName() + "' пропущено: трансформації недоступні.");
            }
        }
    }

    public static void printScene(AbstractShape2D[] shapes) {
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("  " + (i + 1) + ". " + shapes[i]);
        }
    }

    public static void main(String[] args) {
        AbstractShape2D[] shapes = {
                new CircleShape("Коло-Лінза", 0, 0, 5),
                new RectangleShape("Рамка-А", 2, 3, 4, 6),
                new ImmutableReferenceSquare("Еталон-Квадрат", 10, 10, 5)
        };

        System.out.println("========== ПОЛІМОРФНА ГЕОМЕТРІЯ ==========");
        System.out.println("До трансформації:");
        printScene(shapes);
        System.out.println(String.format("Сумарна площа: %.2f", calculateTotalArea(shapes)));

        System.out.println("\nТрансформація: масштаб 2.0, поворот 45°:");
        transformScene(shapes, 2.0, 45.0);

        System.out.println("\nПісля трансформації:");
        printScene(shapes);
        System.out.println(String.format("Сумарна площа: %.2f", calculateTotalArea(shapes)));
        System.out.println("У кола та прямокутника площі збільшилися в 4 рази, еталонний квадрат не змінився.");
    }
}
