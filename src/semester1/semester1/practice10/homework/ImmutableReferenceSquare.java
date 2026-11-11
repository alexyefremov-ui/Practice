package semester1.semester1.practice10.homework;

public final class ImmutableReferenceSquare extends AbstractShape2D {
    private final double side;

    public ImmutableReferenceSquare(String name, double centerX, double centerY, double side) {
        super(name, centerX, centerY);
        this.side = side > 0 ? side : 1.0;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public String toString() {
        return "ImmutableReferenceSquare[" + super.toString() + String.format(", side=%.2f | S=%.2f, P=%.2f, Q=%.4f]",
                side, getArea(), getPerimeter(), getIsoperimetricQuotient());
    }
}
