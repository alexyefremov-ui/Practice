package semester1.practice12.homework;

public class RightTriangle extends Shape {
    private final double legA;
    private final double legB;

    public RightTriangle(String id, String color, double legA, double legB) {
        super(id, color);
        if (legA <= 0 || legB <= 0) {
            throw new IllegalArgumentException("Катети мають бути додатними");
        }
        this.legA = legA;
        this.legB = legB;
    }

    @Override
    public double getArea() {
        return legA * legB / 2.0;
    }

    @Override
    public double getPerimeter() {
        return legA + legB + Math.sqrt(legA * legA + legB * legB);
    }

    @Override
    public String toString() {
        return "RightTriangle[" + getId() + ", " + getColor() + ", " + legA + "x" + legB + "]";
    }
}
