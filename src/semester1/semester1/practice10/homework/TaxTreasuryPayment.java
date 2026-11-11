package semester1.semester1.practice10.homework;

public final class TaxTreasuryPayment extends AbstractPaymentTransaction implements Refundable {
    private final String taxCode;
    private boolean refunded;

    public TaxTreasuryPayment(String txId, double amount, String taxCode) {
        super(txId, amount);
        this.taxCode = taxCode;
        this.refunded = false;
    }

    @Override
    public double calculateFee() {
        return 0.0;
    }

    @Override
    public String getPaymentChannel() {
        return "ДержКазначейство (код " + taxCode + ")";
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
