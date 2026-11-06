package semester1.practice09.homework;

public class GeometryCanvas {
    private final String title;
    private final AbstractShape2D[] shapes;
    private int count;

    public GeometryCanvas(String title, int capacity) {
        this.title = title;
        this.shapes = new AbstractShape2D[(capacity > 0) ? capacity : 1];
        this.count = 0;
    }

    public boolean addShape(AbstractShape2D shape) {
        if (shape == null || count >= shapes.length) {
            return false;
        }
        shapes[count] = shape;
        count++;
        return true;

    }

    public double getTotalArea() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += shapes[i].getArea();
        }

        return total;
    }

    public double getTotalPerimeter() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += shapes[i].getPerimeter();

        }


        return total;
    }

    public AbstractShape2D findLargestShape() {
        if (count == 0) {
            return null;
        }

        AbstractShape2D largest = shapes[0];
        for (int i = 1; i < count; i++) {
            if (shapes[i].getArea() > largest.getArea()) {
                largest = shapes[i];
            }
        }
        return largest;
    }

    public void moveAllShapes(double dx, double dy) {
        for (int i = 0; i < count; i++) {
            shapes[i].moveBy(dx, dy);

        }
    }

    @Override public String toString() {
        String result = String.format("Полотно: '%s' (Фігур: %d/%d)\n", title, count, shapes.length);
        for (int i = 0; i < count; i++) {
            result += "  " + (i + 1) + ". " + shapes[i] + "\n";
        }
        result += "-----------------------------------------------------------------------------\n";
        result += String.format("Сумарна площа креслення: %.2f кв.од.\n", getTotalArea());
        result += String.format("Сумарний периметр: %.2f од.\n", getTotalPerimeter());
        return result;

    }

}
