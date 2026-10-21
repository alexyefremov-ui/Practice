package Practice4;

import java.util.Scanner;

public class Homework4_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("=== АНАЛІЗАТОР ДІАПАЗОНУ ЧИСЕЛ ===");
        System.out.print("Введіть число N: ");
        do {
            n = scanner.nextInt();
            if (n<=0){
                System.out.println("Помилка: N має бути більшим за 0!");
                System.out.print("Введіть число N: ");
            }
        }while (n<=0);
        System.out.println("");

        System.out.println("--- РЕЗУЛЬТАТИ ДЛЯ ДІАПАЗОНУ [1 .. 10] ---");
        int totalSum =0;
        int a = 0;
        int b = 0;
        int aa =0;
        int bb = 0;
        for (int i = 1; i <=n; i++ ) {
            totalSum += i;
            if (i%2 == 0){
                a+=i;
                aa +=1;
            } else {
                b +=i;
                bb += 1;
            }
        }
        System.out.println("Загальна сума чисел:       " + totalSum);
        System.out.println("Сума парних чисел:         " + a + " (кількість: " + aa + ")");
        System.out.println("Сума непарних чисел:       " + b + " (кількість: " + bb + ")");
        double mid = (double) totalSum / n;
        System.out.println("Середнє арифметичне:       " + mid);
        System.out.println("=========================================");
        scanner.close();

    }
}
