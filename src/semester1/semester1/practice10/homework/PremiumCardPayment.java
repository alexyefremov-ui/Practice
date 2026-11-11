package semester1.semester1.practice10.homework;

public class PremiumCardPayment extends AbstractPaymentTransaction implements CashbackCapable, Refundable {
    private final String maskedPan;
    private final double cashbackRate;
    private boolean refunded;

    public PremiumCardPayment(String txId, double amount, String maskedPan) {
        super(txId, amount);
        this.maskedPan = maskedPan;
        this.cashbackRate = 0.03;
        this.refunded = false;
    }

    @Override
    public double calculateFee() {
        return getBaseAmountUah() * 0.01;
    }

    @Override
    public String getPaymentChannel() {
        return "Visa Infinite " + maskedPan;
    }

    @Override
    public double getCashbackRate() {
        return cashbackRate;
    }

    @Override
    public boolean requestRefund(String reason) {
        if (!isProcessed() || refunded) {
            return false;
        }
        refunded = true;
        return true;
    }

    @Override
    public boolean isRefunded() {
        return refunded;
    }
}
