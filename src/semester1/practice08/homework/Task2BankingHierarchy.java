package semester1.practice08.homework;

public class Task2BankingHierarchy {
    public static void main(String[] args) {

        System.out.println("================ БАНКІВСЬКА ІЄРАРХІЯ РАХУНКІВ ================");

        SavingsAccount savings = new SavingsAccount("UA101", "Олена Коваль", 5000, 12, 1000);

        System.out.println("1. Ощадний рахунок (початковий стан):");
        System.out.println(savings);

        System.out.print("-> Спроба зняти 4500 грн: ");
        savings.withdraw(4500);

        System.out.println("-> Нарахування річних відсотків (+12%)...");
        savings.applyInterest();
        System.out.println(savings);

        System.out.println();

        CreditAccount credit = new CreditAccount("UA202", "Максим Бондар", 2000, 10000, 2);

        System.out.println("2. Кредитний рахунок (початковий стан):");
        System.out.println(credit);

        System.out.print("-> Покупка на 5000 грн (3000 грн у кредит з комісією 2% = 60 грн)... ");


        if (credit.withdraw(5000)) {
            System.out.println("УСПІШНО!");
        } else {
            System.out.println("ВІДМОВА!");
        }



        System.out.println(credit);

        System.out.println("==============================================================");
    }
}
