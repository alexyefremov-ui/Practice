package semester1.practice12.homework;

public class Detector extends ZoneItem {
    private final int batteryPercent;

    public Detector(String id, String name, double weightKg, int batteryPercent) {
        super(id, name, weightKg);
        if (batteryPercent < 0 || batteryPercent > 100) {
            throw new IllegalArgumentException("Батарея має бути від 0 до 100 відсотків");
        }
        this.batteryPercent = batteryPercent;
    }

    public int getBatteryPercent() {
        return batteryPercent;
    }

    @Override
    public String getItemType() {
        return "Детектор";
    }

    @Override
    public boolean isUsable() {
        return batteryPercent > 0;
    }

    @Override
    public String toString() {
        return getName() + " (батарея " + batteryPercent + "%)";
    }
}
