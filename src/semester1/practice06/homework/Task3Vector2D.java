package semester1.practice06.homework;
import java.util.Scanner;
public class Task3Vector2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vector2D a = new Vector2D();
        Vector2D b = new Vector2D();
        System.out.println("=== ВЕКТОРНИЙ АНАЛІЗАТОР (2D GEOMETRY) ===");
        System.out.print("Введіть x вектора A: ");
        double x1 = scanner.nextDouble();
        System.out.print("Введіть y вектора A: ");
        double y1 = scanner.nextDouble();
        System.out.print("Введіть x вектора B: ");
        double x2 = scanner.nextDouble();
        System.out.print("Введіть y вектора B: ");
        double y2 = scanner.nextDouble();
        a.set(x1, y1);
        b.set(x2, y2);
        System.out.print("\nВектор A: ");
        a.printVector();

        System.out.print("Вектор B: ");
        b.printVector();
        System.out.printf("\nСкалярний добуток A * B: %.2f%n",
                a.dotProduct(b.getX(), b.getY()));
        boolean result = a.isPerpendicularTo(b.getX(), b.getY());
        System.out.println("Чи є вектори перпендикулярними? " + result);
        System.out.println("\nНормалізація вектора A...");
        a.normalize();

        System.out.print("Одиничний вектор A: ");
        a.printVector();
        scanner.close();
    }



}



class Vector2D {
    private double x;
    private double y;
    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;

    }
    public double getY() {
        return y;
    }
    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }
    public void multiplyByScalar(double k) {
        x *= k;
        y *= k;


    }
    public double dotProduct(double otherX, double otherY) {
        return x * otherX + y * otherY;
    }

    public boolean isPerpendicularTo(double otherX, double otherY) {
        return Math.abs(dotProduct(otherX, otherY)) < 0.000000001;
    }
    public void normalize() {
        double length = getLength();

        if (length != 0) {
            x /= length;
            y /= length;
        }
    }

    public void printVector() {
        System.out.printf("(%.2f; %.2f), Довжина = %.2f%n",
                x, y, getLength());
    }
}
