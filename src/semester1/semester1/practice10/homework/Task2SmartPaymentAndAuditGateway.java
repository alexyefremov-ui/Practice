package semester1.semester1.practice10.homework;

public class Task2SmartPaymentAndAuditGateway {
    public static void auditPayments(AbstractPaymentTransaction[] ledger) {
        double turnover = 0;
        double fees = 0;
        double cashback = 0;

        System.out.println("[1. ПРОВЕДЕННЯ ПЛАТЕЖІВ]:");
        for (int i = 0; i < ledger.length; i++) {
            AbstractPaymentTransaction tx = ledger[i];
            if (tx.process()) {
                turnover = turnover + tx.getBaseAmountUah();
                fees = fees + tx.calculateFee();
                System.out.println(String.format("  %s | %s | Сума: %.2f грн | Комісія: %.2f грн | Всього: %.2f грн",
                        tx.getTxId(), tx.getPaymentChannel(), tx.getBaseAmountUah(),
                        tx.calculateFee(), tx.getTotalCharged()));
            } else {
                System.out.println("  " + tx.getTxId() + ": операція не пройшла перевірку.");
            }
        }

        System.out.println("\n[2. АУДИТ ІНТЕРФЕЙСІВ]:");
        for (int i = 0; i < ledger.length; i++) {
            AbstractPaymentTransaction tx = ledger[i];
            if (!tx.isProcessed()) {
                continue;
            }
            if (tx instanceof CashbackCapable cash) {
                double amount = cash.calculateCashback(tx.getBaseAmountUah());
                cashback = cashback + amount;
                System.out.println(String.format("  [CashbackCapable] %s: %.2f грн (ставка %.0f%%)",
                        tx.getTxId(), amount, cash.getCashbackRate() * 100));
            }
            if (tx instanceof BlockchainVerifiable block) {
                System.out.println(String.format("  [BlockchainVerifiable] %s: hash=%s, підтверджень=%d, завершено=%b",
                        tx.getTxId(), block.getTxHash(), block.getConfirmations(), block.isFinalized()));
            }
            if (tx instanceof Refundable refund) {
                boolean result = refund.requestRefund("Тестове повернення");
                System.out.println("  [Refundable] " + tx.getTxId() + ": повернення " +
                        (result ? "успішне" : "неможливе"));
            }
        }

        System.out.println("\n[ПІДСУМКОВИЙ ЗВІТ]:");
        System.out.println(String.format("  Сумарний базовий оборот: %.2f грн", turnover));
        System.out.println(String.format("  Сумарна комісія: %.2f грн", fees));
        System.out.println(String.format("  Сумарний кешбек: %.2f грн", cashback));
        System.out.println("  (Статистика наведена за проведеними платежами до тестових повернень.)");
    }

    public static void main(String[] args) {
        AbstractPaymentTransaction[] ledger = {
                new PremiumCardPayment("TX-101", 20000, "**** 1234"),
                new CryptoUsdtPayment("TX-102", 8500, "0x9f8a...c4", 18),
                new TaxTreasuryPayment("TX-103", 5000, "101")
        };
        System.out.println("========== ПРОЦЕСИНГОВИЙ ЦЕНТР FINTECH ==========");
        auditPayments(ledger);
    }
}
