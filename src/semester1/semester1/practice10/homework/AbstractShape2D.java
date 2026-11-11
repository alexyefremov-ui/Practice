package semester1.semester1.practice10.homework;

public abstract class AbstractShape2D {
    private final String name;
    private double centerX;
    private double centerY;

    public AbstractShape2D(String name, double centerX, double centerY) {
        this.name = name;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public String getName() {
        return name;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public final double getIsoperimetricQuotient() {
        double perimeter = getPerimeter();
        if (perimeter == 0) {
            return 0;
        }
        return 4 * Math.PI * getArea() / (perimeter * perimeter);
    }

    @Override
    public String toString() {
        return String.format("'%s', center=(%.1f; %.1f)",
                name, centerX, centerY);
    }
}
