package semester1.semester1.practice10.homework;

public class CircleShape extends AbstractShape2D implements Scalable2D {
    private double radius;

    public CircleShape(String name, double centerX, double centerY, double radius) {
        super(name, centerX, centerY);
        this.radius = radius > 0 ? radius : 1.0;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void scale(double factor) {
        if (factor < MIN_SCALE_FACTOR) {
            factor = MIN_SCALE_FACTOR;
        }
        radius = radius * factor;
        System.out.println(String.format("  [Scalable2D] '%s' масштабовано в %.1f разів (новий r=%.2f)",
                getName(), factor, radius));
    }

    @Override
    public String toString() {
        return "CircleShape[" + super.toString() + String.format(", r=%.2f | S=%.2f, P=%.2f, Q=%.4f]",
                radius, getArea(), getPerimeter(), getIsoperimetricQuotient());
    }
}
