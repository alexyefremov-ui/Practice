package Practice3;

import java.util.Scanner;

public class Homework3_2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ТАРИФІКАТОР СЛУЖБИ ДОСТАВКИ ===");

        System.out.print("Введіть вагу відправлення (кг): ");
        double weight = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Введіть відстань транспортування (км): ");
        int distance = scanner.nextInt();
        scanner.nextLine();

        System.out.print(
                "Оберіть пункт призначення (1 - Відділення, 2 - Поштомат, 3 - Кур'єр): "
        );
        int deliveryType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Чи є у вас карта Premium? (так/ні): ");
        String card = scanner.nextLine();

        System.out.println();
        System.out.println("------------- НАКЛАДНА ДОСТАВКИ -------------");

        double cost;

        if (weight > 0 && weight <= 50 && distance > 0) {

            switch (deliveryType) {

                case 1 -> {
                    cost = 60;
                    System.out.println("Тип доставки: Відділення (базовий тариф: 60.00 грн)");
                }
                case 2 -> {
                    if (weight > 15) {
                        cost = 60;
                        System.out.println(
                                "Ви не можете відправити посилку у поштомат, " + "\nтому вона буде відправлена у відділення.");
                        System.out.println("Тип доставки: Відділення (базовий тариф: 60.00 грн)");
                    } else {
                        cost = 60;
                        System.out.println("Тип доставки: Поштомат (базовий тариф: 60.00 грн)");
                    }
                }

                case 3 -> {
                    cost = 100;
                    System.out.println("Тип доставки: Кур'єр (базовий тариф: 100.00 грн)");
                }

                default -> {
                    System.out.println("Error");
                    cost=0;
                }
            }
            double dop;
            if (distance<50){
                dop = 0;
                System.out.println("Доплата за відстань:       " + dop);

            } else if (distance>50 && distance<=200) {
                dop=35;
                System.out.println("Доплата за відстань:       " + dop);

            }else {
                dop = 80;
                System.out.println("Доплата за відстань:       " + dop);
            }
            double sum = dop+cost;
            double afterDiscount = card.equalsIgnoreCase("так") ? sum*0.8 : sum;
            System.out.println("Сума до знижки:            " + sum + " грн");
            if (card.equalsIgnoreCase("так")){
                System.out.println("Статус клієнта:            Premium (-20%)");
            }
            System.out.println("---------------------------------------------");
            System.out.println("РАЗОМ ДО СПЛАТИ:           " + afterDiscount + " грн");
            System.out.println("=============================================");


        } else {
            System.out.println("Error");
        }

        scanner.close();
    }
}