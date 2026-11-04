package semester1.practice08.homework;

public class BankAccount {
    private String iban;
    private String ownerName;
    protected double balance;

    public BankAccount(String iban, String ownerName, double initialBalance){
        this.iban = iban;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public void setBalance(double balance){
        if (balance<0){
            balance=0;
        }
        this.balance = balance;
    }
    public void deposit(double amount){
        if (amount>0){
            this.balance += amount;
        }
    }

    public boolean withdraw(double amount){
        if (amount > 0 && amount <= balance){
            this.balance -= amount;
            return true;
        }else {
            return false;
        }
    }

    @Override public String toString() {
        return String.format("Рахунок[%s | Власник: %s | Баланс: %.2f грн]", iban, ownerName, balance);
    }

}
