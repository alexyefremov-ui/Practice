package Homework5;

import java.util.Scanner;

public class Homework5_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота", "Неділя"};
        double[] sales = new double[7];
        System.out.println("=== ФІНАНСОВИЙ ЗВІТ КАВ'ЯРНІ ЗА ТИЖДЕНЬ ===");
        double sum = 0;

        for (int i = 0; i < days.length; i++){
            System.out.printf("Введіть виторг за %s (грн): ", days[i]);
            sales[i] = scanner.nextDouble();
            sum += sales[i];
        }
        double max = sales[0];
        double min = sales[0];
        String minday = days[0];
        String maxday = days[0];

        for (int i = 1; i < days.length; i++){

            if (min > sales[i]){
                min = sales[i];
                minday = days[i];
            }

            if (max < sales[i]){
                max = sales[i];
                maxday = days[i];
            }
        }

        System.out.println();
        System.out.println("---------------- ПІДСУМКИ ----------------");

        double midl = sum / days.length;

        System.out.println("Загальний тижневий виторг: " + sum + " грн");
        System.out.println("Середній виторг на день:    " + midl + " грн");
        System.out.println("Найкращий день:            " + maxday + " (" + max + " грн)");
        System.out.println("Найгірший день:            " + minday + " (" + min + " грн)");

        System.out.println();
        System.out.println("Дні з виторгом вище середнього:");

        for (int i = 0; i < days.length; i++){

            if (sales[i] > midl){
                System.out.println("- " + days[i] + ": " + sales[i] + " грн");
            }
        }
        System.out.println("==========================================");
        scanner.close();
    }
}