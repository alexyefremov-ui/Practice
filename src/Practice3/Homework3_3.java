package Practice3;

import java.util.Scanner;

public class Homework3_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== СИСТЕМА БАНКІВСЬКОГО СКОРИНГУ ===");
        System.out.print("Введіть вік позичальника: ");
        int age = scanner.nextInt();
        System.out.print("Введіть офіційний місячний дохід (грн): ");
        double monthlyIncome = scanner.nextDouble();
        System.out.print("Чи є негативна кредитна історія? (true/false): ");
        boolean hasBadCreditHistory = scanner.nextBoolean();
        System.out.print("Введіть запитувану суму кредиту (грн): ");
        double loanAmount = scanner.nextDouble();
        System.out.print("Введіть бажаний термін (місяців): ");
        int loanMonths = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        System.out.println("------------- РІШЕННЯ СКОРИНГУ -------------");
        double monthlyPayment = loanAmount/loanMonths;

        if (age>=21 && age<=60 && !hasBadCreditHistory){

            if (loanMonths >= 0 && monthlyIncome*0.5>=monthlyPayment){
                System.out.println("Статус заявки:               СХВАЛЕНО ✅");
                System.out.println("Орієнтовний платіж/міс:      " + monthlyPayment + " грн (" + monthlyPayment/monthlyIncome*100 + "% від доходу)");
                System.out.println("Персональна ставка:          " + (monthlyIncome >= 35000 ? "14.5% річних" : "21% річних"));
                System.out.println("Максимально допустимий платіж: " + monthlyIncome*0.5 + " грн/міс");
                System.out.println("=============================================");


            } else {
                System.out.println("Відмова: термін кредиту некоректний або щомісячний платіж перевищує 50% доходу");
            }

        } else if (age>=21 && age<=60 && hasBadCreditHistory) {
            System.out.println("Відмова: виявлено негативну кредитну історію");
        } else {
            System.out.println("Відмова: вік не відповідає критеріям (21-65 років)");
        }
        scanner.close();



    }
}
