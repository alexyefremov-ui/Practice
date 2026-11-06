package semester1.practice09.homework;

public abstract class AbstractHardwareComponent {
    private final String modelName;
    private final double priceUah;

    public AbstractHardwareComponent(String modelName, double priceUah) {
        this.modelName = modelName;
        this.priceUah = (priceUah >= 0) ? priceUah : 0;
    }

    public String getModelName() {
        return modelName;
    }
    public double getPriceUah() {
        return priceUah;
    }
    public abstract int getPowerWatts();
    public abstract double getBenchmarkScore();
    public abstract String getCategory();

    @Override
    public String toString() {
        return String.format("[%s] %s (%d Вт | Score: %.1f)", getCategory(), modelName, getPowerWatts(), getBenchmarkScore());
    }
}
