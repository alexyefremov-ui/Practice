package semester1.practice12.homework;

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(String id, String color, double width, double height) {
        super(id, color);
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Сторони мають бути додатними");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle[" + getId() + ", " + getColor() + ", " + width + "x" + height + "]";
    }
}
