package semester1.practice09.homework;

public class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point2D(Point2D other) {
        this.x = other.x;
        this.y = other.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public double distanceTo(Point2D other) {
        return Math.sqrt(Math.pow(other.x - x, 2) + Math.pow(other.y - y, 2));
    }
    @Override
    public String toString() {
        return String.format("(%.2f; %.2f)", x, y);
    }
}
