package semester1.practice12.homework;

public class Circle extends Shape {
    private final double radius;

    public Circle(String id, String color, double radius) {
        super(id, color);
        if (radius <= 0) {
            throw new IllegalArgumentException("Радіус має бути додатним");
        }
        this.radius = radius;
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
        return "Circle[" + getId() + ", " + getColor() + ", r=" + radius + "]";
    }
}
