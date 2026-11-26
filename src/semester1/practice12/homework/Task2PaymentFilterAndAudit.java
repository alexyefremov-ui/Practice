package semester1.practice12.homework;

import java.util.HashSet;

public class Task2PaymentFilterAndAudit {
    public static void main(String[] args) {
        System.out.println("========== БАНКІВСЬКИЙ ПЛАТІЖНИЙ ФІЛЬТР ==========");
        HashSet<String> blockedShops = new HashSet<>();
        blockedShops.add("ScamShop");
        blockedShops.add("FakeStore");
        PaymentProcessor processor = new PaymentProcessor(blockedShops, 20000.0);

        processor.addPayment(new CardPayment("P-01", "Rozetka", 4000.0));
        processor.addPayment(new TransferPayment("P-02", "Comfy", 10000.0));
        processor.addPayment(new CardPayment("P-01", "Rozetka", 4000.0));
        processor.addPayment(new CardPayment("P-03", "ScamShop", 5000.0));
        processor.addPayment(new TransferPayment("P-04", "LuxWatch", 25000.0));
        processor.addPayment(new CardPayment("P-05", "Rozetka", 2000.0));
        processor.addPayment(new TransferPayment("P-06", "Allo", 5000.0));

        System.out.println("Чорний список: " + processor.getBlockedShopsCopy());
        System.out.println("Ліміт: 20000.00 грн | Надійшло: " + processor.getPaymentsCopy().size());
        System.out.println("\nОчищення через Iterator.remove():");
        int removed = processor.cleanPayments();

        System.out.println("\nСхвалені платежі:");
        for (Payment p : processor.getPaymentsCopy()) {
            System.out.printf("  %s | %s | Сума: %.2f | Комісія: %.2f | Нетто: %.2f грн%n",
                    p.getId(), p.getShopName(), p.getAmount(), p.calculateFee(), p.getNetAmount());
        }
        System.out.println("\nВидалено: " + removed + " | Схвалено: " + processor.getPaymentsCopy().size());
        System.out.printf("Брутто: %.2f грн | Комісії: %.2f грн | Нетто: %.2f грн%n",
                processor.getTotalGross(), processor.getTotalFees(),
                processor.getTotalGross() - processor.getTotalFees());
        System.out.println("Унікальні магазини: " + processor.getApprovedShops());
    }
}
