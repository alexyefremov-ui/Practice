package Practice4;

import java.util.Scanner;

public class Homework4_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== АНАЛІЗАТОР РОЗРЯДІВ ЧИСЛА ===");
        System.out.print("Введіть додатне ціле число: ");

        int number = scanner.nextInt();
        int originalNumber = number;

        System.out.println();
        System.out.println("--- СТАТИСТИКА ЧИСЛА ---");
        int temp = number;

        int count = 0;
        int sum = 0;
        int maxDigit = 0;
        int reversedNumber = 0;


        while (temp > 0){
            int digit = temp % 10;

            count++;
            sum += digit;

            if (digit > maxDigit) {
                maxDigit = digit;
            }

            reversedNumber = reversedNumber * 10 + digit;

            temp = temp / 10;


        }
        System.out.println("Кількість цифр:          " + count);
        System.out.println("Сума цифр:               " + sum);
        System.out.println("Найбільша цифра:         " + maxDigit);
        System.out.println("Число навпаки:           " + reversedNumber);

        System.out.println();

        if (originalNumber == reversedNumber) {
            System.out.println("Це число є паліндромом! ✨");
        } else {
            System.out.println("Це звичайне число (не паліндром).");
        }

        scanner.close();

    }
}
