package Practice4;

import java.util.Scanner;

public class Homework4_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ЧИСЛА ФІБОНАЧЧІ ТА ЗОЛОТИЙ ПЕРЕТИН ===");
        System.out.print("Скільки чисел згенерувати (N >= 3): ");
        int f1 = 1;
        int f2 = 1;
        int n = scanner.nextInt();
        if (n >= 3 && n <= 30) {
            System.out.println();
            System.out.println("№ 1 | Число: " + f1);
            System.out.println("№ 2 | Число: " + f2);
            double ratio = 0;

            for (int i = 3; i <= n; i++) {

                int next = f1 + f2;
                ratio = (double) next / f2;
                System.out.printf("№ %d | Число: %d          | Відношення F(n)/F(n-1) = %.6f\n", i, next, ratio);
                f1 = f2;
                f2 = next;
            }

            System.out.println();
            System.out.printf("Підсумок: знайдено наближення Золотого перетину: %.6f\n", ratio);
            System.out.println("Еталонне значення:                             1.618034");
            System.out.println("=========================================");




        } else {
            System.out.println("N має бути від 3 до 30");
        }

        scanner.close();
    }
}