package semester1.practice09.homework;

public class PowerSupplyUnit {
    private final String model;
    private final int maxOutputWatts;
    private final double efficiencyCoefficient;

    public PowerSupplyUnit(String model, int maxOutputWatts, double efficiencyCoefficient) {
        this.model = model;
        this.maxOutputWatts = (maxOutputWatts > 0) ? maxOutputWatts : 750;

        if (efficiencyCoefficient >= 0.80 && efficiencyCoefficient <= 0.96) {
            this.efficiencyCoefficient = efficiencyCoefficient;
        } else {
            this.efficiencyCoefficient = 0.90;
        }
    }

    public String getModel() {
        return model;
    }
    public int getSafeContinuousWatts() {
        return (int) (maxOutputWatts * 0.85);
    }

    public double calculateWallPowerDraw(int internalLoadWatts) {
        return internalLoadWatts / efficiencyCoefficient;
    }

    public double getEfficiencyCoefficient() {
        return efficiencyCoefficient;
    }
}
