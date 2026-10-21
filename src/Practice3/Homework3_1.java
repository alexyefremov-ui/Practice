package Practice3;

import java.util.Scanner;

public class Homework3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== КАЛЬКУЛЯТОР ПОЇЗДКИ ТА ПАЛЬНОГО ===");
        System.out.print("Введіть відстань поїздки (км): ");
        double distance = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Введіть середню витрату на 100 км (л): ");
        double fuelConsumption = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Оберіть тип пального (1 - А-95, 2 - Дизель, 3 - Газ): ");
        int fuelType = scanner.nextInt();
        scanner.nextLine();

        if (distance <= 0 || fuelConsumption <= 0) {
            System.out.println("Error");

        }


        System.out.println();
        System.out.println("---------------- ЗВІТ ПОЇЗДКИ ----------------");
        double pricePerLiter = 0;


        switch (fuelType) {
            case 1:
                System.out.println("Обране пальне:               Бензин А-95 (56.50 грн/л)");
                pricePerLiter = 56.5;
                break;
            case 2:
                System.out.println("Обране пальне:                (Дизель) 52.80 грн/л");
                pricePerLiter = 52.8;
                break;
            case 3:
                System.out.println("Обране пальне:                (Газ) 29.40 грн/л");
                pricePerLiter = 29.4;
                break;

            default:
                System.out.println("Ви ввели невідоми вид пального");
                break;

        }

        double needFuel = distance*fuelConsumption/100;
        double baseCost = needFuel*pricePerLiter;
        double finalCost = baseCost >= 2000 ? baseCost*0.95 : baseCost;
        System.out.println("Необхідно пального:          " + needFuel + " л");
        System.out.println("Базова вартість:             " + baseCost + " грн");

        if (baseCost >= 2000){
            System.out.println("Знижка АЗС (5%):             " + baseCost*0.05 + " грн");

        }
        System.out.println("----------------------------------------------");
        System.out.println("Підсумкова сума до сплати:   " + finalCost + " грн");
        System.out.println("==============================================");

        scanner.close();





    }
}
