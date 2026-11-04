package semester1.practice08.homework;

public class SavingsAccount extends BankAccount {
    private double interestRate;
    private double minBalance;
    public SavingsAccount(String iban, String ownerName, double initialBalance, double interestRate, double minBalance) {
        super(iban, ownerName, initialBalance);
        this.interestRate = interestRate;

        this.minBalance = minBalance;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && balance - amount >= minBalance) {
            return super.withdraw(amount);
        } else {
            System.out.println("ВІДМОВА (порушення незнижуваного залишку " + String.format("%.2f", minBalance) + " грн)");
            return false;
        }
    }



    public void applyInterest() {
        double interest = balance * (interestRate / 100.0);

        deposit(interest);
    }
    @Override
    public String toString() {
        return String.format("SavingsAccount{%s, Ставка: %.1f%%, Мін.залишок: %.2f грн}", super.toString(), interestRate, minBalance);
    }
}
