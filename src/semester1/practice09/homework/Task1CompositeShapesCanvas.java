package semester1.practice09.homework;

public class Task1CompositeShapesCanvas {
    public static void main(String[] args) {
        System.out.println("================ ГЕОМЕТРИЧНЕ ПОЛОТНО (КОМПОЗИЦІЯ + ABSTRACT) ================");
        GeometryCanvas canvas = new GeometryCanvas("Інженерне креслення №1", 5);
        Point2D originalPoint = new Point2D(0, 0);
        Circle2D circle = new Circle2D("Коло-А", originalPoint, 5);

        originalPoint.translate(100, 100);
        Point2D copiedPoint = circle.getAnchorPoint();
        copiedPoint.translate(50, 50);

        canvas.addShape(circle);
        canvas.addShape(new Rectangle2D("Плита-Б", new Point2D(10, 5), 4, 6));
        canvas.addShape(new RightTriangle2D("Клин-В", new Point2D(-3, 2), 3, 4));

        System.out.print(canvas);
        AbstractShape2D largest = canvas.findLargestShape();
        System.out.printf("Найбільша фігура: %s (S = %.2f)\n", largest.getName(), largest.getArea());
        System.out.println("Захисне копіювання працює: центр кола залишився " + circle.getAnchorPoint());

        System.out.println("-> Переміщуємо всі фігури на вектор (+5.0; -2.0)...");
        canvas.moveAllShapes(5, -2);
        System.out.println("Новий центр 'Коло-А': " + circle.getAnchorPoint());
        System.out.println("=============================================================================");
    }
}
