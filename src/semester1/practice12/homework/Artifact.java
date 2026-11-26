package semester1.practice12.homework;

public class Artifact extends ZoneItem {
    private final double radiation;
    private final int protection;

    public Artifact(String id, String name, double weightKg, double radiation, int protection) {
        super(id, name, weightKg);
        this.radiation = radiation;
        this.protection = protection;
    }

    public double getRadiation() {
        return radiation;
    }

    public int getProtection() {
        return protection;
    }

    @Override
    public String getItemType() {
        return "Артефакт";
    }

    @Override
    public boolean isUsable() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s [%.1f кг | радіація: %+.1f | захист: +%d%%]",
                getName(), getWeightKg(), radiation, protection);
    }
}
