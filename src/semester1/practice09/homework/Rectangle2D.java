package semester1.practice09.homework;

public class Rectangle2D extends AbstractShape2D {
    private double width;
    private double height;


    public Rectangle2D(String name, Point2D center, double width, double height) {

        super(name, center);
        this.width = (width > 0) ? width : 1;
        this.height = (height > 0) ? height : 1;
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
        return String.format("Rectangle2D[name='%s', center=%s, %.2fx%.2f | S=%.2f, P=%.2f]", getName(), getAnchorPoint(), width, height, getArea(), getPerimeter());
    }
}
