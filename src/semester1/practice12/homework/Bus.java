package semester1.practice12.homework;

public class Bus extends Transport {
    public Bus() {
        super("Bus", 80.0);
    }

    @Override
    public double calculateCostUah(int distanceKm) {
        return distanceKm * 2.5;
    }
}
