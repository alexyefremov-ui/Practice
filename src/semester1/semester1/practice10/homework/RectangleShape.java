package semester1.semester1.practice10.homework;

public class RectangleShape extends AbstractShape2D implements Scalable2D, Rotatable2D {
    private double width;
    private double height;
    private double rotationAngle;

    public RectangleShape(String name, double centerX, double centerY, double width, double height) {
        super(name, centerX, centerY);
        this.width = width > 0 ? width : 1.0;
        this.height = height > 0 ? height : 1.0;
        this.rotationAngle = 0;
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
    public void scale(double factor) {
        if (factor < MIN_SCALE_FACTOR) {
            factor = MIN_SCALE_FACTOR;
        }
        width = width * factor;
        height = height * factor;
        System.out.println(String.format("  [Scalable2D] '%s' масштабовано в %.1f разів (%.2fx%.2f)",
                getName(), factor, width, height));
    }

    @Override
    public void rotate(double deltaDegrees) {
        rotationAngle = (rotationAngle + deltaDegrees) % 360;
        if (rotationAngle < 0) {
            rotationAngle = rotationAngle + 360;
        }
        System.out.println(String.format("  [Rotatable2D] '%s' повернуто на %+.1f° (поточний кут: %.1f°)",
                getName(), deltaDegrees, rotationAngle));
    }

    @Override
    public double getRotationAngle() {
        return rotationAngle;
    }

    @Override
    public String toString() {
        return "RectangleShape[" + super.toString() + String.format(", %.2fx%.2f, angle=%.1f° | S=%.2f, P=%.2f, Q=%.4f]",
                width, height, rotationAngle, getArea(), getPerimeter(), getIsoperimetricQuotient());
    }
}
