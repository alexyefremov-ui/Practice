package semester1.practice12.homework;

public class DeliveryTruck extends Transport {
    public DeliveryTruck() {
        super("DeliveryTruck", 70.0);
    }

    @Override
    public double calculateCostUah(int distanceKm) {
        return distanceKm * 4.0 + 300.0;
    }
}
