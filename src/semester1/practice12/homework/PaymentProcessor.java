package semester1.practice12.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class PaymentProcessor {
    private ArrayList<Payment> payments = new ArrayList<>();
    private HashSet<String> blockedShops;
    private double maxLimit;

    public PaymentProcessor(HashSet<String> blockedShops, double maxLimit) {
        if (blockedShops == null || maxLimit <= 0) {
            throw new IllegalArgumentException("Некоректні параметри процесора");
        }
        this.blockedShops = new HashSet<>(blockedShops);
        this.maxLimit = maxLimit;
    }

    public void addPayment(Payment p) {
        if (p != null) {
            payments.add(p);
        }
    }

    public HashSet<String> getBlockedShopsCopy() {
        return new HashSet<>(blockedShops);
    }

    public ArrayList<Payment> getPaymentsCopy() {
        return new ArrayList<>(payments);
    }

    public int cleanPayments() {
        HashSet<String> seenIds = new HashSet<>();
        Iterator<Payment> it = payments.iterator();
        int removed = 0;
        while (it.hasNext()) {
            Payment p = it.next();
            if (!seenIds.add(p.getId())) {
                System.out.println("  [ДУБЛІКАТ] " + p.getId() + " | " + p.getShopName());
                it.remove();
                removed++;
            } else if (blockedShops.contains(p.getShopName())) {
                System.out.println("  [ЧОРНИЙ СПИСОК] " + p.getId() + " | " + p.getShopName());
                it.remove();
                removed++;
            } else if (p.getAmount() > maxLimit) {
                System.out.println("  [ПОНАД ЛІМІТ] " + p.getId() + " | " + p.getAmount());
                it.remove();
                removed++;
            }
        }
        return removed;
    }

    public double getTotalGross() {
        double total = 0;
        for (Payment p : payments) {
            total += p.getAmount();
        }
        return total;
    }

    public double getTotalFees() {
        double fees = 0;
        for (Payment p : payments) {
            fees += p.calculateFee();
        }
        return fees;
    }

    public HashSet<String> getApprovedShops() {
        HashSet<String> shops = new HashSet<>();
        for (Payment p : payments) {
            shops.add(p.getShopName());
        }
        return shops;
    }
}
