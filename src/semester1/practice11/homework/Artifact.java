package semester1.practice11.homework;

public class Artifact {
    private String name;
    private int costKarbovanets;
    private double radiationLevel;

    public Artifact(String name, int costKarbovanets, double radiationLevel) {
        this.name = name;
        this.costKarbovanets = costKarbovanets;
        this.radiationLevel = radiationLevel;
    }

    public String getName() {
        return name;
    }

    public int getCostKarbovanets() {
        return costKarbovanets;
    }

    public double getRadiationLevel() {
        return radiationLevel;
    }

    public boolean isRadioactiveDud(double maxSafeRadiation) {
        return radiationLevel > maxSafeRadiation || costKarbovanets <= 0;
    }

    @Override
    public String toString() {
        return String.format("%s (ціна: %d крб, радіація: %.1f мкЗв/год)",
                name, costKarbovanets, radiationLevel);
    }
}
