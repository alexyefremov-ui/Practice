
package semester1.practice08.homework;

public class CreditAccount extends BankAccount {
    private double creditLimit;
    private double feePercent;

    public CreditAccount(String iban, String ownerName, double initialBalance, double creditLimit, double feePercent) {
        super(iban, ownerName, initialBalance);
        this.creditLimit = creditLimit;
        this.feePercent = feePercent;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("ВІДМОВА: некоректна сума!");
            return false;
        }

        if (balance >= amount) {
            return super.withdraw(amount);
        }

        double borrowed = amount - Math.max(0.0, balance);
        double fee = borrowed * (feePercent / 100.0);


        if (balance - amount - fee >= -creditLimit) {
            this.balance = balance - amount - fee;
            return true;
        } else {
            System.out.println("ВІДМОВА: перевищено кредитний ліміт!");
            return false;
        }
    }

    public double getCurrentDebt() {
        return balance < 0 ? Math.abs(balance) : 0.0;
    }

    @Override
    public String toString() {
        return String.format("CreditAccount{%s, Ліміт: %.2f грн, Борг: %.2f грн}", super.toString(), creditLimit, getCurrentDebt());
    }
}
