package semester1.practice09.homework;

public class Circle2D extends AbstractShape2D {
    private double radius;

    public Circle2D(String name, Point2D center, double radius) {
        super(name, center);

        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 1;
        }
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
    public String toString() {
        return String.format("Circle2D[name='%s', center=%s, r=%.2f | S=%.2f, P=%.2f]", getName(), getAnchorPoint(), radius, getArea(), getPerimeter());
    }
}
