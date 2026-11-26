package semester1.practice12.homework;

public abstract class Transport {
    private final String name;
    private final double speedKmH;

    public Transport(String name, double speedKmH) {
        if (speedKmH <= 0) {
            throw new IllegalArgumentException("Швидкість має бути додатною");
        }
        this.name = name;
        this.speedKmH = speedKmH;
    }

    public String getName() {
        return name;
    }

    public double getSpeedKmH() {
        return speedKmH;
    }

    public double calculateTimeHours(int distanceKm) {
        return distanceKm / speedKmH;
    }

    public abstract double calculateCostUah(int distanceKm);
}
