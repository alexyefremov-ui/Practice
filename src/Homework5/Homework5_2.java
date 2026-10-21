package Homework5;

public class Homework5_2 {
    public static void main(String[] args) {
        String[] items = {"Ноутбук", "Смартфон", "Бездротові навушники", "Механічна клавіатура", "Монітор 27\""};
        int[] quantities = {8, 3, 25, 4, 12};
        double[] prices = {28500.0, 19200.0, 1850.0, 3100.0, 9400.0};
        double[] totalValues = new double[items.length];
        System.out.println("=================== ЗВІТ СКЛАДУ ЕЛЕКТРОНІКИ ===================");
        System.out.println("№ | Назва товару            | К-сть | Ціна (грн) | Загальна вартість");
        System.out.println("----------------------------------------------------------------");
        double sum = 0;
        double max = 0;
        String maxd = items[0];
        for (int i = 0; i<items.length; i++){
            totalValues[i] = quantities[i] * prices[i];
            System.out.println(i + " | " + items[i] + "   | " + quantities[i] + " шт. | " + prices[i] + "   | " + totalValues[i] + " грн");
            sum += totalValues[i];
            if (max<totalValues[i]){
                max = totalValues[i];
                maxd = items[i];

            }


        }
        System.out.println("Загальна вартість складу: " + sum +" грн");
        System.out.println("Найбільший капітал у товарі: " + maxd + " (" + max + " грн)");
        System.out.println();
        System.out.println("System.out.println();");
        for (int i = 0; i<items.length; i++){
            if (quantities[i] < 5){
                System.out.println("- " + items[i]+ " (залишилось: " + quantities[i] + " шт.) -> ⚠\uFE0F Терміново дозамовити!");
            }

        }
        System.out.println("================================================================");

    }
}
