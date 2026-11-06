package semester1.practice09.homework;

public class RightTriangle2D extends AbstractShape2D {
    private double legA;
    private double legB;

    public RightTriangle2D(String name, Point2D center, double legA, double legB) {
        super(name, center);

        this.legA = (legA > 0) ? legA : 1;
        this.legB = (legB > 0) ? legB : 1;
    }

    public double getHypotenuse() {
        return Math.sqrt(legA * legA + legB * legB);
    }
    @Override
    public double getArea() {
        return legA * legB / 2;
    }

    @Override
    public double getPerimeter() {
        return legA + legB + getHypotenuse();
    }

    @Override
    public String toString() {
        return String.format("RightTriangle2D[name='%s', center=%s, a=%.2f, b=%.2f, c=%.2f | S=%.2f, P=%.2f]",
                getName(), getAnchorPoint(), legA, legB, getHypotenuse(), getArea(), getPerimeter());
    }
}
