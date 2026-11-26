package semester1.practice12.homework;

public class Train extends Transport {
    public Train() {
        super("Train", 100.0);
    }

    @Override
    public double calculateCostUah(int distanceKm) {
        return distanceKm * 1.8 + 150.0;
    }
}
