package semester1.practice06.homework;
import java.util.Scanner;

public class Task2QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== РОЗВ'ЯЗУВАЧ КВАДРАТНИХ РІВНЯНЬ ===");
        for (int i = 1; i <= 3; i++) {
            QuadraticEquation equation = new QuadraticEquation();
            System.out.println("\nТест " + i + ":");
            System.out.print("Введіть a: ");
            double a = scanner.nextDouble();
            System.out.print("Введіть b: ");
            double b = scanner.nextDouble();
            System.out.print("Введіть c: ");
            double c = scanner.nextDouble();
            equation.setCoefficients(a, b, c);
            equation.printSolution();

            System.out.println("--------------------------------------");
        }
        System.out.println("======================================");
        scanner.close();
    }
}



class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    public void setCoefficients(double a, double b, double c) {
        if (a == 0) {
            System.out.println("Увага: коефіцієнт 'a' не може дорівнювати 0 (це лінійне рівняння)!");
            a = 1;
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }
    public boolean hasRealRoots() {
        return getDiscriminant() >= 0;
    }
    public double getRoot1() {
        if (!hasRealRoots()) {
            return Double.NaN;
        }
        return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
    }
    public double getRoot2() {
        if (!hasRealRoots()) {
            return Double.NaN;
        }
        return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
    }
    public void printSolution() {
        double d = getDiscriminant();
        System.out.println("Рівняння: " + a + "*x^2 + (" + b + ")*x + " + c + " = 0");
        System.out.printf("Дискримінант D = %.2f%n", d);


        if (d > 0) {
            System.out.println("Рівняння має 2 дійсні корені:");
            System.out.printf("x1 = %.2f%n", getRoot1());
            System.out.printf("x2 = %.2f%n", getRoot2());
        }
        else if (d == 0) {
            System.out.println("Рівняння має один дійсний корінь:");
            System.out.printf("x = %.2f%n", getRoot1());
        }
        else {
            System.out.println("Рівняння не має дійсних коренів (D < 0)");
        }


    }

}
