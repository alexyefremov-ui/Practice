package semester1.practice06.homework;
import java.util.Scanner;

public class Task1Fraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();
        System.out.println("=== КАЛЬКУЛЯТОР ДРОБІВ ===");
        System.out.print("Введіть чисельник першого дробу: ");
        int num1 = scanner.nextInt();

        System.out.print("Введіть знаменник першого дробу: ");
        int den1 = scanner.nextInt();

        fraction1.setValues(num1, den1);
        System.out.print("Перший дріб: ");
        fraction1.printFraction();
        fraction1.simplify();
        System.out.print("\nПісля скорочення: ");
        fraction1.printFraction();
        System.out.println("\nДесятковий вигляд: " + fraction1.toDecimal());
        System.out.print("\nВведіть чисельник другого дробу: ");
        int num2 = scanner.nextInt();
        System.out.print("Введіть знаменник другого дробу: ");
        int den2 = scanner.nextInt();

        fraction2.setValues(num2, den2);
        System.out.print("Другий дріб: ");
        fraction2.printFraction();

        fraction1.add(fraction2.getNumerator(), fraction2.getDenominator());
        System.out.print("\nРезультат додавання: ");
        fraction1.printFraction();
        System.out.println("\nДесятковий вигляд: " + fraction1.toDecimal());
        scanner.close();
    }
}

class Fraction {
    private int numerator;
    private int denominator;
    public void setValues(int num, int den) {
        if (den == 0) {
            System.out.println("Помилка: знаменник не може дорівнювати 0!");
            den = 1;
        }
        if (den < 0) {
            num = -num;
            den = -den;
        }
        numerator = num;
        denominator = den;
    }
    public int getNumerator() {
        return numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void simplify() {
        int n = gcd(numerator, denominator);
        numerator /= n;
        denominator /= n;
    }
    public double toDecimal() {
        return (double) numerator / denominator;
    }
    public void add(int otherNum, int otherDen) {
        int num = numerator * otherDen + otherNum * denominator;
        int den = denominator * otherDen;

        setValues(num, den);
        simplify();
    }
    public void printFraction() {
        if (denominator == 1) {
            System.out.print(numerator);
        } else {
            System.out.print(numerator + "/" + denominator);
        }
    }
}
